package com.aerolinea.api.domain;

import org.springframework.stereotype.Component;

import com.aerolinea.api.util.AerolineaProperties;

@Component
public class DatabaseCredentials {

	private final AerolineaProperties properties;

	public DatabaseCredentials(AerolineaProperties properties) {
		this.properties = properties;
	}

	private String host;

	private String port;

	private String engine;

	private String username;

	private String password;

	private String dbname;

	private String dbInstanceIdentifier;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getDbInstanceIdentifier() {
		return dbInstanceIdentifier;
	}

	public void setDbInstanceIdentifier(String dbInstanceIdentifier) {
		this.dbInstanceIdentifier = dbInstanceIdentifier;
	}

	public DatabaseCredentials getDataCredentials() {
		this.host = properties.getConection();
		this.port = properties.getPort();
		this.password = properties.getPassword();
		this.username = properties.getUsername();
		this.engine = properties.getEngine();
		return this;
	}

}
