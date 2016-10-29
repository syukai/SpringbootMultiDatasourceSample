package com.example.datasource;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * データソース設定の管理クラス
 * @author u0268
 *
 */
@Component
@Configuration
public class DatasourceConfig {
    
	@Bean
	public DataSource datasource(){
		DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/sample01");
		ds.setUsername("user01");
		ds.setPassword("pass");
		return ds;
	}
}
