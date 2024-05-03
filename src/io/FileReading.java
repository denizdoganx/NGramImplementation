package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import util.R;

public class FileReading {
	
	

	public List<String> getWords(String fileName) {
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		List<String> sentences = null;
		String line = null;
		
		if(!file.exists()) {
			System.out.println("This file does not exist.");
		}
		else {
			try {
				fr = new FileReader(file, Charset.forName("ISO-8859-9"));
				br = new BufferedReader(fr);
				sentences = new ArrayList<>();
				ArrayList<String> splittedLine;
				while((line = br.readLine()) != null) {
					splittedLine = getSplittedText(line);
					for(String word : splittedLine) {
						if(!word.equals("")) {
							sentences.add(word.toLowerCase());
						}
					}
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			} 
			finally {
				if(sentences != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return sentences;
	}

	private ArrayList<String> getSplittedText(String line) {
		ArrayList<String> splitted = new ArrayList<>();
		String word = "";
		ArrayList<String> delimiters = R.getDelimiters();
		for(int i = 0;i < line.length(); i++) {
			if(delimiters.contains(String.valueOf(line.charAt(i)))) {
				
				if(word.length() > 0) {
					if(word.charAt(0) != 146) {
						splitted.add(word);
					}
				}

				word = "";
			}
			else {
				word += line.charAt(i);
			}
		}
		
		return splitted;
	}
}
