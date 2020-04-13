package envio_01;

import javax.swing.JOptionPane;
import java.awt.Component;
import javax.swing.JDialog;


public class Ejercicio_basico_00 {

	public static void main(String args[]) {
		
		//System.out.println("\n ESTO ES JAVA");
		
		
		//Solicitar Datos (JOptionPane.showInputDialog)
		
		/*String nombre;
		nombre=JOptionPane.showInputDialog(null, "Ingrese su nombre", JOptionPane.QUESTION_MESSAGE);
		System.out.println("El usuario ha escrito "+nombre);*/
		
		// Con JCombobox
		/*Object seleccion = JOptionPane.showInputDialog(
		 null,
		 "Seleccione opción",
		 "Selector de opciones",
		 JOptionPane.QUESTION_MESSAGE,
		 null, // null para icono defecto
		 new Object[] { "opcion 1", "opcion 2", "opcion 3" },
		 "opcion 1");
		System.out.println("El usuario ha elegido "+seleccion);*/
		
		
		
		
		
		//Mostrar Mensaje (JOptionPane.showMessageDialog)
		
		/*JOptionPane.showMessageDialog(null, "Hola "+nombre+". Bienvenido/a!!");*/
		
		//JOptionPane.showMessageDialog(null, "El cielo es azul", "Dialogo sencillo", JOptionPane.YES_NO_CANCEL_OPTION);
		
		
		/* int seleccion=JOptionPane.showOptionDialog(
				 null,
				 "Seleccione opcion",
				 "Selector de opciones",
				 JOptionPane.YES_NO_CANCEL_OPTION,
				 JOptionPane.QUESTION_MESSAGE,
				 null, // null para icono por defecto.
				 new Object[] { "opcion 1", "opcion 2", "opcion 3", "Cancelar" }, // null para YES, NO y CANCEL
				 "Cancelar");
		 if (seleccion != -1) //-1 se guarda cuando se presiona la cruz
			 System.out.println("seleccionada opcion " + (seleccion + 1)); // el arreglo comienza desde 0 */
		
		
		//JOptionPane.showConfirmDialog()
		
		/*int confirmado = JOptionPane.showConfirmDialog(
				 null,
				 "¿Lo confirmas?");
				if (JOptionPane.OK_OPTION == confirmado)
				 System.out.println("confirmado");
				else
				 System.out.println("vale... no borro nada...");*/
		

		
	
		
		
	}
}
