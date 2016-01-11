package com.github.aesteve.groovy.decorators.annot

import org.codehaus.groovy.transform.GroovyASTTransformationClass

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
@GroovyASTTransformationClass(["com.github.aesteve.groovy.decorators.DecorateTransformation"])
@interface Decorate {
    String value()
}