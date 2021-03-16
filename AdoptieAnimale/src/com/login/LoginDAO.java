package com.login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.LoginBean;

//clasa responsabila cu conectarea la baza de date in cadrul logarii
public class LoginDAO {

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
	//functia care verifica daca datele de logare introduse de utilizator sunt corecte
	public String validate (LoginBean loginBean)
	{
		boolean status1 = false, status2 = false;
		String client = "client";
		String furnizor = "furnizor";
		String error = "error";

		loadDriver(dbDriver);
		Connection con = getConnection();

		String sql1 = "select * from client where userid = ? and parola =?";
		PreparedStatement ps1;

		String sql2 = "select * from furnizor where userid = ? and parola =?";
		PreparedStatement ps2;

		try {
			ps1 = con.prepareStatement(sql1);
			ps1.setString(1, loginBean.getUsername());
			ps1.setString(2, loginBean.getPassword());
			ResultSet rs = ps1.executeQuery();
			status1 = rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ps2 = con.prepareStatement(sql2);
			ps2.setString(1, loginBean.getUsername());
			ps2.setString(2, loginBean.getPassword());
			ResultSet rs2 = ps2.executeQuery();
			status2 = rs2.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(status1 != false) {
			return client;
		}
		else if(status2 != false) {
			return furnizor;
		}

		return error;
	}
}