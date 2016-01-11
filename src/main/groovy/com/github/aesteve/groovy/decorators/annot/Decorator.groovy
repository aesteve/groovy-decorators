package com.github.aesteve.groovy.decorators.annot

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
@interface Decorator {
	String value()
}