import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	private Grafo<?> grafo;
	private LinkedList<Integer> fila;
	private HashMap<Integer, Boolean> visitas;
	
	public BFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.fila = new LinkedList<Integer>();
		this.visitas = new HashMap<>();
	}
	
	public LinkedList<Integer> bfs() {
		LinkedList<Integer> respuesta = new LinkedList<Integer>();
		//Vaciar la fila F.
		this.fila.clear();
		//Para cada vértices v de G
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while(it.hasNext()) {
			//Marcar v como NO_VISITADO.
			this.visitas.put(it.next(), false);
		}
		it = this.grafo.obtenerVertices();
		//Para cada vértice v de G
		while(it.hasNext()) {
			//Si v es NO_VISITADO:
			int verticeId = it.next();
			if(!this.visitas.get(verticeId)) {
				respuesta.add(verticeId);
				respuesta.addAll(bfs_visit(verticeId));
			}
		}
		return respuesta;
			
	}

	private LinkedList<Integer> bfs_visit(int verticeId) {
		LinkedList<Integer> respuesta = new LinkedList<Integer>();
		//Marcar el vértice s como VISITADO.
		this.visitas.put(verticeId, true);
		//Agregar s a la fila F.
		this.fila.add(verticeId);
		//Mientras la fila F no esté vacía
		while(!this.fila.isEmpty()) {
			//Tomamos vértice x de la fila,
			//Para cada vértice y adyacente a x:
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(fila.pop());
			while(it.hasNext()){
				int id = it.next();
				//Si y es NO_VISITADO :
				if(!this.visitas.get(id)) {
					//Marcar el vértice y como VISITADO.
					this.visitas.put(id, true);
					//Agregar y a la fila F.
					this.fila.push(id);
					respuesta.add(id);
				}
		
			}
		}
		return respuesta;
			
		
	}
}
