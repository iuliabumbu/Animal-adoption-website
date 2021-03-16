package com.beans;

//clasa folosita pentru a pastra proprietatile adoptiei
public class Adoptie {
	private int idAdoptie;
	private int idAnimal;
	private String donator;
	private String proprietar;
	public Adoptie(int idAdoptie, int idAnimal, String donator, String proprietar) {
		super();
		this.idAdoptie = idAdoptie;
		this.idAnimal = idAnimal;
		this.donator = donator;
		this.proprietar = proprietar;
	}
	public Adoptie() {
		// TODO Auto-generated constructor stub
	}
	public int getIdAdoptie() {
		return idAdoptie;
	}
	public void setIdAdoptie(int idAdoptie) {
		this.idAdoptie = idAdoptie;
	}
	public int getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	public String getDonator() {
		return donator;
	}
	public void setDonator(String donator) {
		this.donator = donator;
	}
	public String getProprietar() {
		return proprietar;
	}
	public void setProprietar(String proprietar) {
		this.proprietar = proprietar;
	}
	
	
	

	
	
	
	

}
