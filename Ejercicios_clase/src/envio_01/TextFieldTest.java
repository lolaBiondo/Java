package envio_01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldTest extends JFrame{
	
	private JTextField textField1, textField2, textField3;
	private JPasswordField passwordField;
	
	public static void main( String args[] ) {
		TextFieldTest application = new TextFieldTest();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public TextFieldTest()	{
		super( "Funcionamiento de la clase JTextField " );
		Container container = getContentPane();
		container.setLayout( new FlowLayout() );
		
		textField1 = new JTextField( 10 );
		container.add( textField1 );
		textField2 = new JTextField( "Entre un texto aquí" );
		container.add( textField2 );
		textField3 = new JTextField( "Texto visible, no editable", 20 );
		textField3.setEditable( false );
		container.add( textField3 );
		passwordField = new JPasswordField( "Texto no visible" );
		container.add( passwordField );
		TextFieldHandler handler = new TextFieldHandler();
		textField1.addActionListener( handler );
		textField2.addActionListener( handler );
		textField3.addActionListener( handler );
		passwordField.addActionListener( handler );
		setSize( 325, 200 );
		setVisible( true );
	}
	
	// Clase privada manejadora de eventos
	private class TextFieldHandler implements ActionListener {
		public void actionPerformed( ActionEvent event ){
			String string = "";
			// El usuario presiona Enter en JTextField en cada campo de texto
			if ( event.getSource() == textField1 )
				string = "Campo de texto 1: " + event.getActionCommand();
			else if ( event.getSource() == textField2 )
				string = "Campo de texto 2: " + event.getActionCommand();
			else if ( event.getSource() == textField3 )
				string = " Campo de texto 3: " + event.getActionCommand();
			else if ( event.getSource() == passwordField ) {
				string = "passwordField: " +
						new String( passwordField.getPassword() );}
			JOptionPane.showMessageDialog( null, string );
		} 
	}
}
