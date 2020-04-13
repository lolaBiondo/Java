package envio_01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ComboBoxTest extends JFrame {
	private JComboBox imagesComboBox;
	private JLabel label;
	private String names[] ={ "bug1.gif", "bug2.gif", "travelbug.gif", "buganim.gif" };
	private Icon icons[] = { new ImageIcon( names[ 0 ] ), new ImageIcon( names[ 1 ] ), new ImageIcon( names[ 2 ] ), new ImageIcon( names[ 3 ] ) };
	public static void main( String args[] )
	{
		ComboBoxTest application = new ComboBoxTest();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	// Configurar GUI
	public ComboBoxTest()
	{
		super( "JComboBox" );
		Container container = getContentPane();
		container.setLayout( new FlowLayout() );
		
		imagesComboBox = new JComboBox( names );
		imagesComboBox.setMaximumRowCount( 3 );
		imagesComboBox.addItemListener(
		new ItemListener() {
		
			public void itemStateChanged( ItemEvent event )
			{
				if ( event.getStateChange() == ItemEvent.SELECTED )
					label.setIcon( icons[imagesComboBox.getSelectedIndex() ] );
			}
		});
		container.add( imagesComboBox );
		label = new JLabel( icons[ 0 ] );
		container.add( label );
		setSize( 350, 100 );
		setVisible( true );
	}
}
