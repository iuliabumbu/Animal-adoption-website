package com.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.beans.Adoptie;
import com.beans.Animal;
import com.database.DataBase;


//clasa folosita pentru controlul detinut de client
public class ClientControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int idAdoptie = 5540;
	ArrayList<Animal> list = new ArrayList<>();
	HttpSession session;
  
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
		
		//verificam ce categorie a animalelor dorim sa o afisam si redirectam continutul spre pagina respectiva
		if(page.equals("caini") || page.equals("pisici") || page.equals("papagali") || page.equals("hamsteri") || page.equals("iepuri") || page.equals("pesti") || page.equals("all-animals")) {
			DataBase db = new DataBase();
			 try {
				list = db.fetchAnimale();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("list", list);

			if(page.equals("caini"))
				request.getRequestDispatcher("caini.jsp").forward(request, response);
			if(page.equals("pisici"))
				request.getRequestDispatcher("pisici.jsp").forward(request, response);
			if(page.equals("papagali"))
				request.getRequestDispatcher("papagali.jsp").forward(request, response);
			if(page.equals("hamsteri"))
				request.getRequestDispatcher("hamsteri.jsp").forward(request, response);
			if(page.equals("iepuri"))
				request.getRequestDispatcher("iepuri.jsp").forward(request, response);
			if(page.equals("pesti"))
				request.getRequestDispatcher("pesti.jsp").forward(request, response);
			if(page.equals("all-animals"))
				request.getRequestDispatcher("toateAnimalele.jsp").forward(request, response);
		}
		
		// in cadrul acestui if realizam sortarea datelor afisate dupa varsta crescator sau descrescator in functie de comanda primita
		if(page.equals("age-sort")) {
			String age = request.getParameter("sort");
			String action = request.getParameter("action");
			
			DataBase db = new DataBase();
			 try {
				list = db.fetchAnimale();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			Animal p = new Animal();
			if(age.equals("low-to-high"))
				list = p.lowtohigh(list);
			else
				list = p.hightolow(list);
			
			request.setAttribute("list", list);

			if(action.equals("all-animals"))
				request.getRequestDispatcher("toateAnimalele.jsp").forward(request, response);
			if(page.equals("caini"))
				request.getRequestDispatcher("caini.jsp").forward(request, response);
			if(page.equals("pisici"))
				request.getRequestDispatcher("pisici.jsp").forward(request, response);
			if(page.equals("papagali"))
				request.getRequestDispatcher("papagali.jsp").forward(request, response);
			if(page.equals("hamsteri"))
				request.getRequestDispatcher("hamsteri.jsp").forward(request, response);
			if(page.equals("iepuri"))
				request.getRequestDispatcher("iepuri.jsp").forward(request, response);
			if(page.equals("pesti"))
				request.getRequestDispatcher("pesti.jsp").forward(request, response);
		}
		
		//daca se solicita adaugarea unei adoptii preluam datele introduse in campurile soecifice, cream adoptia si o inseram in baza de date cu un id generat aleator
		if(page.equals("efectueazaAdoptie")){
			String id = request.getParameter("id");
			String donator = request.getParameter("donator");
			String proprietar = request.getParameter("proprietar");
			DataBase db = new DataBase();
			
		    Random rand = new Random(); 
		    idAdoptie = rand.nextInt(5000); 
		
			Adoptie a = new Adoptie(idAdoptie, Integer.parseInt(id), donator, proprietar);
			
			
			try {
				db.addAdoptie(a);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Animal an = new Animal();
			
			try {
				an = db.fetchAnimal(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			an.setAdoptat(true);
			
			try {
				db.updateAnimal(an);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			request.getRequestDispatcher("adoptie.jsp?donator="+donator).forward(request, response);
		}
	
	}

}
