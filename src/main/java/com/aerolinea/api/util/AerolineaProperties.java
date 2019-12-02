package com.aerolinea.api.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aerolinea")
public class AerolineaProperties {

	private String region;

	private String username;

	private String password;

	private String conection;

	private String port;

	private String engine;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public String getConection() {
		return conection;
	}

	public void setConection(String conection) {
		this.conection = conection;
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

	@Override
	public String toString() {
		return "AerolineaProperties [region=" + region + ", username=" + username + ", password=" + password
				+ ", conection=" + conection + ", port=" + port + ", engine=" + engine + "]";
	}

}
