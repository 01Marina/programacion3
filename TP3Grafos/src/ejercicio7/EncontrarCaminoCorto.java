package ejercicio7;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EncontrarCaminoCorto {

	private Grafo<?> grafo;
	private HashMap<Integer, Boolean> visitas;
	
	
	public EncontrarCaminoCorto(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitas =  new HashMap<>();
	}

	public ArrayList<Integer> encontrarCaminos(int origen, int destino) {
		ArrayList<Integer> camino = new ArrayList<>();
		
		if(this.grafo.contieneVertice(origen) && this.grafo.contieneVertice(destino) &&origen !=destino)  {
			
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen);
			while(it.hasNext()) {
				resetVisits();
				this.visitas.put(origen, true);
				ArrayList<Integer> tmp = encontrarCaminios_visit(it.next(), destino).get(0);
				if(camino.isEmpty()) {
					camino.addAll(tmp);
				}else {
					if(camino.size()> tmp.size()) {
						camino.clear();
						camino.addAll(tmp);
					}

				}
			}
			
				camino.add(0, origen);
		}
		return camino;
	}

	private void resetVisits() {
		Iterator<Integer> it= this.grafo.obtenerVertices();
		while(it.hasNext()) {
			this.visitas.put(it.next(), false);
		}
		
	}

	private ArrayList<ArrayList<Integer>> encontrarCaminios_visit(Integer origen, Integer destino) {
		ArrayList<ArrayList<Integer>> caminos = new ArrayList<>();
		this.visitas.put(origen, true);
		if (origen.equals(destino)) {
			ArrayList<Integer> camino = new ArrayList<>();
			camino.add(destino);
			caminos.add(camino);
			this.visitas.put(destino, false);
			return caminos;
		} else {
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(origen);
			while(it.hasNext()) {
				int adyacente = it.next();
					if(!this.visitas.get(adyacente)) {
						caminos.addAll(this.encontrarCaminios_visit(adyacente, destino));
					}
			}
		}
		if(!caminos.isEmpty()) {
			ArrayList<Integer> caminotmp = new ArrayList<>();
			caminotmp.addAll(caminos.get(0));
			for(ArrayList<Integer> camino: caminos) {
				if( caminotmp.size() > camino.size()) {
					caminotmp.clear();
					caminotmp.addAll(camino);
				}
			}
			caminotmp.add(0, origen);
			caminos.clear();
			caminos.add(caminotmp);
			return caminos;
		}
		return caminos;
	}


	
	
}