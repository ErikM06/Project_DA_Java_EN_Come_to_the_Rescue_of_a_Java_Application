package com.hemebiotech.analytics.ComputMedical;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.SymptomCount.ISymptomCount;
import com.hemebiotech.analytics.SymptomCount.SymptomCount;
import com.hemebiotech.analytics.SymptomReader.IReadSymptomDataFromFile;
import com.hemebiotech.analytics.SymptomReader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.SymptomWriter.ISymptomWriter;
import com.hemebiotech.analytics.SymptomWriter.SymptomWriter;

public class ComputMedical implements IComputMedical {

	private String inputPath;
	private String outputPath;

	/**
	 * @param inputPath outputPath from main
	 * 
	 */
	public ComputMedical(String inputPath, String outputPath) {

		this.inputPath = inputPath;
		this.outputPath = outputPath;
	}

	public void computMedicalOnFile() {

		try {

			IReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile(inputPath);
			List<String> symptoms = readSymptomDataFromFile.getSymptomsFromFile(); // get the data input in a List of String

			ISymptomCount symptomCount = new SymptomCount();
			Map<String, Integer> count = symptomCount.getSymptomsCount(symptoms); // count the symptoms and send them in a map

			ISymptomWriter writeSymptomsCountOnFile = new SymptomWriter(outputPath); // Read the localized file
			
			writeSymptomsCountOnFile.mapSymptomsWriter(count); // write the symptoms on the localized file

		}

		catch (Exception e) {
			System.out.println("an error occured");
		}

	}

}
