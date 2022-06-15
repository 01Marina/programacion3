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
		
		//g.agregarArco(1,4, 1);
		//g.agregarArco(1, 2, 1);
		g.agregarArco(1, 6, 1);
		g.agregarArco(1, 2, 1);
		g.agregarArco(1, 5, 1);
		
		g.agregarArco(2, 4, 2);
		g.agregarArco(2, 5, 2);
		
		g.agregarArco(3, 4, 3);
		g.agregarArco(3, 1, 3);
		g.agregarArco(3, 7, 3);
		
		g.agregarArco(4, 5, 2);
		g.agregarArco(4, 2, 2);
		
		g.agregarArco(6, 3, 6);
		g.agregarArco(7, 5, 7);
		
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
		
		EncontrarCamino ec = new EncontrarCamino(g);
		System.out.println(" ");
		System.out.println("encontrar camino (1-5)");
		System.out.print(ec.encontrarCamino(1, 5));
		
		
		EncontrarCaminos ecs = new EncontrarCaminos(g);
		System.out.println(" ");
		System.out.println("encontrar caminos (1-5)");
		System.out.print(ecs.encontrarCaminos(1, 5));
		
		EncontrarCaminoCorto ecc = new EncontrarCaminoCorto(g);
		System.out.println(" ");
		System.out.println("encontrar camino mas corto (1-5)");
		System.out.print(ecc.caminoMasCorto(1, 5));
		
		
		EncontrarCaminoLargo ecl = new EncontrarCaminoLargo(g);
		System.out.println(" ");
		System.out.println("encontrar camino mas Largo (1-5)");
		System.out.print(ecl.caminoMasLargo(1, 5));
		
		
		Ejercicio5 e5 = new Ejercicio5(g);
		System.out.println(" ");
		System.out.println("origenes y caminos exixtentes (5)");
		System.out.print(e5.encontrarCaminosExistentes(5));
		
		System.out.println(" ");
		System.out.println("DFS");
		DFS dfs = new DFS(g);
		System.out.println(dfs.dfs());
		
		
		
		
		System.out.println(" ");
		System.out.println("BFS");
		BFS bfs = new BFS(g);
		System.out.println(bfs.bfs());
		/*
		Iterator<Integer> itt = g.obtenerAdyacentes(2);
		while(itt.hasNext()) {
			System.out.println(itt.next());
		}*/
		/*System.out.println("Cantidad de vértices: "+g.cantidadVertices());
		System.out.println("Cantidad de arcos: "+g.cantidadArcos());
		
		System.out.println("obtener arcos de grafo:");
		Iterator<Arco<Integer>> agg = g.obtenerArcos();
		while(agg.hasNext()) {
			Arco<Integer> aggtemp = agg.next();
			System.out.println("Origen: "+aggtemp.getVerticeOrigen()+" Destino: "+aggtemp.getVerticeDestino());
		}
		
		System.out.println("Contine vertice dado (4)? "+g.contieneVertice(4));
		System.out.println("Existe arco dado (1-5)? "+g.existeArco(1, 5));
		
		System.out.println("obtener adyacentes de un vértice dado (1):");
		Iterator<Integer> aIt = g.obtenerAdyacentes(1);
		while(aIt.hasNext()) {
			System.out.println(aIt.next());
		}
		
		System.out.println("obtener arcos de un vértice dado (1):");
		Iterator<Arco<Integer>> arIt = g.obtenerArcos(1);
		while(arIt.hasNext()) {
			Arco<Integer> arTemp = arIt.next();
			System.out.println("Origen: "+arTemp.getVerticeOrigen()+" Destino: "+arTemp.getVerticeDestino());
		}
		
		System.out.println("obtener todos los vértices");
		Iterator<Integer> vIt = g.obtenerVertices();
		while(vIt.hasNext()) {
			System.out.println(vIt.next());
		}
		
		System.out.println(" ");
		System.out.println("Borrado arco 1-5");
		g.borrarArco(1, 5);
		
		System.out.println("obtener arcos de un vértice dado (1):");
		Iterator<Arco<Integer>> arItb = g.obtenerArcos(1);
		while(arItb.hasNext()) {
			Arco<Integer> arTempb = arItb.next();
			System.out.println("Origen: "+arTempb.getVerticeOrigen()+" Destino: "+arTempb.getVerticeDestino());
		}

		System.out.println("Borrado arco 1-2");
		g.borrarArco(1, 2);
		
		System.out.println("obtener arcos de un vértice dado (1):");
		Iterator<Arco<Integer>> arItb2 = g.obtenerArcos(1);
		while(arItb2.hasNext()) {
			Arco<Integer> arTempb2 = arItb2.next();
			System.out.println("Origen: "+arTempb2.getVerticeOrigen()+" Destino: "+arTempb2.getVerticeDestino());
		}
		
		System.out.println("obtener adyacentes de un vértice dado (1):");
		Iterator<Integer> aIt1 = g.obtenerAdyacentes(1);
		while(aIt1.hasNext()) {
			System.out.println(aIt1.next());
		}
		
		System.out.println("obtener adyacentes de un vértice dado (3):");
		Iterator<Integer> aIt3 = g.obtenerAdyacentes(3);
		while(aIt3.hasNext()) {
			System.out.println(aIt3.next());
		}
		
		System.out.println("Borrado vértice 1");
		g.borrarVertice(1);
		
		System.out.println("obtener adyacentes de un vértice dado (3):");
		Iterator<Integer> aIt33 = g.obtenerAdyacentes(3);
		while(aIt33.hasNext()) {
			System.out.println(aIt33.next());
		}
		
		System.out.println("Cantidad de vértices: "+g.cantidadVertices());
		System.out.println("Cantidad de arcos: "+g.cantidadArcos());
		
		System.out.println("obtener arcos de grafo:");
		Iterator<Arco<Integer>> ag = g.obtenerArcos();
		while(ag.hasNext()) {
			Arco<Integer> agtemp = ag.next();
			System.out.println("Origen: "+agtemp.getVerticeOrigen()+" Destino: "+agtemp.getVerticeDestino());
		}
		
		System.out.println("Contine vertice dado (1)? "+g.contieneVertice(1));
		System.out.println("obtener vértices de grafo:");
		Iterator<Integer> vb = g.obtenerVertices();
		while(vb.hasNext()) {
			System.out.println(vb.next());
		}
		System.out.println("Existe arco dado (1-4)? "+g.existeArco(1, 4));
		
		System.out.println("creo un nuevo arco (2-5)");
		g.agregarArco(2, 5, 2);
		
		System.out.println("Cantidad de arcos: "+g.cantidadArcos());
		
		System.out.println("obtener arcos de grafo:");
		Iterator<Arco<Integer>> aag = g.obtenerArcos();
		while(aag.hasNext()) {
			Arco<Integer> aagtemp = aag.next();
			System.out.println("Origen: "+aagtemp.getVerticeOrigen()+" Destino: "+aagtemp.getVerticeDestino());
		}
		
		System.out.println("borro arco (5-2)");
		g.borrarArco(5, 2);
		
		System.out.println("obtener arcos de grafo:");
		Iterator<Arco<Integer>> aaag = g.obtenerArcos();
		while(aaag.hasNext()) {
			Arco<Integer> aaagtemp = aaag.next();
			System.out.println("Origen: "+aaagtemp.getVerticeOrigen()+" Destino: "+aaagtemp.getVerticeDestino());
		}*/
	}

}
