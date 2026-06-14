package com.comigo.vem.validations;

import java.time.LocalDate;
import java.time.Period;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AdultValidator implements ConstraintValidator<Adult, LocalDate>{
	
	private int minAge;
	
    @Override
    public void initialize(Adult constraintAnnotation) {
        this.minAge = constraintAnnotation.minAge();
    }
	
    @Override
	public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
		if (value == null) {
            return true; // @NotNull trata isso
        }
		return Period.between(value, LocalDate.now())
                .getYears() >= 18;
	}
	
}
	
	

