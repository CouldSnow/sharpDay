package com.zy.springboot.springbootmaven.utils;

import groovy.lang.GroovyClassLoader;

public class GroovyHelper {
    private static final  GroovyClassLoader loader = new GroovyClassLoader();

    /**
     * 自定义java脚本返回java对象,因为是泛型 所以可以返回任意对象
     * @param classContent
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T getEntity(String classContent) throws Exception{
        Class groovyClass = loader.parseClass(classContent);
        T groovyObject = (T)groovyClass.newInstance();
        //groovyObject.invokeMethod("run",null);
        return  groovyObject;
    }

    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("public class Test implements Runnable{ public void run(){ System.out.println(\"123\")}} ");

        Runnable runnable = GroovyHelper.getEntity(sb.toString());
        runnable.run();
    }
}
