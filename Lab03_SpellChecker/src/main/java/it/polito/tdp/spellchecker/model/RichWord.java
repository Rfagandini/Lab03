package it.polito.tdp.spellchecker.model;

public class RichWord {

	String word;
	Boolean correct = true;
	
	public RichWord(String word, Boolean correct) {
		super();
		this.word = word;
		this.correct = correct;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Boolean getCorrect() {
		return correct;
	}
	public void setCorrect(Boolean correct) {
		this.correct = correct;
	}
	@Override
	public String toString() {
		return this.word;
	}
	
	
	
}
