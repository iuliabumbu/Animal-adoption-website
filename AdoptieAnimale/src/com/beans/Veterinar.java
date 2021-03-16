package com.beans;

//clasa folosita pentru a pastra proprietatile veterinarului
public class Veterinar {
	private int idVeterinar;
	private String nume;
	private String prenume;
	private String adresa;
	private String email;
	private String telefon;
	
	public Veterinar(int idVeterinar, String nume, String prenume, String adresa, String email, String telefon) {
		super();
		this.idVeterinar = idVeterinar;
		this.nume = nume;
		this.prenume = prenume;
		this.adresa = adresa;
		this.email = email;
		this.telefon = telefon;
	}

	public int getIdVeterinar() {
		return idVeterinar;
	}

	public void setIdVeterinar(int idVeterinar) {
		this.idVeterinar = idVeterinar;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	
	
	

}
