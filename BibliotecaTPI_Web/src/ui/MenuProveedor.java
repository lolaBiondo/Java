package ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entities.*;
import logic.*;

public class MenuProveedor {
	Scanner s=null;
	ProveedorController ctrlProveedor = new ProveedorController();

	public void start() {
		s = new Scanner(System.in);
		String command;
		do {
			System.out.print("------------------------------------------------------------------------------- \nMEN�\n");
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}
	private void executeCommand(String command) {
		switch (command) {			
		case "new":
			System.out.print("------------------------------------------------------------------------------- \nNUEVO PROVEEDOR\n");
			System.out.println(newProveedor());
			break;	
		case "list":
			System.out.print("------------------------------------------------------------------------------- \nLISTADO DE PROVEEDORES\n");
			System.out.println(ctrlProveedor.getAllProveedores());
			break;
		case "search":
			System.out.print("------------------------------------------------------------------------------- \nB�SQUEDA POR CUIT\n");
			System.out.println(getByCUIT());
			break;
		case "edit":
			System.out.print("------------------------------------------------------------------------------- \nMODIFICAR PROVEEDOR\n");
			editProveedor();
			break;
		case "delete":
			System.out.print("------------------------------------------------------------------------------- \nELIMINAR PROVEEDOR\n");
			deleteProveedor();
			break;
		default:
			break;
		}
	}

	
	private void deleteProveedor() {
		Proveedor prov=new Proveedor();
		System.out.println("Ingrese los datos del proveedor que desea eliminar: ");
		prov=getByCUIT();
		while (prov==null) {
			System.out.println("Proveedor inesxistente. Ingrese los datos del proveedor que desea eliminar: ");
			prov=getByCUIT();
		}
		System.out.println("Proveedor que desea eliminar: "+prov);
		System.out.println("Est� seguro que desea elminar a este proveedor? si / no: ");
		switch(s.nextLine()) {
		case "no":
			System.out.println("Proveedor no eliminado.");
			break;
		case "si":
			ctrlProveedor.deleteProveedor(prov);
			System.out.println("El proveedor fue eliminado con �xito!");
		}
		
	}
	private void editProveedor() {
		Proveedor prov = new Proveedor();
		System.out.println("Ingrese los datos del proveedor que desea editar: ");
		prov=getByCUIT();
		while (prov==null) {
			System.out.println("Proveedor inesxistente. Ingrese los datos del proveedor que desea editar: ");
			prov=getByCUIT();
		}
		System.out.println("Proveedor que desea editar: "+prov);
		System.out.print("Ingrese el nuevo CUIT: ");
		prov.setCUIT(s.nextLine());
		System.out.print("Ingrese la nueva Raz�n Social: ");
		prov.setRazonSocial(s.nextLine());
		System.out.print("Ingrese el nuevo email: ");
		prov.setMail(s.nextLine());
		System.out.print("Ingrese la nueva direcci�n: ");
		prov.setDireccion(s.nextLine());
		System.out.print("Ingrese el nuevo telefono: ");
		prov.setTelefono(s.nextLine());
		ctrlProveedor.editProveedor(prov);
		System.out.println("Los datos fueron editados con �xito!");
		System.out.print("Proveedor: "+prov);
	}
	
	
	private String getCommand() {
		System.out.println("Ingrese el comando seg�n la opci�n que desee realizar");
		System.out.println("new\t\tNuevo Proveedor");
		System.out.println("list\t\tListar Proveedores");
		System.out.println("search\t\tBuscar Proveedores");
		System.out.println("edit\t\tEditar Proveedores");
		System.out.println("delete\t\tEliminar Proveedores");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	private Proveedor getByCUIT() {
		System.out.println();
		Proveedor prov=new Proveedor();
		System.out.print("CUIT: ");
		prov.setCUIT(s.nextLine());
		return ctrlProveedor.getByCUIT(prov);
	}
	
	private Proveedor newProveedor() {
		System.out.println();
		Proveedor prov=new Proveedor();
		System.out.print("Ingrese el CUIT: ");
		prov.setCUIT(s.nextLine());
		System.out.print("Ingrese la razon social: ");
		prov.setRazonSocial(s.nextLine());
		System.out.print("Ingrese el email: ");
		prov.setMail(s.nextLine());
		System.out.print("Ingrese la direcci�n: ");
		prov.setDireccion(s.nextLine());
		System.out.print("Ingrese el telefono: ");
		prov.setTelefono(s.nextLine());
		ctrlProveedor.createProveedor(prov);
		System.out.println("\nEl proveedor fue ingresado con �xito!");
		return prov;
	}

}
