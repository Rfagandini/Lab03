package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary {

	List<String> Arrayword = new ArrayList<String>();
	List<RichWord> ArrayVerifyWrong = new ArrayList<RichWord>();
	List<RichWord> ArrayVerifyCorrect = new ArrayList<RichWord>();
	public String loadwrongwords() {
		String aux = "";
		for(RichWord w: ArrayVerifyWrong) {
			aux += w.toString()+"\n";
		}
		return aux.trim();
	}
	
	public int Errorsfound() {
		return ArrayVerifyWrong.size();
	}
	
	public void loadDictionaryMech(String lol) throws IOException {
		
		String language = "src/main/resources/"+lol+".txt";
		try {
			FileReader fr = new FileReader(language);
			BufferedReader br = new BufferedReader(fr);
			String pinzas;
			while((pinzas = br.readLine())!=null) {
				Arrayword.add(pinzas);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the file");;
		}
		
	}
	
	public void VerifyWords(String text) {
		String Text = text;
		Text = Text.toLowerCase();
		Text = Text.replaceAll(" [^a-zA-Z]+","");
		Text = Text.replaceAll("\\d", "");
		Text = Text.replaceAll("[?'.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
		String[] Pinzas;
		
		boolean u = false;
		Pinzas = Text.split(" ");
		for(int i = 0; i < Pinzas.length ; i++) {
			System.out.println(Pinzas[i]);
			u = false;
			if(Arrayword.contains(Pinzas[i])) {
				u = true;
				RichWord o = new RichWord(Pinzas[i],u);
				ArrayVerifyCorrect.add(o);
			}
			else if(Pinzas!=null && !Pinzas.equals("")){
				
				RichWord o = new RichWord(Pinzas[i],u);
				ArrayVerifyWrong.add(o);
			}
		}
		
	}
	
	public boolean containsword(String word) {
		
		
		
		
		
		return false;
	}
	
}
