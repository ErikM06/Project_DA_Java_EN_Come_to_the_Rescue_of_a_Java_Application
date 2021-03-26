package com.hemebiotech.analytics.SymptomCount;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class SymptomCount implements ISymptomCount {
	
	/**
	 * @param symptoms the List returned from ISymptomReader
	 */
	public Map<String,Long> getSymptomsCount (List <String> symptoms){
		
		Map<String,Long> countEverySymptoms = new TreeMap<String,Long>();
		
		symptoms.forEach(item->{  
			
			if(countEverySymptoms.get(item)==null) { 
				
				countEverySymptoms.put(item, symptoms.stream() // put item and the stream.filter in the map
						.filter(i->i.contains(item)).count());	// stream.filter count every item occurrence in the stream
			}
		});
			return countEverySymptoms;
	}

}
