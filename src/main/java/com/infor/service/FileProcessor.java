package com.infor.service;

/**
 * FileProcessor class defines abstract methods to be overidden by
 * implementation classes
 * 
 * @author Purushottam S.
 * @version 1.0
 *
 */
public abstract class FileProcessor {
	
	protected String toReplace;
	protected String replaceWith;
	
	public FileProcessor(String toReplace, String replaceWith) {
		this.toReplace = toReplace;
		this.replaceWith = replaceWith;
	}

	/**
	 * This function replaces each string in the file that matches with `toReplace` with 
	 * `replaceWith` 
	 * 
	 */
	abstract public void processFile();

	/**
	 * This function replaces each string in the file that matches with `toReplace` with 
	 * `replaceWith`
	 * 
	 * @param targetLocation
	 *            targetFile
	 * @param resultLocation
	 *            resultFile
	 */
	abstract public void processFile(String targetLocation, String resultLocation);

}
