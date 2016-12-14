package com.health.care.management;

import static com.health.care.management.constant.Constant.SQL_DRIVER;
import static com.health.care.management.constant.Constant.SQL_PASSWORD;
import static com.health.care.management.constant.Constant.SQL_URL;
import static com.health.care.management.constant.Constant.SQL_USERNAME;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class HealthCareServiceConfiguration {

    // Single DB connection to be maintained accross application
    private static JdbcTemplate jdbcTemplate = null;
    public static JdbcTemplate getJdbcConnection() {
        if (null == jdbcTemplate) {
        try {
        Properties properties = new Properties();
        InputStream ioStream = HealthCareServiceApplication.class.getClassLoader().getResourceAsStream("application.properties");

            properties.load(ioStream);

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(properties.getProperty(SQL_URL));
        dataSource.setUsername(properties.getProperty(SQL_USERNAME));
        dataSource.setPassword(properties.getProperty(SQL_PASSWORD));
        dataSource.setDriverClassName(properties.getProperty(SQL_DRIVER));
                jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (IOException execption) {

            System.out.println("Error occured while reading the property file. Please configure it in right path" + execption.getMessage());
        }
        }
        return jdbcTemplate;
    }
}
