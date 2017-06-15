package com.homelibrary.annotation;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateFormatValidator implements ConstraintValidator<DateFormat, String>{
	

	@Override
	public void initialize(DateFormat ConstraintAnnotation){
		
	}
	
	@Override
	public boolean isValid(String releaseDate, ConstraintValidatorContext constraintValidatorContext){
		   SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");

		   try{
			   df.parse(releaseDate);
		   return true;
		}catch (ParseException e){
			return false;
		}
	}
}

