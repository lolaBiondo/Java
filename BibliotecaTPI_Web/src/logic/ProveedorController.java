package logic;

import data.*;
import entities.*;

import java.util.LinkedList;
import java.util.Scanner;

public class ProveedorController {
	
	private DataProveedor dpr;
	
	public ProveedorController() {
		dpr=new DataProveedor();
	}
	
	public LinkedList<Proveedor> getAllProveedores(){
		return dpr.getAll();
	}
	
	public Proveedor getByCUIT(Proveedor prov) {
		return dpr.getByCUIT(prov);
	}
	
	public Proveedor createProveedor(Proveedor prov) {
		return dpr.add(prov);
	}

	public Proveedor editProveedor(Proveedor prov) {
		return dpr.editProveedor(prov);
	}

	public Proveedor deleteProveedor(Proveedor prov) {
		return dpr.deleteProveedor(prov);
	}
	
	
}
