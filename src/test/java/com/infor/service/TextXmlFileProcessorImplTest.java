package com.infor.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TextXmlFileProcessorImplTest {

	FileProcessor fileProcessor;

	@Test
	public void testProcessFile_textFormat() throws FileNotFoundException, IOException {
		fileProcessor = FileProcessorFactory.getFileProcessor("text", "abc", "pqr");
		File file = new File("C:\\data\\result1.txt");
		fileProcessor.processFile("C:\\data\\demo.txt", "C:\\data\\result.txt");
		String result = IOUtils.toString(new FileInputStream(file), "UTF-8");
		Assert.assertFalse(result.contains("abc"));
	}

	@Test
	public void testProcessFile_xmlFormat() throws FileNotFoundException, IOException {
		fileProcessor = FileProcessorFactory.getFileProcessor("xml", "=\"abc\"", "=\"pqr\"");
		File file = new File("C:\\data\\result.xml");
		fileProcessor.processFile("C:\\data\\demo.xml", "C:\\data\\result.xml");
		String result = IOUtils.toString(new FileInputStream(file), "UTF-8");
		Assert.assertFalse(result.contains("abc"));
	}

}
