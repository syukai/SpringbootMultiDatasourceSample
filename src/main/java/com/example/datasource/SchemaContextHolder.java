package com.example.datasource;

import org.springframework.util.Assert;

public class SchemaContextHolder {
    private static ThreadLocal<SchemaType> contextHolder = new ThreadLocal<SchemaType>();
    
//    public class Schema{
//    	public static final String DATA1 = "datasource1";
//    	public static final String DATA2 = "datasource2";
//    }
    
    public static void setSchemaType(SchemaType datasourcename) {
        Assert.notNull(datasourcename, "Schema type cannot be null.");
        contextHolder.set(datasourcename);
    }

    public static SchemaType getSchemaType() {
        return contextHolder.get();
    }

    public static void clear() {
        contextHolder.remove();
    }
}
