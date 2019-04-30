package com.example.demo22.annotation;


import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(ImportSelectorTest.class)
public @interface AutoConfigurationTest {
    String policy() default "fly";
}
