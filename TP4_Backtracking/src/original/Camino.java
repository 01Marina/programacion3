package original;

import java.util.ArrayList;
import java.util.HashSet;

public class Camino {

	private HashSet<Casillero> casillerosVisitados;
	private ArrayList<Casillero> camino;
	private int valor;

	public int getValor() {
		return this.valor;
	}
	
	public void incrementar(int valor) {
		this.valor += valor;
	}

	public void decrementar(int valor) {
		this.valor -= valor;
	}
	
	public void agregarAlCamino(Casillero casillero) {
		this.camino.add(casillero);
	}
	
	public void quitarUltimo() {
		this.camino.remove(this.camino.size()-1);
	}
	
	public void marcarVisitado(Casillero casillero) {
		this.casillerosVisitados.add(casillero);
	}
	
	public void quitarVisitado(Casillero casillero) {
		this.casillerosVisitados.remove(casillero);
	}
	
	public boolean estaVisitado(Casillero casillero) {
		return this.casillerosVisitados.contains(casillero);
	}

	public ArrayList<Casillero> getCamino() {
		return this.camino;
	}
	
	public void setCamino(ArrayList<Casillero> camino) {
		this.camino.clear();
		this.camino.addAll(camino);
	}

	public void setValor(int valor) {
		this.valor = valor;
		
	}

	
}
