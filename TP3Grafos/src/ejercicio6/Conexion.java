package ejercicio6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Conexion {
	private Grafo<?> grafo;
	private HashMap<Integer, Boolean> visitas;
	
	public Conexion(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitas = new HashMap<>();
	}
	
	public Boolean obtener_conexion(Integer origen, Integer destino, ArrayList<Integer> computadorasFueraDeServicio) {
		
		resetVisit();
		return obtener_conexion_visit(origen, destino, computadorasFueraDeServicio);
	}
	
	private void resetVisit() {
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while (it.hasNext()) {
			int verticeId = it.next();
			this.visitas.put(verticeId, false);
		}
	}

	public Boolean obtener_conexion_visit(Integer origen, Integer destino, ArrayList<Integer> computadorasFueraDeServicio) {
		
		this.visitas.put(origen, true);

		if (origen == destino) {
			return true;
		} else {
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen);
			while (it.hasNext()) {
				int adyacente = it.next();
				if (!computadorasFueraDeServicio.contains(adyacente)&&!this.visitas.get(adyacente)) {
					boolean hayCamino = obtener_conexion(adyacente,destino, computadorasFueraDeServicio);
					if (hayCamino)
						return true;
				}
			}
		}
	
		return false;
	}
	
	
}
