package com.example.datasource;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class DatasourceConfig {
    
//	@Bean
	public DataSource datasource1(){
		DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/sample01");
		ds.setUsername("user01");
		ds.setPassword("pass");
		return ds;
	}

//	@Bean
	public DataSource datasource2(){
		DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/sample02");
		ds.setUsername("user02");
		ds.setPassword("pass");
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
