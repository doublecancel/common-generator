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
            <#if !column.key>
                <#if column.type == "String">
                    <if test="domain.${column.field} != null and domain.${column.field}.length()>0">
                    ${column.field},
                    </if>
                <#else>
                    <if test="domain.${column.field} != null">
                    ${column.field},
                    </if>
                </#if>
            <#else>
            </#if>
        </#list>
        </trim>
    </sql>
    <sql id="insertValues">
        <trim suffixOverrides=",">
        <#list columns as column>
            <#if !column.key>
                <#if column.type == "String">
                    <if test="domain.${column.field} != null and domain.${column.field}.length()>0">
                    ${r'#{domain.'}${column.field}${r'}'},
                    </if>
                <#else>
                    <if test="domain.${column.field} != null">
                    ${r'#{domain.'}${column.field}${r'}'},
                    </if>
                </#if>
            <#else>
            </#if>
        </#list>
        </trim>
    </sql>

    <sql id="updateColumn">
        <trim prefix="set" suffixOverrides=",">
        <#list columns as column>
            <#if !column.key>
                <#if column.type == "String">
                    <if test="domain.${column.field} != null and domain.${column.field}.length()>0">
                        `${column.field}` = ${r'#{domain.'}${column.field}${r'}'},
                    </if>
                <#else>
                    <if test="domain.${column.field} != null">
                        `${column.field}` = ${r'#{domain.'}${column.field}${r'}'},
                    </if>
                </#if>
            <#else>
            </#if>
        </#list>
        </trim>
    </sql>

    <sql id="whereCondition">
        <trim suffixOverrides="AND">
        <#list columns as column>
            <#if column.type == "String">
                <if test="domain.${column.field} != null and domain.${column.field}.length()>0">
                    AND `${column.field}` = ${r'#{domain.'}${column.field}${r'}'}
                </if>
            <#elseif column.type == "OptLocalDateTime">
                <if test="domain.${column.field} != null">

                    <if test="domain.${column.field}.start != null">
                        AND `${column.field}` ${r'&gt'};= ${r'#{domain.'}${column.field}${r'.start}'}
                    </if>
                    <if test="domain.${column.field}.end != null">
                        AND `${column.field}` ${r'&lt'};= ${r'#{domain.'}${column.field}${r'.end}'}
                    </if>
                </if>
            <#else>
                <if test="domain.${column.field} != null">
                    AND `${column.field}` = ${r'#{domain.'}${column.field}${r'}'}
                </if>
            </#if>
        </#list>
        </trim>
    </sql>
    <sql id="whereLikeCondition">
        <trim suffixOverrides="AND">
        <#list columns as column>
            <#if column.key>
                <if test="domain.${column.field} != null and domain.${column.field}.length()>0">
                    AND `${column.field}` = ${r'#{domain.'}${column.field}${r'}'}
                </if>
            <#elseif column.type == "String">
                <if test="domain.${column.field} != null and domain.${column.field}.length()>0">
                    AND `${column.field}` like CONCAT("%", ${r'#{domain.'}${column.field}${r'}'}, "%")
                </if>
            <#elseif column.type == "OptLocalDateTime">
                <if test="domain.${column.field} != null">

                    <if test="domain.${column.field}.start != null">
                        AND `${column.field}` ${r'&gt'};= ${r'#{domain.'}${column.field}${r'.start}'}
                    </if>
                    <if test="domain.${column.field}.end != null">
                        AND `${column.field}` ${r'&lt'};= ${r'#{domain.'}${column.field}${r'.end}'}
                    </if>
                </if>
            <#else>
                <if test="domain.${column.field} != null">
                    AND `${column.field}` like CONCAT("%", ${r'#{domain.'}${column.field}${r'}'}, "%")
                </if>
            </#if>
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

    <update id="updateById" parameterType="${table.domainPackageName}.${table.domainClassName}">
        UPDATE `${table.DB}`.`${table.tableName}`
        <include refid="updateColumn" />
        WHERE
        ${table.primaryKey} = ${r'#{domain.id}'}
    </update>

    <update id="updateByIds">
        UPDATE `${table.DB}`.`${table.tableName}`
        <include refid="updateColumn" />
        WHERE
        ${table.primaryKey} IN
        <foreach collection="list" item="item" index="index" open="(" separator="," close=")" >
        ${r'#{item}'}
        </foreach>
    </update>

    <delete id="deleteById" parameterType="java.lang.${table.primaryType}">
        DELETE FROM `${table.DB}`.`${table.tableName}`
        WHERE
        ${table.primaryKey} = ${r'#{domain.id}'}
    </delete>
    <delete id="deleteByIds">
        DELETE FROM `${table.DB}`.`${table.tableName}`
        WHERE
        ${table.primaryKey} IN
        <foreach collection="list" item="item" index="index" open="(" separator="," close=")" >
            ${r'#{item}'}
        </foreach>
    </delete>

    <insert id="insert" parameterType="${table.domainPackageName}.${table.domainClassName}">

        <selectKey resultType="${table.primaryType}" order="AFTER" keyProperty="domain.${table.primaryKey}">
            SELECT LAST_INSERT_ID()
        </selectKey>
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
        WHERE 1 = 1
        <if test="extension.markLike">
            <include refid="whereLikeCondition" />
        </if>
        <if test="!extension.markLike">
            <include refid="whereCondition" />
        </if>
        <if test="extension.groupBy != null and extension.groupBy.length() > 0">
            GROUP BY ${r'${extension.groupBy}'}
        </if>
        <if test="extension.orderBy != null and extension.orderBy.length() > 0">
            ORDER BY  ${r'${extension.orderBy}'}
        </if>
        <if test="extension.orderType != null and extension.orderType.length() > 0">
             ${r'${extension.orderType}'}
        </if>
        <if test="extension.offset != null and extension.offset >= 0">
            limit ${r'${extension.offset}'}
        </if>
        <if test="extension.rowNum != null and extension.rowNum >= 0">
            , ${r'${extension.rowNum}'}
        </if>
        <if test="extension.attach != null and extension.attach.length() > 0">
            ${r'${extension.attach}'}
        </if>
    </select>

    <select id="countByCondition" parameterType="${table.domainPackageName}.${table.domainClassName}" resultType="java.lang.Integer">
        SELECT COUNT(*) FROM
        `${table.DB}`.`${table.tableName}`
        WHERE 1 = 1
        <if test="extension.markLike">
            <include refid="whereLikeCondition" />
        </if>
        <if test="!extension.markLike">
            <include refid="whereCondition" />
        </if>
        <if test="extension.groupBy != null and extension.groupBy.length() > 0">
            GROUP BY ${r'${extension.groupBy}'}
        </if>
        <if test="extension.attach != null and extension.attach.length() > 0">
            ${r'${extension.attach}'}
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