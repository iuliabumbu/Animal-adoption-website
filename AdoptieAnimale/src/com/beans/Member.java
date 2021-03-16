package com.beans;

//clasa folosita pentru a pastra proprietatile utilizatorului denumit generic membru
public class Member {
	
	private String nume;
	private String prenume;
	private String username;
	private String password;
	private String adresa;
	private String email;
	private String telefon;
	
	public Member(String nume, String prenume, String username, String password,String adresa, String email, String telefon) {
		this.nume = nume;
		this.prenume = prenume;
		this.username = username;
		this.password = password;
		this.adresa = adresa;
		this.email = email;
		this.telefon = telefon;
	}
	public Member() {
		
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public void setPassword(String password) {
		this.password = password;
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