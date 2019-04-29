package com.example.demo22.annotation;

import com.example.demo22.config.AutoFlyConfig;
import com.example.demo22.config.AutoWalkConfig;
import com.example.demo22.pojo.Fly;
import com.example.demo22.pojo.Walk;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

public class ImportSelectorTest implements ImportSelector{
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Class<?> annotationType = AutoConfigurationTest.class;
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(
                annotationType.getName(), false));
        String policy = attributes.getString("policy");
        if ("fly".equals(policy)) {
            return new String[] { Fly.class.getName() };
//            return new String[] { AutoFlyConfig.class.getName() };

        } else {
            return new String[] { Walk.class.getName() };
//            return new String[] { AutoWalkConfig.class.getName() };
        }
    }
}
