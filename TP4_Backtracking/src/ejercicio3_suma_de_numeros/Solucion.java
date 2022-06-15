package ejercicio3_suma_de_numeros;

import java.util.ArrayList;

public class Solucion {
	
	private ArrayList<ArrayList<Numero>> sumas;

	public Solucion() {
		this.sumas = new ArrayList<>();
	}
	
	public void addValores(ArrayList<Numero> valores) {
		if(!this.sumas.contains(valores)) {
			this.sumas.add(valores);
		}
	}

}
