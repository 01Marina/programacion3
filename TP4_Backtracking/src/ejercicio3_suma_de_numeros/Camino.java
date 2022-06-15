package ejercicio3_suma_de_numeros;

import java.util.ArrayList;
import java.util.HashSet;

public class Camino {

	private HashSet<Numero> salasVicitadas;
	private ArrayList<Numero> camino;
	
	public void agregarAlCamino(Numero sala) {
		this.camino.add(sala);
	}
	
	public void quitarUltimo() {
		this.camino.remove(this.camino.size()-1);
	}
	
	public void marcarVisitado(Numero sala) {
		this.salasVicitadas.add(sala);
	}
	
	public void quitarVisitado(Numero sala) {
		this.salasVicitadas.remove(sala);
	}
	
	public boolean estaVisitado(Numero sala) {
		return this.salasVicitadas.contains(sala);
	}

	public ArrayList<Numero> getCamino() {
		return this.camino;
	}
	
	public void setCamino(ArrayList<Numero> camino) {
		this.camino.clear();
		this.camino.addAll(camino);
	}

	public Integer getSuma() {
		Integer suma = 0;
		for(Numero n: this.camino) {
			suma = suma +n.getValor();
		}
		return suma;
	}
	
}
