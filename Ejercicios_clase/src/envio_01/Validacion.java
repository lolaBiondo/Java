package envio_01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Validacion extends JFrame {
	//declaración de variables
	private JTextField telefonoCampoTexto, codigoPostalCampoTexto, estadoCampoTexto,
	ciudadCampoTexto, direccionCampoTexto, nombreCampoTexto, apellidoCampoTexto;
	
	public static void main (String args[]) {
		
		Validacion aplicacion = new Validacion();
		aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra frame
	}
	
	
	//CONSTRUCTOR VALIDACION
	public Validacion() {
		super("Validacion");
		//componentes de GUI
		//creo labels
		JLabel telefonoEtiqueta = new JLabel( "Teléfono" );
		JLabel codigoPostalEtiqueta = new JLabel( "C.P." );
		JLabel estadoEtiqueta = new JLabel( "Estado" );
		JLabel ciudadEtiqueta = new JLabel( "Ciudad" );
		JLabel direccionEtiqueta = new JLabel( "Dirección" );
		JLabel nombreEtiqueta = new JLabel( "Primer nombre" );
		JLabel apellidoEtiqueta = new JLabel( "Apellido paterno" );
		//creo boton
		JButton aceptarBoton = new JButton( "Aceptar" );
		aceptarBoton.addActionListener(		
				new ActionListener() {
					public void actionPerformed(ActionEvent evento) {
						validarTodo();	}}	);
		//creo textfields (sin poner adelante JTextField
		telefonoCampoTexto = new JTextField( 15 );
		codigoPostalCampoTexto = new JTextField( 5 );
		estadoCampoTexto = new JTextField( 2 );
		ciudadCampoTexto = new JTextField( 12 );
		direccionCampoTexto = new JTextField( 20 );
		nombreCampoTexto = new JTextField( 20 );
		apellidoCampoTexto = new JTextField( 20 );		
		//creo paneles de datos y agrego labels y textfields y boton
		JPanel primerNombre = new JPanel();
		primerNombre.add( nombreEtiqueta );
		primerNombre.add( nombreCampoTexto );
		JPanel apellidoPaterno = new JPanel();
		apellidoPaterno.add( apellidoEtiqueta );
		apellidoPaterno.add( apellidoCampoTexto );
		JPanel direccion1 = new JPanel();
		direccion1.add( direccionEtiqueta );
		direccion1.add( direccionCampoTexto );
		JPanel direccion2 = new JPanel();
		direccion2.add( ciudadEtiqueta );
		direccion2.add( ciudadCampoTexto );
		direccion2.add( estadoEtiqueta );
		direccion2.add( estadoCampoTexto );
		direccion2.add( codigoPostalEtiqueta );
		direccion2.add( codigoPostalCampoTexto );
		JPanel telefono = new JPanel();
		telefono.add( telefonoEtiqueta );
		telefono.add( telefonoCampoTexto );
		JPanel aceptar = new JPanel();
		aceptar.add( aceptarBoton );
	
		//agrego componentes de gui a aplicacion
		Container contenedor = getContentPane();
		contenedor.setLayout(new GridLayout(6,1));
		contenedor.add( primerNombre );
		contenedor.add( apellidoPaterno );
		contenedor.add( direccion1 );
		contenedor.add( direccion2 );
		contenedor.add( telefono );
		contenedor.add( aceptar );
		
		//caracteristicas del frame
		setSize(400,225);
		setVisible(true);	
	}
	
	
	private void validarTodo() {
		if ( apellidoCampoTexto.getText().equals( "" ) ||
				nombreCampoTexto.getText().equals( "" ) ||
				direccionCampoTexto.getText().equals( "" ) ||
				ciudadCampoTexto.getText().equals( "" ) ||
				estadoCampoTexto.getText().equals( "" ) ||
				codigoPostalCampoTexto.getText().equals( "" ) ||
				telefonoCampoTexto.getText().equals( "" ) )
			JOptionPane.showMessageDialog( this, "Por favor llene todos los campos" );
		else if ( !nombreCampoTexto.getText().matches( "[A-Z][a-zA-Z]*" ) )
		JOptionPane.showMessageDialog( this, "Primer nombre inválido" );
		else if ( !apellidoCampoTexto.getText().matches( "[A-Z][a-zA-Z]*" ) )
		JOptionPane.showMessageDialog( this, "Apellido inválido" );
		else if ( !direccionCampoTexto.getText().matches(
		"([a-zA-Z]+\\s+\\d+|[a-zA-Z]+\\s[a-zA-Z]+\\s+\\d+)" ) )
		JOptionPane.showMessageDialog( this, "Dirección inválida" );
		else if ( !ciudadCampoTexto.getText().matches(
		"([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" ) )
		JOptionPane.showMessageDialog( this, "Ciudad inválida" );
		else if ( !estadoCampoTexto.getText().matches(
		"([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" ) )
		JOptionPane.showMessageDialog( this, "Estado inválido" );
		else if ( !codigoPostalCampoTexto.getText().matches( "\\d{4}" ) )
		JOptionPane.showMessageDialog( this, "Código postal inválido" );
		else if ( !telefonoCampoTexto.getText().matches(
		"[0-9]{9}" ) )
		JOptionPane.showMessageDialog( this, "Número telefónico inválido" );
		else {JOptionPane.showMessageDialog(this, "Gracias");}
	}
}
