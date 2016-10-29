package com.example.datasource;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class DatasourceConfig {
	@Autowired
	DatasourceBaseProperties datasourceBase;
	
	@Autowired
	DatasourceProperties01 datasourceP01;
	
	@Autowired
	DatasourceProperties02 datasourceP02;
    
//	@Bean
	public DataSource datasource1(){
		DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		ds.setDriverClassName(this.datasourceBase.getDriverClassName());
		ds.setUrl(this.datasourceP01.getUrl());
		ds.setUsername(this.datasourceP01.getUsername());
		ds.setPassword(this.datasourceP01.getPassword());
		return ds;
	}

//	@Bean
	public DataSource datasource2(){
		DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		ds.setDriverClassName(this.datasourceBase.getDriverClassName());
		ds.setUrl(this.datasourceP02.getUrl());
		ds.setUsername(this.datasourceP02.getUsername());
		ds.setPassword(this.datasourceP02.getPassword());
		return ds;
	}

    @Bean
//    @Primary
    public DynamicRoutingDataSourceResolver dataSource() {
        DynamicRoutingDataSourceResolver resolver = new DynamicRoutingDataSourceResolver();

        Map<Object, Object> dataSources = new HashMap<Object,Object>();
        dataSources.put("datasource1", datasource1());
        dataSources.put("datasource2", datasource2());

        resolver.setTargetDataSources(dataSources);
        
        // default datasource
        resolver.setDefaultTargetDataSource(datasource1());

        return resolver;
    }
}
