package clases;

import javax.swing.*;

public class Main {
	
	static Usuario[] usuarios;
	
			
	public static void main(String[] args) {
		
			usuarios = Usuario.inicializarUsuarios();
			formulario_base formulario=new formulario_base();
	        formulario.setBounds(0,0,600,600);
	        formulario.setTitle("Bienvenido al Banco Banca Comercial S.A.");
	        formulario.setVisible(true);
	        formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        formulario.setUsuarios(usuarios);
		
		
		
	}
}


