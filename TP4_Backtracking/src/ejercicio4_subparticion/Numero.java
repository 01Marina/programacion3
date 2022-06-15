package ejercicio4_subparticion;

import java.util.ArrayList;

public class Numero {
	private Integer valor;
	private ArrayList<Numero> numeros;
	
	public Numero(Integer valor) {
		this.valor = valor;
		this.numeros = new ArrayList<>();
	}
	
	public void addVecino(Numero n) {
		this.numeros.add(n);
	}

	public ArrayList<Numero> getVecinos() {
		return numeros;
	}

	public Integer getValor() {
		return this.valor;
	}
	
	public Boolean equals(Numero n) {
		return this.valor.equals(n.getValor());
	}
	
	public String toString() {
		return valor.toString();
	}

}
