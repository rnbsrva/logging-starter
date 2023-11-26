package com.akerke.loggingstarter.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Annotation to enable logging for methods in a class.
 * When applied to a class, this annotation triggers logging for each method within the annotated class.
 * The logged information includes the class name, method name, execution time, and the specified application name.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableLoggerLib {
}
