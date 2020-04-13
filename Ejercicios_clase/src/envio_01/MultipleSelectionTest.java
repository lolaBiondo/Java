package envio_01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MultipleSelectionTest extends JFrame {
	private JList colorList, copyList;
	private JButton copyButton;
	private final String colorNames[] = { "Negro", "Azul", "Celeste",
	"Gris Oscuro", "Gris", "Verde", "Gris Claro", "Violeta",
	"Naranja", "Rosa", "Rojo", "Blanco", "Amarillo" };
	public static void main( String args[] )
	{
		MultipleSelectionTest application = new MultipleSelectionTest();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	
	public MultipleSelectionTest()
	{
		super( "Lista de selección múltiple" );
		Container container = getContentPane();
		container.setLayout( new FlowLayout() );
	
		colorList = new JList( colorNames );
		colorList.setVisibleRowCount( 5 );
		colorList.setSelectionMode(
		ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
		container.add( new JScrollPane( colorList ) );
		// boton p copiar de una lista a la otra
		copyButton = new JButton( "Copiar >>>" );
		copyButton.addActionListener(
		new ActionListener() { 
			public void actionPerformed( ActionEvent event )
			{
				copyList.setListData( colorList.getSelectedValues() );
			}
		});
		container.add( copyButton );
		copyList = new JList( );
		copyList.setVisibleRowCount( 5 );
		copyList.setFixedCellWidth( 100 );
		copyList.setFixedCellHeight( 15 );
		copyList.setSelectionMode(
		ListSelectionModel.SINGLE_INTERVAL_SELECTION );
		container.add( new JScrollPane( copyList ) );
		setSize( 300, 130 );
		setVisible( true );
	}
}