package envio_01;
import java.awt.*;
import javax.swing.*;

public class Ventana03 extends JFrame{
	
	public Ventana03( String titulo )
	{
	setTitle( titulo );
	inicializarComponentes();
	mostrarVentana();
	} //fin del constructor Ventana03
	public void inicializarComponentes() {
	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
	JButton btnUno = new JButton( "Uno" );
	JButton btnDos = new JButton( "Dos" );
	setLayout( new FlowLayout() );
	add( btnUno );
	add( btnDos );
	} //fin del método inicializarComponentes
	public void mostrarVentana()
	{
	setSize( 300, 200 );
	setVisible( true );
	} //fin del método mostrarVentana

}
