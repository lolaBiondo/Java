package logic;

import java.util.LinkedList;

import data.DataPoliticaPrestamo;
import entities.Persona;
import entities.PoliticaPrestamo;

public class PoliticaPrestamoController {
	private DataPoliticaPrestamo dpp;
	public PoliticaPrestamoController() {
		dpp=new DataPoliticaPrestamo();
	}
	public LinkedList<PoliticaPrestamo> ppGetAll(){
		return dpp.getAll();
	}
	public PoliticaPrestamo newPolitica(PoliticaPrestamo pp) {
		return dpp.add(pp);
	}
	
	public PoliticaPrestamo getByIdPolitica (PoliticaPrestamo pp) {
		return dpp.getById(pp);
	}
	public PoliticaPrestamo editPolitica (PoliticaPrestamo pp) {
		return dpp.editPolitica(pp);
	}
	public PoliticaPrestamo deletePoliticaPrestamo (PoliticaPrestamo pp) {
		return dpp.deletePolitica(pp);
	}
}
