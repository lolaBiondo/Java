package clases;

public class Usuario {
	String usuario;
	String clave;
	String nroCajaAhorro;
	double saldoCajaAhorro;
	String nroCtaCte;
	double saldoCtaCte;
	
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNroCajaAhorro() {
		return nroCajaAhorro;
	}
	public void setNroCajaAhorro(String nroCajaAhorro) {
		this.nroCajaAhorro = nroCajaAhorro;
	}
	public double getSaldoCajaAhorro() {
		return saldoCajaAhorro;
	}
	public void setSaldoCajaAhorro(double saldoCajaAhorro) {
		this.saldoCajaAhorro = saldoCajaAhorro;
	}
	public String getNroCtaCte() {
		return nroCtaCte;
	}
	public void setNroCtaCte(String nroCtaCte) {
		this.nroCtaCte = nroCtaCte;
	}
	public double getSaldoCtaCte() {
		return saldoCtaCte;
	}
	public void setSaldoCtaCte(double saldoCtaCte) {
		this.saldoCtaCte = saldoCtaCte;
	}
	
	
	public Usuario(String usuario, String clave, String nroCajaAhorro, double saldoCajaAhorro, String nroCtaCte,
			double saldoCtaCte) {
		this.setUsuario(usuario);
		this.setClave(clave);
		this.setNroCajaAhorro(nroCajaAhorro);
		this.setSaldoCajaAhorro(saldoCajaAhorro);
		this.setNroCtaCte(nroCtaCte);
		this.setSaldoCtaCte(saldoCtaCte);
	}
		
	public static Usuario[] inicializarUsuarios() {
		Usuario[] users = {
    			 new Usuario("Usuario1", "passwor1", "100", 500.00, "123", 850.00),
    			 new Usuario("Usuario2", "passwor2", "200", 700.00, "456", 470.00),
    			 new Usuario("Usuario3", "passwor3", "300", 900.00, "789", 788.50),
    			 new Usuario("Usuario4", "passwor4", "400", 1250.50, "444", 999.00)
    			};
    	return users;
    } 
	
	
	
	
}
