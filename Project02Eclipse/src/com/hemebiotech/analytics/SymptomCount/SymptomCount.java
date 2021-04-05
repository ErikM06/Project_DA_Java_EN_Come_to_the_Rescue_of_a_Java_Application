package com.hemebiotech.analytics.SymptomCount;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class SymptomCount implements ISymptomCount {
	
	/**
	 * @param symptomsFromFile the List returned from IReadSymptomDataFromFile 
	 */
	public Map<String,Integer> getSymptomsCount (List <String> symptomsFromFile){
		
		Map<String,Integer> countEverySymptoms = new TreeMap<String,Integer>();
		
		for (String s : symptomsFromFile) {
			if(countEverySymptoms.containsKey(s)) {
				Integer count = countEverySymptoms.get(s);
				countEverySymptoms.put(s, count+1);
			}
			else {
				countEverySymptoms.put(s, 1);
			}
			
		}
		
			return countEverySymptoms;
	}

}
