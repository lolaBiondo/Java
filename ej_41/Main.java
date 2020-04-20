package ej_41;

import javax.swing.JOptionPane; 
public class Main {
	
	static int cant = 2;
	static Empleado empleados [] = new Empleado[cant];
	static boolean band = false;
	static String nombre;
	static String apellido;
	static double h_trabajadas;
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Bienvenido a la carga de empleados");		
		for (int i = 0; i<cant; i++) {
				try {
					nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
					apellido = JOptionPane.showInputDialog("Ingrese el apellido del empleado: ");
					double h_trabajadas = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la cantidad de horas trabajadas: "));
					empleados[i] = cargarEmpleado(nombre, apellido, h_trabajadas); 
					JOptionPane.showMessageDialog(null, "Empleado cargado con éxito!");	
				}
			    catch(NullPointerException e) {
			    	JOptionPane.showMessageDialog(null, "No ingreso ningun dato.");
			    }
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "El numero ingresado no es correcto.");
				}
			}
		
		liquidacionEmpleados(empleados);
	}
	
	private static void liquidacionEmpleados(Empleado[] empleados) {
		double valor_hs = 25;
		double valor_he = 30;
		double porc_dcto = 19.5;
		double premio = 100;
		double hs_min = 40;
		System.out.println("Listado de empleados \n");
    	for (Empleado empleado : empleados) {
    		if (empleado != null) {
    			System.out.println("\nEmpleado : "+empleado.getApellido()+", "+empleado.getNombre());
				calcularYMostrarSueldo(empleado, valor_hs, valor_he, porc_dcto, premio, hs_min);    			
    		}
    	}
	}

	private static void calcularYMostrarSueldo(Empleado empleado, double valor_hs, double valor_he, double porc_dcto, double premio, double hs_min) {
		double h_simples = 0;
		double h_excedentes = 0;
		double s_bruto = 0;
		double dctos = 0;
		double s_neto = 0;
		if (empleado.getH_trabajadas()>=hs_min) {
			h_simples = hs_min;
			h_excedentes = empleado.getH_trabajadas() - hs_min;
			s_bruto = h_simples*valor_hs + h_excedentes*valor_he;
			dctos = porc_dcto*(h_simples*valor_hs)/100;
			s_neto = s_bruto - dctos + premio;
		} else {
			h_simples = empleado.getH_trabajadas();
			s_bruto = h_simples*valor_hs ;
			dctos = porc_dcto*(h_simples*valor_hs)/100 ;
			s_neto = s_bruto - dctos;
			premio = 0;
		}
		
		System.out.println( "Cantidad horas trabajadas: "+empleado.getH_trabajadas()
				+"\nCantidad horas simples: "+h_simples
				+"\nCantidad horas excedentes: "+h_excedentes
				+"\nSueldo Básico: $"+s_bruto
				+"\nDescuentos: $"+dctos
				+"\nPremio: $"+premio
				+"\nA cobrar: $"+s_neto);
		
	}

	private static Empleado cargarEmpleado(String nombre, String apellido, double h_trabajadas) {
		Empleado e = new Empleado(nombre, apellido, h_trabajadas);
		return e;
	}


}
