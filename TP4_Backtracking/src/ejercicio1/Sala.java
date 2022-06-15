package ejercicio1;

import java.util.ArrayList;

public class Sala {

	private ArrayList<Sala> salasVecinas;

	public ArrayList<Sala> getVecinos() {
		// Devuelve las salas vecinas a las que puede acceder esta sala
		return salasVecinas;
	}

}
