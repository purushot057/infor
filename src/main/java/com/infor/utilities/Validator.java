package com.infor.utilities;

/**
 * This class contains the validation methods that are invoked before processing
 * the file
 * 
 * @author Purushottam S.
 * @version 1.0
 *
 */
public class Validator {

	public static void validateFileType(String type) {
		if (!(type.equalsIgnoreCase("text") || type.equalsIgnoreCase("xml"))) {
			throw new IllegalArgumentException("File format not supported");
		}
	}

}
