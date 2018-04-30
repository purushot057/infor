package com.infor.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infor.app.App;
import com.infor.utilities.ModifyingInputStream;

/**
 * Implementation class for Text and Xml file processor
 * 
 * @author Purushottam S.
 * @version 1.0
 *
 */
public class TextXmlFileProcessorImpl extends FileProcessor {

	private static final Logger LOG = LoggerFactory.getLogger(TextXmlFileProcessorImpl.class);

	public TextXmlFileProcessorImpl(String toReplace, String replaceWith) {
		super(toReplace, replaceWith);
	}

	@Override
	public void processFile() {
		LOG.info("Started processing file");

		String targetLocation = null;
		String resultLocation = null;
		Properties prop = new Properties();
		try (InputStream input = App.class.getClassLoader().getResourceAsStream("application.properties")) {
			// load properties file
			prop.load(input);
			// fetch the property values
			targetLocation = prop.getProperty("target.file.path");
			resultLocation = prop.getProperty("result.file.path");
		} catch (IOException ex) {
			LOG.error("Error loading properties file ", ex);
		}
		processFile(targetLocation, resultLocation);

		LOG.info("End processing file ");
	}

	@Override
	public void processFile(String targetLocation, String resultLocation) {
		LOG.info("Started processing file ");

		try (FileInputStream is = new FileInputStream(new File(targetLocation));
				FileOutputStream os = new FileOutputStream(new File(resultLocation));) {
			byte[] buf = new byte[4096];
			int read = 0;
			while ((read = is.read(buf)) > 0) {
				byte[] ret = replaceInByteArray(buf, toReplace, replaceWith);
				os.write(ret);
			}
		} catch (IOException e) {
			LOG.error("Error processing file ", e);
		}

		LOG.info("End processing file ");
	}

	private byte[] replaceInByteArray(byte[] buf, String toBeReplaced, String replaceWith) {
		LOG.info("Replace within byte array started");
		ByteArrayInputStream bis = new ByteArrayInputStream(buf);
		byte[] search = new byte[0];
		byte[] replacement = new byte[0];

		try {
			search = toBeReplaced.getBytes("UTF-8");
			replacement = replaceWith.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			LOG.error("Error while converting to string in UTF-8 ", e);
		}

		try (InputStream mis = new ModifyingInputStream(bis, search, replacement);
				ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
			int b = 0;
			while ((b = mis.read()) > 0) {
				bos.write(b);
			}
			return bos.toByteArray();
		} catch (IOException e) {
			LOG.error("Error during replacing byte array", e);
		}
		return new byte[0];
	}

}
