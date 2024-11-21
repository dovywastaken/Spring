package com.springmvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import com.springmvc.domain.Book;

@Component
public class UnitsInstockValidator implements Validator
{
	public boolean supports(Class<?> clazz) 
	{
		return Book.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) 
	{
		Book book = (Book) target;
		if(book.getUnitPrice() >= 10000 && book.getUnitsInstock() > 99) 
		{
			errors.rejectValue("unitsInstock", "UnitsInStockValidator.message");
		}
	}

	
	
}
