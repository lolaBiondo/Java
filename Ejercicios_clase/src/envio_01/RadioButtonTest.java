package envio_01;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class RadioButtonTest extends JFrame {
	private JTextField field;
	private Font plainFont, boldFont, italicFont, boldItalicFont;
	private JRadioButton plainButton, boldButton, italicButton, boldItalicButton;
	private ButtonGroup radioGroup;
	public static void main( String args[] )
	{
		RadioButtonTest application = new RadioButtonTest();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public RadioButtonTest()
	{
		super( "RadioButton" );
		Container container = getContentPane();
		container.setLayout( new FlowLayout() );
		field = new JTextField( "Mirá como cambia el estilo", 25 );
		container.add( field );
		//botones
		plainButton = new JRadioButton( "Normal", true );
		container.add( plainButton );
		boldButton = new JRadioButton( "Negrita", false );
		container.add( boldButton );
		italicButton = new JRadioButton( "Cursiva", false );
		container.add( italicButton );
		boldItalicButton = new JRadioButton( "Negrita/Cursiva", false );
		container.add( boldItalicButton );
		
		radioGroup = new ButtonGroup();
		radioGroup.add( plainButton );
		radioGroup.add( boldButton );
		radioGroup.add( italicButton );
		radioGroup.add( boldItalicButton );
		
		// Crear objetos de fuentes
		plainFont = new Font( "Serif", Font.PLAIN, 14 );
		boldFont = new Font( "Serif", Font.BOLD, 14 );
		italicFont = new Font( "Serif", Font.ITALIC, 14 );
		boldItalicFont = new Font( "Serif", Font.BOLD + Font.ITALIC, 14 );
		field.setFont( plainFont ); 
		
		plainButton.addItemListener( new RadioButtonHandler( plainFont ) );
		boldButton.addItemListener( new RadioButtonHandler( boldFont ) );
		italicButton.addItemListener( new RadioButtonHandler( italicFont ) );
		boldItalicButton.addItemListener( new RadioButtonHandler( boldItalicFont ) );
		setSize( 300, 200 );
		setVisible( true );
	}
		private class RadioButtonHandler implements ItemListener {
			private Font font;
			public RadioButtonHandler( Font f )
			{
				font = f;
			}
		// Evento Botón
			public void itemStateChanged( ItemEvent event )
			{
				field.setFont( font );
			}
		}
}