package Project02Eclipse.src.com.hemebiotech.WriterPath;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDefaultPath implements IWriterDefaultPath {
	
	
	public void GetWriterDefaultPath() {
		
	File file = new File ("C:\\Users\\Desktop\\HemebioTech\\result.txt");
	file.getParentFile().mkdirs();
	FileWriter writer = new FileWriter(file);
	}
}
