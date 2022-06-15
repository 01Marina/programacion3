

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigidoHashMap<T> implements Grafo<T> {
	private HashMap<Integer, LinkedList<Arco<T>>> vertices;
	
	GrafoDirigidoHashMap(){
		vertices = new HashMap<Integer, LinkedList<Arco<T>>>();
	}
	//Listo
	@Override
	public void agregarVertice(int verticeId) {//O(1)
		if(!contieneVertice(verticeId)) {//O(1)?
			this.vertices.put(verticeId, null);//O(1)
		}
	}
	//Listo
	@Override
	public void borrarVertice(int verticeId) {//O(1)
		if(contieneVertice(verticeId)) {//O(1)?
			this.vertices.remove(verticeId);//O(1)?
			//remover los arcos que apunten a este vértice
			removerOcurrenciasExistentes(verticeId);//O(V)+O(A)+O(AD)
		}
	}
	//Listo
	private void removerOcurrenciasExistentes(int verticeId) {//O(V^A)?
		Iterator<LinkedList<Arco<T>>> arcos = this.vertices.values().iterator();//O(1)?
		while(arcos.hasNext()) {//O(V)
			LinkedList<Arco<T>> arcosV = arcos.next();
			Iterator<Arco<T>> arcoTmp = arcosV.iterator();
			while(arcoTmp.hasNext()) {//O(V^A)?
				Arco<T> tmp = arcoTmp.next();
				if(tmp.getVerticeDestino() == verticeId) {
					arcosV.remove(tmp);//O(A)?
				}
			}
		}
	}
	//Lista
	@Override
	public void borrarArco(int verticeId1, int verticeId2) {//O(A)+O(?)
		if(existeArco(verticeId1,verticeId2)) {//O(A)
			this.vertices.get(verticeId1).remove(this.obtenerArco(verticeId1, verticeId2)/*O(A)*/);//O(A)+ O(?)
		}
	}
	//Lista
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {//O(A)
		if(contieneVertice(verticeId1)/*O(1)?*/ && contieneVertice(verticeId2)/*O(1)?*/
				&& !existeArco(verticeId1,verticeId2)/*O(A)*/) {//O(A)
			Arco<T> a = new Arco<T>(verticeId1, verticeId2, etiqueta);
			this.vertices.get(verticeId1).add(a);//O(1)
		}
	}

	//Lista
	@Override
	public boolean contieneVertice(int verticeId) {//O(1)?
		return this.vertices.containsKey(verticeId);
	}
	//Lista
	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {//O(A)  
		Iterator<Arco<T>> arIt = this.vertices.get(verticeId1).iterator();//O(1)
		
		while(arIt.hasNext()) {//O(A)
			Arco<T> tmp = arIt.next();
			if(tmp.getVerticeDestino() == verticeId2) {
				return true;
			}
		}
		return false;//this.vertices.contentValue();
	}
	//Listo
	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {//O(A)
		Iterator<Arco<T>> aIt = this.vertices.get(verticeId1).iterator();//O(1)
		while(aIt.hasNext()) {//O(A)
			Arco<T> tmp = aIt.next();
			if(tmp.getVerticeDestino() == verticeId2) {
				return tmp;
			}
		}
		return null;
	}
	//Listo
	@Override
	public int cantidadVertices() {//O(1)
		return this.vertices.size();
	}
	//Listo
	@Override
	public int cantidadArcos() {//O(A)
		Iterator<LinkedList<Arco<T>>> vIt = this.vertices.values().iterator();
		int size = 0;
		while(vIt.hasNext()) {//O(V)
			size = size + vIt.next().size();
		}
		return size;
	}
	//Listo
	@Override
	public Iterator<Integer> obtenerVertices() {//O(1)
		return this.vertices.keySet().iterator();
	}
	//Lito
	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {//O(A)
		Iterator<Arco<T>> arcos = this.obtenerArcos(verticeId);//O(1)?
		LinkedList<Integer> adyacentes = new LinkedList<Integer>();
		while(arcos.hasNext()) {//O(A)
			adyacentes.add(arcos.next().getVerticeDestino());
		}
		return adyacentes.iterator();
	}
	//Listo
	@Override
	public Iterator<Arco<T>> obtenerArcos() {//O(V)+O(A)
		Iterator<LinkedList<Arco<T>>> arcos = this.vertices.values().iterator();
		LinkedList<Arco<T>> tmpAr = new LinkedList<Arco<T>>();
		while(arcos.hasNext()) {//O(V)
			tmpAr.addAll(arcos.next());//O(A)
		}
		return tmpAr.iterator();
	}

	//Listo
	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {//O(1)
		return this.vertices.get(verticeId).iterator();
	}

}
