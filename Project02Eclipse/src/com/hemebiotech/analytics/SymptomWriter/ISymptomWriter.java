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
	 * @param map the TreeMap that ISymptomCount return
	 */
	
	 void MapSymptomsWriter(Map<String, Long> map);
	 
	 

}