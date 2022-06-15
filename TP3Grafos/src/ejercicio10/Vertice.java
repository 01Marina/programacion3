package ejercicio10;

import java.util.LinkedList;

public class Vertice<T> {
	private int id;
	private LinkedList<Vertice<T>> adyacentes;
	private LinkedList<Integer> adyacentesId;//creado para simplificar función en la clase Grafo obtenerAdyacentes(int verticeId)
	private LinkedList<Arco<T>> arcos;//creado para simplificar función en la clase Grafo obtenerArcos(int verticeId)
	private Boolean enServicio;
	Vertice(int id){
		this.id = id;
		this.adyacentes = new LinkedList<Vertice<T>>();
		this.adyacentesId = new LinkedList<Integer>();
		this.arcos = new LinkedList<Arco<T>>();
		this.setEnServicio(true);
	}

	public LinkedList<Vertice<T>> getAdyacentes() {//O(1)
		return adyacentes;
	}
	public LinkedList<Integer> getAdyacentesId() {//O(1)
		return adyacentesId;
	}
	public void AddAdyacente(Vertice<T> adyacente) {//O(AD)
		if(!this.adyacentesId.contains(adyacente.getId())) {//O(AD)
			this.adyacentes.add(adyacente);//O(1)
			this.adyacentesId.add(adyacente.getId());//O(1)
		}
	}

	public int getId() {//O(1)
		return id;
	}

	public void addArco(Arco<T> a) {//O(A)
		if(!this.arcos.contains(a)) {//O(A)
			this.arcos.add(a);//O(1)
		}
	}
	public LinkedList<Arco<T>> getArcos() {//O(1)
		return this.arcos;//O(1)
	}

	public void borraAdyacente(Vertice<T> v) {//O(AD)
		this.adyacentes.remove(v);//O(AD)
		Integer id = v.getId();
		this.adyacentesId.remove(id);//O(AD)
	}

	public void borrarArco(int verticeId2) {//O(A) usar Iterador de la lista
		for(Arco<T> a: this.arcos) {//O(A)
			if(a.getVerticeDestino()== verticeId2) {
				this.arcos.remove(a);//O(A)
			}
		}
	}

	public Boolean getEnServicio() {
		return enServicio;
	}

	public void setEnServicio(Boolean enServicio) {
		this.enServicio = enServicio;
	}

}
