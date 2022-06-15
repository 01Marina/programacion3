package ejercicio10;

import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {
	private LinkedList<Vertice<T>> vertices;
	private LinkedList<Integer> verticesId;//creado para simplificar el retorno de la función obtenerVertices()
	private LinkedList<Arco<T>> arcos;
	
	GrafoDirigido(){
		vertices = new LinkedList<Vertice<T>>();
		verticesId = new LinkedList<Integer>();
		arcos = new LinkedList<Arco<T>>();
	}
	
	@Override
	public void agregarVertice(int verticeId) {//O(V)
		if(!contieneVertice(verticeId)) {//O(V)
			this.vertices.add(new Vertice<T>(verticeId));//O(1)
			this.verticesId.add(verticeId);//O(1)
		}
	}

	@Override
	public void borrarVertice(int verticeId) {//O(V)+O(A)+O(AD)
		if(contieneVertice(verticeId)) {//O(V)
			verticesId.remove((Integer)verticeId);//O(V)
			Vertice<T> v = obtenerVertice(verticeId);//O(V)
			//remover los  adyacentes en vértices y los arcos que apunten a este vértice y a los que apunte este mismo
			removerOcurrenciasExistentes(verticeId);//O(V)+O(A)+O(AD)
			vertices.remove(v);//O(V)
		}
	}
	
	private void removerOcurrenciasExistentes(int verticeId) {//O(V)+O(A)+O(AD)
		for(Vertice<T> ve: vertices) {//O(V)
			borrarArco(verticeId, ve.getId());//O(V)+O(A)+O(AD)
			borrarArco(ve.getId(), verticeId);//O(V)+O(A)+O(AD)
		}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {//O(V)+O(A)+O(AD)
		if(existeArco(verticeId1,verticeId2)) {//O(A)
			//remuevo el arco del array del grafo
			this.arcos.remove(obtenerArco(verticeId1, verticeId2));//O(A)
			//busco el vértice origen
			Vertice<T> v = obtenerVertice(verticeId1);//O(V)
			//elimino del vértice origen el arco que apunta al destino que ya no debe apuntar
			v.borrarArco(verticeId2);//O(A)
			//elimino del vértice origen el adyacente que ya no pertenece a sus adyacentes
			Vertice<T> adyacente = obtenerVertice(verticeId2);//O(V)
			v.borraAdyacente(adyacente);//O(AD)
		}
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {//O(V)+O(A)+O(AD)
		if(contieneVertice(verticeId1) && contieneVertice(verticeId2) && !existeArco(verticeId1,verticeId2)) {//O(V)+O(A)
			Arco<T> a = new Arco<T>(verticeId1, verticeId2, etiqueta);
			this.arcos.add(a);//O(1)
			Vertice<T> v = obtenerVertice(verticeId1);//O(V)
			v.AddAdyacente(obtenerVertice(verticeId2));//O(AD)
			v.addArco(a);//O(A)
		}
	}

	private Vertice<T> obtenerVertice(int verticeId) {//O(V)
		for(Vertice<T> v: this.vertices) {
			if(v.getId() == verticeId) {
				return v;
			}
		}
		return null;
	}


	@Override
	public boolean contieneVertice(int verticeId) {//O(V)
		Iterator<Integer> vIt = obtenerVertices();
		while(vIt.hasNext()) {
			int tmp = vIt.next();
			if(tmp == verticeId) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {//O(A)  
		//Otra opción es redefinir equals en Arco para hacer andar el contain
		for(Arco<T> a: this.arcos) {
			boolean igual = (a.getVerticeOrigen() == verticeId1 && a.getVerticeDestino() == verticeId2);
			if(igual) {
				return igual;
			}
		}
		return false;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {//O(A)
		Iterator<Arco<T>> aIt = obtenerArcos();//O(1)
		while(aIt.hasNext()) {//O(A)
			Arco<T> tmp = aIt.next();
			if(tmp.getVerticeOrigen() == verticeId1 && tmp.getVerticeDestino() == verticeId2) {
				return tmp;
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {//O(1)
		return this.vertices.size();
	}

	@Override
	public int cantidadArcos() {//O(1)
		return this.arcos.size();
	}

	@Override
	public Iterator<Integer> obtenerVertices() {//O(1)
		return this.verticesId.iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {//O(A)
		//Usar Iterador de Vértices, es lo mismo que el for. Pero con el Iterador queda anclado en un valor que puede ser útil
		for(Vertice<T> v: this.vertices) {//O(A)
			if(v.getId() == verticeId) {
				return v.getAdyacentesId().iterator();
			}
		}
		return null;
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {//O(1)
		return this.arcos.iterator();
	}
	
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {//O(1)
		return obtenerVertice(verticeId).getArcos().iterator();
	}

}
