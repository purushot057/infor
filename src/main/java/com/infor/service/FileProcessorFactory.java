package com.infor.service;

/**
 * Factory class for FileProcessor interface
 * 
 * @author Purushottam S.
 * @version 1.0
 *
 */
public class FileProcessorFactory {
	
	private FileProcessorFactory() {
		// Ensures this class is not instantiated
	}

	public static FileProcessor getFileProcessor(String fileType) {
		if (fileType.equalsIgnoreCase("text") || fileType.equalsIgnoreCase("xml")) {
			return new TextXmlFileProcessorImpl();
		}
		return null;
	}

}
