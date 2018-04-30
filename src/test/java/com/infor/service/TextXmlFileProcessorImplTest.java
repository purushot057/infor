package com.infor.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

public class TextXmlFileProcessorImplTest {

	FileProcessor fileProcessor;
	ClassLoader classLoader;

	@Before
	public void setup() {
		classLoader = getClass().getClassLoader();
	}

	@Test
	public void testProcessFile_textFormat() throws IOException {
		fileProcessor = FileProcessorFactory.getFileProcessor("text");
		File resultFile = new File(classLoader.getResource("result.txt").getFile());
		File targetFile = new File(classLoader.getResource("demo.txt").getFile());
		fileProcessor.processFile(classLoader.getResource("demo.txt").getFile(),
				classLoader.getResource("result.txt").getFile(), "abc", "pqr");
		String input = IOUtils.toString(new FileInputStream(targetFile), "UTF-8");
		String output = IOUtils.toString(new FileInputStream(resultFile), "UTF-8");
		assertTrue(input.contains("abc"));
		assertFalse(output.contains("abc"));
		assertEquals(resultFile.getTotalSpace(), targetFile.getTotalSpace());
	}

	@Test
	public void testProcessFile_xmlFormat() throws IOException {
		fileProcessor = FileProcessorFactory.getFileProcessor("xml");
		File resultFile = new File(classLoader.getResource("result.xml").getFile());
		File targetFile = new File(classLoader.getResource("demo.xml").getFile());
		fileProcessor.processFile(classLoader.getResource("demo.xml").getFile(),
				classLoader.getResource("result.xml").getFile(), "=\"abc\"", "=\"pqr\"");
		String input = IOUtils.toString(new FileInputStream(targetFile), "UTF-8");
		String output = IOUtils.toString(new FileInputStream(resultFile), "UTF-8");
		assertTrue(input.contains("=\"abc\""));
		assertFalse(output.contains("=\"abc\""));
		assertEquals(resultFile.getTotalSpace(), targetFile.getTotalSpace());
	}

}
