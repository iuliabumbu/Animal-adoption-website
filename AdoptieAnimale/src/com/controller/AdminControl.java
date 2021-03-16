package com.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.beans.Animal;
import com.beans.Client;
import com.beans.Furnizor;
import com.beans.Veterinar;
import com.database.DataBase;

//clasa folosita pentru controlul detinut de administrator
public class AdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int idAnimal; 
	private static int idVet;
  
	//verificam daca exista o pagina la care ne putem conecta
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page == null) {
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		}else {
			doPost(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		
		//realizam logarea administratorului
		if(page.equals("admin-login-form")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			//verificam daca datele introduse sunt corecte
			if(username.equals("admin") && password.equals("admin")) {
				request.getRequestDispatcher("index.jsp").forward(request, response);			

			}
			//daca sunt gresite suntem trimisi la pagina care atesta existenta unor date eronate
			else {		
				response.sendRedirect("adminLoginFailed.jsp");
				

			}
		}
		
		//daca se solicita stergerea unui client apelam functia de stergere din baza de date dupa id
		if(page.equals("delete_client")) {
			String id = request.getParameter("id");
			DataBase db = new DataBase();
			try {
				db.deleteClient(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "Client deleted successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

		//daca se solicita stergerea unui furnizor apelam functia de stergere din baza de date dupa id
		if(page.equals("delete_furnizor")) {
			String id = request.getParameter("id");
			DataBase db = new DataBase();
			try {
				db.deleteFurnizor(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "Furnizor deleted successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

		//daca se solicita stergerea unui animal apelam functia de stergere din baza de date dupa id
		if(page.equals("delete_animal")) {
			String id = request.getParameter("id");
			DataBase db = new DataBase();
			try {
				db.deleteAnimal(Integer.parseInt(id));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "Animal deleted successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
		
		//daca se solicita stergerea unui veterinar apelam functia de stergere din baza de date dupa id
		if(page.equals("delete_veterinar")) {
			String id = request.getParameter("id");
			DataBase db = new DataBase();
			try {
				db.deleteVeterinar(Integer.parseInt(id));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "Veterinar deleted successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}
	    
		//daca se solicita editarea unui client preluam noile date actualizata si apelam functia de update a bazei de date tinand cont de modificari
		if(page.equals("edit_client")){
		
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String id = request.getParameter("id");
			String pass = request.getParameter("parola");
			String adresa = request.getParameter("adresa");
			String email = request.getParameter("email");
			String telefon = request.getParameter("telefon");
			
			Client c = new Client(nume, prenume, id, pass, adresa, email, telefon);
			
			DataBase account = new DataBase();
			
			
			try {
				account.updateClient(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Client details updated successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		//daca se solicita editarea unui furnizor preluam noile date actualizata si apelam functia de update a bazei de date tinand cont de modificari
		if(page.equals("edit_furnizor")){
			
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String id = request.getParameter("id");
			String pass = request.getParameter("parola");
			String adresa = request.getParameter("adresa");
			String email = request.getParameter("email");
			String telefon = request.getParameter("telefon");
			
			Furnizor f = new Furnizor(nume, prenume, id, pass, adresa, email, telefon);
			
			DataBase account = new DataBase();
			
			
			try {
				account.updateFurnizor(f);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Provider details updated successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		//daca se solicita unui veterinar preluam noile date actualizata si apelam functia de update a bazei de date tinand cont de modificari
		if(page.equals("edit_veterinar")){
			String id = request.getParameter("id");
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");

			String adresa = request.getParameter("adresa");
			String email = request.getParameter("email");
			String telefon = request.getParameter("telefon");
			
			Veterinar v = new Veterinar(Integer.parseInt(id), nume, prenume, adresa, email, telefon);
			
			DataBase account = new DataBase();
			
			
			try {account.updateVeterinar(v);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Provider details updated successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		//daca se solicita editarea unui animal preluam noile date actualizata si apelam functia de update a bazei de date tinand cont de modificari
		if(page.equals("edit_animal")){
			String id = request.getParameter("id");
			String nume = request.getParameter("nume");
			String proprietar = request.getParameter("proprietar");
			String tip = request.getParameter("tip");
			String rasa= request.getParameter("rasa");
			String varsta = request.getParameter("varsta");
			String gen = request.getParameter("gen");
			String imagine = request.getParameter("imagine");
			boolean adoptat = Boolean.parseBoolean(request.getParameter("adoptat"));
			
			Animal a = new Animal(Integer.parseInt(id), nume, proprietar, tip, rasa, Integer.parseInt(varsta), gen, imagine, adoptat);
			
			DataBase account = new DataBase();
			
			
			try {account.updateAnimal(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Provider details updated successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		//daca se solicita adaugarea unui client preluam noile date si apelam functia de inserare in bazei de date
		if(page.equals("add_client")){
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String id = request.getParameter("username");
			String pass = request.getParameter("password");
			String adresa = request.getParameter("adresa");
			String email = request.getParameter("email");
			String telefon = request.getParameter("telefon");
			
			Client c = new Client(nume, prenume, id, pass, adresa, email, telefon);
			
			DataBase account = new DataBase();
			try {
				account.addClient(c);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Client added Successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		//daca se solicita adaugarea unui furnizor preluam noile date si apelam functia de inserare in bazei de date
		if(page.equals("add_furnizor")){
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String id = request.getParameter("username");
			String pass = request.getParameter("password");
			String adresa = request.getParameter("adresa");
			String email = request.getParameter("email");
			String telefon = request.getParameter("telefon");
			
			Furnizor f = new Furnizor(nume, prenume, id, pass, adresa, email, telefon);
			
			DataBase account = new DataBase();
			try {
				account.addFurnizor(f);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Provider added Successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		//daca se solicita adaugarea unui animal preluam noile date si apelam functia de inserare in bazei de date
		if(page.equals("add_animal")){
			String nume = request.getParameter("nume");
			String proprietar = request.getParameter("proprietar");
			String tip = request.getParameter("tip");
			String rasa= request.getParameter("rasa");
			String varsta = request.getParameter("varsta");
			String gen = request.getParameter("gen");
			String imagine = request.getParameter("imagine");
			
		    Random rand = new Random(); 

		    idAnimal = rand.nextInt(5000); 
			
			Animal a = new Animal(idAnimal, proprietar, nume, tip, rasa, Integer.parseInt(varsta), gen, imagine, false);
			
			
			DataBase account = new DataBase();
			try {
				account.addAnimal(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Animal added Successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		//daca se solicita adaugarea unui veterinar preluam noile date si apelam functia de inserare in bazei de date
		if(page.equals("add_veterinar")){
			
			String nume = request.getParameter("nume");
			String prenume = request.getParameter("prenume");
			String adresa = request.getParameter("adresa");
			String email = request.getParameter("email");
			String telefon = request.getParameter("telefon");
			
		    Random rand = new Random(); 

		    idVet = rand.nextInt(5000); 
			
			Veterinar v = new Veterinar(idVet, nume, prenume, adresa, email, telefon);
			
			DataBase account = new DataBase();
			try {
				account.addVeterinar(v);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Vet added Successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
