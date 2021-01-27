package logic;

import data.*;
import entities.*;

import java.util.LinkedList;
import java.util.Scanner;

public class LibroController {
	
	private DataLibro dl;
	
	public LibroController() {
		dl=new DataLibro();
	}
	
	public LinkedList<Libro> getAllLibros(){
		return dl.getAll();
	}
	
	public Libro getByIdLibro(Libro lib) {
		return dl.getById(lib);
	}
	
	public Libro createLibro(Libro lib) {
		return dl.add(lib);
	}

	public Libro editLibro(Libro lib) {
		return dl.editLibro(lib);
	}

	public Libro deleteLibro(Libro lib) {
		return dl.deleteLibro(lib);
	}
	
	public LinkedList<Ejemplar> getEjByIdLibro (Libro lib) {
		return dl.getEjByIdLibro(lib);
	}
	
	public Ejemplar newEjemplar(Ejemplar ej) {
		return dl.addEjemplar(ej);
	}
	
	public Ejemplar deleteEjemplar(Ejemplar ej) {
		return dl.deleteEjemplar(ej);		
	}
	
	public LinkedList<Ejemplar> getAllEjemplares(){
		return dl.getAllEjemplares();
	}
	public Ejemplar deleteEjemplarPorIdLibro (Ejemplar ej, Libro lib) {
		return dl.deleteEjemplar(ej);		
	}
	
	/*public Ejemplar getByIdEjemplar(Ejemplar ej) {
		return de.getByIdEjemplar(ej);
	}*/
	
	
}