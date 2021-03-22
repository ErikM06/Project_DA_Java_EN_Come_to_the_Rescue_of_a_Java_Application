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
	

	public ComputMedical(String inputPath) {

		this.inputPath = inputPath;
		

	}

	public Map<String, Long> printSymptomsOnMap() {

		Map<String, Long> count = null;

		if (inputPath != null)
			try {

				ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile(inputPath);
				List<String> symptoms = readSymptomDataFromFile.GetSymptoms(); // get the data input in a List of String
				System.out.println(symptoms);

				ISymptomCount symptomCount = new SymptomCount();
				count = symptomCount.result(symptoms); // count the symptoms and send them in a map
				System.out.println(count);

			}

			catch (Exception e) {
				System.out.println("an error occured");
			}
		else {
			System.out.println("No input nor output paths find");
		}
		return count;

	}
}
