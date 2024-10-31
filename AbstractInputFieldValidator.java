package com.stalk.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.ObjectUtils;

import com.stalk.validation.InputField;

public abstract class AbstractInputFieldValidator<T> implements ConstraintValidator<InputField, T> {
	private InputField field;
	
	@Override
	public void initialize(InputField constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		
		this.field = constraintAnnotation;
	}
	
	@Override
	public boolean isValid(T value, ConstraintValidatorContext context) {
		if (field.isRequried() && ObjectUtils.isEmpty(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(getInputField().value() + "을(를) 입력 해주세요.").addConstraintViolation();
			return false;
		}
		return isCustomValid(value, context);
	}
	
	abstract boolean isCustomValid(T value, ConstraintValidatorContext context);

	protected InputField getInputField() {
		return this.field;
	}
}