package Project02Eclipse.src.com.hemebiotech.analytics.SymptomWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;


public class SymptomWriter implements ISymptomWriter {

	private String filepathW;

	/**
	 * 
	 * @param filepathW the output file path
	 */
	
	public SymptomWriter(String filepathW) {

		this.filepathW = filepathW;
	}
	
	/**
	 * @param map TreeMap from ISymptomCount
	 * 
	 */
	
	public void MapSymptomsWriter(Map<String,Long> map) {

		if (filepathW != null) {
			/**
			 *
			 */
			File printOnFile = new File(filepathW);
			// we create a new FileOuputStream with @param filepathW and we associate a PrinterWriter which print on fos
			try (OutputStream fos = new FileOutputStream(printOnFile); PrintWriter pw = new PrintWriter(fos);) { //autocloseable
				
				// create a Map m that will print @param map values and keys in the file
				for (Map.Entry<String,Long> m : map.entrySet()) { 
					pw.println(m.getKey() + "=" + m.getValue());  
				}

			} 
			catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
