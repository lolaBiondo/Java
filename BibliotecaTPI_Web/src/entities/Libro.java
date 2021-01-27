
package entities;
//import java.sql.Blob; esta por la imagen 
import java.util.*;
public class Libro {
private String titulo;
private  int idLibro ;
private int isbn;
private Date fechaEdicion; 
private int nroEdicion;
private int cantDiasMaxPrestamo;
private String genero;
private String CUIT;
private ArrayList<Ejemplar> ejemplaresL;
//private Blog imagen; ver esto

public String getCUIT() {
	return CUIT;
}
public void setCUIT(String cUIT) {
	CUIT = cUIT;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public int getIdLibro() {
	return idLibro;
}
public void setIdLibro(int idLibro) {
	this.idLibro = idLibro;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public Date getFechaEdicion() {
	return fechaEdicion;
}
public void setFechaEdicion(Date date) {
	this.fechaEdicion = date;
}
public int getNroEdicion() {
	return nroEdicion;
}
public void setNroEdicion(int nroEdicion) {
	this.nroEdicion = nroEdicion;
}
public int getCantDiasMaxPrestamo() {
	return cantDiasMaxPrestamo;
}
public void setCantDiasMaxPrestamo(int cantDiasMaxPrestamo) {
	this.cantDiasMaxPrestamo = cantDiasMaxPrestamo;
}
public String getGenero() {
	return genero;
}
public void setGenero(String genero) {
	this.genero = genero;
}

@Override
public String toString() {
	return "Libro [Id Libro=" + idLibro + ", Isbn=" + isbn + ", T�tulo=" + titulo + ", Fecha Edici�n=" + fechaEdicion + ", N� Edici�n" + nroEdicion
			+ ", Cant. de d�as m�x. de pr�stamo=" + cantDiasMaxPrestamo+
			", G�nero=" + genero+"]";
}

}
