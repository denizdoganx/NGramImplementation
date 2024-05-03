package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import model.BigramObject;
import model.TrigramObject;

public class Trigram {

	private static Trigram instance = null;
	
	private List<BigramObject> bigrams;
	
	private List<String> allTrigrams;
	
	private HeapSort heapSort;
	
	private Trigram() {
		this.heapSort = HeapSort.getInstance();
	}
	
	public static Trigram getInstance() {
		if(instance == null) {
			instance = new Trigram();
		}
		return instance;
	}
	
	public void setCorpus(List<String> words) {
		List<String> allTrigrams = new ArrayList<>();
		for(int i = 0;i < words.size() - 2; i++) {
			allTrigrams.add(String.valueOf(words.get(i) + " " + words.get(i + 1) + " " + words.get(i + 2)));
		}
		this.allTrigrams = allTrigrams;
	}
	
	public void updateListOfBigrams(List<BigramObject> bigrams) {
		this.bigrams = bigrams;
	}
	
	public List<TrigramObject> getTrigramList(){
		List<TrigramObject> trigramsArrayList = null;
		if(this.allTrigrams != null) {
			int index = 0;
			trigramsArrayList = new ArrayList<>();
			TrigramObject[] trigramsArray;
			HashMap<String, Integer> frequenciesDict = new HashMap<>();
			for(String trigram : allTrigrams) {
				if(frequenciesDict.containsKey(trigram)) {
					int oldFrequency = frequenciesDict.get(trigram);
					frequenciesDict.replace(trigram, oldFrequency, oldFrequency + 1);
				}
				else {
					frequenciesDict.put(trigram, 1);
				}
			}
			trigramsArray = new TrigramObject[frequenciesDict.size()];
			Set<Entry<String, Integer>> allEntry = frequenciesDict.entrySet();
			String[] splittedTrigram;
			for(Entry<String, Integer> entry : allEntry) {
				TrigramObject temp = new TrigramObject();
				splittedTrigram = entry.getKey().split(" ");
				if(splittedTrigram.length == 3) {
					temp.setTwoWord(splittedTrigram[0] + " " + splittedTrigram[1]);
					temp.setThreeWord(splittedTrigram[0] + " " + splittedTrigram[1] + " " + splittedTrigram[2]);
					temp.setFrequency(entry.getValue());
					temp.setBigramFrequency(getFrequencyOfBigramItem(splittedTrigram[0]));
					temp.setProbability((double)temp.getFrequency() / (double)temp.getBigramFrequency());
					trigramsArray[index] = temp;
					index++;
				}
			}
			
			heapSort.sort(trigramsArray);
			
			for(int i = trigramsArray.length - 1;i >= 0; i--) {
				trigramsArrayList.add(trigramsArray[i]);
			}
		}
		return trigramsArrayList;
	}
	
	private int getFrequencyOfBigramItem(String word) {
		
		for(BigramObject bigram : bigrams) {
			if(bigram.getFirstWord().equals(word)) {
				return bigram.getFrequency();
			}
		}
		return - 1;
		
	}
}
