package org.practice.ssmPractice.conifg;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"org.practice.ssmPractice"}, excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}))
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class SpringConfig {

    @Value("${jdbc.driver}") String driverClassName;
    @Value("${jdbc.url}") String url;
    @Value("${jdbc.username}") String username;
    @Value("${jdbc.password}") String password;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        System.out.println("connecting datasource, driver: " + driverClassName);
        dataSource.setDriverClassName(driverClassName);
        System.out.println("connecting datasource, url: " + url);
        dataSource.setUrl(url);
        System.out.println("connecting datasource, username: " + username);
        dataSource.setUsername(username);
        System.out.println("connecting datasource, password: " + password);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());
        return transactionManager;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        // sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setTypeAliasesPackage("org.practice.ssmPractice.pojo");
        // sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));

        // 设置 MyBatis 配置属性
        Properties properties = new Properties();
        properties.setProperty("mapUnderscoreToCamelCase", "true");
//        Map<String, Object> configurationProperties = new HashMap<>();
//        configurationProperties.put("mapUnderscoreToCamelCase", true);
        sqlSessionFactoryBean.setConfigurationProperties(properties);

        // 添加分页插件
        sqlSessionFactoryBean.setPlugins(new PageInterceptor());
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("org.practice.ssmPractice.mapper");
        return mapperScannerConfigurer;
    }
}
