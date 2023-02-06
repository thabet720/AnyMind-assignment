package com.anymind.points.validation;

import com.anymind.points.validation.exception.ValidatorException;

public interface RuleValidator<T> {
	public void validate(T t) throws ValidatorException;
}
