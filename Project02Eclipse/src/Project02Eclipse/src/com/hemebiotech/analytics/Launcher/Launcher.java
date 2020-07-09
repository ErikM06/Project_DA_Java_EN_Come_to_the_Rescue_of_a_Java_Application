package Project02Eclipse.src.com.hemebiotech.analytics.Launcher;


import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;

import Project02Eclipse.src.com.hemebiotech.analytics.SymptomCount.ISymptomCount;
import Project02Eclipse.src.com.hemebiotech.analytics.SymptomCount.SymptomCount;
import Project02Eclipse.src.com.hemebiotech.analytics.SymptomReader.ISymptomReader;
import Project02Eclipse.src.com.hemebiotech.analytics.SymptomReader.ReadSymptomDataFromFile;
import Project02Eclipse.src.com.hemebiotech.analytics.SymptomWriter.ISymptomWriter;
import Project02Eclipse.src.com.hemebiotech.analytics.SymptomWriter.SymptomWriter;
import Project02Eclipse.src.com.hemebiotech.analytics.WriterPath.IWriterDefaultPath;
import Project02Eclipse.src.com.hemebiotech.analytics.WriterPath.WriterDefaultPath;


/**
 * 
 * @author Megaport
 * 
 * A program that take input from a file with symptoms on it, take the
 * symptoms into a List then count them and send the result to a Map,
 * and output the result into a file
 */

public class Launcher {

	public static void main(String[] args) throws Exception, FileNotFoundException {

	String inputPath = null; 
	String outputPath = null;
	
		try {
			if (args.length == 0) {
				System.out.println("default args[0] starting");
				// We need to indicate the repertory "Project02Eclispe\\symptoms.txt" as getAbsoluteFile won't breach into it
				File inputDefaultFilePath = new File ("Project02Eclipse\\symptoms.txt").getAbsoluteFile(); 
				// convert the intput filepath into a String
				String input = inputDefaultFilePath.toString();
				inputPath = input ;
				
				System.out.println("The absolute Path is "+inputDefaultFilePath.getAbsolutePath());
				System.out.println("default args[0] ending");
			}
			else {
				inputPath = args[0];
			}
			
			if (args.length <= 1) {
				System.out.println("default args[1] starting");
				
				File outputDefaultFilePath = new File ("C:\\users\\Public\\HemebioTech\\result.txt");
				// convert the output filepath into String
			    String output =outputDefaultFilePath.toString();
				System.out.println(outputDefaultFilePath.getAbsolutePath());
				
				IWriterDefaultPath writerDefaultFilePath = new WriterDefaultPath();
				// create the output filepath and the file indicated
				writerDefaultFilePath.GetWriterDefaultPath(output);
				outputPath =output ;
				System.out.println(outputPath);
				System.out.println("default args[1] ending");
					
			}
			else {
				outputPath = args[1];
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Filepath error");
		}
			
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


