package ejercicio3_suma_de_numeros;

public class Estado2 {

	private Numero posActual;
	private Camino caminoActual;

	public Camino getCaminoActual() {
		return caminoActual;
	}

	public void setCaminoActual(Camino caminoActual) {
		this.caminoActual = caminoActual;
	}

	public Numero getPosActual() {
		return posActual;
	}

	public void setPosActual(Numero posActual) {
		this.posActual = posActual;
	}

	public boolean estaVisitado(Numero vecino) {
		return this.caminoActual.estaVisitado(vecino);
	}

	public void marcarVisitado(Numero vecino) {
		this.caminoActual.marcarVisitado(vecino);
	}

	public void desmarcarVisitado(Numero vecino) {
		this.caminoActual.quitarVisitado(vecino);

	}
	
	public Integer getSuma() {
		return this.caminoActual.getSuma();
	}

}
