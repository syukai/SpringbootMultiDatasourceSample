package com.example.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRoutingDataSourceResolver extends AbstractRoutingDataSource {

	/**
	 * 使用するデータソースキーを返却する
	 */
	@Override
    protected Object determineCurrentLookupKey() {
        if (SchemaContextHolder.getSchemaType() == null) {
        	// デフォルト
            return "datasource1";

        } else if(SchemaContextHolder.getSchemaType() == SchemaType.DATA1) {
            return "datasource1";

        } else if(SchemaContextHolder.getSchemaType() == SchemaType.DATA2) {
            return "datasource2";

        }else{
        	// デフォルト
            return "datasource1";
        }
    }

}
