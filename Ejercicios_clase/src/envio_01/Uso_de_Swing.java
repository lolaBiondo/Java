package envio_01;

import java.util.*;

import javax.swing.*;
import java.text.DecimalFormat;
import java.awt.*;
import java.awt.event.*;

public class Uso_de_Swing {
	
	public static void main(String args[]) {
	
	//EJERCICIO 2
	/*int x = Integer.parseInt(JOptionPane.showInputDialog("Escriba el primer numero"));
	int y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
	JOptionPane.showMessageDialog(null, "El resultado es: "+(x+y));*/
	
	//EJERCICIO 3
	/*int num = Integer.parseInt(JOptionPane.showInputDialog("Escriba el numero"));
	if(num%2==0) 
		JOptionPane.showMessageDialog(null, "El numero ingresado, "+num+", es par");
		else 
			JOptionPane.showMessageDialog(null, "El numero ingresado, "+num+", es impar");*/
	
	//EJERCICIO 4
	/*int sum = 0;
	for (int i = 0; i < 10; i++) {
		
		sum = sum + (Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero")));
	}
	JOptionPane.showMessageDialog(null, "La suma de todos los numeros es: " +sum);*/
		
	//EJERCICIO 5
	/*int num = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero")));	
	boolean es_primo=true;	
	int cont = 2; //porque por 1 se dividen todos
	while ((es_primo) && (cont!=num)) {
		if(num % cont == 0) 
			es_primo = false;
		else cont++;
	}
	if (es_primo) 
		JOptionPane.showMessageDialog(null, "El numero "+num+" es primo");
	else 
		JOptionPane.showMessageDialog(null, "El numero "+num+" es compuesto");*/
		
	//EJERICCIO 6
		/*int num = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero")));	
		boolean es_primo=true;	
		int cont = 2; //porque por 1 se dividen todos
		
		while ((cont!=num) && (es_primo)) {
			if(num%cont == 0) 
				es_primo = false;
			else 
				cont++;			
		}
		
		if (es_primo) 
			JOptionPane.showMessageDialog(null, "El numero "+num+" es primo");
		else {
			JOptionPane.showMessageDialog(null, "El numero "+num+" es compuesto");
			for(int i = 1 ; i <=num ; i++){
		        if(num%i==0){
		            System.out.println(i);
		        }
		    }
		}*/
		
		
		//EJERCICIO 7
		/*int sum = 0;
		for (int i = 0; i < 30 ; i++) {
			sum = sum + (int)Math.pow(i, 2);
		}
		System.out.print("La suma de los cuadrados de los treinta primeros numeros naturales es: "+sum);*/
			
		//EJERCICIO 8
		/*int sum = 0;
		int num = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero")));
		for (int i = num+1; i < num+101; i++) 
			sum = sum + i;
		JOptionPane.showMessageDialog(null, "La suma de todos los siguientes 100 numeros a "+num+" es: " +sum);*/
		
		//EJERCICIO 9 Y 10
		/*ArrayList numeros = new ArrayList<>();
		boolean band = false;
		int num = 0;
		int acum = 0;
		int i = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de numeros que quiera: ")));
		for (int j = 0; j<i;j++) {
			while (band==false) {
				num = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese un numero par:")));
				if (num%2==0) band=true;
				else {
					band=false;
					JOptionPane.showMessageDialog(null, "El numero ingresado "+num+" no es par");
					}
			}
			band=false;
			numeros.add(num);
		}
		Collections.sort(numeros);
		System.out.println("EL menor numero ingresado es: "+numeros.get(0));
		System.out.println("EL mayor numero ingresado es: "+numeros.get(i-1));*/	
		
		//EJERCICIO 11
		/*DecimalFormat formateador = new DecimalFormat("###.##");
		boolean band = false;
		int temp = 0;
		while(band==false) {
				temp = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese una temperatura en °F (si quiere finalizar ingrese 999):")));
				if(temp!=999) {
					//int temp_c= 
					JOptionPane.showMessageDialog(null, "La temperatura ingresada, "+temp+"°F equivale a "+(formateador.format(0.5556*(temp-32)))+"°C");
					}
				else {
					band=true;
					JOptionPane.showMessageDialog(null, "Finalizado");
				}
				
		}*/
		
		//EJERCICIO 12
		
		/*JOptionPane.showMessageDialog(null, "El formato de la ecuación será el siguiente: Ax+By=C", "Ecuación de 1° grado", JOptionPane.INFORMATION_MESSAGE);
		int A = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese A")));
		int B = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese B")));
		int C = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese C")));
		System.out.println("Conjunto de coordenadas posibles");
		int cont=0;
		for (int x=0;x<=10;x++) {
			for (int y=-50;y<=50;y++) {
				int C_2=A*x+B*y;
				
				if(C_2==C) {
					cont++;
					if(cont<=10) {
					System.out.println("Coordenada "+cont+": "+x+", "+y);
					}
				}
			}
		}*/
		
		//EJERCICIO 13
		/*DecimalFormat formateador = new DecimalFormat("###.##");
		JOptionPane.showMessageDialog(null, "El formato de la ecuación será el siguiente: ax^2+bx+c=0", "Ecuación de 2° grado", JOptionPane.INFORMATION_MESSAGE);
		int a = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese a")));
		int b = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese b")));
		int c = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese c")));
		if (a==0 && b==0 && c==0) {JOptionPane.showMessageDialog(null, "x puede tomar cualquier valor");}
		else {
			if (a==0 && b==0 && c!=0){JOptionPane.showMessageDialog(null, "La ecuación no tiene solución");}
			else {
				double x1 = (-b + Math.sqrt((b*b)-(4*a*c)))/(2*a);

		        double x2 = (-b - Math.sqrt((b*b)-(4*a*c)))/(2*a);
		        JOptionPane.showMessageDialog(null, "Las raíces de la ecuación son: "+formateador.format(x1)+" y "+formateador.format(x2));
				
			}
		}
		pregunta clase: Al hacer la raíz cuadrada de un numero negativo, como no existe devuelve un valor especial
		como lo uso a ese valor para comparar en un if?

		Double.isNaN() 
		if (foo == Double.isNan()){} 
	
		*/
		
		
		//EJERCICIO 14
		/*JOptionPane.showMessageDialog(null, "Productos disponibles: \n 1-$5 \n 2-$6 \n 3-$7 \n 4-$8 \n 5-$9", "Bienvenido a su compra", JOptionPane.INFORMATION_MESSAGE);
		boolean band=false;
		int acum=0;
		int rta=0;
		while(band==false) {
			rta = (Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de un producto (si quiere finalizar ingrese 9):")));
			if(rta!=9) {
				switch(rta) {
				case 1: acum=acum+5;
						break;
				case 2: acum=acum+6;
				break;
				case 3: acum=acum+7;
				break;
				case 4: acum=acum+8;
				break;
				case 5: acum=acum+9;
				break;
				default: JOptionPane.showMessageDialog(null, "Producto no encontrado. Ingrese un número del 1-5 o 9 para finalizar");
				break;
				}			
			}
			else {
				if(rta==9) {
				band=true;
				JOptionPane.showMessageDialog(null, "Compra finalizada. Costo total: "+acum);
				}
			}
		}*/
		
		
		//EJERCICIO 15
		/*DecimalFormat formateador = new DecimalFormat("###.##");
		int n=(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de datos a cargar")));
		int cont_0=0;
		int cont_m=0;
		int cont_f=0;
		int cont_1=0;
		int cont_2=0;
		int cont_3=0;
		int cont_4=0;
		
		for (int i=0;i<n;i++) {	
			int rta_s = JOptionPane.showOptionDialog(null, "Seleccione el sexo", "Votante "+(i+1), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Masculino",  "Femenino"}, "Masculino");
			if(rta_s==0) cont_m++; else cont_f++;
			String rta_v = (JOptionPane.showInputDialog(null, "Seleccione la opción votada", "Votante: "+(i+1), JOptionPane.QUESTION_MESSAGE, null, 
					new Object[] {"Partido 1", "Partido 2",  "Partido 3", "Partido 4", "Voto en blanco"}, "Partido 1")).toString();

			switch(rta_v) {
			case "Partido 1": cont_1++; break;
			case "Partido 2": cont_2++; break;
			case "Partido 3": cont_3++; break;
			case "Partido 4": cont_4++; break;
			case "Voto en blanco": cont_0++; break;
			}
		}
		JOptionPane.showMessageDialog(null, "Cantidad de votantes masculinos: "+cont_m+"\n Cantidad de votantes femeninos: "+cont_f);
		JOptionPane.showMessageDialog(null, "Cantidad de votos totales: "+n+"\nPor partido: \n 1: 	"+cont_1+" - "+formateador.format((double)cont_1/n*100)+
																			"% \n 2: 	"+cont_2+" - "+formateador.format((double)cont_2/n*100)+
																			"% \n 3:	 "+cont_3+" - "+formateador.format((double)cont_3/n*100)+
																			"% \n 4: 	"+cont_4+" - "+formateador.format((double)cont_4/n*100)+
																			"% \n En blanco: "+cont_0+" - "+formateador.format((double)cont_0/n*100+"%"));*/
		
		
		JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelSuperior.setBackground(Color.cyan);
		panelSuperior.add(new JButton("Sup.1"));
		panelSuperior.add(new JButton("Sup.2"));
		panelSuperior.add(new JButton("Sup.3"));
		panelSuperior.add(new JButton("Sup.4"));
		
		JPanel panelInferior = new JPanel(new FlowLayout());
		panelInferior.setBackground(Color.yellow);
		panelInferior.add(new JLabel("Pon texto"));
		panelInferior.add(new JTextField(25));
		panelInferior.add(new JButton("Listo"));
		
		/*JFrame miVentana = new JFrame();
		miVentana.setTitle( "Mi Ventana 02" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		miVentana.setLayout(new FlowLayout() );
		miVentana.pack();
		miVentana.setVisible( true );
		miVentana.add(panelSuperior);
		miVentana.add(panelInferior);
		miVentana.setSize(1000, 1000);*/
		
		JPanel panelIzquierdo = new JPanel();
		panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
		panelIzquierdo.setBackground(Color.red);
		panelIzquierdo.add(new JButton("1"));
		panelIzquierdo.add(new JButton("2"));
		panelIzquierdo.add(new JButton("3"));
		
		JPanel panelDerecho = new JPanel();
		panelDerecho.setBackground(Color.green);
		panelDerecho.setLayout(new BoxLayout(panelDerecho, BoxLayout.Y_AXIS));
		panelDerecho.add(new JButton("A"));
		panelDerecho.add(new JButton("B"));
		panelDerecho.add(new JButton("C"));
		panelDerecho.add(new JButton("D"));
		
		// Creamos el componente central, un JTextArea con scroll.
		JScrollPane scroll=new JScrollPane(new JTextArea());
		JFrame v = new JFrame();
		// Añadimos todos los componentes
		v.getContentPane().setLayout(new BorderLayout());
		v.getContentPane().add(scroll,BorderLayout.CENTER);
		v.getContentPane().add(panelSuperior,BorderLayout.NORTH);
		v.getContentPane().add(panelInferior,BorderLayout.SOUTH);
		v.getContentPane().add(panelIzquierdo,BorderLayout.WEST);
		v.getContentPane().add(panelDerecho,BorderLayout.EAST);
		v.setSize(1000, 600); 
		v.setVisible(true);
		
	
	}
}
