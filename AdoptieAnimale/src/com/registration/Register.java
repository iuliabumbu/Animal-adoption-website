package com.registration;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Client;
import com.beans.Furnizor;

/**
 * Servlet implementation class Register
 */
//clasa Servlet responsabila cu inregistrarea
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//metoda preia toate datele din campurile completate de utilizator si creeaza un cont de tipul cerut, dupa care redirectioneaza utilizatorul la pagina de logare
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nume = request.getParameter("nume");
		String prenume = request.getParameter("prenume");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String adresa = request.getParameter("adresa");
		String telefon = request.getParameter("telefon");
		
		RegisterDAO rDao = new RegisterDAO();
		
		if(request.getParameter("tip") != null) {
            if(request.getParameter("tip").equals("furnizor")) {
            	Furnizor furnizor = new Furnizor(nume,prenume, username, password, adresa, email, telefon);
            	rDao.insert(furnizor, request.getParameter("tip"));
                
            }
            else if(request.getParameter("tip").equals("client")) {
            	Client client = new Client(nume,prenume, username, password, adresa, email, telefon);
            	rDao.insert(client, request.getParameter("tip"));
            }
              
            }
           
			
		response.sendRedirect("login.jsp");
		
	}

}
