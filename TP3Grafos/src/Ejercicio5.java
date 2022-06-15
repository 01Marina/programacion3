import java.util.ArrayList;
import java.util.Iterator;

public class Ejercicio5 {
	private Grafo<?> grafo;
	
	public Ejercicio5(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public ArrayList<Integer> encontrarCaminosExistentes(Integer destino){
		ArrayList<Integer> caminos = new ArrayList<>();
		
		Iterator<Integer> it = this.grafo.obtenerVertices();
		
		ExisteCamino ex = new ExisteCamino(grafo);
		while(it.hasNext()) {
			Integer origen = it.next();
			if(origen!=destino) {
				if(ex.existeCamino(origen, destino)) {
					caminos.add(origen);
				}
			}
		}
		return caminos;
	}

}
