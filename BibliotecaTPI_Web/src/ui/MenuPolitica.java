package ui;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import entities.*;
import logic.*;


public class MenuPolitica {
	Scanner s=null;
	PoliticaPrestamoController ctrlPP = new PoliticaPrestamoController();
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
		case "list":
			System.out.print("------------------------------------------------------------------------------- \nLISTADO DE POLITICAS DE PRESTAMO\n");
			System.out.println(ctrlPP.ppGetAll());
			break;
		case "find":
			System.out.print("------------------------------------------------------------------------------- \nBUSCAR POR ID\n");
			System.out.println(getByIdPolitica());
			break;
		case "new":
			System.out.print("------------------------------------------------------------------------------- \nNUEVA POLITCA DE PRESTAMO\n");
			System.out.println(newPolitica());
			break;
		case "edit":
			System.out.print("------------------------------------------------------------------------------- \nMODIFICAR PERSONA\n");
			System.out.println(editPolitica());
			break;
		case "delete":
			System.out.print("------------------------------------------------------------------------------- \nMODIFICAR PERSONA\n");
			deletePolitica();
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1
		System.out.println("search\t\tlistar por apellido"); //puede devolver varios
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
		System.out.println("delete\t\tborra por tipo y nro de documento");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	private PoliticaPrestamo newPolitica() {
		System.out.println();
		PoliticaPrestamo pp = new PoliticaPrestamo();
		System.out.print("Ingrese el número máximo de libros que puede retirar el socio: ");
		pp.setCantMaximaSocio(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese el número máximo de libros que puede retirar el no socio: ");
		pp.setCantMaximaNoSocio(Integer.parseInt(s.nextLine()));
		/*System.out.println("Ingrese la fecha de hoy: yyyy-mm-dd");
		try {
			java.util.Date fecha2=formato.parse(s.nextLine());
			pp.setFechaAlta(fecha2);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
				
		/*String date_c = s.nextLine();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try{
            date = df.parse(date_c);
            System.out.println("Ahora hemos creado un objeto date con la fecha indicada, "+date);
        } catch (Exception e){ System.out.println("invalid format");}
 
        if (!df.format(date).equals(date)){
            System.out.println("invalid date!!");
        } else {
            System.out.println("valid date");
        }*/
		ctrlPP.newPolitica(pp);
		return pp;
		
	}
	private PoliticaPrestamo getByIdPolitica() {
		System.out.println();
		System.out.println(ctrlPP.ppGetAll());
		PoliticaPrestamo pp=new PoliticaPrestamo();
		System.out.print("Id: ");
		pp.setIdPoliticaPrestamo(Integer.parseInt(s.nextLine()));

		
		return ctrlPP.getByIdPolitica(pp);
	}
	private PoliticaPrestamo editPolitica() {
		PoliticaPrestamo pp= new PoliticaPrestamo();
		ctrlPP.ppGetAll();
		System.out.println("Ingrese el id de la politica a editar: ");
		pp=getByIdPolitica();
		while (pp==null) {
			System.out.println("Persona inesxistente. Ingrese los datos de la persona que desea editar: ");
			pp=getByIdPolitica();
		}
		System.out.println("Politica que desea editar: "+pp);
		System.out.print("Ingrese la cantidad maxima de libros por socio: ");
		pp.setCantMaximaSocio(Integer.parseInt(s.nextLine()));
		System.out.print("Ingrese la cantidad maxima de libros por no socio: ");
		pp.setCantMaximaNoSocio(Integer.parseInt(s.nextLine()));
			
		ctrlPP.editPolitica(pp);

		System.out.println("Los datos fueron editados con éxito!");
		System.out.print("Politica de Prestamo: "+pp);
		
		return pp;
	}	
	private void deletePolitica() {
		PoliticaPrestamo pp=new PoliticaPrestamo();
		System.out.println("Ingrese el id de la politica de Prestamo que desea eliminar: ");
		pp=getByIdPolitica();
		while (pp==null) {
			System.out.println("Politica de Prestamo inesxistente. Ingrese el id de la politica que desea eliminar: ");
			pp=getByIdPolitica();
		}
		System.out.println("Politica de Prestamo que desea eliminar: "+pp);
		System.out.println("Está seguro que desea elminar a esta persona? si / no: ");
		switch(s.nextLine()) {
		case "no":
			System.out.println("Persona no eliminada.");
			break;
		case "si":
			ctrlPP.deletePoliticaPrestamo(pp);
			System.out.println("Eliminada con éxito!");
		}
		
	}


}
