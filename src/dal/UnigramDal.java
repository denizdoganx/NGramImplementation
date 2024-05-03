package dal;

import java.util.List;

import algorithm.Unigram;
import model.UnigramObject;

public class UnigramDal extends DataAccessLayer {

	private static UnigramDal instance;

	private Unigram unigram;
	
	private UnigramDal() {
		
		this.unigram = Unigram.getInstance();
	}
	
	public static UnigramDal getInstance() {
		if(instance == null) {
			instance = new UnigramDal();
		}
		return instance;
	}
	
	public List<UnigramObject> getUnigramList(String fileName){
		this.unigram.setCorpus(getListOfWords(fileName)); 
		return unigram.getUnigramList();
		
	}
	

}
