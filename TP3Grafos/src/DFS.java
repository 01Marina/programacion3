import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class DFS {
	private Grafo<?> grafo;
	private HashMap <Integer, String> colores;
	private HashMap <Integer, Integer> descubrimiento, finalizacion;
	private int tiempo;
	
	public DFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
		this.descubrimiento = this.finalizacion = new HashMap<>();
		this.tiempo = 0;
	}
	
	public LinkedList<Integer> dfs() {
		LinkedList<Integer> respuesta = new LinkedList<Integer>();
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while(it.hasNext()) {
			this.colores.put(it.next(), "blanco");
		}
		this.tiempo = 0;
		it = this.grafo.obtenerVertices();
		while(it.hasNext()) {
			int verticeId = it.next();
			if(this.colores.get(verticeId).equals("blanco")) {
				respuesta.addAll(dfs_visit(verticeId));
			}
		}
		return respuesta;
	}
	
	private LinkedList<Integer> dfs_visit(int verticeId) {
		LinkedList<Integer> respuesta = new LinkedList<Integer>();
		respuesta.add(verticeId);
		this.colores.put(verticeId, "amarillo");
		tiempo = tiempo+1;
		this.descubrimiento.put(verticeId, tiempo);
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(verticeId);
		while(it.hasNext()) {
			int adyacente = it.next();
			if(this.colores.get(adyacente).equals("blanco")) {
				respuesta.addAll(dfs_visit(adyacente));
			}
		}
		tiempo = tiempo +1;
		this.finalizacion.put(verticeId, tiempo);
		this.colores.put(verticeId, "negro");
		return respuesta;
	}
}
