package com.qait.training.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class SpecReader {
	
	public static String[] getElementfromFile(String fileName,String token)
	{
		
		String[] elements = null;
		ClassLoader classLoader = SpecReader.class.getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			if(line.startsWith(token))
			{
			line=line.replaceAll("[ \t]+"," ");
			elements=line.split(" ",3);
			}
		}
		return elements;
	}
}
