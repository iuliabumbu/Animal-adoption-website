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
import com.database.DataBase;

//clasa folosita pentru controlul detinut de furnizor
public class FurnizorControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int idAnimal;
  
	//verificam daca exista o pagina la care ne putem conecta
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			doPost(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		
		//daca se solicita adaugarea unui anunt preluam datele introduse in campurile soecifice, cream un nou animal si il inseram in baza de date
		if(page.equals("adauga_anunt")){
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
			JOptionPane.showMessageDialog(null, "Anunt adaugat cu succes!", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("anunturiFurnizor.jsp").forward(request, response);
		}
	
	}

}
