package com.hemebiotech.analytics.ComputMedical;

import java.util.List;
import java.util.Map;

import com.hemebiotech.analytics.SymptomCount.ISymptomCount;
import com.hemebiotech.analytics.SymptomCount.SymptomCount;
import com.hemebiotech.analytics.SymptomReader.ISymptomReader;
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

			ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(inputPath);
			List<String> symptoms = readSymptomDataFromFile.GetSymptoms(); // get the data input in a List of String
			System.out.println(symptoms);

			ISymptomCount symptomCount = new SymptomCount();
			Map<String, Long> count = symptomCount.result(symptoms); // count the symptoms and send them in a map
			System.out.println(count);

			ISymptomWriter writeSymptomsCountOnFile = new SymptomWriter(outputPath); // Read the localized file
			System.out.println(outputPath);

			writeSymptomsCountOnFile.MapSymptomsWriter(count); // write the symptoms on the localized file

		}

		catch (Exception e) {
			System.out.println("an error occured");
		}

	}

}
