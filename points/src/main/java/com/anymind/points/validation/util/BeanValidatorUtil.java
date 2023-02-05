package com.anymind.points.validation.util;

import com.anymind.points.validation.exception.ValidatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BeanValidatorUtil {
	 private static Validator VALIDATOR;

	  @Autowired
	  public BeanValidatorUtil(Validator validator) {
	    BeanValidatorUtil.VALIDATOR = validator;
	  }
	 

	  public static <T> void validate(T t) throws ValidatorException {
	
	    Set<ConstraintViolation<T>> constraintViolations = VALIDATOR.validate(t, Default.class);
	    if (constraintViolations.size() > 0) {
	      List<String> errorMsgs = new ArrayList<>(constraintViolations.size());
	      for (ConstraintViolation<T> constraintViolation : constraintViolations) {
	        errorMsgs.add(constraintViolation.getPropertyPath().toString() + " " + constraintViolation.getMessage());
	      }
	      throw new ValidatorException(errorMsgs);
	    }
	  }

}
