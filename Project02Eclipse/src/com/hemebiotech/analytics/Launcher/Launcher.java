package com.hemebiotech.analytics.Launcher;


import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;

import com.hemebiotech.analytics.SymptomCount.ISymptomCount;
import com.hemebiotech.analytics.SymptomCount.SymptomCount;
import com.hemebiotech.analytics.SymptomReader.ISymptomReader;
import com.hemebiotech.analytics.SymptomReader.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.SymptomWriter.ISymptomWriter;
import com.hemebiotech.analytics.SymptomWriter.SymptomWriter;
import com.hemebiotech.analytics.WriterPath.IWriterDefaultPath;
import com.hemebiotech.analytics.WriterPath.WriterDefaultPath;


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
				
				File outputDefaultFilePath = new File ("Project02Eclipse\\result.txt");
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
			List<String> symptoms = readSymptomDataFromFile.getSymptoms(); // get the data input in a List of String
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


