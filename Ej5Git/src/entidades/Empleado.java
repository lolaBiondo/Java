package entidades;

public class Empleado {
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private double sueldoBase;
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	public Empleado(int dni, String apellido, String nombre, String email, double sueldoBase) {
		this.setDni(dni);
		this.setApellido(apellido);
		this.setNombre(nombre);
		this.setEmail(email);
		this.setSueldoBase(sueldoBase);
	}
	public String getDetalle() {
		//String detalle = "Nombre: "+this.getNombre()+" "+this.getApellido()+" - Email: "+this.getEmail()+" - Dni: "+this.getDni()+" - Sueldo Base: "+this.getSueldoBase();
		String detalle = "Nombre: "+this.getNombre()+" "+this.getApellido()+" - Dni: "+this.getDni();
		return detalle;
	}
		
	
}
