package com.anymind.points.validation.util;



import com.anymind.points.validation.RuleConstraint;
import com.anymind.points.validation.RuleValidator;
import com.anymind.points.validation.exception.ValidatorException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

public class RuleValidatorUtil {
	private RuleValidatorUtil() {}

	  /**
	   * Validation order : parent object first
	   *
	   * @param <T>
	   * @param t
	   */
	  public static <T> void validate(T t) {
	    List<RuleValidator<?>> validators = new ArrayList<>();
	    Class<?> targetClass = null;
	    RuleConstraint ruleConstraint;
	    try {
	      targetClass = t.getClass();
	      ruleConstraint = targetClass.getAnnotation(RuleConstraint.class);
	      validators.add(newValidateInstance(ruleConstraint.validateBy()));
	      while (ruleConstraint.validateParent()) {
	        targetClass = targetClass.getSuperclass();
	        ruleConstraint = targetClass.getAnnotation(RuleConstraint.class);
	        validators.add(0, newValidateInstance(ruleConstraint.validateBy()));
	      }
	    } catch (NullPointerException ex) {
	      throw new IllegalArgumentException("The validator for " + targetClass + " has not been registered", ex);
	    }
	    for (RuleValidator validator : validators) {
	      try {
	        validator.validate(t);
	      } catch (ValidatorException e) {
	        throw new ValidatorException(e.getMessage());
	      }
	    }
	  }

	  private static RuleValidator<?> newValidateInstance(Class<? extends RuleValidator<?>> clazz) {
	    RuleValidator<?> validator = null;
	    if (clazz.getAnnotation(Component.class) != null) {
	      try {
	        validator = ContextLoader.getCurrentWebApplicationContext().getBean(clazz.getSimpleName().toLowerCase(), RuleValidator.class);
	      } catch (BeansException e) {
	        // Ignore
	      }
	    }
	    if (validator == null) {
	      try {
	        validator = clazz.newInstance();
	      } catch (InstantiationException | IllegalAccessException e) {
	        throw new IllegalArgumentException("Can't initiailize validator for: " + clazz, e);
	      }
	    }
	    return validator;
	  }

}
