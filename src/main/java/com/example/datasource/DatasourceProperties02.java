package com.example.datasource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("datasource.data2")
public class DatasourceProperties02 extends AbstractDatasourceProperties {
}
