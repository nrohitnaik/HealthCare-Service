package com.health.care.management;

import static com.health.care.management.constant.Constant.SQL_DRIVER;
import static com.health.care.management.constant.Constant.SQL_PASSWORD;
import static com.health.care.management.constant.Constant.SQL_URL;
import static com.health.care.management.constant.Constant.SQL_USERNAME;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class HealthCareServiceConfiguration {
	private final static Logger LOGGER = Logger.getLogger(HealthCareServiceConfiguration.class);
	// Single DB connection to be maintained across application
	private static JdbcTemplate jdbcTemplate = null;

	/**
	 * This methods return the jdbc connection if connection doesn't exists and
	 * single connection is maintained across the application
	 * 
	 * @return JdbcTemplate
	 */
	public static JdbcTemplate getJdbcConnection() {
		if (null == jdbcTemplate) {
			LOGGER.info("Creating jdbc instacane..");
			try {
				Properties properties = new Properties();
				InputStream ioStream = HealthCareServiceApplication.class.getClassLoader()
						.getResourceAsStream("application.properties");

				properties.load(ioStream);

				DriverManagerDataSource dataSource = new DriverManagerDataSource();
				dataSource.setUrl(properties.getProperty(SQL_URL));
				dataSource.setUsername(properties.getProperty(SQL_USERNAME));
				dataSource.setPassword(properties.getProperty(SQL_PASSWORD));
				dataSource.setDriverClassName(properties.getProperty(SQL_DRIVER));
				jdbcTemplate = new JdbcTemplate(dataSource);
				LOGGER.info("Database connection has been successfully established");
			} catch (IOException execption) {
				LOGGER.error("Exception occured while creating db connection " + execption.getMessage());
				System.out.println("Error occured while reading the property file. Please configure it in right path");
			}
		}
		return jdbcTemplate;
	}
}
