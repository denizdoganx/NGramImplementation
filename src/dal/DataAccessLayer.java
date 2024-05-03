package dal;

import java.util.List;

import io.FileReading;
import util.R;

public abstract class DataAccessLayer {

	private static List<String> file1Words;
	
	private static List<String> file2Words;
	
	private static List<String> file3Words;
	
	private static List<String> file4Words;
	
	private static List<String> file5Words;
	
	private FileReading fileReading;
	
	public DataAccessLayer() {
		this.fileReading = new FileReading();
	}
	
	List<String> getListOfWords(String fileName) {
		List<String> words = null;
		switch (fileName) {
		case R.fileName1: 
			if(file1Words == null) {
				file1Words = fileReading.getWords(fileName);
			}
			words = file1Words;
			break;
		case R.fileName2: 
			if(file2Words == null) {
				file2Words = fileReading.getWords(fileName);
			}
			words = file2Words;
			break;
		case R.fileName3: 
			if(file3Words == null) {
				file3Words = fileReading.getWords(fileName);
			}
			words = file3Words;
			break;
		case R.fileName4: 
			if(file4Words == null) {
				file4Words = fileReading.getWords(fileName);
			}
			words = file4Words;
			break;
		case R.fileName5: 
			if(file5Words == null) {
				file5Words = fileReading.getWords(fileName);
			}
			words = file5Words;
			break;
		}
		return words;
	}
}
