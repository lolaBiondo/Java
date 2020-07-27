package ui;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import entities.*;
import logic.Login;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		Persona p=login();
		System.out.println("\n\nBienvenido "+p.getNombre()+" "+p.getApellido());
		System.out.println();
		
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
			System.out.print("------------------------------------------------------------------------------- \nLISTADO DE PERSONAS\n");
			System.out.println(ctrlLogin.getAll());
			break;
		case "find":
			System.out.print("------------------------------------------------------------------------------- \nBÚSQUEDA POR DOCUMENTOn");
			System.out.println(find());
			break;
		case "search":
			System.out.print("------------------------------------------------------------------------------- \nBÚSQUEDA POR APELLIDO\n");
			System.out.println(search());
			break;
		case "new":
			System.out.print("------------------------------------------------------------------------------- \nNUEVA PERSONA\n");
			System.out.println(newPerson());
			break;
		case "edit":
			System.out.print("------------------------------------------------------------------------------- \nMODIFICAR PERSONA\n");
			editPerson();
			break;
		case "delete":
			System.out.print("------------------------------------------------------------------------------- \nELIMINAR PERSONA\n");
			deletePerson();
			break;
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
	
	public Persona login() {
		Persona p=new Persona();
		
		System.out.print("Email: ");
		p.setEmail(s.nextLine());

		System.out.print("password: ");
		p.setPassword(s.nextLine());
		
		p=ctrlLogin.validate(p);
		
		return p;
		
	}
	
	private Persona find() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		return ctrlLogin.getByDocumento(p);
	}
	
	private LinkedList<Persona> search() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Ingrese el apellido: ");
		p.setApellido(s.nextLine());
		
		return ctrlLogin.getByLastName(p);
	}
	
	private Persona newPerson() {
			System.out.println();
			Persona p=new Persona();
			Documento d=new Documento();
			Rol r=new Rol();
			p.setDocumento(d);
			System.out.print("Ingrese el nombre: ");
			p.setNombre(s.nextLine());
			System.out.print("Ingrese el apellido: ");
			p.setApellido(s.nextLine());
			System.out.print("Tipo doc: ");
			d.setTipo(s.nextLine());
			System.out.print("Nro doc: ");
			d.setNro(s.nextLine());
			System.out.print("Ingrese el email: ");
			p.setEmail(s.nextLine());
			System.out.print("Ingrese el password: ");
			p.setPassword(s.nextLine());
			System.out.print("Ingrese el telefono: ");
			p.setTel(s.nextLine());
			/*boolean band = false;
			while (band==false) {
				System.out.print("El usuario está habilitado? SI / NO: ");
				if (s.nextLine()=="SI" || s.nextLine()=="NO") {
					band=true;
				}
			}
			if (s.nextLine()=="SI") {
				p.setHabilitado(true);
			}
			else p.setHabilitado(false);*/
			System.out.print("¿Estará habilitado? true / false: ");
			p.setHabilitado(Boolean.valueOf(s.nextLine()));
			System.out.println("Listado de roles:");
			System.out.println(ctrlLogin.getAllRoles());
			System.out.println("Ingrese el id del rol que desea: ");
			r.setId(Integer.parseInt(s.nextLine()));
			r=ctrlLogin.getById(r);
			while(r==null) {
				System.out.println("Rol Incorrecto. Ingrese el id del rol que desea: ");
				r=new Rol();
				r.setId(Integer.parseInt(s.nextLine()));
				r=ctrlLogin.getById(r); // piso el r inicial
			}
			
			System.out.println("Rol escogido:"+r);
			ctrlLogin.createPerson(p); //creo persona en db
			ctrlLogin.setRolPerson(p, r); //asigno rol en tabla rol_persona db
			System.out.println("\nLa persona fue ingresada con éxito!");
			ctrlLogin.setRoles(p); //asigno rol a entidad persona
			return p;
			
		}

	private void editPerson() {
		Persona p=new Persona();
		HashMap<Integer, Rol> roles=new HashMap<Integer, Rol>();
		System.out.println("Ingrese los datos de la persona que desea editar: ");
		p=find();
		while (p==null) {
			System.out.println("Persona inesxistente. Ingrese los datos de la persona que desea editar: ");
			p=find();
		}
		roles=p.getRoles();
		System.out.println("Persona que desea editar: "+p);
		System.out.println("Roles de la persona: "+roles);
		System.out.println("Menú de edición: \n1-Datos de persona \n2-Roles de persona \nOpción: ");
		switch(s.nextLine()) {
		case "1" :
			System.out.print("Ingrese el nuevo nombre: ");
			p.setNombre(s.nextLine());
			System.out.print("Ingrese el nuevo apellido: ");
			p.setApellido(s.nextLine());
			System.out.print("Ingrese el nuevo email: ");
			p.setEmail(s.nextLine());
			System.out.print("Ingrese el nuevo password: ");
			p.setPassword(s.nextLine());
			System.out.print("Ingrese el nuevo telefono: ");
			p.setTel(s.nextLine());
			System.out.print("¿Estará habilitado? true / false: ");
			p.setHabilitado(Boolean.valueOf(s.nextLine()));
			ctrlLogin.editPerson(p);
			break;
		case "2":
			System.out.print("Menú roles - Ingrese la opción que desea: \n1 - Elminar \n2 - Agregar \nOpción: ");
			switch(s.nextLine()) {
			case "1": //ELIMINAR ROL
				editDelRol(p);
				break;
			case "2":  //AÑADIR ROL
				editRol(p);
				break;
			}
		}
				
		System.out.println("Los datos fueron editados con éxito!");
		System.out.print("Persona: "+p);
		System.out.print("Roles: "+p.getRoles());
	}

	private void editRol(Persona p) {
		Rol r= new Rol();
		System.out.println("Listado de roles:");
		System.out.println(ctrlLogin.getAllRoles());
		System.out.println("Ingrese el id del rol que desea agregar: ");
		r.setId(Integer.parseInt(s.nextLine()));
		r=ctrlLogin.getById(r);
		while(r==null) {
			System.out.println("Rol Incorrecto. Ingrese el id del rol que desea: ");
			r=new Rol();
			r.setId(Integer.parseInt(s.nextLine()));
			r=ctrlLogin.getById(r);
		}
		if (p.hasRol(r)==true) {
			System.out.println("La persona ya tiene este rol asignado.");
		}
		else {
			p.addRol(r);
			ctrlLogin.setRolPerson(p, r); //asigno rol en tabla rol_persona db
			System.out.println("Rol agregado con éxito:"+r);
		}		
	}

	private void editDelRol(Persona p) {
		Rol r = new Rol();
		System.out.println("Roles de la persona: "+p.getRoles());
		System.out.println("Ingrese el id del rol que desea eliminar: ");
		r.setId(Integer.parseInt(s.nextLine()));
		r=ctrlLogin.getById(r);
		while(r==null) {
			System.out.println("Rol Incorrecto. Ingrese el id del rol que desea: ");
			r=new Rol();
			r.setId(Integer.parseInt(s.nextLine()));
			r=ctrlLogin.getById(r);
		}
		if (p.hasRol(r)==false) {
			System.out.println("La persona no tiene este rol asignado.");
		}
		else {
			p.removeRol(r);
			ctrlLogin.removeRolPerson(p, r); //asigno rol en tabla rol_persona db
			System.out.println("Rol eliminado con éxito:"+r);
		}
		
	}

	private void deletePerson() {
		Persona p=new Persona();
		HashMap<Integer, Rol> roles=new HashMap<Integer, Rol>();
		System.out.println("Ingrese los datos de la persona que desea eliminar: ");
		p=find();
		while (p==null) {
			System.out.println("Persona inesxistente. Ingrese los datos de la persona que desea eliminar: ");
			p=find();
		}
		roles=p.getRoles();
		System.out.println("Persona que desea eliminar: "+p);
		System.out.println("Roles de la persona: "+roles);
		System.out.println("Está seguro que desea elminar a esta persona? si / no: ");
		switch(s.nextLine()) {
		case "no":
			System.out.println("Persona no eliminada.");
			break;
		case "si":
			ctrlLogin.deletePerson(p);
			System.out.println("La persona fue eliminada con éxito!");
		}
		
	}
}

