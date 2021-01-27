package entities;

import java.util.ArrayList;

public class Proveedor {
	private String razonSocial;
	private String CUIT;
	private String telefono;
	private String mail;
	private String direccion;
	private ArrayList<Libro> librosP;
	
	public ArrayList<Libro> getLibrosP() {
		return librosP;
	}
	public void setLibrosP(ArrayList<Libro> librosP) {
		this.librosP = librosP;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCUIT() {
		return CUIT;
	}
	public void setCUIT(String cUIT) {
		CUIT = cUIT;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	} 
	@Override
	public String toString() {
		return "Proveedor [CUIT=" + CUIT + ", Razon Social=" + razonSocial + ", E-Mail=" + mail + ", Dirección" + direccion+ ", Teléfono=" + telefono+ "]";
	}
}
