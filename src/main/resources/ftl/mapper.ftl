<?xml version="1.0" encoding="UTF-8"?>
<!--
    该mapper文件由模板生成，禁止修改和格式化，
    重新生成后会造成修改丢失，
    如果需要拓展，请在对应的空mapper文件中实现。
 -->
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${table.daoPackageName}.${table.daoClassName}">

    <sql id="queryColumn">
        <trim suffixOverrides=",">
        <#list columns as column>
            `${column.field}`,
        </#list>
        </trim>
    </sql>
    <sql id="insertColumn">
        <trim suffixOverrides=",">
        <#list columns as column>
            <if test="domain.${column.field} != null and domain.${column.field}.length()>0">
               ${column.field},
            </if>
        </#list>
        </trim>
    </sql>
    <sql id="insertValues">
        <trim suffixOverrides=",">
        <#list columns as column>
            <if test="domain.${column.field} != null and domain.${column.field}.length()>0">
                ${r'#{domain.'}${column.field}${r'}'},
            </if>
        </#list>
        </trim>
    </sql>

    <sql id="updateColumn">
        <trim prefix="set" suffixOverrides=",">
        <#list columns as column>
            <if test="domain.${column.field} != null and domain.${column.field}.length()>0">
            `${column.field}` = ${r'#{domain.'}${column.field}${r'}'},
            </if>
        </#list>
        </trim>
    </sql>

    <sql id="whereCondition">
        <trim prefix="WHERE" suffixOverrides=",">
        <#list columns as column>
            <if test="domain.${column.field} != null and domain.${column.field}.length()>0">
                AND `${column.field}` = ${r'#{domain.'}${column.field}${r'}'},
            </if>
        </#list>
        </trim>
    </sql>
    <sql id="whereLikeCondition">
        <trim prefix="WHERE" suffixOverrides=",">
        <#list columns as column>
            <if test="domain.${column.field} != null and domain.${column.field}.length()>0">
                AND `${column.field}` like CONCAT(${r'#{domain.'}${column.field}${r'}'}, "%") ,
            </if>
        </#list>
        </trim>
    </sql>

    <select id="findOneById" parameterType="java.lang.${table.primaryType}" resultType="${table.domainPackageName}.${table.domainClassName}" >
        SELECT
        <include refid="queryColumn" />
        FROM
        `${table.DB}`.`${table.tableName}`
        WHERE
        ${table.primaryKey} = ${r'#{id}'}
    </select>

    <update id="update" parameterType="${table.domainPackageName}.${table.domainClassName}">
        UPDATE TABLE `${table.DB}`.`${table.tableName}`
        <include refid="updateColumn" />
        WHERE
        ID = ${r'#{domain.id}'}
    </update>
    <delete id="deleteById" parameterType="java.lang.Long">
        DELETE FROM `${table.DB}`.`${table.tableName}`
        WHERE
        ID = ${r'#{domain.id}'}
    </delete>
    <delete id="deleteByIds" parameterType="java.lang.Long">
        DELETE FROM `${table.DB}`.`${table.tableName}`
        WHERE
        ID IN
        <foreach collection="list" item="item" index="index" open="(" separator="," close=")" >
            ${r'#{item}'}
        </foreach>
    </delete>
    <insert id="insert" parameterType="${table.domainPackageName}.${table.domainClassName}">
        INSERT INTO
        `${table.DB}`.`${table.tableName}`
        (
        <include refid="insertColumn" />
        )
        VALUES
        (
        <include refid="insertValues" />
        )
    </insert>
    <insert id="batInsert" parameterType="${table.domainPackageName}.${table.domainClassName}" >

        INSERT INTO
        `${table.DB}`.`${table.tableName}`
        (
        <include refid="insertColumn" />
        )
        VALUES
        <foreach collection="list" item="domain" index="index" separator="," >
            (<include refid="insertValues" />)
        </foreach>

    </insert>
    <select id="findAllByCondition" resultType="${table.domainPackageName}.${table.domainClassName}">

        SELECT
        <include refid="queryColumn" />
        FROM
        `${table.DB}`.`${table.tableName}`
        WHERE
        1 = 1
        <if test="extension.markLike">
            <include refid="whereLikeCondition" />
        </if>
        <if test="!extension.markLike">
            <include refid="whereCondition" />
        </if>
        <if test="extension.groupBy != null AND extension.groupBy.length() > 0">
            GROUP BY ${r'#{extension.groupBy}'}
        </if>
        <if test="extension.orderBy != null AND extension.orderBy.length() > 0">
            ORDER BY  ${r'#{extension.orderBy}'}
        </if>
        <if test="extension.orderType != null AND extension.orderType.length() > 0">
            ORDER BY ${r'#{extension.orderType}'}
        </if>


    </select>

    <select id="findPageByCondition" resultType="${table.domainPackageName}.${table.domainClassName}">

        SELECT
        <include refid="queryColumn" />
        FROM
        `${table.DB}`.`${table.tableName}`
        WHERE
        1 = 1
        <if test="extension.markLike">
            <include refid="whereLikeCondition" />
        </if>
        <if test="!extension.markLike">
            <include refid="whereCondition" />
        </if>
        <if test="extension.groupBy != null AND extension.groupBy.length() > 0">
            GROUP BY ${r'#{extension.groupBy}'}
        </if>
        <if test="extension.orderBy != null AND extension.orderBy.length() > 0">
            ORDER BY  ${r'#{extension.orderBy}'}
        </if>
        <if test="extension.orderType != null AND extension.orderType.length() > 0">
            ORDER BY ${r'#{extension.orderType}'}
        </if>
        <if test="extension.offset != null AND extension.offset > 0">
            limit ${r'#{extension.offset}'}
        </if>
        <if test="extension.rowNum != null AND extension.rowNum > 0">
            , ${r'#{extension.rowNum}'}
        </if>

        <if test="extension.attach != null AND extension.attach.length() > 0">
             ${r'${extension.attach}'}
        </if>

    </select>

    <select id="countByCondition" parameterType="${table.domainPackageName}.${table.domainClassName}" resultType="java.lang.Long">
        SELECT COUNT(*) FROM
        `${table.DB}`.`${table.tableName}`
        WHERE 1 = 1
        <if test="extension.markLike">
            <include refid="whereLikeCondition" />
        </if>
        <if test="!extension.markLike">
            <include refid="whereCondition" />
        </if>
        <if test="extension.groupBy != null AND extension.groupBy.length() > 0">
            GROUP BY ${r'#{extension.groupBy}'}
        </if>
        <if test="extension.orderBy != null AND extension.orderBy.length() > 0">
            ORDER BY  ${r'#{extension.orderBy}'}
        </if>
        <if test="extension.orderType != null AND extension.orderType.length() > 0">
            ${r'#{extension.orderType}'}
        </if>
    </select>
    <select id="findListByIds" parameterType="${table.domainPackageName}.${table.domainClassName}" resultType="${table.domainPackageName}.${table.domainClassName}">
        SELECT
        <include refid="queryColumn" />
        FROM
        `${table.DB}`.`${table.tableName}`
        WHERE
        ID IN
        <foreach collection="list" item="item" index="index" open="(" separator="," close=")" >
            ${r'#{item}'}
        </foreach>
    </select>
</mapper>