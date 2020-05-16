package clases;

import javax.swing.*;

import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import java.util.Arrays;


public class formulario_base extends JFrame implements ActionListener{

	private JButton boton1,boton2,boton3;
    private JLabel texto, passtx;
    private JTextField usu;
    private JPasswordField pass;
    private Usuario[] usersAux;
    private JRadioButton ctaCte, cajaAhorro, saldo, transferencia;
	private ButtonGroup radioGroup;
    private int cont=0;
	
	public formulario_base() {
        setLayout(null);
        texto = new JLabel("Usuario");
        texto.setBounds(5,1,100,100);
        add(texto);
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
    	boolean ingresado;
    	
        if (e.getSource()==boton1) {
        	band=validarDatos();
        	if(band==false) cont++;
        	
        	if(band==true && cont<3) {
        		ingresado=validarUsuario();
        		if(ingresado==false) cont++;
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
        
        /*if(e.getSource()==ctaCte || e.getSource()==cajaAhorro) {
        	activaOperaciones();
        }
        
        if(e.getSource()==saldo) {
        	mostrarSaldo();
        }*/     
    }

	private void activaOperaciones() {
    	menuOperaciones();
    	setVisible(true);		
	}

	private void menuOperaciones() {
		Container container = getContentPane();
		container.setLayout( new FlowLayout() );
		//botones
		saldo = new JRadioButton( "Cuenta Corriente", true );
		container.add( saldo );
		transferencia = new JRadioButton( "Caja de Ahorro", false );
		container.add( transferencia );
		
		radioGroup = new ButtonGroup();
		radioGroup.add( saldo );
		radioGroup.add( transferencia );
		
		saldo.addActionListener( this );
		transferencia.addActionListener( this );
		
	}

	private boolean validarUsuario() {
    	char[] password = pass.getPassword();
		String usuario = usu.getText();
		boolean ingresado=false;
		for(int i=0 ; i<usersAux.length ; i++) {
			if ((String.valueOf(password).equals(usersAux[i].getClave())) && usuario.equals(usersAux[i].getUsuario())) //tendria q guardar el usuario
			{
				desactivaIngreso();
				setTitle("Bienvenido "+usuario);
				JOptionPane.showMessageDialog(this, "Bienvenido");
				ingresado=true;
				activaMenuCuentas();
			}
		}
		if(ingresado==false){
		   		JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrecta");
		   		usu.setText("");
		        pass.setText("");
		}
		return ingresado;
    }

	private void activaMenuCuentas() {
		menuCuentas();
		setVisible(true);
		boton3.setVisible(true);
	}

	private void menuCuentas() {
			Container container = getContentPane();
			container.setLayout( new FlowLayout() );
			//botones
			ctaCte = new JRadioButton( "Cuenta Corriente", true );
			container.add( ctaCte );
			cajaAhorro = new JRadioButton( "Caja de Ahorro", false );
			container.add( cajaAhorro );
			
			radioGroup = new ButtonGroup();
			radioGroup.add( ctaCte );
			radioGroup.add( cajaAhorro );
			
			ctaCte.addActionListener( this );
			cajaAhorro.addActionListener( this );
	}
		

	public void desactivaIngreso()
    {
    	usu.setVisible(false);
    	texto.setVisible(false);
    	pass.setVisible(false);
    	passtx.setVisible(false);
    	boton1.setVisible(false);
    	boton2.setVisible(false);
    	boton3.setVisible(false);	
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
    
}   
