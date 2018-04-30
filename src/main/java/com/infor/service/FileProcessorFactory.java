package com.infor.service;

import com.infor.utilities.Validator;

/**
 * Factory class for FileProcessor interface
 * 
 * @author Purushottam S.
 * @version 1.0
 *
 */
public class FileProcessorFactory {

	private FileProcessorFactory() {
		// Let it not be instantiated
	}

	public static FileProcessor getFileProcessor(String fileType) throws IllegalArgumentException {
		Validator.validateFileType(fileType);
		if (fileType.equalsIgnoreCase("text") || fileType.equalsIgnoreCase("xml")) {
			return new TextXmlFileProcessorImpl();
		}
		return null;
	}

}
