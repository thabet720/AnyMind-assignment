package com.anymind.points.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RuleConstraint {

  /**
   * Indicate the validator class
   */
  Class<? extends RuleValidator<?>> validateBy();

  /**
   * Indicate whether it's needed to validate the parent Object
   */
  boolean validateParent() default false;

}