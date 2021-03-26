package com.hemebiotech.analytics.SymptomCount;

import java.util.List;
import java.util.Map;

/**
 * Anything that will count the symptoms from a List
 * 
 * A method that loop on each item of the List returned from ISymptomReader,
 * count every item then return an ordered TreeMap with a key as the symptom and value the number of occurrence
 *
 *
 */

public interface ISymptomCount {
	
	/**
	 * @param symptoms the result ISymptomReader class return
	 *
	 */
	
	Map<String,Long> getSymptomsCount (List<String> symptoms);
	 
}
