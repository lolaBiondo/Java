package entities;
import java.util.*;

//import java.sql.Date;

public class PoliticaPrestamo {
	private int idPoliticaPrestamo;
	private Date fechaAlta;
	private int cantMaximaSocio;
	private int cantMaximaNoSocio;
	
	
	public int getIdPoliticaPrestamo() {
		return idPoliticaPrestamo;
	}
	public void setIdPoliticaPrestamo(int idPoliticaPrestamo) {
		this.idPoliticaPrestamo = idPoliticaPrestamo;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date date) {
		this.fechaAlta = date;
	}
	public int getCantMaximaSocio() {
		return cantMaximaSocio;
	}
	public void setCantMaximaSocio(int cantMaximaSocio) {
		this.cantMaximaSocio = cantMaximaSocio;
	}
	public int getCantMaximaNoSocio() {
		return cantMaximaNoSocio;
	}
	public void setCantMaximaNoSocio(int cantMaximaNoSocio) {
		this.cantMaximaNoSocio = cantMaximaNoSocio;
	}
	public String toString() {
		return "\nPolitica [id=" + idPoliticaPrestamo + ", Cantidad maxima por socio:" + cantMaximaSocio + ", Cantidad maxima no socio: "+
				cantMaximaNoSocio+", Fecha alta:"+fechaAlta+"]";
	}
}
