package com.hemebiotech.analytics.SymptomReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements IReadSymptomDataFromFile {

	private String inputPath;
	
	/**
	 * 
	 * @param inputPath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String inputPath) {
		
		this.inputPath = inputPath;
	}
	
	@Override
	public List<String> getSymptomsFromFile() {
		ArrayList<String> symptomsFromFile = new ArrayList<String>();
		
		if (inputPath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(inputPath));
				String line = reader.readLine();
				
				while (line != null) {
					symptomsFromFile.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return symptomsFromFile;
	}

}
