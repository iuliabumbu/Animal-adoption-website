package com.login;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beans.LoginBean;


/**
 * Servlet implementation class LoginServlet
 */
//clasa Servlet responsabila cu logarea
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	//se verifica validarea datelor de logare introduse de utilizator si in caz afirmativ aeste redirectionat la pagina sa
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO loginDao = new LoginDAO();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
	
		if (loginDao.validate(loginBean).equals("client"))
		{
			response.sendRedirect("indexClient.jsp?username="+username);
			
		}
		else if (loginDao.validate(loginBean).equals("furnizor"))
		{
			response.sendRedirect("indexFurnizor.jsp?username="+username);
			
		}
		else 
		{
			response.sendRedirect("loginError.jsp");
			
		}
		
	}

}