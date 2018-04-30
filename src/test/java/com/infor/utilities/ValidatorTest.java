package com.infor.utilities;

import org.junit.Test;

public class ValidatorTest {

	@Test(expected = IllegalArgumentException.class)
	public void testValidateFileType_throwsException() {
		Validator.validateFileType("json");
	}
	
	@Test
	public void testValidateFileType() {
		Validator.validateFileType("text");
	}

}
