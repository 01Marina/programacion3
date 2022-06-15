package ejercicio1;

import java.util.ArrayList;
import java.util.HashSet;

public class Camino {

	private HashSet<Sala> salasVicitadas;
	private ArrayList<Sala> camino;
	
	public void agregarAlCamino(Sala sala) {
		this.camino.add(sala);
	}
	
	public void quitarUltimo() {
		this.camino.remove(this.camino.size()-1);
	}
	
	public void marcarVisitado(Sala sala) {
		this.salasVicitadas.add(sala);
	}
	
	public void quitarVisitado(Sala sala) {
		this.salasVicitadas.remove(sala);
	}
	
	public boolean estaVisitado(Sala sala) {
		return this.salasVicitadas.contains(sala);
	}

	public ArrayList<Sala> getCamino() {
		return this.camino;
	}
	
	public void setCamino(ArrayList<Sala> camino) {
		this.camino.clear();
		this.camino.addAll(camino);
	}


	
}
