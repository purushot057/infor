package com.infor.service;

public class FileProcessorFactory {

	public static FileProcessor getFileProcessor(String fileType, String toReplace, String replaceWith) {
		if (fileType.equalsIgnoreCase("text") || fileType.equalsIgnoreCase("xml")) {
			return new TextXmlFileProcessorImpl(toReplace, replaceWith);
		}
		return null;
	}

}
