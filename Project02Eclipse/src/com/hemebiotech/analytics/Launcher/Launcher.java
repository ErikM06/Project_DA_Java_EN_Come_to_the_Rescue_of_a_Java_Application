package com.hemebiotech.analytics.Launcher;

import java.io.File;
import java.io.FileNotFoundException;

import com.hemebiotech.analytics.ComputMedical.ComputMedical;
import com.hemebiotech.analytics.ComputMedical.IComputMedical;

import com.hemebiotech.analytics.WriterPath.IWriterDefaultPath;
import com.hemebiotech.analytics.WriterPath.WriterDefaultPath;

/**
 * 
 * @author Megaport
 * 
 *         A program that take input from a file with symptoms on it, take the
 *         symptoms into a List then count them and send the result to a Map,
 *         and output the result into a file
 */

public class Launcher {

	public static void main(String[] args) throws Exception, FileNotFoundException {

		String inputPath = null;
		String outputPath = null;
		
		/*
		 *  give a default filepath to args[0] (input filepath) if user don't specified it
		 */
		try {
			if (args.length == 0) {
				System.out.println("default args[0] starting");
				
				File inputDefaultFilePath = new File("Project02Eclipse\\symptoms.txt").getAbsoluteFile(); // We need to indicate the repertory "Project02Eclispe\\symptoms.txt" as getAbsoluteFile won't breach into it
				String input = inputDefaultFilePath.toString(); // convert the intput filepath into a String
				inputPath = input;
				
				System.out.println("The absolute Path is " + inputDefaultFilePath.getAbsolutePath());
				System.out.println("default args[0] ending");
			} else {
				inputPath = args[0];
			}
			/*
			 * give a default fielpath to args[1] (output filepath) if user don't specified it
			 */
			if (args.length < 1) {
				System.out.println("default args[1] starting");

				File outputDefaultFilePath = new File("Project02Eclipse\\result.txt");
				// convert the output filepath into String
				String output = outputDefaultFilePath.toString();
				System.out.println(outputDefaultFilePath.getAbsolutePath());

				IWriterDefaultPath writerDefaultFilePath = new WriterDefaultPath();
				// create the output filepath and the file indicated
				writerDefaultFilePath.GetWriterDefaultPath(output);
				outputPath = output;
				System.out.println(outputPath);
				System.out.println("default args[1] ending");

			} else {
				outputPath = args[1];
			}
		} catch (FileNotFoundException e) {
			System.out.println("Filepath error");
		}

		try {
			
			IComputMedical printSymptomsOnFile = new ComputMedical(inputPath, outputPath); 
			printSymptomsOnFile.computMedicalOnFile(); //apply computMedicalOnFile method to prinSymptomsOnFile
			
		} catch (Exception e) {
			System.out.println("an error occured");
		}
	}

}
