package original;

import java.util.ArrayList;

public class Backtracking {

	private Casillero destino;
	private Solucion mejorSolucion;
	
	private void back(Estado estado) {
			
		if (this.destino.equals(estado.getPosActual())) { // Condicion de corte
			// Operar solucion
			if (this.mejorSolucion == null || this.mejorSolucion.getCosto() > estado.getCosto()) {
				this.mejorSolucion = new Solucion(estado.getCaminoActual(),estado.getCosto());
			}
		} else { // Sino
			
			ArrayList<Casillero> vecinos = estado.getPosActual().getVecinos();
			
			Casillero original = estado.getPosActual();
			
			for (Casillero vecino: vecinos) { // Por cada posible decisión / hijo
				
				if (!estado.estaVisitado(vecino)) {
					
					// Aplico los cambios que resultan de tomar esa decisión
					estado.getCaminoActual().agregarAlCamino(vecino);
					estado.setPosActual(vecino);
					estado.incrementarCosto(vecino.getValor());
					estado.marcarVisitado(vecino);
					
					if (!poda(estado)) // Si no debo podar
						this.back(estado); // Llamo al backtracking
					
					// Deshago los cambios que resultaron de tomar esa decisión
					estado.getCaminoActual().quitarUltimo();
					estado.setPosActual(original);
					estado.decrementarCosto(vecino.getValor());
					estado.desmarcarVisitado(vecino);
					
				}
						
			}
		}
	}
	
	private boolean poda(Estado estado) {
		return (this.mejorSolucion != null && estado.getCosto() > this.mejorSolucion.getCosto());
	}

	public Solucion back(Casillero origen, Casillero destino) {		
		this.destino = destino;
		this.mejorSolucion = null;
		
		// Generacion del estado inicial
		Estado estado = new Estado();
		estado.getCaminoActual().agregarAlCamino(origen);
		estado.setPosActual(origen);
		estado.incrementarCosto(origen.getValor());
		estado.marcarVisitado(origen);
		
		// Llamo al bactracking desde ese estado incial
		this.back(estado);
				
		return this.mejorSolucion;
	}
}
