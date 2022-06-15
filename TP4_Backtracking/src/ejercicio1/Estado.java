package ejercicio1;

public class Estado {

	private Sala posActual;
	private Camino caminoActual;

	public Camino getCaminoActual() {
		return caminoActual;
	}

	public void setCaminoActual(Camino caminoActual) {
		this.caminoActual = caminoActual;
	}

	public Sala getPosActual() {
		return posActual;
	}

	public void setPosActual(Sala posActual) {
		this.posActual = posActual;
	}

	public boolean estaVisitado(Sala vecino) {
		return this.caminoActual.estaVisitado(vecino);
	}

	public void marcarVisitado(Sala vecino) {
		this.caminoActual.marcarVisitado(vecino);
	}

	public void desmarcarVisitado(Sala vecino) {
		this.caminoActual.quitarVisitado(vecino);

	}

	

}
