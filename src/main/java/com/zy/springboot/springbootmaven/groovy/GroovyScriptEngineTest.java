package com.zy.springboot.springbootmaven.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.lang.GroovyShell;

/**
 * groovy脚本
 * 可以接受前台传送过来的java代码，运行。
 */
public class GroovyScriptEngineTest {

    public static void main(String[] args) throws Exception{
       /* Binding binding = new Binding();
        binding.setVariable("javaFunction",new JavaFunction());
        binding.setVariable("custom","123");
        binding.setVariable("str1","name");
        GroovyShell gs = new GroovyShell(binding);
        Object value = gs.evaluate("return javaFunction.run()");
        Object value1 = gs.evaluate("return custom");
       // Object value2 = gs.evaluate("return  javaFunction.run1("1","str1")");
        Object value3 = gs.evaluate("return  javaFunction.run2('146345343')");*/

        StringBuilder sb = new StringBuilder();
        sb.append("public class Test implements Runnable{ public void run(){ System.out.println(\"123\")}} ");

        GroovyClassLoader loader = new GroovyClassLoader();
        Class groovyClass = loader.parseClass(sb.toString());
        Runnable groovyObject = (Runnable)groovyClass.newInstance();
        //groovyObject.invokeMethod("run",null);
        groovyObject.run();

    }
}
