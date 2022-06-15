package ejercicio3_suma_de_numeros;

import java.util.ArrayList;

import original.Estado;

public class Backtracking {

	private Integer resultado;
	private Solucion solucion;
	
	public Solucion back(Numero origen, Integer resultado) {		
		this.resultado = resultado;
		this.solucion = new Solucion();
		
		// Generacion del estado inicial
		Estado2 estado = new Estado2();
		estado.getCaminoActual().agregarAlCamino(origen);
		estado.setPosActual(origen);
		estado.marcarVisitado(origen);
		
		// Llamo al bactracking desde ese estado incial
		this.back(estado);
				
		return this.solucion;
	}
	
	private void back(Estado2 estado) {
			
		if (estado.getSuma().equals(this.resultado)) { // Condicion de corte
			this.solucion.addValores(estado.getCaminoActual().getCamino());
		} else { // Sino
			
			ArrayList<Numero> vecinos = estado.getPosActual().getVecinos();
			
			Numero original = estado.getPosActual();
			
			for (Numero vecino: vecinos) { // Por cada posible decisión / hijo
				
				if (!estado.estaVisitado(vecino)) {
					
					// Aplico los cambios que resultan de tomar esa decisión
					estado.getCaminoActual().agregarAlCamino(vecino);
					estado.setPosActual(vecino);
					estado.marcarVisitado(vecino);
					
					if(!poda(estado))
						this.back(estado); // Llamo al backtracking
					
					// Deshago los cambios que resultaron de tomar esa decisión
					estado.getCaminoActual().quitarUltimo();
					estado.setPosActual(original);
					estado.desmarcarVisitado(vecino);
					
				}
						
			}
		}
	}
	
	private boolean poda(Estado2 estado) {
		return estado.getSuma() > this.resultado;
	}
	
}
