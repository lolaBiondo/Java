package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import entities.*;
import logic.*;

public class MenuLibro {
	Scanner s=null;
	LibroController ctrlLibro = new LibroController();
	ProveedorController ctrlProv = new ProveedorController();
	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	
	public void start() {
		s = new Scanner(System.in);
		String command;
		do {
			System.out.print("------------------------------------------------------------------------------- \nMENÚ\n");
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}
	private void executeCommand(String command) {
		switch (command) {			
		case "new":
			System.out.print("------------------------------------------------------------------------------- \nNUEVO Libro\n");
			System.out.println(newLibro());
			break;	
		case "list":
			System.out.print("------------------------------------------------------------------------------- \nLISTADO DE Libros\n");
			System.out.println(ctrlLibro.getAllLibros());
			break;
		case "search":
			System.out.print("------------------------------------------------------------------------------- \nBÚSQUEDA POR ID LIBRO\n");
			System.out.println(getByIdLibro());
			break;
		case "edit":
			System.out.print("------------------------------------------------------------------------------- \nMODIFICAR Libro\n");
			editLibro();
			break;
		case "delete":
			System.out.print("------------------------------------------------------------------------------- \nELIMINAR Libro\n");
			deleteLibro();
			break;
		case "new1":
			System.out.print("------------------------------------------------------------------------------- \nNUEVO Ejemplar\n");
			System.out.println(newEjemplar());
			break;	
		case "list1":
			System.out.print("------------------------------------------------------------------------------- \nLISTADO DE Ejemplares por Libro\n");
			System.out.println(getByLibro());
			break;
		case "delete1":
			System.out.print("------------------------------------------------------------------------------- \nELIMINAR Ejemplar\n");
			deleteEjemplar();
			break;	
		
		default:
			break;
		}
	}

	
	private void deleteLibro() {
		Libro lib=new Libro();
		System.out.println("Ingrese los datos del Libro que desea eliminar: ");
		lib=getByIdLibro();
		while (lib==null) {
			System.out.println("Libro inesxistente. Ingrese los datos del Libro que desea eliminar: ");
			lib=getByIdLibro();
		}
		System.out.println("Libro que desea eliminar: "+lib);
		System.out.println("Está seguro que desea elminar a este Libro? si / no: ");
		switch(s.nextLine()) {
		case "no":
			System.out.println("Libro no eliminado.");
			break;
		case "si":
			ctrlLibro.deleteLibro(lib);
			System.out.println("El Libro fue eliminado con éxito!");
		}
		
	}
	private void editLibro() {
		Libro lib = new Libro();
		Proveedor p = new Proveedor();
		System.out.println(ctrlLibro.getAllLibros());
		System.out.println("Ingrese los datos del Libro que desea editar: ");
		lib=getByIdLibro();
		while (lib==null) {
			System.out.println("Libro inesxistente. Ingrese los datos del Libro que desea editar: ");
			lib=getByIdLibro();
		}
		System.out.println("Libro que desea editar: "+lib);
		System.out.print("Ingrese el nuevo ISBN: ");
		lib.setIsbn(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese el título: ");
		lib.setTitulo(s.nextLine());
		System.out.print("Ingrese la nueva fecha de edición: ");
		/*try {
			java.sql.Date fecha = (java.sql.Date) formato.parse(s.nextLine());
			lib.setFechaEdicion(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		try {
			java.util.Date fecha=formato.parse(s.nextLine());
			lib.setFechaEdicion(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.print("Ingrese el nuevo número de edición: ");
		lib.setNroEdicion(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese la nueva cantidad de días máxima de préstamo : ");
		lib.setCantDiasMaxPrestamo(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese el nuevo género: ");
		lib.setGenero(s.nextLine());
		System.out.println("---------------Listado de proveeores disponibles---------------");
		System.out.println(ctrlProv.getAllProveedores());
		System.out.print("Ingrese el nuevo CUIT del proveedor correspondiente: ");
		p.setCUIT(s.nextLine());
		p=ctrlProv.getByCUIT(p);
		while(p==null) {
			System.out.println("CUIT Incorrecto. Ingrese el nuevo CUIT del proveedor que desea: ");
			p=new Proveedor();
			p.setCUIT(s.nextLine());
			p=ctrlProv.getByCUIT(p);
		}
		
		System.out.println("Proveedor escogido:"+p);
		lib.setCUIT(p.getCUIT());
		ctrlLibro.editLibro(lib);
		System.out.println("Los datos fueron editados con éxito!");
		System.out.print("Libro: "+lib);
	}
	
	
	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("new\t\tNuevo Libro");
		System.out.println("list\t\tListar Libros");
		System.out.println("search\t\tBuscar Libros");
		System.out.println("edit\t\tEditar Libros");
		System.out.println("delete\t\tEliminar Libros");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	private Libro getByIdLibro() {
		System.out.println();
		Libro lib=new Libro();
		System.out.print("Id Libro: ");
		lib.setIdLibro(Integer.parseInt(s.nextLine()));
		return ctrlLibro.getByIdLibro(lib);
	}
	
	private Libro newLibro() {
		System.out.println();
		Libro lib=new Libro();
		Proveedor p = new Proveedor();
		lib.setFechaEdicion(new Date());
		System.out.print("Ingrese el ISBN: ");
		lib.setIsbn(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese el título: ");
		lib.setTitulo(s.nextLine());
		System.out.print("Ingrese la fecha de edición: ");
		/*try {
			lib.setFechaEdicion(formato.parse(s.nextLine()));
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		try {
			java.util.Date fecha=formato.parse(s.nextLine());
			lib.setFechaEdicion(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.print("Ingrese el número de edición: ");
		lib.setNroEdicion(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese la cantidad de días máxima de préstamo : ");
		lib.setCantDiasMaxPrestamo(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese el género: ");
		lib.setGenero(s.nextLine());
		System.out.println("---------------Listado de proveeores disponibles---------------");
		System.out.println(ctrlProv.getAllProveedores());
		System.out.print("Ingrese el CUIT del proveedor correspondiente: ");
		p.setCUIT(s.nextLine());
		p=ctrlProv.getByCUIT(p);
		while(p==null) {
			System.out.println("CUIT Incorrecto. Ingrese el CUIT del proveedor que desea: ");
			p=new Proveedor();
			p.setCUIT(s.nextLine());
			p=ctrlProv.getByCUIT(p);
		}
		
		System.out.println("Proveedor escogido:"+p);
		// listar prov, pedir cuit, verificar con el getBy, y añadir al arreglo de proveedores
		lib.setCUIT(p.getCUIT());
		ctrlLibro.createLibro(lib);
		System.out.println("\nEl Libro fue ingresado con éxito!");
		return lib;
	}
	
	
	private LinkedList<Ejemplar> getByLibro(){
		Libro l = new Libro();
		System.out.println(ctrlLibro.getAllLibros());
		System.out.println("Ingrese el id del libro:");
		l.setIdLibro(Integer.parseInt(s.nextLine()));
		Libro lib = ctrlLibro.getByIdLibro(l);
		while (lib==null) {
			System.out.println("Libro inexistente. Ingrese el id del Libro: ");
			lib = ctrlLibro.getByIdLibro(l);
		}
		return ctrlLibro.getEjByIdLibro(lib);
	} 
	private Ejemplar newEjemplar() {
		System.out.println();
		Ejemplar ej = new Ejemplar();
		Libro l = new Libro();
		System.out.println(ctrlLibro.getAllLibros());
		System.out.println("Ingrese el id del Libro");
		l.setIdLibro(Integer.parseInt(s.nextLine()));
		l =ctrlLibro.getByIdLibro(l);
		while (l==null) {
			System.out.println("Libro inexistente. Ingrese el id del Libro: ");
			l=new Libro();
			l.setIdLibro(Integer.parseInt(s.nextLine()));
			l = ctrlLibro.getByIdLibro(l);
		}
		ej.setIdLibro(l.getIdLibro());
		ej.setEstado(true);
		ctrlLibro.newEjemplar(ej);
		System.out.println("Ejemplar agregado con exito!");
		return ej;
	}
	
	
	private void deleteEjemplar() {
		System.out.println();
		Ejemplar ej = new Ejemplar();
		Libro l = new Libro();
		LinkedList<Ejemplar> ejemplares =new LinkedList<>();
		System.out.println(ctrlLibro.getAllLibros());
		System.out.println("Ingrese el id del Libro");
		l.setIdLibro(Integer.parseInt(s.nextLine()));
		l =ctrlLibro.getByIdLibro(l);
		while (l==null) {
			System.out.println("Libro inexistente. Ingrese el id del Libro: ");
			l=new Libro();
			l.setIdLibro(Integer.parseInt(s.nextLine()));
			l = ctrlLibro.getByIdLibro(l);
		}
		System.out.println(ctrlLibro.getByIdLibro(l));
		System.out.println("Ingrese el ejemplar a eliminar:");
		ej.setIdEjemplar(Integer.parseInt(s.nextLine()));
		System.out.println("Ejemplar a eliminar:"+ej);
		System.out.println("Del libro"+l.getTitulo());
		System.out.println("Está seguro que desea elminar este ejemplar? si / no: ");
		switch(s.nextLine()) {
		case "no":
			System.out.println("Ejemplar no eliminado.");
			break;
		case "si":
			ctrlLibro.deleteEjemplar(ej);
			System.out.println("Ejemplar eliminado con éxito!");
		}
		
	}
	/*private Ejemplar getByIdEjemplar () {
		Ejemplar ej = new Ejemplar();
		System.out.println(ctrlLibro.getAllEjemplares());
		System.out.println("Ingrese el id del ejemplar:");
		ej.setIdEjemplar(Integer.parseInt(s.nextLine()));
		ctrlLibro.getByIdEjemplar(ej);
		return ej;
	}*/

}
