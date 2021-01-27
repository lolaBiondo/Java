package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.LinkedList;

import entities.Libro;
import logic.LibroController;


/**
 * Servlet implementation class modificarLibroServlet
 */
@WebServlet("/modificarLibroServlet")
public class modificarLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modificarLibroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * LibroController ctrlLibro = new LibroController(); Libro lib=new Libro();
		 * lib.setIdLibro(Integer.parseInt(request.getParameter("id")));
		 * lib=ctrlLibro.getByIdLibro(lib); //lo piso con el objeto
		 * request.setAttribute("libroAEditar", lib);
		 * request.getRequestDispatcher("modificarLibro.jsp").forward(request,
		 * response);
		 */
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		LibroController ctrlLibro = new LibroController();
		request.setAttribute("listaLibros", ctrlLibro.getAllLibros());
		request.getRequestDispatcher("modificarLibro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LibroController ctrlLibro = new LibroController();
		Libro lib=new Libro();
		lib.setIdLibro(Integer.parseInt(request.getParameter("id")));
		String titulo = request.getParameter("titulo");
		int isbn = Integer.parseInt(request.getParameter("isbn"));
		int nroedicion = Integer.parseInt(request.getParameter("nroedicion"));
		int cantdias = Integer.parseInt(request.getParameter("cantdiasprestamo"));
		String genero = request.getParameter("genero");
		//int id = Integer.parseInt(request.getParameter("id"));
		
		
		lib.setTitulo(titulo);
		lib.setIsbn(isbn);
		
		lib.setNroEdicion(nroedicion);
		lib.setGenero(genero);
		lib.setCantDiasMaxPrestamo(cantdias);
		
		ctrlLibro.editLibro(lib);
		
		request.getRequestDispatcher("listarLibroServlet").forward(request, response);
		//doGet(request, response);
	}

}
