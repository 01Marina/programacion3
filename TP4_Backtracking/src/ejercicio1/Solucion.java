package ejercicio1;

import java.util.ArrayList;

public class Solucion {
	
	private ArrayList<Sala> salas;

	public Solucion() {
		this.salas = new ArrayList<>();
	}
	
	public void addSalas(ArrayList<Sala> camino) {
		this.salas.addAll(camino);
	}

	public int getNumeroSalas() {
		return this.salas.size();
	}

}
