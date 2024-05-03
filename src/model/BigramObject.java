package model;

public class BigramObject implements INGramObject {

	private String firstWord;
	
	private String secondWord;
	
	private int frequency;
	
	private int unigramFrequency;
	
	private double probability;

	public String getFirstWord() {
		return firstWord;
	}

	public void setFirstWord(String firstWord) {
		this.firstWord = firstWord;
	}

	public String getSecondWord() {
		return secondWord;
	}

	public void setSecondWord(String secondWord) {
		this.secondWord = secondWord;
	}

	public int getUnigramFrequency() {
		return unigramFrequency;
	}

	public void setUnigramFrequency(int unigramFrequency) {
		this.unigramFrequency = unigramFrequency;
	}

	@Override
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public int getFrequency() {
		return this.frequency;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	
}
