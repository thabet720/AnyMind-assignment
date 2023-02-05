package com.anymind.points.validation.field;

import com.anymind.points.validation.field.validator.DateTimeFormatValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = DateTimeFormatValidator.class)
@Target({ ElementType.TYPE, ElementType.FIELD,ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IsDateFormatValid {
	  String message() default "com.anymind.points.validation.field.IsDateFormatValid.message";
	  Class <?> [] groups() default {};
	  Class <? extends Payload> [] payload() default {};
	  String format() default "yyyy-MM-dd'T'hh:mm:ss'z'";
	 
}
