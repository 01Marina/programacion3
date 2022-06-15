package ejercicio1;

import java.util.ArrayList;

public class Backtracking {

	private Sala destino;
	private Solucion mejorSolucion;
	
	public Solucion back(Sala origen, Sala destino) {		
		this.destino = destino;
		this.mejorSolucion = null;
		
		// Generacion del estado inicial
		Estado estado = new Estado();
		estado.getCaminoActual().agregarAlCamino(origen);
		estado.setPosActual(origen);
		estado.marcarVisitado(origen);
		
		// Llamo al bactracking desde ese estado incial
		this.back(estado);
				
		return this.mejorSolucion;
	}
	
	private void back(Estado estado) {
			
		if (this.destino.equals(estado.getPosActual())) { // Condicion de corte
			if (this.mejorSolucion == null || this.mejorSolucion.getNumeroSalas() < estado.getCaminoActual().getCamino().size()) {
				this.mejorSolucion = new Solucion();
				this.mejorSolucion.addSalas(estado.getCaminoActual().getCamino());
			}
			
		} else { // Sino
			
			ArrayList<Sala> vecinos = estado.getPosActual().getVecinos();
			
			Sala original = estado.getPosActual();
			
			for (Sala vecino: vecinos) { // Por cada posible decisión / hijo
				
				if (!estado.estaVisitado(vecino)) {
					
					// Aplico los cambios que resultan de tomar esa decisión
					estado.getCaminoActual().agregarAlCamino(vecino);
					estado.setPosActual(vecino);
					estado.marcarVisitado(vecino);
					
					//No hay criterio de poda
						this.back(estado); // Llamo al backtracking
					
					// Deshago los cambios que resultaron de tomar esa decisión
					estado.getCaminoActual().quitarUltimo();
					estado.setPosActual(original);
					estado.desmarcarVisitado(vecino);
					
				}
						
			}
		}
	}
	
}
