package org.practice.spring.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.practice.ssmPractice.conifg.JDBCConfig;
import org.practice.ssmPractice.conifg.SpringConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JDBCConfig.class)
public class ConfigTest {

//    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProptertiesConfig.class);
//    ConfigurableEnvironment env = context.getEnvironment();
    @Autowired
    private Environment env;
    @Value("${jdbc.driver}")
    private String driver;


    @Test
    public void configTest(){
        System.out.println(driver);
        System.out.println(env.getProperty("jdbc.username"));
    }



}
