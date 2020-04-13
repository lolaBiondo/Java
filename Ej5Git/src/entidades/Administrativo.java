package entidades;

public class Administrativo extends Empleado {
	
	double hsExtra;
	double hsMes;
	public double getHsExtra() {
		return hsExtra;
	}
	public void setHsExtra(double hsExtra) {
		this.hsExtra = hsExtra;
	}
	public double getHsMes() {
		return hsMes;
	}
	public void setHsMes(double hsMes) {
		this.hsMes = hsMes;
	}
	
	public Administrativo(int dni, String apellido, String nombre, String email, double sueldoBase, double hsExtra, double hsMes) {
		super(dni, apellido, nombre, email, sueldoBase);
		this.setHsExtra(hsExtra);
		this.setHsMes(hsMes);
	}
	
	@Override
	public String getDetalle() {
		//return super.getDetalle()+" - Hs. Extra: "+this.getHsExtra()+" - Hs Mes: "+this.getHsMes();
		double sueldo = this.getSueldoBase()*((this.getHsExtra()*1.5)+this.getHsMes())/this.getHsMes();
		return super.getDetalle()+" - Sueldo: "+sueldo;
	}
}
