package com.hemebiotech.analytics.SymptomWriter;

import java.util.Map;

/**
 * Anything that will create a file and output the ISymptomCount TreeMap on it
 *
 *
 */

public interface ISymptomWriter {
	
	/**
	 * 
	 * @param count the TreeMap that ISymptomCount return
	 */
	
	 void mapSymptomsWriter(Map<String, Integer> count);
	 
	 

}