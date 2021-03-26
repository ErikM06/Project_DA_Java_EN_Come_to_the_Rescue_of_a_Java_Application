package com.hemebiotech.analytics.SymptomCount;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class SymptomCount implements ISymptomCount {
	
	/**
	 * @param symptoms the List returned from ISymptomReader
	 */
	public Map<String,Integer> getSymptomsCount (List <String> symptoms){
		
		Map<String,Integer> countEverySymptoms = new TreeMap<String,Integer>();
		
		for (String s : symptoms) {
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
