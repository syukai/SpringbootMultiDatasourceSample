package com.example.datasource;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.MappedInterceptor;

@Component
@Configuration
public class DatasourceConfig {
	@Autowired
	DatasourceBaseProperties datasourceBase;
	
	@Autowired
	DatasourceProperties01 datasourceP01;
	
	@Autowired
	DatasourceProperties02 datasourceP02;
    

    @Bean
    @Primary
    public DynamicRoutingDataSourceResolver dataSource() {
        DynamicRoutingDataSourceResolver resolver = new DynamicRoutingDataSourceResolver();

        Map<Object, Object> dataSources = new HashMap<Object,Object>();
        dataSources.put("datasource1", datasourceP01.createDataSourceBean());
        dataSources.put("datasource2", datasourceP02.createDataSourceBean());

        resolver.setTargetDataSources(dataSources);
        
        // default datasource
        resolver.setDefaultTargetDataSource(datasourceP01.createDataSourceBean());

        return resolver;
    }
    
    @Bean
    public HandlerInterceptor datasourceInterceptor(){
    	return new com.example.interceptor.DatasourceInterceptor();
    }
    
    @Bean
    public MappedInterceptor interceptorMapping(){
    	return new MappedInterceptor(new String[]{"/**"}, datasourceInterceptor());
    }
}
