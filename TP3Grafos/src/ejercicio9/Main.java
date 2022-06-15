package ejercicio9;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		GrafoNoDirigido<Integer> g = new GrafoNoDirigido<Integer>();
		
		g.agregarVertice(1);
		g.agregarVertice(2);
		g.agregarVertice(3);
		g.agregarVertice(4);
		g.agregarVertice(5);
		
		g.agregarArco(1, 3, 1);
		g.agregarArco(1, 2, 1);
		g.agregarArco(1, 4, 1);
		g.agregarArco(2, 3, 1);
		g.agregarArco(2, 4, 1);
		g.agregarArco(2, 5, 1);
		g.agregarArco(4, 5, 1);
		
		Iterator<Integer> vIt = g.obtenerVertices();
		while(vIt.hasNext()) {
			System.out.println(vIt.next());
		}
		
		/*System.out.println("obtener arcos de grafo:");
		 //rompe
		Iterator<Arco<Integer>> ag = g.obtenerArcos();
		while(ag.hasNext()) {
			Arco<Integer> agtemp = ag.next();
			System.out.println("Origen: "+agtemp.getVerticeOrigen()+" Destino: "+agtemp.getVerticeDestino());
		}*/
		
		Arco<Integer> tramoCortado = new Arco <Integer>(2, 5, 2);
		
		EncontrarCaminos ec = new EncontrarCaminos(g);
		System.out.println(" ");
		System.out.println("encontrar camino (1-5)");
		System.out.print(ec.encontrarCaminos(1, 5, tramoCortado));

	}

}
