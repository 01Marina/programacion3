

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EncontrarCamino {

	private Grafo<?> grafo;
	private HashMap<Integer, String> visitas;
	
	public EncontrarCamino(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitas = new HashMap<>();
	}


	public ArrayList<Integer> encontrarCamino(int origen, int destino) {
		
		ArrayList<Integer> camino = new ArrayList<>();
		Iterator<Integer> it= this.grafo.obtenerVertices();
		while(it.hasNext()) {
			this.visitas.put(it.next(), "blanco");
		}
		camino.addAll(encontrarCamino_visit(origen, destino));
		return camino;
	}


	private ArrayList<Integer> encontrarCamino_visit(int origen, int destino) {
		ArrayList<Integer> camino = new ArrayList<>();
		
		this.visitas.put(origen, "amarillo");

		if (origen == destino) {
			camino.add(destino);
			return camino;
		} else {
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen);
			while (it.hasNext() && camino.isEmpty()) {
				Integer adyacente = it.next();
				if (this.visitas.get(adyacente).equals("blanco")) {
					camino.addAll(encontrarCamino_visit(adyacente,destino));
				}
			}
			if(!camino.isEmpty()) {
				camino.add(0, origen);
			}
		}
		return camino;
	}
	
}