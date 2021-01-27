package entities;

public class Ejemplar {
	private int idEjemplar;
	private int idLibro;
	private boolean estado;  
	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getIdEjemplar() {
		return idEjemplar;
	}

	public void setIdEjemplar(int idEjemplar) {
		this.idEjemplar = idEjemplar;
	}
	
	
	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	
	
	
	@Override
	public String toString() {
		return "Ejemplar [Id Ejemplar=" + idEjemplar + ", Id Libro=" + idLibro  + ", estado="+ estado +"]";
	}
}
