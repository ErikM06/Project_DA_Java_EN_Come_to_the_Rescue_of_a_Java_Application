package Project02Eclipse.src.com.hemebiotech.analytics.Launcher;

import java.util.List;
import java.util.Map;

import Project02Eclipse.src.com.hemebiotech.WriterPath.IWriterDefaultPath;
import Project02Eclipse.src.com.hemebiotech.WriterPath.WriterDefaultPath;
import Project02Eclipse.src.com.hemebiotech.analytics.SymptomCount.ISymptomCount;
import Project02Eclipse.src.com.hemebiotech.analytics.SymptomCount.SymptomCount;
import Project02Eclipse.src.com.hemebiotech.analytics.SymptomReader.ISymptomReader;
import Project02Eclipse.src.com.hemebiotech.analytics.SymptomReader.ReadSymptomDataFromFile;
import Project02Eclipse.src.com.hemebiotech.analytics.SymptomWriter.ISymptomWriter;
import Project02Eclipse.src.com.hemebiotech.analytics.SymptomWriter.SymptomWriter;


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

		ISymptomReader readSymptomDataFromFile = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt"); // read the data input
																												 
		List<String> symptoms = readSymptomDataFromFile.GetSymptoms(); // get the data input in a List of String

		ISymptomCount symptomCount = new SymptomCount();
		Map<String, Long> count = symptomCount.result(symptoms); // count the symptoms and send them in a map
		
		IWriterDefaultPath writerPath = new WriterDefaultPath();
		
		ISymptomWriter writeSymptomsCountOnFile = new SymptomWriter("result.txt"); // Read the localized file
																										
		writeSymptomsCountOnFile.SymptomsWriter(count); // write the symptoms on the localized file

	}
}


