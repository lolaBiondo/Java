package logic;

import java.util.LinkedList;
import java.util.Scanner;

import data.*;
import entities.*;

public class Login {
	private DataPersona dp;
	private DataRol dr;
	Scanner s=null;
	
	public Login() {
		dp=new DataPersona();
		dr=new DataRol();
	}
	
	public Persona validate(Persona p) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return dp.getByUser(p);
	}

	public LinkedList<Persona> getAll(){
		return dp.getAll();
	}
	
	public LinkedList<Persona> getByLastName(Persona per){
		return dp.getByLastName(per);
	}


	public Persona getByDocumento(Persona per) {
		return dp.getByDocumento(per);
		
	}
	
	public LinkedList<Rol> getAllRoles(){
		return dr.getAll();
	}
	
	public Rol getById(Rol r){
		return dr.getById(r);
	}
	
	public Persona createPerson(Persona per) {
		return dp.add(per);
	}

	public void setRolPerson(Persona p, Rol r) {
		dr.setRolPerson(p, r);
	}

	public void setRoles(Persona p) {
		dr.setRoles(p);
	}

	public Persona editPerson(Persona p) {
		return dp.editPerson(p);
	}

	public void removeRolPerson(Persona p, Rol r) {
		dr.removeRolPerson(p, r);
	}

	public Persona deletePerson(Persona p) {
		return dp.deletePerson(p);		
	}

	public void removeRolesPerson(Persona p) {
		dr.removeRolesPerson(p);
		
	}

	
}
