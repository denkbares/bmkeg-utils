package edu.isi.bmkeg.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtils {

	/*
	 * From http://www.javapractices.com/topic/TopicAction.do?Id=42
	 */
	static public String readFileToString(File aFile) {

		StringBuilder contents = new StringBuilder();

		try {
			
			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try {
				String line = null; // not declared within while loop
				/*
				 * readLine is a bit quirky : it returns the content of a line
				 * MINUS the newline. it returns null only for the END of the
				 * stream. it returns an empty String if two newlines appear in
				 * a row.
				 */
				while ((line = input.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return contents.toString();
		
	}
	
	public static String runStripPattern(String wholeFile, String pattStr) {

		Pattern patt = Pattern.compile(pattStr, 
				Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE);
		
		StringBuffer myStringBuffer = new StringBuffer();
		Matcher m = patt.matcher(wholeFile);
		while (m.find()) {
		    m.appendReplacement(myStringBuffer, "");
		}
		m.appendTail(myStringBuffer);
		
		String newFile = myStringBuffer.toString();
		
		return newFile;

	}
	
	public static String runExtractPattern(String wholeFile, String pattStr) {

		Pattern patt = Pattern.compile(pattStr, 
				Pattern.CASE_INSENSITIVE | Pattern.DOTALL | Pattern.MULTILINE);
		
		StringBuffer myStringBuffer = new StringBuffer();
		Matcher m = patt.matcher(wholeFile);
		while (m.find()) {
		    m.appendReplacement(myStringBuffer, "");
		}
		m.appendTail(myStringBuffer);
		
		String newFile = myStringBuffer.toString();
		
		return newFile;

	}

}
