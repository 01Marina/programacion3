package ejercicio10;

import java.util.HashMap;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		GrafoDirigido<Integer> g = new GrafoDirigido<Integer>();
		
		g.agregarVertice(0);
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		g.agregarVertice(5);
		g.agregarVertice(6);
		g.agregarVertice(7);
		g.agregarVertice(8);
		g.agregarVertice(9);
		g.agregarVertice(10);
		g.agregarVertice(11);
		g.agregarVertice(12);
		
		g.agregarArco(0, 2, 0);
		g.agregarArco(0, 1, 0);
		
		g.agregarArco(1, 3, 3);
		
		g.agregarArco(2, 5, 1);
		g.agregarArco(2, 7, 18);
		
		g.agregarArco(3, 4, 5);
		g.agregarArco(3, 6, 8);
		
		g.agregarArco(4, 11, 1);
		
		g.agregarArco(5, 6, 2);
		
		g.agregarArco(6, 12, 5);
		g.agregarArco(6, 10, 6);
		
		g.agregarArco(7, 8, 7);
		
		g.agregarArco(8, 9, 4);
		
		g.agregarArco(9, 10, 1);
		
		g.agregarArco(11, 12, 9);
		
		Iterator<Integer> vIt = g.obtenerVertices();
		while(vIt.hasNext()) {
			System.out.println(vIt.next());
		}
		
		HashMap<Integer, Integer> t = new HashMap<>();
		
		t.put(0, 0);
		t.put(1, 4);
		t.put(2, 18);
		t.put(3, 4);
		t.put(4, 13);
		t.put(5, 22);
		t.put(6, 18);
		t.put(7, 12);
		t.put(8, 3);
		t.put(9, 2);
		t.put(10, 3);
		t.put(11, 1);
		t.put(12, 5);
		
		tiempoMaxEjecucion ec = new tiempoMaxEjecucion(g, t);
		System.out.println(" ");
		System.out.println("tiempos de ejecicion (0-10)");
		System.out.print(ec.tiempoMaxDeEjecucion(0, 10));

	}

}
