package ej_41;

public class Empleado {
	String nombre;
	String apellido;
	double h_trabajadas;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public double getH_trabajadas() {
		return h_trabajadas;
	}
	public void setH_trabajadas(double h_trabajadas) {
		this.h_trabajadas = h_trabajadas;
	}
	public Empleado(String nombre, String apellido, double h_trabajadas) {
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setH_trabajadas(h_trabajadas);
	}
	
	

}
