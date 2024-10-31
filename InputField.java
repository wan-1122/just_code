package com.stalk.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.stalk.validation.validator.InputFieldReportTypeValidator;
import com.stalk.validation.validator.InputFieldStringValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { InputFieldStringValidator.class, InputFieldReportTypeValidator.class })
public @interface InputField {
	String value();
	
	String message() default "%s";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

	boolean isRequried() default false;

	int byteLength() default 4000;
	
	int length() default 4000;

}
