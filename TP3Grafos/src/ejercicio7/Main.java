package ejercicio7;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
GrafoDirigido<Integer> g = new GrafoDirigido<Integer>();
		
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
		
		//g.agregarArco(1,4, 1);
		//g.agregarArco(1, 2, 1);
		g.agregarArco(1, 2, 1);
		g.agregarArco(1, 4, 1);
		
		g.agregarArco(2, 3, 2);
		
		g.agregarArco(3, 6, 3);
		
		g.agregarArco(4, 7, 2);
		
		g.agregarArco(5, 4, 7);
		
		g.agregarArco(6, 5, 2);
		g.agregarArco(6, 9, 2);
		
		g.agregarArco(7, 8, 2);
		g.agregarArco(7, 10, 2);
		
		g.agregarArco(8, 5, 2);
		g.agregarArco(8, 9, 2);
		
		g.agregarArco(9, 12, 2);
		
		
		g.agregarArco(11, 8, 2);
		g.agregarArco(11, 10, 2);
		
		g.agregarArco(12, 11, 2);
		
		Iterator<Integer> vIt = g.obtenerVertices();
		while(vIt.hasNext()) {
			System.out.println(vIt.next());
		}
		
		System.out.println("obtener arcos de grafo:");
		Iterator<Arco<Integer>> ag = g.obtenerArcos();
		while(ag.hasNext()) {
			Arco<Integer> agtemp = ag.next();
			System.out.println("Origen: "+agtemp.getVerticeOrigen()+" Destino: "+agtemp.getVerticeDestino());
		}
		
		EncontrarCaminoCorto ec = new EncontrarCaminoCorto(g);
		System.out.println(" ");
		System.out.println("encontrar camino (1-11)");
		System.out.print(ec.encontrarCaminos(1, 5));
		

	}

}
