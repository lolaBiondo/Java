package envio_01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class CheckBoxTest extends JFrame {
	private JTextField field;
	private JCheckBox bold, italic;
	public static void main( String args[] )
	{
	CheckBoxTest application = new CheckBoxTest();
	application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public CheckBoxTest()
	{
		super( " Uso de JCheckBox" );
		Container container = getContentPane();
		container.setLayout( new FlowLayout() );
		field = new JTextField( "Mirame como cambio", 20 );
		field.setFont( new Font( "Serif", Font.PLAIN, 14 ) ); //fuente original
		container.add( field );
		bold = new JCheckBox( "Negrita" );
		container.add( bold );
		italic = new JCheckBox( "Cursiva" );
		container.add( italic );
		
		CheckBoxHandler handler = new CheckBoxHandler();
		bold.addItemListener( handler );
		italic.addItemListener( handler );
		setSize( 275, 100 );
		setVisible( true );
		}
	
	private class CheckBoxHandler implements ItemListener {
		private int valBold = Font.PLAIN;
		private int valItalic = Font.PLAIN;
		
		public void itemStateChanged( ItemEvent event )
		{
			if ( event.getSource() == bold )
				valBold = bold.isSelected() ? Font.BOLD : Font.PLAIN;
			if ( event.getSource() == italic )
				valItalic = italic.isSelected() ? Font.ITALIC : Font.PLAIN;
			
			field.setFont( new Font( "Serif", valBold + valItalic, 14 ) );
		}
	}
}