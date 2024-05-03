package dal;

import java.util.List;


import algorithm.Trigram;

import model.TrigramObject;

public class TrigramDal extends DataAccessLayer {

	private static TrigramDal instance;

	private Trigram trigram;
	
	private TrigramDal() {
		
		this.trigram = Trigram.getInstance();
	}
	
	public static TrigramDal getInstance() {
		if(instance == null) {
			instance = new TrigramDal();
		}
		return instance;
	}
	
	public List<TrigramObject> getTrigramList(String fileName){
		this.trigram.setCorpus(getListOfWords(fileName)); 
		return trigram.getTrigramList();
		
	}
}
