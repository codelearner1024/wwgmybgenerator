package com.wwg.mybatis.generator;


import java.util.Date;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 *类描述:mybatis generator生成注释插件
 *
 *@Author:WWG
 *@date:2020年1月22日
 *@Version:2.5
 */
public class MyCommentGenerator extends EmptyCommentGenerator {
    
    public MyCommentGenerator() {
        super();
        properties = new Properties();
    }

    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString().replace("\n", " "));
        field.addJavaDocLine(" */");
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        String author = properties.getProperty("author");
        String version = properties.getProperty("version");

        // 获取表注释
        String remarks = introspectedTable.getRemarks();

        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * 类描述：" + remarks);
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * @Author：" + author);
        topLevelClass.addJavaDocLine(" * @date：" + super.dateFormat.format(new Date()));
        topLevelClass.addJavaDocLine(" * @Version：" + version);
        topLevelClass.addJavaDocLine(" */");
    }
}

