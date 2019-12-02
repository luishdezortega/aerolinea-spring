package com.aerolinea.api.config;

import static com.aerolinea.api.util.AerolineaConstants.DATABASE_NAME;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aerolinea.api.domain.DatabaseCredentials;

@Configuration
@EnableJpaRepositories(basePackages = { "com.aerolinea.api.repository" })
@EnableTransactionManagement
@ComponentScan(basePackages = "com.aerolinea")
@EntityScan(basePackages = "com.aerolinea")
@Profile("default")
public class DataSourceConfiguration {

	@Bean
	public DataSource dataSource(DatabaseCredentials credentials) {

		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceBuilder.url(new StringBuilder().append("jdbc:").append("mysql").append("://").append("127.0.0.1")
				.append(":").append("33060").append("/").append(DATABASE_NAME).toString());
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("secret");

		return dataSourceBuilder.build();
	}

}
