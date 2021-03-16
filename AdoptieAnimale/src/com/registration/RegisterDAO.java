package com.registration;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.beans.Member;

//clasa responsabila cu conectarea la baza de date in cadrul inregistrarii
public class RegisterDAO {
	
	private String dbUrl = "jdbc:mysql://localhost:3306/adoptieanimale";
	private String dbUname = "root";
	private String dbPassword = "rootpass";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	//functia care incarca driverul
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//functia care realizeaza conexiunea la baza de date
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	//functia care asigura inserarea noului membru inregistrat in baza de date
	public String insert(Member member, String tip)
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data entered successfully";
		String sql = null;
		
		if (tip.equals("furnizor")) {
			sql = "insert into furnizor values(?,?,?,?,?,?,?)";
		}
		else if (tip.equals("client")) {
			sql = "insert into client values(?,?,?,?,?,?,?)";
		}
		
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getNume());
		ps.setString(2, member.getPrenume());
		ps.setString(3, member.getUsername());
		ps.setString(4, member.getPassword());
		ps.setString(5, member.getAdresa());
		ps.setString(6, member.getEmail());
		ps.setString(7, member.getTelefon());
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;
	}

}