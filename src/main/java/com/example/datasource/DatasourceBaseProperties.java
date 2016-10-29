package com.example.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("my.datasource.abstract")
public class DatasourceBaseProperties {
	private String driverClassName;
	private String SqlScriptEncoding;
	private Integer maxActive;
	private Integer maxIdle;
	private Integer minIdle;
	private Integer initialSize;
	private String validationQuery;
	private Boolean testOnBorrow;
	private Boolean testWhileIdle;
	private Integer timeBetweenEvictionRunsMillis;
	private Integer minEvictableIdleTimeMillis;
}
