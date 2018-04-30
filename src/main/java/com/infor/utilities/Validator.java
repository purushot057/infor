package com.infor.utilities;

import com.infor.exception.TechnicalException;

public class Validator {

	public void validateFileType(String type) throws TechnicalException {
		if (!(type.equalsIgnoreCase("text") || type.equalsIgnoreCase("xml"))) {
			throw new TechnicalException("File format not supported");
		}
	}

}
