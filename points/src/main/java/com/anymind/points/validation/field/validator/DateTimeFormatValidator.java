package com.anymind.points.validation.field.validator;

import com.anymind.points.validation.field.IsDateFormatValid;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateTimeFormatValidator implements ConstraintValidator<IsDateFormatValid, String> {

	private String format;
	
	
	@Override
	public void initialize(IsDateFormatValid constraintAnnotation) {
		format = constraintAnnotation.format();
	}


	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return isValidFormat(format, value);
	}
    private static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            if (value != null){
                date = sdf.parse(value);
                if (!value.equals(sdf.format(date))) {
                    date = null;
                }
            }

        } catch (ParseException ex) {
        	return false;
        }
        return  date != null;
    }

}
