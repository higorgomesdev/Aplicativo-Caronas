package com.comigo.vem.validations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = AdultValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Adult {
	
	int minAge() default 18;
	
	String message() default "Usuário deve ter pelo menos 18 anos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
