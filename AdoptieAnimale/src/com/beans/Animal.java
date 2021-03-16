package com.beans;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//clasa folosita pentru a pastra proprietatile animalului
public class Animal implements Comparable<Animal>{
	private int idanimal;
	private String proprietar;
	private String nume;
	private String tip;
	private String rasa;
	private int varsta;
	private String gen;
	private String imagine;
	private boolean adoptat;
	
	
	
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Animal(int idanimal, String proprietar, String nume, String tip, String rasa, int varsta, String gen,
			String imagine, boolean adoptat) {
		super();
		this.idanimal = idanimal;
		this.proprietar = proprietar;
		this.nume = nume;
		this.tip = tip;
		this.rasa = rasa;
		this.varsta = varsta;
		this.gen = gen;
		this.imagine = imagine;
		this.adoptat = adoptat;
	}


	public int getIdanimal() {
		return idanimal;
	}
	public void setIdanimal(int idanimal) {
		this.idanimal = idanimal;
	}
	public String getProprietar() {
		return proprietar;
	}
	public void setProprietar(String proprietar) {
		this.proprietar = proprietar;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getRasa() {
		return rasa;
	}
	public void setRasa(String rasa) {
		this.rasa = rasa;
	}
	public int getVarsta() {
		return varsta;
	}
	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getImagine() {
		return imagine;
	}
	public boolean isAdoptat() {
		return adoptat;
	}


	public void setAdoptat(boolean adoptat) {
		this.adoptat = adoptat;
	}


	public void setImagine(String imagine) {
		this.imagine = imagine;
	}
	
	public ArrayList<Animal> lowtohigh(ArrayList<Animal> list) {
		Collections.sort(list);
		return list;
	}
	@Override
	public int compareTo(Animal p) {
		
		return this.varsta - p.varsta;
	}
	public ArrayList<Animal> hightolow(ArrayList<Animal> list) {
		Collections.sort(list, new Temp());
		return list;
	}
	
}



class Temp implements Comparator<Animal>{

	@Override
	public int compare(Animal o1, Animal o2) {
		return o2.getVarsta() - o1.getVarsta();
	}
	
}
	
	

