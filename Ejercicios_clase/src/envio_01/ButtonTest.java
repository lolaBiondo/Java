package envio_01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ButtonTest extends JFrame {
	private JButton plainButton, fancyButton;
	public static void main( String args[] )
	{
		ButtonTest application = new ButtonTest();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	public ButtonTest()
	{
		super( "Testeo de botones" );
		Container container = getContentPane();
		container.setLayout( new FlowLayout() );
		plainButton = new JButton( "Botón Plano" );
		container.add( plainButton );
		Icon bug1 = new ImageIcon( "descarga.png" );
		Icon bug2 = new ImageIcon( "descarga.png" );
		fancyButton = new JButton( "Botón con Imagen", bug1 );
		fancyButton.setRolloverIcon( bug2 );
		container.add( fancyButton );
		
		ButtonHandler handler = new ButtonHandler();
		fancyButton.addActionListener( handler );
		plainButton.addActionListener( handler );
		setSize( 275, 100 );
		setVisible( true );
	}
	private class ButtonHandler implements ActionListener {
		public void actionPerformed( ActionEvent event )
		{
			JOptionPane.showMessageDialog( ButtonTest.this,
			"Usted presionó: " + event.getActionCommand() );
		}
	}
}

