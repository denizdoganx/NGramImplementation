package dal;

import java.util.List;

import algorithm.Bigram;

import model.BigramObject;


public class BigramDal extends DataAccessLayer {

	private static BigramDal instance;

	private Bigram bigram;
	
	private BigramDal() {
		
		this.bigram = Bigram.getInstance();
	}
	
	public static BigramDal getInstance() {
		if(instance == null) {
			instance = new BigramDal();
		}
		return instance;
	}
	
	public List<BigramObject> getBigramList(String fileName){
		this.bigram.setCorpus(getListOfWords(fileName)); 
		return bigram.getBigramList();
		
	}
}
