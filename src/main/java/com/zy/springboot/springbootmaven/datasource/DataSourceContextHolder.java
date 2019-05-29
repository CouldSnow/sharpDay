package com.zy.springboot.springbootmaven.datasource;

/**
 * 数据源持有类
 */
public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setDataSource(String dbType){
        System.out.println("切换到"+dbType+"数据源");
        contextHolder.set(dbType);
    }
    public static String getDataSource(){
        return contextHolder.get();
    }
    public static void clearDataSource(){
        contextHolder.remove();
    }
}
