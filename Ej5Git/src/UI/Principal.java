package UI;

import javax.swing.JOptionPane;

import entidades.*;

public class Principal {
	
	static int cant = 2;
	static Empleado empleados [] = new Empleado[cant];
	
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Bienvenido a la carga de empleados");
		for (int i=0;i<cant;i++) {
		
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
			String apellido = JOptionPane.showInputDialog("Ingrese el apellido del empleado: ");
			int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dni del empleado: "));
			String email = JOptionPane.showInputDialog("Ingrese el email del empleado: ");
			int sueldoBase = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el sueldo base del empleado: "));
			
			int rta = JOptionPane.showOptionDialog(null, "Ingrese la ocpión que cargara:", "Carga de empleados", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Administrativo",  "Vendedor"}, "Administrativo");
			
			if (rta==0) {
				empleados[i] = cargarAdministrativo(nombre, apellido, dni, email, sueldoBase);				
			}
			else {
				empleados[i] = cargarVendedor(nombre, apellido, dni, email, sueldoBase);	
			}
			
			JOptionPane.showMessageDialog(null, "Empleado cargado con éxito!");
		}
		
		mostrarEmpleados(empleados);
			
	}
	
	
	
	private static Vendedor cargarVendedor(String nombre, String apellido, int dni, String email, int sueldoBase) {
		
		double porcenComision = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje de comision: "));
		int totalVentas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el total de ventas: "));
		Vendedor vend = new Vendedor(dni, apellido, nombre, email, sueldoBase, porcenComision, totalVentas);
		return vend;
	}



	private static Administrativo cargarAdministrativo(String nombre, String apellido, int dni, String email, int sueldoBase) {
		
		double hsExtra = Double.parseDouble(JOptionPane.showInputDialog("Ingrese las horas extras: "));
		double hsMes = Double.parseDouble(JOptionPane.showInputDialog("Ingrese las horas del mes: "));
		Administrativo admin = new Administrativo(dni, apellido, nombre, email, sueldoBase, hsExtra, hsMes);
		return admin;
	}
	
	public static void mostrarEmpleados(Empleado[] empleados) {
    	System.out.println("Listado de empleados");
    	for (int i=0; i<cant; i++) {
    		if (empleados[i]!= null) {
    			System.out.println(" Empleado "+i+1+": "+empleados[i].getDetalle());
    		}
    	}
	}

}
