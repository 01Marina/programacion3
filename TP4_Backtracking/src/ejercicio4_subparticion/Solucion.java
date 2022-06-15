package ejercicio4_subparticion;

import java.util.ArrayList;

public class Solucion {
	
	private ArrayList<ArrayList<Numero>> conjuntos;

	public Solucion() {
		this.conjuntos = new ArrayList<>();
	}
	
	public void addValores(ArrayList<Numero> valores) {
		//if(!this.conjuntos.contains(valores)) {
		ArrayList<Numero> n = new ArrayList<Numero>(valores);
			this.conjuntos.add(n);
		
	}
	
	public String toString() {
		return conjuntos.toString();
	}

	public ArrayList<ArrayList<Numero>> getConjuntos() {
		return this.conjuntos;
	}

	public boolean contiene(ArrayList<Numero> s) {
		Boolean iguales = false;
		int i = 0;
		while(!iguales && i<this.conjuntos.size()) {
			if(this.conjuntos.get(i).size() == s.size()) {
				iguales = coincidenValores(this.conjuntos.get(i), s);
			}
			i++;
		}
		return iguales;
	}

	private boolean coincidenValores(ArrayList<Numero> c, ArrayList<Numero> s) {
		Boolean coincide = true;
		int i = 0;
		while(coincide && i<c.size()) {
			coincide = s.contains(c.get(i));
			i++;
		}
		return coincide;
	}

}
