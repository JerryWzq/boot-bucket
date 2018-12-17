package com.wzq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class})
@MapperScan("com.wzq.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        Properties properties = System.getProperties();
//        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
//        for(Map.Entry entry : entries){
//            System.err.println(entry.getKey() + "---" + entry.getValue());
//        }
//
//        System.err.println("============================================================");
//
//        Map<String, String> envs = System.getenv();
//        Set<Map.Entry<String, String>> entries1 = envs.entrySet();
//        for(Map.Entry entry : entries1){
//            System.err.println(entry.getKey() + "===" + entry.getValue());
//        }

        Runtime runtime = Runtime.getRuntime();
        try {
            Process p = runtime.exec("\"D:\\Program Files\\Notepad++\\notepad++.exe\"");
            Thread.sleep(10000);
            p.destroy();
            System.out.println("nodePad++>>>>>>>>"+p.exitValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
