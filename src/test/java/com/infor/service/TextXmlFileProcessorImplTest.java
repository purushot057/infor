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
		fileProcessor = FileProcessorFactory.getFileProcessor("text");
		File resultFile = new File(getClass().getClassLoader().getResource("result.txt").getFile());
		File targetFile = new File(getClass().getClassLoader().getResource("demo.txt").getFile());
		fileProcessor.processFile(getClass().getClassLoader().getResource("demo.txt").getFile(),
				getClass().getClassLoader().getResource("result.txt").getFile(), "abc", "pqr");
		String result = IOUtils.toString(new FileInputStream(resultFile), "UTF-8");
		Assert.assertFalse(result.contains("abc"));
		Assert.assertEquals(resultFile.getTotalSpace(), targetFile.getTotalSpace());
	}

	@Test
	public void testProcessFile_xmlFormat() throws FileNotFoundException, IOException {
		fileProcessor = FileProcessorFactory.getFileProcessor("xml");
		File resultFile = new File(getClass().getClassLoader().getResource("result.xml").getFile());
		File targetFile = new File(getClass().getClassLoader().getResource("demo.xml").getFile());
		fileProcessor.processFile(getClass().getClassLoader().getResource("demo.xml").getFile(),
				getClass().getClassLoader().getResource("result.xml").getFile(), "=\"abc\"", "=\"pqr\"");
		String result = IOUtils.toString(new FileInputStream(resultFile), "UTF-8");
		Assert.assertFalse(result.contains("=\"abc\""));
		Assert.assertEquals(resultFile.getTotalSpace(), targetFile.getTotalSpace());
	}

}
