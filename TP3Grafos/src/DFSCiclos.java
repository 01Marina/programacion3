import java.util.HashMap;
import java.util.Iterator;

public class DFSCiclos {
	private Grafo<?> grafo;
	private HashMap <Integer, String> colores;
	
	public DFSCiclos(Grafo<?> grafo) {
		this.grafo = grafo;
		this.colores = new HashMap<>();
	}
	
	public boolean dfs_ciclo() {
		Iterator<Integer> it = this.grafo.obtenerVertices();
		while(it.hasNext()) {
			this.colores.put(it.next(), "blanco");
		}
		it = this.grafo.obtenerVertices();
		boolean ciclo = false;
		while(it.hasNext() && !ciclo) {
			int verticeId = it.next();
			if(this.colores.get(verticeId).equals("blanco")) {
				ciclo = dfs_visit(verticeId);
			}
		}
		return ciclo;
	}
	
	private boolean dfs_visit(int verticeId) {
		this.colores.put(verticeId, "amarillo");
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(verticeId);
		boolean ciclo = false;
		while(it.hasNext()) {
			int adyacente = it.next();
			if(this.colores.get(adyacente).equals("blanco")) {
				ciclo = dfs_visit(adyacente);
			}else if(this.colores.get(adyacente).equals("amarillo")) {
				ciclo = true;
			}
		}
		//this.colores.put(verticeId, "negro");
		return ciclo;
	}
}
