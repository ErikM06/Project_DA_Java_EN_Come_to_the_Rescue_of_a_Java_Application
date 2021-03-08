package Project02Eclipse.src.com.hemebiotech.analytics.WriterPath;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class WriterDefaultPath implements IWriterDefaultPath {
	
	/**
	 * @param outputDefaultFilePath indicated in main
	 */
	public void GetWriterDefaultPath(String outputDefaultFilePath) {
		
		Writer fw = null;
		try {
			File file = new File (outputDefaultFilePath);
			file.getParentFile().mkdirs(); // create all the directories if they don't already exist
			fw = new FileWriter (file);
			System.out.println("path is "+ file.getAbsolutePath());
			
		}
		catch (Exception e){
			System.out.println("Default path couldn't be created");
		}
		
		
		finally {
			System.out.println("The try finished");
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
