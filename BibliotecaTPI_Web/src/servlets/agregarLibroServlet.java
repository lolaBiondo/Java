package servlets;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Libro;
import logic.LibroController;

/**
 * Servlet implementation class agregarLibroServlet
 */
@WebServlet("/agregarLibroServlet")
public class agregarLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public agregarLibroServlet() {
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
		LibroController ctrlLibro = new LibroController();
		Libro lib = new Libro();
		
		String titulo = request.getParameter("titulo");
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		String cuit = request.getParameter("cuit");
		int nroedicion = Integer.parseInt(request.getParameter("nroedicion"));
		int cantdias = Integer.parseInt(request.getParameter("cantdiasprestamo"));
		String genero = request.getParameter("genero");
		
		
		lib.setTitulo(titulo);
		lib.setIsbn(isbn);
		lib.setCUIT(cuit);
		lib.setNroEdicion(nroedicion);
		lib.setGenero(genero);
		lib.setCantDiasMaxPrestamo(cantdias);
		
		ctrlLibro.createLibro(lib);
		
		request.setAttribute("nuevoLibro", lib);
		request.getRequestDispatcher("listarLibroServlet").forward(request, response);
		//doGet(request, response);
		
	}

}
