package envio_01;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
public class ListTest extends JFrame {
	private JList colorList;
	private Container container;
	private final String colorNames[] = { "Negro", "Azul", "Celeste",
	"Gris Oscuro", "Gris", "Verde", "Gris Claro", "Violeta",
	"Naranja", "Rosa", "Rojo", "Blanco", "Amarillo" };
	private final Color colors[] = { Color.BLACK, Color.BLUE, Color.CYAN,
	Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
	Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE,
	Color.YELLOW };
	public static void main( String args[] )
	{
		ListTest application = new ListTest();
		application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	public ListTest()
	{
		super( "Lista de texto" );
		container = getContentPane();
		container.setLayout( new FlowLayout() );
		colorList = new JList( colorNames );
		colorList.setVisibleRowCount( 5 );
		colorList.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		// Adicionar un JScrollPane conteniendo JList
		container.add( new JScrollPane( colorList ) );
		colorList.addListSelectionListener(
		new ListSelectionListener() {
		// igual q para el ej 48
			public void valueChanged( ListSelectionEvent event )
			{
				container.setBackground(
				colors[ colorList.getSelectedIndex() ] );
			}
		});
		setSize( 350, 150 );
		setVisible( true );
	}
}