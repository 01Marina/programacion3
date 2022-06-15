package ejercicio3_suma_de_numeros;

import java.util.ArrayList;

public class Numero {
	private Integer valor;
	private ArrayList<Numero> numeros;
	
	public Numero(Integer valor, ArrayList<Numero> numeros) {
		this.valor = valor;
		this.numeros = numeros;
	}

	public ArrayList<Numero> getVecinos() {
		return numeros;
	}

	public Integer getValor() {
		return this.valor;
	}

}
