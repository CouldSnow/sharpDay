package com.zy.springboot.springbootmaven.groovy;

public class JavaFunction {

    public static int i=0;
    public String run(){
        return "运行了java代码";
    }

    public String run1(String str1,String str2){
        return str1+str2;
    }


    public void run2(String str1){
        System.out.println(str1);
    }
}
