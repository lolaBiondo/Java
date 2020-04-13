package entidades;

public class Vendedor extends Empleado {
	double porcenComision;
	int totalVentas;
	
	public double getPorcenComision() {
		return porcenComision;
	}
	public void setPorcenComision(double porcenComision) {
		this.porcenComision = porcenComision;
	}
	public int getTotalVentas() {
		return totalVentas;
	}
	public void setTotalVentas(int totalVentas) {
		this.totalVentas = totalVentas;
	}
	
	public Vendedor (int dni, String apellido, String nombre, String email, double sueldoBase, double porcenComision, int totalVentas) {
		super(dni, apellido, nombre, email, sueldoBase);//INVOCO CONSTRUCTOR DE SUPERCLASE
		this.setPorcenComision(porcenComision);
		this.setTotalVentas(totalVentas);
	}
	
	@Override
	public String getDetalle() {
		//return super.getDetalle()+" - % Comisión: "+this.getPorcenComision()+"% - Total Ventas: "+this.getTotalVentas();
		double sueldo = super.getSueldoBase()+(this.getPorcenComision()*this.getTotalVentas()/100);
		return super.getDetalle()+" - Sueldo: "+sueldo;
	}
}
