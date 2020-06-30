package Project02Eclipse.src.com.hemebiotech.analytics.Launcher;

import java.util.List;
import java.util.Map;

import Project02Eclipse.src.com.hemebiotech.analytics.SymptomReader.ReadSymptomDataFromFile;

/**
 * 
 * @author Megaport
 * 
 * A program that take input from a file with symptoms on it, take the
 * symptoms into a List then count them and send the result to a Map,
 * and output the result into a file
 */

public class Launcher {

	public static void main(String[] args) throws Exception {

		ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile("symptom.txt"); // read the data input
																												 
		List<String> symptoms = readSymptomDataFromFile.GetSymptoms("symptom.txt"); // get the data input in a List of String

		ISymptomCount symptomCount = new SymptomCount();
		Map<String, Long> count = symptomCount.result(symptoms); // count the symptoms and send them in a map

		ISymptomWriter writeSymptomsCountOnFile = new SymptomWriter("result.txt"); // read the localized file
																										
		writeSymptomsCountOnFile.SymptomsWriter(count); // write the symptoms on the localized file

	}
}


