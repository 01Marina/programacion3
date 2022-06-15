package ejercicio10;



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class tiempoMaxEjecucion {

	private Grafo<?> grafo;
	private HashMap<Integer, Boolean> visitas;
	private HashMap<Integer, Integer> tiempoComputacional;
	
	
	public tiempoMaxEjecucion(Grafo<?> grafo, HashMap<Integer, Integer> tiempoComputacional) {
		this.grafo = grafo;
		this.visitas =  new HashMap<>();
		this.tiempoComputacional = tiempoComputacional;
	}

	public Integer tiempoMaxDeEjecucion(int origen, int destino) {
		ArrayList<Integer> tiempoEjecicion = new ArrayList<Integer>();
		
		if(this.grafo.contieneVertice(origen) && this.grafo.contieneVertice(destino) && origen != destino)  {
			resetVisits();
			tiempoEjecicion.addAll(tiempoMaxDeEjecucion_visit(origen, destino));
		}
		return Collections.max(tiempoEjecicion);
	}
	
	private void resetVisits() {
		Iterator<Integer> it= this.grafo.obtenerVertices();
		while(it.hasNext()) {
			this.visitas.put(it.next(), false);
		}
	}

	private ArrayList<Integer> tiempoMaxDeEjecucion_visit(Integer origen, Integer destino) {
		ArrayList<Integer> tiempos = new ArrayList<>();
		this.visitas.put(origen, true);
		if (origen.equals(destino)) {
			this.visitas.put(destino, false);
			tiempos.add(this.tiempoComputacional.get(origen));
			return tiempos;
		} else {
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen);
			while(it.hasNext()) {
				int adyacente = it.next();
					if(!this.visitas.get(adyacente)) {
						ArrayList<Integer> tiemposTmp = this.tiempoMaxDeEjecucion_visit(adyacente, destino);
						incrementarTiempo(tiemposTmp, this.grafo.obtenerArco(origen, adyacente).getEtiqueta());
						tiempos.addAll(tiemposTmp);
					}
			}
		}
		if(!tiempos.isEmpty()) {
			this.incrementarTiempo(tiempos, this.tiempoComputacional.get(origen));
		}
		this.visitas.put(origen, false);
		return tiempos;
	}

	private void incrementarTiempo(ArrayList<Integer> tiempos, Integer tiempo) {
		int i = 0;
		while(i <= tiempos.size()-1) {
			Integer t = tiempos.get(i);
			t = t+tiempo;
			tiempos.set(i, t);
			i++;
		}
	}

	


	
	
}