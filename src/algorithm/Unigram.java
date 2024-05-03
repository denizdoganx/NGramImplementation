package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import model.UnigramObject;

public class Unigram {

	private static Unigram instance = null;
	
	private List<String> words;
	
	private HeapSort heapSort;
	
	private Unigram() {
		this.heapSort = HeapSort.getInstance();
	}
	
	public static Unigram getInstance() {
		if(instance == null) {
			instance = new Unigram();
		}
		return instance;
	}
	
	public void setCorpus(List<String> words) {
		this.words = words;
	}
	
	public List<UnigramObject> getUnigramList(){
		List<UnigramObject> unigramsArrayList = null;
		if(this.words != null) {
			int index = 0;
			unigramsArrayList = new ArrayList<>();
			UnigramObject[] unigramsArray;
			HashMap<String, Integer> frequenciesDict = new HashMap<>();
			for(String word : words) {
				if(frequenciesDict.containsKey(word)) {
					int oldFrequency = frequenciesDict.get(word);
					frequenciesDict.replace(word, oldFrequency, oldFrequency + 1);
				}
				else {
					frequenciesDict.put(word, 1);
				}
			}
			unigramsArray = new UnigramObject[frequenciesDict.size()];
			Set<Entry<String, Integer>> allEntry = frequenciesDict.entrySet();
			
			for(Entry<String, Integer> entry : allEntry) {
				
				UnigramObject temp = new UnigramObject();
				temp.setWord(entry.getKey());
				temp.setFrequency(entry.getValue());
				temp.setProbability((double)entry.getValue() / (double)words.size());
				unigramsArray[index] = temp;
				index++;
			}
			
			heapSort.sort(unigramsArray);

			for(int i = unigramsArray.length - 1;i >= 0; i--) {
				unigramsArrayList.add(unigramsArray[i]);
			}
			
			
		}
		return unigramsArrayList;
	}
}
