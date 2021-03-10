package com.hemebiotech.analytics.WriterPath;

import java.io.IOException;

/**
 * 
 * An interface that implement a method that create the file and the filepath indicated in the main methode
 *
 */

public interface IWriterDefaultPath {
	/**
	 * 
	 * @param defaultOutputFilePath the default output filepath indicated in main
	 * @throws IOException
	 */
	void GetWriterDefaultPath(String defaultOutputFilePath) throws IOException ;

}
