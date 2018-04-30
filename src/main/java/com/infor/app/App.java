package com.infor.app;

import com.infor.exception.TechnicalException;
import com.infor.service.FileProcessor;
import com.infor.service.FileProcessorFactory;

public class App {

	public static void main(String[] args) throws TechnicalException {

		if (args.length == 0) {
			throw new TechnicalException("No arguments passed");
		} else if (args.length < 3) {
			throw new TechnicalException("Insufficient arguments");
		} else {
			FileProcessor fileProcessor = FileProcessorFactory.getFileProcessor(args[0]);
			fileProcessor.processFile(args[1], args[2]);
		}

	}

}
