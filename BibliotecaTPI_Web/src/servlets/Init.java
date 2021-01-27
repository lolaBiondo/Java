package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Libro;
import entities.Persona;
import logic.LibroController;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class init
 * 
 */
@WebServlet("/init")
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Init() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Hola2");
		
		
		//String email = request.getParameter("email");
		//String password = request.getParameter("password");
		
		
		//request.getSession().setAttribute("usuario", per);
		processRequest (request, response);
		
	}	
	
	protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
	    	String email = request.getParameter("email");
	    	String password = request.getParameter("password");
	    	Persona per = new Persona();
	    	if (email.equalsIgnoreCase("sofia"))
	    	{
	    		if (password.equalsIgnoreCase("1234"))
	        	{
	    		  per.setEmail(email);
	    		  per.setContraseña(password);
	        	  HttpSession sesion = request.getSession();
	        	  sesion.setAttribute("usuario", per);
	        	  RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
	  			  rd.forward(request, response);
	     	  
	        	}	
	    		else
	    		{
	    			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
	    			rd.forward(request, response);
	    			
	    		}
	    	}
	    	else
			{
				RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
				
			}
	    	
	    	//doGet(request, response);
	}

}
