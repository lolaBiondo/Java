package clases;

import javax.swing.*;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

//FALTA:PONER EN UN WHILE PARA PODER INICIAR SESION DEVUELTA

public class formulario_base extends JFrame implements ActionListener{

	private JButton boton1,boton2,boton3, cerrarSesion;
    private JLabel usutx, passtx;
    private JTextField usu;
    private JPasswordField pass;
    private Usuario[] usersAux;
    private JRadioButton ctaCte, cajaAhorro, saldo, transferencia, extraccion, deposito;
	private ButtonGroup radioGroupCtas, radioGroupOp;
    private int cont=0;
    private Usuario userActual;
    private boolean ingresado;
	
	public formulario_base() {
        setLayout(null);
        usutx = new JLabel("Usuario");
        usutx.setBounds(5,1,100,100);
        add(usutx);
        passtx = new JLabel("Clave");
        passtx.setBounds(5,1,200,200);
        add(passtx);
        
        usu = new JTextField(10);
        usu.setBounds(100,40,100,30);
        add(usu);
        pass = new JPasswordField(10);
        pass.setBounds(100,80,100,30);
        add(pass);
        
        boton1=new JButton("Aceptar");
        boton1.setBounds(10,150,90,30);
        add(boton1);
        boton1.addActionListener(this);
        boton2=new JButton("Borrar");
        boton2.setBounds(110,150,90,30);
        add(boton2);
        boton2.addActionListener(this);
        boton3=new JButton("Salir");
        boton3.setBounds(210,150,90,30);
        add(boton3);
        boton3.addActionListener(this);        	
    }
    
    public void actionPerformed(ActionEvent e) {
    	boolean band;
   try { 	
        if (e.getSource()==boton1) {
        	band=validarDatos();
        	if(band==false) cont++;
        	
        	if(band==true && cont<3) {
        		ingresado=validarUsuario();
        		if(ingresado==false) cont++;
        		else {
        			activaOperaciones();
        			userActual = buscarUsuario();
        		}
        	}
        	
        	if(cont>=3) {
        		desactivaIngreso();
				JOptionPane.showMessageDialog(this, "Privilegios suspendidos");
        	}
        }
        if (e.getSource()==boton2) {
            usu.setText("");
            pass.setText("");
        }
        if (e.getSource()==boton3) {
            System.exit(0);
        }
        if(e.getSource()==cerrarSesion) { 
        	activaIngreso();
        	desactivaOperaciones();
        }  
        if(ingresado==true) {
	        if(ctaCte.isSelected()==true) {
	        	int tipoCuenta=1;
	        	if(saldo.isSelected()==true) {
	        		JOptionPane.showMessageDialog(null, "Su saldo es: "+userActual.getSaldoCtaCte());
	        		limpiarBotones();
	        	}
	        	if(transferencia.isSelected()==true) {
	        		transferencia(tipoCuenta);
	        		limpiarBotones();
	        	}
	        	if(extraccion.isSelected()==true) {
	        		extraccion(tipoCuenta);
	        		limpiarBotones();
	        	}
	        	if(deposito.isSelected()==true) {
	        		deposito(tipoCuenta);
	        		limpiarBotones();
	        	}
	        }
	        if(cajaAhorro.isSelected()==true) {
	        	int tipoCuenta=2;
	        	if(saldo.isSelected()==true) {
	        		JOptionPane.showMessageDialog(null, "Su saldo es: "+userActual.getSaldoCajaAhorro());
	        		limpiarBotones();
	        	}
	        	if(transferencia.isSelected()==true) {
	        		transferencia(tipoCuenta);
	        		limpiarBotones();
	        	}
	        	if(extraccion.isSelected()==true) {
	        		extraccion(tipoCuenta);
	        		limpiarBotones();
	        	}
	        	if(deposito.isSelected()==true) {
	        		deposito(tipoCuenta);
	        		limpiarBotones();
	        	}
	        }
	    }
   }
   catch(NullPointerException nullPointerException) {}
   catch(NumberFormatException numberFormatException) {
	   JOptionPane.showMessageDialog(null, "Número ingresado inválido. Vuelva a realizar la operación.", "Número Inválido", JOptionPane.WARNING_MESSAGE);
   }
    }

	
	private void extraccion(int tipoCuenta) {
		boolean saldoDisp = false;
		double monto=Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el monto que desea extraer: ", "Extracción", JOptionPane.QUESTION_MESSAGE));
		if(tipoCuenta==1) {
			saldoDisp = verificarMonto(monto, userActual.getSaldoCtaCte());
			if(saldoDisp) {
				userActual.setSaldoCtaCte(userActual.getSaldoCtaCte()-monto);
				JOptionPane.showMessageDialog(null, "Su extracción ha sido realizado con éxito. Su nuevo saldo es $"+userActual.getSaldoCtaCte(), "Extracción en Cuenta Corriente", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "No tiene suficiente saldo en su Cuenta Corriente para realizar la extracción", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else {
			saldoDisp = verificarMonto(monto, userActual.getSaldoCtaCte());
			if(saldoDisp) {
				userActual.setSaldoCajaAhorro(userActual.getSaldoCajaAhorro()-monto);
				JOptionPane.showMessageDialog(null, "Su extracción ha sido realizado con éxito. Su nuevo saldo es $"+userActual.getSaldoCajaAhorro(), "Extracción en Caja de Ahorro", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "No tiene suficiente saldo en su Caja de Ahorro para realizar la extracción", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}

	private void deposito(int tipoCuenta) {
		double monto=Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el monto que desea depositar: ", "Deposito",  JOptionPane.QUESTION_MESSAGE));
		if(tipoCuenta==1) {
			
			userActual.setSaldoCtaCte(userActual.getSaldoCtaCte()+monto);
			JOptionPane.showMessageDialog(null, "Su depósito ha sido realizado con éxito. Su nuevo saldo es $"+userActual.getSaldoCtaCte(), "Depósito en Cuenta Corriente",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			userActual.setSaldoCajaAhorro(userActual.getSaldoCajaAhorro()+monto);
			JOptionPane.showMessageDialog(null, "Su depósito ha sido realizado con éxito. Su nuevo saldo es $"+userActual.getSaldoCajaAhorro(), "Depósito en Caja de Ahorro", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	public void transferencia(int tipoCuenta) {
		int ctaATransferir;
		boolean saldoDisp = false;
		double monto=0;
		Usuario user=null;
			String usuario=JOptionPane.showInputDialog(null, "Ingrese el usuario al que desea transferir dinero: "); 
			
			//verifico que exista el usuario
			for(int i=0 ; i<usersAux.length ; i++) {
				if (usuario.equals(usersAux[i].getUsuario())) {user=usersAux[i];}
			}
			if(user==null) {
				JOptionPane.showMessageDialog(null, "Usuario Incorrecto. Vuelva a realizar la operación.");
				
			}
			
			else {
				ctaATransferir=JOptionPane.showOptionDialog(null, "Ingrese a qué cuenta quiere transferir:", "Transferencia a "+user.getUsuario(), 						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Caja de Ahorro", "Cuenta Corriente"},  "Caja de Ahorro");
				monto=Float.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el monto que desea transferir: ", "Transferencia a "+user.getUsuario(),  JOptionPane.QUESTION_MESSAGE));
				
				//desde cta cte
				if(tipoCuenta==1) {
					saldoDisp = verificarMonto(monto, userActual.getSaldoCtaCte());
					if(saldoDisp) {
						userActual.setSaldoCtaCte(userActual.getSaldoCtaCte()-monto);
						if(ctaATransferir==1) {	user.setSaldoCtaCte(user.getSaldoCtaCte()+monto);}
						else { 	user.setSaldoCajaAhorro(user.getSaldoCajaAhorro()+monto);}
						JOptionPane.showMessageDialog(null, "Su transferencia ha sido realizada con éxito.", "Transferencia desde Cuenta Corriente", 														JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "No tiene suficiente saldo para realizar la transferencia", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
				//desde caja ahorro
				if(tipoCuenta==2) {
					saldoDisp = verificarMonto(monto, userActual.getSaldoCajaAhorro());
					if(saldoDisp) {
						userActual.setSaldoCajaAhorro(userActual.getSaldoCajaAhorro()-monto);
						if(ctaATransferir==1) {	user.setSaldoCtaCte(user.getSaldoCtaCte()+monto);}
						else { 	user.setSaldoCajaAhorro(user.getSaldoCajaAhorro()+monto);}
						JOptionPane.showMessageDialog(null, "Su transferencia ha sido realizada con éxito.", "Transferencia desde Caja de Ahorro", 														JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "No tiene suficiente saldo para realizar la transferencia", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				
			}
	}


	private boolean verificarMonto(double monto, double saldoActual) {
		if (saldoActual>monto) {return true;}
		else {return false;}
		
	}

	public void activaOperaciones() {
    	menuOperaciones();
    	setVisible(true);
        
	}
	
	public void desactivaOperaciones() {
    	ctaCte.setVisible(false);
    	cajaAhorro.setVisible(false);
    	saldo.setVisible(false);
    	transferencia.setVisible(false);
    	deposito.setVisible(false);
    	extraccion.setVisible(false);
    	cerrarSesion.setVisible(false);
	}
	
	public void menuOperaciones() {
			
			Container cuentas = getContentPane();
			cuentas.setLayout( new FlowLayout() );
			//botones
			ctaCte = new JRadioButton( "Cuenta Corriente", false );
			//ctaCte.setBounds(2, 10, 100, 100);
			cuentas.add( ctaCte );
			cajaAhorro = new JRadioButton( "Caja de Ahorro", false );
			//cajaAhorro.setBounds(2, 20, 100, 100);
			cuentas.add( cajaAhorro );
			
			
			Container operaciones = getContentPane();
			operaciones.setLayout( new FlowLayout() );
			saldo = new JRadioButton ( "Saldo", false);
			operaciones.add(saldo);
			transferencia = new JRadioButton("Transferencia", false);
			operaciones.add(transferencia);
			extraccion = new JRadioButton("Extraccion", false);
			operaciones.add(extraccion);
			deposito = new JRadioButton("Deposito", false);
			operaciones.add(deposito);
			
			radioGroupCtas = new ButtonGroup();
			radioGroupCtas.add( ctaCte );
			radioGroupCtas.add( cajaAhorro );
			
			radioGroupOp = new ButtonGroup ();
			radioGroupOp.add(saldo);
			radioGroupOp.add(transferencia);
			radioGroupOp.add(deposito);
			radioGroupOp.add(extraccion);
			
			
			ctaCte.addActionListener(this);
			cajaAhorro.addActionListener( this );
			saldo.addActionListener(this);
			transferencia.addActionListener(this);
			extraccion.addActionListener(this);
			deposito.addActionListener(this);
			
			cerrarSesion=new JButton("Cerrar Sesión");
	        add(cerrarSesion);
	        cerrarSesion.addActionListener(this);
	        /*JPanel radioPanel = new JPanel();
	        radioPanel.add(ctaCte);
	        radioPanel.add(cajaAhorro);
	        radioPanel.add(saldo);
	        radioPanel.add(extraccion);
	        radioPanel.add(deposito);
	        radioPanel.add(transferencia);
	        radioPanel.add(cerrarSesion);
	        radioPanel.setLayout(new GridLayout(6, 1));
	        setContentPane(radioPanel);  // Button panel is only content.
	        pack(); */       
	        
	}
		
	private boolean validarUsuario() {
    	char[] password = pass.getPassword();
		String usuario = usu.getText();
		boolean ingresado=false;
		for(int i=0 ; i<usersAux.length ; i++) {
			if ((String.valueOf(password).equals(usersAux[i].getClave())) && usuario.equals(usersAux[i].getUsuario()))
			{
				desactivaIngreso();
				setTitle("Bienvenido "+usuario);
				JOptionPane.showMessageDialog(this, "Bienvenido");
				ingresado=true;
			}
		}
		if(ingresado==false){
		   		JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta");
		   		usu.setText("");
		        pass.setText("");
		}
		return ingresado;
    }

	public void desactivaIngreso()
    {
    	usu.setVisible(false);
    	usutx.setVisible(false);
    	pass.setVisible(false);
    	passtx.setVisible(false);
    	boton1.setVisible(false);
    	boton2.setVisible(false);
    	boton3.setVisible(false);	
    }
	
	public void activaIngreso()
    {
		setLayout(null);
		usutx.setBounds(5,1,100,100);
		passtx.setBounds(5,1,200,200); 
        usu.setBounds(100,40,100,30);
        pass.setBounds(100,80,100,30);
        boton1.setBounds(10,150,90,30);
        boton2.setBounds(110,150,90,30);
        boton3.setBounds(210,150,90,30);
        
		usu.setText("");
    	usu.setVisible(true);
    	usutx.setVisible(true);
    	pass.setText("");
    	pass.setVisible(true);
    	passtx.setVisible(true);
    	boton1.setVisible(true);
    	boton2.setVisible(true);
    	boton3.setVisible(true);	
    }
	
    private boolean validarDatos() {
    	boolean band=false;
		if (usu.getText().equals("") ||
				String.valueOf(pass.getPassword()).equals( "" ) )
			JOptionPane.showMessageDialog( this, "Por favor llene todos los campos" );
		
		else if ( !usu.getText().matches( "[A-Z][a-zA-Z0-9]{7,20}" ) ) 
		JOptionPane.showMessageDialog( this, "Usuario inválido" );
		else if ( ! (String.valueOf(pass.getPassword())).matches( "[a-zA-Z0-9]{8}" ) ) 
				JOptionPane.showMessageDialog( this, "Clave inválida" );
		else band=true;
		return band;
	}

	public void setUsuarios(Usuario[] usuarios) {
		usersAux=usuarios;
	}
    
	public void limpiarBotones() {
		radioGroupCtas.clearSelection();
		radioGroupOp.clearSelection();
	}

	
	private Usuario buscarUsuario() {
		Usuario us = null;
			char[] password = pass.getPassword();
			String usuario = usu.getText();
			for(int i=0 ; i<usersAux.length ; i++) {
				if ((String.valueOf(password).equals(usersAux[i].getClave())) && usuario.equals(usersAux[i].getUsuario()))
				{
					us=usersAux[i];
				}
			}		
		return us;
	}

	
	
}   
