package com.wwg.mybatis.generator;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.InnerEnum;
import org.mybatis.generator.api.dom.java.JavaElement;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.kotlin.KotlinFile;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.internal.util.StringUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wwg.mybatis.constants.Constants;
import com.wwg.mybatis.constants.MyPropertyRegistry;

/**
 * 类描述:子类如果不重写，就会默认执行父类的，所以使用EmptyCommentGenerator重置所有注释为空
 *
 * @Author:WWG
 * @date:2020年1月22日
 */
public class EmptyCommentGenerator implements CommentGenerator {

    private static final Logger LOG = LoggerFactory.getLogger(EmptyCommentGenerator.class);
    
    protected Properties properties;

    private boolean suppressDate;

    protected boolean suppressAllComments;

    /** If suppressAllComments is true, this option is ignored. */
    private boolean addRemarkComments;
    
    protected SimpleDateFormat dateFormat;
    
    protected String author;

    protected String version;
    
    public EmptyCommentGenerator() {
        super();
        properties = new Properties();
        suppressDate = false;
        suppressAllComments = false;
        addRemarkComments = false;
    }
    
    @Override
    public void addConfigurationProperties(Properties properties) {

        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        
        // 获取自定义的 properties
        this.properties.putAll(properties);
        
        author = properties.getProperty(MyPropertyRegistry.ANNO_AUTHOR);
       
        version = properties.getProperty(MyPropertyRegistry.ANNO_VERSION);

        suppressDate = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));

        suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));

        addRemarkComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_ADD_REMARK_COMMENTS));

        String dateFormatString = properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_DATE_FORMAT);
        
        
        if (StringUtility.stringHasValue(dateFormatString)) {
            dateFormat = new SimpleDateFormat(dateFormatString);
        }
        LOG.info(Constants.METHOD_END_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());

    }
    
    /**
     * 代码头，加一些公司版权之类的信息
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
//        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
//        
//        // add no file level comments by default
//        compilationUnit.getFileCommentLines();
//        compilationUnit.addFileCommentLine("Copyright (c) 2011 ABC.Co.Ltd. All rights reserved."+ author);
//        
//        LOG.info(Constants.METHOD_END_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    /**
     * mapper.xml文件对sql添加注释
     */
    @Override
    public void addComment(XmlElement xmlElement) {
//        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
//        if (suppressAllComments) {
//            return;
//        }
//
//        xmlElement.addElement(new TextElement("<!--addComment(XmlElement xmlElement)")); //$NON-NLS-1$
//
//        StringBuilder sb = new StringBuilder();
////        sb.append("  WARNING - "); //$NON-NLS-1$
////        sb.append(MergeConstants.NEW_ELEMENT_TAG);
//        sb.append("");
//        xmlElement.addElement(new TextElement(sb.toString()));
//        xmlElement.addElement(
//                new TextElement("  This element is automatically generated by MyBatis Generator," //$NON-NLS-1$
//                        + " do not modify.")); //$NON-NLS-1$
//
//        String s = getDateString();
//        if (s != null) {
//            sb.setLength(0);
//            sb.append("  This element was generated on "); //$NON-NLS-1$
//            sb.append(s);
//            sb.append('.');
//            xmlElement.addElement(new TextElement(sb.toString()));
//        }
//
//        xmlElement.addElement(new TextElement("-->")); //$NON-NLS-1$
//        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void addRootComment(XmlElement rootElement) {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        // add no document level comments by default
    }

    /**
     * 可以进行一些特殊说明
     *
     * @param javaElement       the java element
     * @param markAsDoNotDelete the mark as do not delete
     */
    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
//        javaElement.addJavaDocLine(" *"); //$NON-NLS-1$
//        StringBuilder sb = new StringBuilder();
//        sb.append(" * "); //$NON-NLS-1$
//        sb.append(MergeConstants.NEW_ELEMENT_TAG);
//        if (markAsDoNotDelete) {
//            sb.append(" do_not_delete_during_merge"); //$NON-NLS-1$
//        }
//        String s = getDateString();
//        if (s != null) {
//            sb.append(' ');
//            sb.append(s);
//        }
//        javaElement.addJavaDocLine(sb.toString());
    }

    /**
     * Returns a formated date string to include in the Javadoc tag and XML
     * comments. You may return null if you do not want the date in these
     * documentation elements.
     * 
     * @return a string representing the current timestamp, or null
     */
    protected String getDateString() {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        if (suppressDate) {
            return null;
        } else if (dateFormat != null) {
            return dateFormat.format(new Date());
        } else {
            return new Date().toString();
        }
    }
    
    /** 
     * 可能是一个内部静态类
     * 例如：
     * protected abstract static class GeneratedCriteria {
     * public static class Criterion {
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
//        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
//        if (suppressAllComments) {
//            return;
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        innerClass.addJavaDocLine("/**"); //$NON-NLS-1$
//        innerClass.addJavaDocLine(" * addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable)"
//            + "This class was generated by MyBatis Generator."); //$NON-NLS-1$
//
//        sb.append(" * This class corresponds to the database table "); //$NON-NLS-1$
//        sb.append(introspectedTable.getFullyQualifiedTable());
//        innerClass.addJavaDocLine(sb.toString());
//
//        addJavadocTag(innerClass, false);
//
//        innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /**
     * 可能是一个内部类：
     * public static class Criteria extends GeneratedCriteria {
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {
//        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
//        if (suppressAllComments) {
//            return;
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        innerClass.addJavaDocLine("/**addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete)"); //$NON-NLS-1$
//        innerClass.addJavaDocLine(" * This class was generated by MyBatis Generator."); //$NON-NLS-1$
//
//        sb.append(" * This class corresponds to the database table "); //$NON-NLS-1$
//        sb.append(introspectedTable.getFullyQualifiedTable());
//        innerClass.addJavaDocLine(sb.toString());
//
//        addJavadocTag(innerClass, markAsDoNotDelete);
//
//        innerClass.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /**
     * 子类重写了
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        if (suppressAllComments) {
            return;
        }

        StringBuilder sb = new StringBuilder();

        innerEnum.addJavaDocLine("/**addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable)"); //$NON-NLS-1$
        innerEnum.addJavaDocLine(" * This enum was generated by MyBatis Generator."); //$NON-NLS-1$

        sb.append(" * This enum corresponds to the database table "); //$NON-NLS-1$
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerEnum.addJavaDocLine(sb.toString());

        addJavadocTag(innerEnum, false);

        innerEnum.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /** 
     * 子类重写了 
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
    }

    /** 
     * 非databaseModel字段添加注释
     * 例如： private static final long serialVersionUID = 1L;
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
//        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
//        if (suppressAllComments) {
//            return;
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        field.addJavaDocLine("/**addFieldComment(Field field, IntrospectedTable introspectedTable)"); //$NON-NLS-1$
//        field.addJavaDocLine(" * This field was generated by MyBatis Generator."); //$NON-NLS-1$
//
//        sb.append(" * This field corresponds to the database table "); //$NON-NLS-1$
//        sb.append(introspectedTable.getFullyQualifiedTable());
//        field.addJavaDocLine(sb.toString());
//
//        addJavadocTag(field, false);
//
//        field.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    /** 
     * 
     * 普通方法 或者接口方法
     * 例如：
     * @Override
       public String toString() {
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
//        if (suppressAllComments) {
//            return;
//        }
//
//        StringBuilder sb = new StringBuilder();
//
//        method.addJavaDocLine("/**addGeneralMethodComment(Method method, IntrospectedTable introspectedTable)"); //$NON-NLS-1$
//        method.addJavaDocLine(" * This method was generated by MyBatis Generator."); //$NON-NLS-1$
//
//        sb.append(" * This method corresponds to the database table "); //$NON-NLS-1$
//        sb.append(introspectedTable.getFullyQualifiedTable());
//        method.addJavaDocLine(sb.toString());
//
//        addJavadocTag(method, false);
//
//        method.addJavaDocLine(" */"); //$NON-NLS-1$
    }

    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn) {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,
            Set<FullyQualifiedJavaType> imports) {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        imports.add(new FullyQualifiedJavaType("javax.annotation.Generated")); //$NON-NLS-1$
        String comment = "addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,\r\n" + 
            "            Set<FullyQualifiedJavaType> imports) {  Source Table: " + introspectedTable.getFullyQualifiedTable().toString(); //$NON-NLS-1$
        method.addAnnotation(getGeneratedAnnotation(comment));
    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        imports.add(new FullyQualifiedJavaType("javax.annotation.Generated")); //$NON-NLS-1$
        String comment = "addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable,\r\n" + 
            "            IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {   Source field: " //$NON-NLS-1$
                + introspectedTable.getFullyQualifiedTable().toString() + "." //$NON-NLS-1$
                + introspectedColumn.getActualColumnName();
        method.addAnnotation(getGeneratedAnnotation(comment));
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,
            Set<FullyQualifiedJavaType> imports) {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        imports.add(new FullyQualifiedJavaType("javax.annotation.Generated")); //$NON-NLS-1$
        String comment = "addFieldAnnotation(Field field, IntrospectedTable introspectedTable,\r\n" + 
            "            Set<FullyQualifiedJavaType> imports) {  Source Table: " + introspectedTable.getFullyQualifiedTable().toString(); //$NON-NLS-1$
        field.addAnnotation(getGeneratedAnnotation(comment));
    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable,
            IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        imports.add(new FullyQualifiedJavaType("javax.annotation.Generated")); //$NON-NLS-1$
        String comment = "addFieldAnnotation(Field field, IntrospectedTable introspectedTable,\r\n" + 
            "            IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> imports) { Source field: " //$NON-NLS-1$
                + introspectedTable.getFullyQualifiedTable().toString() + "." //$NON-NLS-1$
                + introspectedColumn.getActualColumnName();
        field.addAnnotation(getGeneratedAnnotation(comment));

        if (!suppressAllComments && addRemarkComments) {
            String remarks = introspectedColumn.getRemarks();
            if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
                field.addJavaDocLine("/**"); //$NON-NLS-1$
                field.addJavaDocLine(" * Database Column Remarks:"); //$NON-NLS-1$
                String[] remarkLines = remarks.split(System.getProperty("line.separator")); //$NON-NLS-1$
                for (String remarkLine : remarkLines) {
                    field.addJavaDocLine(" *   " + remarkLine); //$NON-NLS-1$
                }
                field.addJavaDocLine(" */"); //$NON-NLS-1$
            }
        }
    }

    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable,
            Set<FullyQualifiedJavaType> imports) {
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        imports.add(new FullyQualifiedJavaType("javax.annotation.Generated")); //$NON-NLS-1$
        String comment = "addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable,\r\n" + 
            "            Set<FullyQualifiedJavaType> imports) {   Source Table: " + introspectedTable.getFullyQualifiedTable().toString(); //$NON-NLS-1$
        innerClass.addAnnotation(getGeneratedAnnotation(comment));
    }

    private String getGeneratedAnnotation(String comment) {
        StringBuilder buffer = new StringBuilder();
        LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
        buffer.append("getGeneratedAnnotation(String comment)   @Generated("); //$NON-NLS-1$
        if (suppressAllComments) {
            buffer.append('\"');
        } else {
            buffer.append("value=\""); //$NON-NLS-1$
        }

        buffer.append(MyBatisGenerator.class.getName());
        buffer.append('\"');

        if (!suppressDate && !suppressAllComments) {
            buffer.append(", date=\""); //$NON-NLS-1$
            buffer.append(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now()));
            buffer.append('\"');
        }

        if (!suppressAllComments) {
            buffer.append(", comments=\""); //$NON-NLS-1$
            buffer.append(comment);
            buffer.append('\"');
        }

        buffer.append(')');
        return buffer.toString();
    }

    @Override
    public void addFileComment(KotlinFile kotlinFile) {
        if (suppressAllComments) {
            LOG.info(Constants.METHOD_START_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
            return;
        }

        kotlinFile.addFileCommentLine("/*  addFileComment(KotlinFile kotlinFile)"); //$NON-NLS-1$
        kotlinFile.addFileCommentLine(" * Auto-generated file. Created by MyBatis Generator"); //$NON-NLS-1$
        if (!suppressDate) {
            kotlinFile.addFileCommentLine(" * Generation date: " //$NON-NLS-1$
                    + DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(ZonedDateTime.now()));
        }
        kotlinFile.addFileCommentLine(" */"); //$NON-NLS-1$
        LOG.info(Constants.METHOD_END_TEMPLETE, this.getClass().getName(), Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
