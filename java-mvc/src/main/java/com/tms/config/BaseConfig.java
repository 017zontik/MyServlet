package com.tms.config;

import com.tms.dao.UserDao;
import com.tms.dao.IUserDao;
import com.tms.service.UserService;
import com.tms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class BaseConfig {

    @Autowired
    private Environment environment;

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(environment.getProperty("url"));
        ds.setUsername(environment.getProperty("login"));
        ds.setPassword(environment.getProperty("password"));
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        return ds;
    }

    @Bean
    public IUserDao getUserDao(){
        return new UserDao(getJdbcTemplate());
    }

    @Bean
    public IUserService getUserService() {
        return  new UserService();
    }



}
