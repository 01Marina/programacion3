package ejercicio4_subparticion;

import java.util.ArrayList;

import original.Estado;

public class Backtracking {

	private Integer resultado;
	public Solucion solucion;
	private ArrayList<Numero> solucionParcial;
	
	public Backtracking(Integer suma) {
		this.resultado = suma;
	}
	
	public void back(Numero origen) {
		this.solucion = new Solucion();
		this.solucionParcial = new ArrayList<>();
		
		ArrayList<Numero> vecinos = origen.getVecinos();
		for(Numero vecino: vecinos) {
			Estado3 estadoV = new Estado3(vecino);
			estadoV.getCaminoActual().agregarAlCamino(vecino);
			estadoV.setPosActual(vecino);
			estadoV.marcarVisitado(vecino);
			this.back(estadoV);
		}
		
	}
	
	private void back(Estado3 estado) {
			
		if(!this.solucionParcial.contains(estado.getPosActual())) {
			this.solucionParcial.add(estado.getPosActual());
		}
		if(!this.solucion.contiene(this.solucionParcial)) 
			//if(igualSuma(this.solucionParcial))
				this.solucion.addValores(solucionParcial);
		
			
		ArrayList<Numero> vecinos = estado.getPosActual().getVecinos();
		
		Numero original = estado.getPosActual();
		
		for (Numero vecino: vecinos) { // Por cada posible decisión / hijo
			
			if (!estado.estaVisitado(vecino)) {
				// Aplico los cambios que resultan de tomar esa decisión
				
				estado.getCaminoActual().agregarAlCamino(vecino);
				estado.setPosActual(vecino);
				estado.marcarVisitado(vecino);
				
				//if(!poda(estado))
					this.back(estado); // Llamo al backtracking
				
				// Deshago los cambios que resultaron de tomar esa decisión
				
				estado.getCaminoActual().quitarUltimo();
				estado.setPosActual(original);
				estado.desmarcarVisitado(vecino);
				
			}
		}
		this.solucionParcial.remove(original);
	}
	
	private boolean igualSuma(ArrayList<Numero> sp) {
		Integer suma = 0;
		for(Numero n: sp) {
			suma = suma+n.getValor();
		}
		return suma == this.resultado;
	}

	
	
}
