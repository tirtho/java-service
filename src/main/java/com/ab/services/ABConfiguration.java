package com.ab.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ABConfiguration {
	private static String POSTGRES_DATABASE_URL = "com.ab.services.databases.postgres.url";
	private static String POSTGRES_DATABASE_USER = "com.ab.services.databases.postgres.user";
	private static String POSTGRES_DATABASE_PASSWORD = "com.ab.services.databases.postgres.password";
	private static String PROPERTIES_FILE = "META-INF/service.properties";
	private String postgresUrl;
	
	public String getPostgresUrl() {
		return postgresUrl;
	}

	public void setPostgresUrl(String postgresUrl) {
		this.postgresUrl = postgresUrl;
	}

	public String getPostgresUser() {
		return postgresUser;
	}

	public void setPostgresUser(String postgresUser) {
		this.postgresUser = postgresUser;
	}

	public String getPostgresPassword() {
		return postgresPassword;
	}

	public void setPostgresPassword(String postgresPassword) {
		this.postgresPassword = postgresPassword;
	}

	private String postgresUser;
	private String postgresPassword;
		
    private static final Logger logger = Logger.getLogger(ABConfiguration.class.getName());

	public ABConfiguration() {
		super();
		try {
			Configuration config = new PropertiesConfiguration(PROPERTIES_FILE);
			setPostgresUrl(config.getString(POSTGRES_DATABASE_URL));
			setPostgresUser(config.getString(POSTGRES_DATABASE_USER));
			setPostgresPassword(config.getString(POSTGRES_DATABASE_PASSWORD));			
		} catch (ConfigurationException ex) {
			logger.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
}
