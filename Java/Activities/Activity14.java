package activities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Activity14 {
	public static void main (String[] args) throws IOException {
		try {
			File file = new File ("src/session1/newFile.txt");
			boolean fStatus = file.createNewFile();
			if (fStatus) {
				System.out.println("File created successfully");
			} else {
				System.out.println("File already exist in the path");
			}
			//get the file object
			File fileUtil = FileUtils.getFile("src/session1/newfile.txt");
			
			//Read file
			System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));
			
			//Create directory
			File destinationDir = new File ("resources");
			
			//Copy file to directory
			FileUtils.copyFileToDirectory(file, destinationDir);
			
			//Get file from new directory
			File newFile = FileUtils.getFile (destinationDir, "newfile.txt");
			
			//Read data from file
			String newFileData = FileUtils.readFileToString(newFile, "UTF-8");
			
			//Print
			System.out.println("Data in new file " + newFileData);
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

/*
Create a new text file using the default File Class.
Use the createNewFile() method to create a file.
Write some text into the text file.
Next, we create a new directory named resources.
Copy the text file into this directory using the copyFileToDirectory() method.
To read data from this new file using FileUtils class use the getFile() method to get the file. Then use readFileToString() to read file.
*/