package com.wwg.mybatis.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class Generator {
    
    public static void main(String[] args) {
        // 执行中的异常信息会保存在warnings中 
        List<String> warnings = new ArrayList<>();
           try {
               // true:生成的文件覆盖之前的
               boolean overwrite = true;
               // 读取配置,构造 Configuration 对象.  
               // 如果不想使用配置文件的话,也可以直接来 new Configuration(),然后给相应属性赋值.
               File configFile = new File("src/main/resources/generator.xml");
               ConfigurationParser cp = new ConfigurationParser(warnings);
               Configuration config = cp.parseConfiguration(configFile);
               DefaultShellCallback callback = new DefaultShellCallback(overwrite);
               MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
               myBatisGenerator.generate(null);
           } catch (Exception e) {
               e.printStackTrace();
           }
           
           for (String warning : warnings){
               System.out.println(warning);
           }
       }
    
  }

