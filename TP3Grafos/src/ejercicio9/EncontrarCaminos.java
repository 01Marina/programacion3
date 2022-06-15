package ejercicio9;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class EncontrarCaminos {

	private Grafo<?> grafo;
	private HashMap<Integer, Boolean> visitas;
	
	
	public EncontrarCaminos(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitas =  new HashMap<>();
	}

	public ArrayList< ArrayList<Integer> > encontrarCaminos(int origen, int destino, Arco<?> tramoCortado) {
		ArrayList<ArrayList<Integer>> caminos = new ArrayList<ArrayList<Integer>>();
		
		if(this.grafo.contieneVertice(origen) && this.grafo.contieneVertice(destino) && origen != destino)  {
			resetVisits();
			caminos.addAll(encontrarCaminios_visit(origen, destino,tramoCortado));
		}
		return caminos;
	}

	private void resetVisits() {
		Iterator<Integer> it= this.grafo.obtenerVertices();
		while(it.hasNext()) {
			this.visitas.put(it.next(), false);
		}
		
	}

	private ArrayList<ArrayList<Integer>> encontrarCaminios_visit(Integer origen, Integer destino, Arco<?> tramoCortado) {
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
						if(tramoCortado.getVerticeDestino() != adyacente || tramoCortado.getVerticeOrigen()!=origen) {
								caminos.addAll(this.encontrarCaminios_visit(adyacente, destino, tramoCortado));
						}
					}
			}
		}
		if(!caminos.isEmpty()) {
			for(ArrayList<Integer> camino: caminos) {
				camino.add(0, origen);
			}
		}
		this.visitas.put(origen, false);
		return caminos;
	}

	
	
}