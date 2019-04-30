package com.example.demo22.annotation;

import java.lang.annotation.*;


//编译器将把注释记录在class文件中。当运行Java程序时，JVM也会保留注释，程序可以通过反射获取该注释。
@Retention(RetentionPolicy.RUNTIME)
//该Annotation只能修饰方法
@Target(ElementType.METHOD)
public @interface Test {
    String name() default "chenbilang";
    int value() default 0;
}
