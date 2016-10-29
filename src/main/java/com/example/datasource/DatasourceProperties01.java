package com.example.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("datasource.data1")
public class DatasourceProperties01 extends AbstractDatasourceProperties {
}
