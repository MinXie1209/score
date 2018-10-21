package org.javatribe.score.annotation;

import java.lang.annotation.*;

/**
 * 验证token的注解
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TokenValid {

}