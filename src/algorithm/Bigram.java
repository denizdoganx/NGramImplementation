package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import model.BigramObject;
import model.UnigramObject;

public class Bigram {

	private static Bigram instance = null;
	
	private List<UnigramObject> unigrams;
	
	private List<String> allBigrams;
	
	private HeapSort heapSort;
	
	private Bigram() {
		this.heapSort = HeapSort.getInstance();
	}
	
	public static Bigram getInstance() {
		if(instance == null) {
			instance = new Bigram();
		}
		return instance;
	}
	
	public void setCorpus(List<String> words) {
		List<String> allBigrams = new ArrayList<>();
		for(int i = 0;i < words.size() - 1; i++) {
			allBigrams.add(String.valueOf(words.get(i) + " " + words.get(i + 1)));
			//System.out.println(allBigrams.get(i));
		}
		this.allBigrams = allBigrams;
	}
	
	public void updateListOfUnigrams(List<UnigramObject> unigrams) {
		this.unigrams = unigrams;
	}
	
	public List<BigramObject> getBigramList(){	
		List<BigramObject> bigramsArrayList = null;
		if(this.allBigrams != null) {
			int index = 0;
			bigramsArrayList = new ArrayList<>();
			BigramObject[] bigramsArray;
			HashMap<String, Integer> frequenciesDict = new HashMap<>();
			for(String bigram : allBigrams) {
				if(frequenciesDict.containsKey(bigram)) {
					int oldFrequency = frequenciesDict.get(bigram);
					frequenciesDict.replace(bigram, oldFrequency, oldFrequency + 1);
				}
				else {
					frequenciesDict.put(bigram, 1);
				}
			}
			bigramsArray = new BigramObject[frequenciesDict.size()];
			Set<Entry<String, Integer>> allEntry = frequenciesDict.entrySet();
			String[] splittedBigram;
			for(Entry<String, Integer> entry : allEntry) {
				BigramObject temp = new BigramObject();
				splittedBigram = entry.getKey().split(" ");
				if(splittedBigram.length == 2) {
					temp.setFirstWord(splittedBigram[0]);
					temp.setSecondWord(splittedBigram[1]);
					temp.setFrequency(entry.getValue());
					temp.setUnigramFrequency(getFrequencyOfUnigramItem(splittedBigram[0]));
					temp.setProbability((double)temp.getFrequency() / (double)temp.getUnigramFrequency());
					bigramsArray[index] = temp;
					index++;
				}
			}
			
			heapSort.sort(bigramsArray);
			
			for(int i = bigramsArray.length - 1;i >= 0; i--) {
				bigramsArrayList.add(bigramsArray[i]);
			}
		}
		return bigramsArrayList;
	}
	
	private int getFrequencyOfUnigramItem(String word) {
		
		for(UnigramObject unigram : unigrams) {
			if(unigram.getWord().equals(word)) {
				return unigram.getFrequency();
			}
		}
		return - 1;
		
	}
}
