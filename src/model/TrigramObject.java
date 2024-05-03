package model;

public class TrigramObject implements INGramObject {

	private String twoWord;
	
	private String threeWord;
	
	private int bigramFrequency;
	
	private int frequency;
	
	private double probability;

	public String getTwoWord() {
		return twoWord;
	}

	public void setTwoWord(String twoWord) {
		this.twoWord = twoWord;
	}

	public String getThreeWord() {
		return threeWord;
	}

	public void setThreeWord(String threeWord) {
		this.threeWord = threeWord;
	}

	public int getBigramFrequency() {
		return bigramFrequency;
	}

	public void setBigramFrequency(int bigramFrequency) {
		this.bigramFrequency = bigramFrequency;
	}

	@Override
	public int getFrequency() {
		return frequency;
	}

	@Override
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	
}
