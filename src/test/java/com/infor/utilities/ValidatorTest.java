package com.infor.utilities;

import org.junit.Test;

import com.infor.exception.TechnicalException;

public class ValidatorTest {

	@Test(expected = TechnicalException.class)
	public void testValidateFileType_throwsException() throws TechnicalException {
		Validator.validateFileType("json");
	}
	
	@Test
	public void testValidateFileType() throws TechnicalException {
		Validator.validateFileType("text");
	}

}
