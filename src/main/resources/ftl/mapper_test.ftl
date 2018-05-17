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
        <foreach collection="map" item="value" index="key"  separator=" " >
            <if test="value != null">
                <foreach collection="value" item="k"  separator=" " >
                    <if test="k.t2.key == 1">
                        AND ${r'${key}'} = ${r'#{k.t1}'}
                    </if>
                    <if test="k.t2.key == 2">
                        AND ${r'${key}'} LIKE CONCAT("%" , ${r'#{k.t1}'}, "%")
                    </if>
                    <if test="k.t2.key == 4">
                        AND ${r'${key}'} LIKE CONCAT("%" ,${r'#{k.t1}'})
                    </if>
                    <if test="k.t2.key == 8">
                        AND ${r'${key}'} LIKE CONCAT(${r'#{k.t1}'}, "%")
                    </if>
                    <if test="k.t2.key == 16">
                        AND ${r'${key}'} ${r'&gt'};= ${r'#{k.t1}'}
                    </if>
                    <if test="k.t2.key == 32">
                        AND ${r'${key}'} ${r'&lt'};= ${r'#{k.t1}'}
                    </if>
                    <if test="k.t2.key == 64">
                        AND ${r'${key}'} IN
                        <foreach collection="k.t1" item="item" open="(" separator="," close=")" >
                        ${r'#{item}'}
                        </foreach>
                    </if>
                </foreach>
            </if>
        </foreach>
    </sql>

    <select id="findOneById" parameterType="java.lang.${table.primaryType}" resultType="${table.domainPackageName}.${table.domainClassName}" >
        SELECT
        <include refid="queryColumn" />
        FROM
        `${table.DB}`.`${table.tableName}`
        WHERE
    ${table.primaryKey} = ${r'#{id}'}
        LIMIT 1
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

    <update id="updateByCondition">
        UPDATE `${table.DB}`.`${table.tableName}`
        <include refid="updateColumn" />
        WHERE 1 = 1
        <include refid="whereCondition" />
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

    <delete id="deleteByCondition">
        DELETE FROM `${table.DB}`.`${table.tableName}`
        WHERE 1 = 1
        <include refid="whereCondition" />
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

    <select id="findAll" resultType="${table.domainPackageName}.${table.domainClassName}" >
        SELECT
        <include refid="queryColumn" />
        FROM
        `${table.DB}`.`${table.tableName}`
        WHERE 1 = 1
    </select>

    <select id="findAllByCondition" resultType="${table.domainPackageName}.${table.domainClassName}" parameterType="${table.paramsMap}">
        SELECT
        <include refid="queryColumn" />
        FROM
        `${table.DB}`.`${table.tableName}`
        WHERE 1 = 1
        <include refid="whereCondition" />
    </select>

    <select id="findListByCondition" resultType="${table.domainPackageName}.${table.domainClassName}">
        SELECT
        <include refid="queryColumn" />
        FROM
        `${table.DB}`.`${table.tableName}`
        WHERE 1 = 1
        <include refid="whereCondition" />
    ${r'${attach}'}
    </select>

    <select id="countByCondition" parameterType="${table.paramsMap}" resultType="java.lang.Long">
        SELECT COUNT(*) FROM
        `${table.DB}`.`${table.tableName}`
        WHERE 1 = 1
        <include refid="whereCondition" />
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