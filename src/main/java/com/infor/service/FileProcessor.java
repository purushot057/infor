package com.infor.service;

/**
 * FileProcessor interface defines abstract methods to be overridden by
 * implementation classes
 * 
 * @author Purushottam S.
 * @version 1.0
 *
 */
public interface FileProcessor {

	/**
	 * This function replaces each string in the file that matches with
	 * `toReplace` with the one in `replaceWith`
	 * 
	 * @param toReplace
	 *            String to be replaced
	 * @param replaceWith
	 *            String to replace with
	 * 
	 */
	void processFile(String toReplace, String replaceWith);

	/**
	 * This function replaces each string in the file that matches with
	 * `toReplace` with the one in `replaceWith`
	 * 
	 * @param targetLocation
	 *            String representation of targetFile
	 * @param resultLocation
	 *            String representation of resultFile
	 * @param toReplace
	 *            String to be replaced
	 * @param replaceWith
	 *            String to replace with
	 */
	void processFile(String targetLocation, String resultLocation, String toReplace, String replaceWith);

}
