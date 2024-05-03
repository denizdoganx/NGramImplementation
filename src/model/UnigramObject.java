package model;

public class UnigramObject implements INGramObject {

	private String word;
	
	private int frequency;
	
	private double probability;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}
	
	@Override
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public int getFrequency() {
		return this.frequency;
	}
}
