package com.infor.utilities;

import com.infor.exception.TechnicalException;

/**
 * This class contains the validation methods that are invoked before processing
 * the file
 * 
 * @author Purushottam S.
 * @version 1.0
 *
 */
public class Validator {

	public static void validateFileType(String type) throws TechnicalException {
		if (!(type.equalsIgnoreCase("text") || type.equalsIgnoreCase("xml"))) {
			throw new TechnicalException("File format not supported");
		}
	}

}
