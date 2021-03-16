package com.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.Adoptie;
import com.beans.Animal;
import com.beans.Client;
import com.beans.Furnizor;
import com.beans.Veterinar;

//clasa folosita pentru manipularea bazei de date de catre administrator/client/furnizor
public class DataBase {
	
	private String username = "root";
	private String password = "rootpass";
	private String dbName = "adoptieanimale";
	private String url = "jdbc:mysql://localhost:3306/adoptieanimale";
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	ArrayList<Animal> aList = new ArrayList<>();
	ArrayList<Furnizor> fList = new ArrayList<>();
	ArrayList<Client> cList = new ArrayList<>();
	ArrayList<Veterinar> vList = new ArrayList<>();
	
	private Connection con;
	
	//functia realizeaza conexiunea la baza de date
	private void dbConnect() {
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//functiea responsabila de inchiderea conexiunii catre baza de date
	private void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//functia realizeaza inserarea unui nou client in tabelul corespunzator
	public void addClient(Client user) throws SQLException {
		dbConnect();
		String sql = "Insert into client(nume,prenume, userid, parola, adresa, email, telefon) values(?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, user.getNume());
		st.setString(2, user.getPrenume());
		st.setString(3, user.getUsername());
		st.setString(4, user.getPassword());
		st.setString(5, user.getAdresa());
		st.setString(6, user.getEmail());
		st.setString(7, user.getTelefon());
				
		st.executeUpdate();
		dbClose();
	}
	
	//functia realizeaza inserarea unui nou furnizor in tabelul corespunzator
	public void addFurnizor(Furnizor user) throws SQLException {
		dbConnect();
		String sql = "Insert into furnizor(nume,prenume, userid, parola, adresa, email, telefon) values(?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, user.getNume());
		st.setString(2, user.getPrenume());
		st.setString(3, user.getUsername());
		st.setString(4, user.getPassword());
		st.setString(5, user.getAdresa());
		st.setString(6, user.getEmail());
		st.setString(7, user.getTelefon());
				
		st.executeUpdate();
		dbClose();
	}
	
	//functia realizeaza inserarea unui nou veterinar in tabelul corespunzator
	public void addVeterinar(Veterinar vet) throws SQLException {
		dbConnect();
		String sql = "Insert into veterinar(idveterinar,nume,prenume, adresa, email, telefon) values(?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, vet.getIdVeterinar());
		st.setString(2, vet.getNume());
		st.setString(3, vet.getPrenume());
		st.setString(4, vet.getAdresa());
		st.setString(5, vet.getEmail());
		st.setString(6, vet.getTelefon());
				
		st.executeUpdate();
		dbClose();
	}
	
	//functia realizeaza inserarea unui nou animal in tabelul corespunzator
	public void addAnimal(Animal pet) throws SQLException {
		dbConnect();
		String sql = "Insert into animal(idanimal, proprietar, nume,tip, rasa, varsta, gen, imagine, adoptat) values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, pet.getIdanimal());
		st.setString(2, pet.getProprietar());
		st.setString(3, pet.getNume());
		st.setString(4, pet.getTip());
		st.setString(5, pet.getRasa());
		st.setInt(6, pet.getVarsta());
		st.setString(7, pet.getGen());
		st.setString(8, pet.getImagine());
		if(pet.isAdoptat()) {
			st.setString(9, "true");
		}
		else {
			st.setString(9, "false");
		}
		
		
		st.executeUpdate();
		dbClose();
	}
	
	//functia realizeaza inserarea unei noi adoptii in tabelul corespunzator
	public void addAdoptie(Adoptie a) throws SQLException {
		dbConnect();
		String sql = "Insert into adoptie(idadoptie,idanimal, donator, proprietar) values(?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, a.getIdAdoptie());
		st.setInt(2, a.getIdAnimal());
		st.setString(3, a.getDonator());
		st.setString(4, a.getProprietar());

		st.executeUpdate();
		dbClose();
	}

	//functia verifica daca clientul cu nume si parola data au cont creat
	public boolean checkClient(String username, String password) throws SQLException {
		dbConnect();
		int count = 0;
		String sql = "Select * from furnizor where userid = ? and parola = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, username);
		st.setString(2, password);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			count = 1;
		}
		
		dbClose();
		if(count == 0)
			return false;
		
		return true;
	}
	
	//functia verifica daca furnizorul cu nume si parola data au cont creat
	public boolean checkFurnizor(String username, String password) throws SQLException {
		dbConnect();
		int count = 0;
		String sql = "Select * from furnizor where userid = ? and parola = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, username);
		st.setString(2, password);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			count = 1;
		}
		
		dbClose();
		if(count == 0)
			return false;
		
		return true;
	}
	
	//functia returneaza un sir cu toate animalele existente in baza de date
	public ArrayList<Animal> fetchAnimale() throws SQLException {
		dbConnect();
		String sql = "Select * from animal";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("idanimal");
			String prop = rs.getString("proprietar");
			String nume= rs.getString("nume");
			String tip= rs.getString("tip");
			String rasa= rs.getString("rasa");
			int varsta = rs.getInt("varsta");
			String gen= rs.getString("gen");
			String imagine= rs.getString("imagine");
			boolean adoptat = Boolean.valueOf(rs.getString("adoptat"));
			
			Animal pet = new Animal(id, prop, nume, tip, rasa, varsta, gen, imagine, adoptat);
		
			aList.add(pet);
			pet=null;
			
		}
		
		dbClose();
		return aList;
	}
	//functia returneaza un sir cu toati furnizorii existenti in baza de date
	public ArrayList<Furnizor> fetchFurnizori() throws SQLException {
		dbConnect();
		String sql = "Select * from furnizor";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String nume = rs.getString("nume");
			String prenume = rs.getString("prenume");
			String id = rs.getString("userid");
			String pass = rs.getString("parola");
			String adresa = rs.getString("adresa");
			String email = rs.getString("email");
			String telefon = rs.getString("telefon");
			
			Furnizor f = new Furnizor(nume, prenume, id, pass, adresa, email, telefon);
			fList.add(f);
			f=null;
				
		}
		
		dbClose();
		return fList;
	}
	//functia returneaza un sir cu toati clientii existenti in baza de date
	public ArrayList<Client> fetchClienti() throws SQLException {
		dbConnect();
		String sql = "Select * from client";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String nume = rs.getString("nume");
			String prenume = rs.getString("prenume");
			String id = rs.getString("userid");
			String pass = rs.getString("parola");
			String adresa = rs.getString("adresa");
			String email = rs.getString("email");
			String telefon = rs.getString("telefon");
			
			Client c = new Client(nume, prenume, id, pass, adresa, email, telefon);
			cList.add(c);
			c=null;
				
		}
		
		dbClose();
		return cList;
	}
	//functia returneaza un sir cu toati veterinarii existenti in baza de date
	public ArrayList<Veterinar> fetchVeterinari() throws SQLException {
		dbConnect();
		String sql = "Select * from veterinar";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("idveterinar");
			String nume = rs.getString("nume");
			String prenume = rs.getString("prenume");
			String adresa = rs.getString("adresa");
			String email = rs.getString("email");
			String telefon = rs.getString("telefon");
			
			Veterinar v = new Veterinar(id,nume, prenume, adresa, email, telefon);
			vList.add(v);
			v=null;
				
		}
		
		dbClose();
		return vList;
	}
	

	//functia realizeaza stergerea din tabelul animal a inregistrarii cu id primit ca parametru
	public void deleteAnimal(int id) throws SQLException {
		
		dbConnect();
		String sql = "Delete from animal where idanimal=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		st.executeUpdate();
		dbClose();
		
	}
	
	//functia realizeaza stergerea din tabelul veterinar a inregistrarii cu id primit ca parametru
	public void deleteVeterinar(int id) throws SQLException {
		
		dbConnect();
		String sql = "Delete from veterinar where idveterinar=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		st.executeUpdate();
		dbClose();
		
	}
	
	//functia realizeaza stergerea din tabelul client a inregistrarii cu id primit ca parametru
	public void deleteClient(String id) throws SQLException {
		
		dbConnect();
		String sql = "Delete from client where userid=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.executeUpdate();
		dbClose();
		
	}
	
	//functia realizeaza stergerea din tabelul furnizor a inregistrarii cu id primit ca parametru
	public void deleteFurnizor(String id) throws SQLException {
		
		dbConnect();
		String sql = "Delete from furnizor where userid=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.executeUpdate();
		dbClose();
		
	}

	//functia realizeaza actualizarea datelor animalului cu id primit
	public void updateAnimal(Animal pet) throws SQLException {
		dbConnect();
		String sql = "update animal set idanimal=?,proprietar=?,nume=?,tip=?,rasa=?,varsta=?,gen=?,imagine=?, adoptat=? where idanimal=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, pet.getIdanimal());
		st.setString(2, pet.getProprietar());
		st.setString(3, pet.getNume());
		st.setString(4, pet.getTip());
		st.setString(5, pet.getRasa());
		st.setInt(6, pet.getVarsta());
		st.setString(7, pet.getGen());
		st.setString(8, pet.getImagine());
		st.setString(9, pet.isAdoptat()+"");
		st.setInt(10, pet.getIdanimal());
		st.executeUpdate();
		dbClose();
	}
	
	//functia realizeaza actualizarea datelor clientului cu id primit
	public void updateClient(Client c) throws SQLException {
		dbConnect();
		String sql = "update client set nume=?,prenume=?,parola=?,adresa=?,email=?,telefon=? where userid=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, c.getNume());
		st.setString(2, c.getPrenume());
		st.setString(3, c.getPassword());
		st.setString(4, c.getAdresa());
		st.setString(5, c.getEmail());
		st.setString(6, c.getTelefon());
		st.setString(7, c.getUsername());
		st.executeUpdate();
		System.out.println("DB: userid "+c.getUsername()+" adresa:"+c.getAdresa());
		dbClose();
	}
	
	//functia realizeaza actualizarea datelor furnizorului cu id primit
	public void updateFurnizor(Furnizor f) throws SQLException {
		dbConnect();
		String sql = "update furnizor set nume=?,prenume=?,parola=?,adresa=?,email=?,telefon=? where userid=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, f.getNume());
		st.setString(2, f.getPrenume());
		st.setString(3, f.getPassword());
		st.setString(4, f.getAdresa());
		st.setString(5, f.getEmail());
		st.setString(6, f.getTelefon());
		st.setString(7, f.getUsername());
		st.executeUpdate();
		dbClose();
	}
	
	//functia realizeaza actualizarea datelor veterinarului cu id primit
	public void updateVeterinar(Veterinar v) throws SQLException {
		dbConnect();
		String sql = "update veterinar set nume=?,prenume=?,adresa=?,email=?,telefon=? where idveterinar=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, v.getNume());
		st.setString(2, v.getPrenume());
		st.setString(3, v.getAdresa());
		st.setString(4, v.getEmail());
		st.setString(5, v.getTelefon());
		st.setInt(6, v.getIdVeterinar());
		st.executeUpdate();
		dbClose();
	}
	
	//functia returneaza din baza de date clientul cu id primit ca parametru
	public Client fetchClient(String id) throws SQLException {
		dbConnect();
		String sql = "select * from client where userid=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rst = pstmt.executeQuery();
		Client c = new Client();
		while(rst.next()){
			
			c.setNume(rst.getString("nume"));
			c.setPrenume(rst.getString("prenume"));
			c.setUsername(rst.getString("userid"));
			c.setPassword(rst.getString("parola"));
			c.setAdresa(rst.getString("adresa"));
			c.setEmail(rst.getString("email"));
			c.setTelefon(rst.getString("telefon"));
		}
		dbClose();
		return c;
	}
	
	//functia returneaza din baza de date animalul cu id primit ca parametru
	public Animal fetchAnimal(String id) throws SQLException {
		dbConnect();
		String sql = "select * from animal where idanimal=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rst = pstmt.executeQuery();
		Animal c = new Animal();
		while(rst.next()){
			
			c.setIdanimal(rst.getInt("idanimal"));
			c.setProprietar(rst.getString("proprietar"));
			c.setNume(rst.getString("nume"));
			c.setTip(rst.getString("tip"));
			c.setRasa(rst.getString("rasa"));
			c.setVarsta(rst.getInt("varsta"));
			c.setGen(rst.getString("gen"));
			c.setAdoptat(Boolean.valueOf(rst.getString("adoptat")));
		}
		dbClose();
		return c;
	}
	
	//functia returneaza din baza de date adoptia cu id primit ca parametru
	public Adoptie fetchAdoptie(int idAdoptie) throws SQLException {
		dbConnect();
		String sql = "select * from adoptie where idadoptie=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, idAdoptie);
		ResultSet rst = pstmt.executeQuery();
		Adoptie c = new Adoptie();
		while(rst.next()){			
			c.setIdAdoptie(rst.getInt("idadoptie"));
			c.setProprietar(rst.getString("proprietar"));
			c.setDonator(rst.getString("donator"));
			c.setIdAnimal(rst.getInt("idanimal"));			
		}
		dbClose();
		return c;
	}




	
	
	
}
