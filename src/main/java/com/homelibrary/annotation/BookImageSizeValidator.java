package com.homelibrary.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class BookImageSizeValidator implements ConstraintValidator<BookImageSize, MultipartFile> {

	public static final long FOUR_MB_IN_BYTES = 4194304;
	
	@Override
	public void initialize(BookImageSize constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(MultipartFile bookImage, ConstraintValidatorContext context) {
		
		if(bookImage.getSize() < FOUR_MB_IN_BYTES){
			return true;
		}
		return false;
	}
	
	

}
