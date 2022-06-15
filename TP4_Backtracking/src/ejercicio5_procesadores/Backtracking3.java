package ejercicio5_procesadores;

import java.util.ArrayList;
import java.util.Collections;


public class Backtracking3 {
	
	public ArrayList<ArrayList<Procesador>> soluciones = new ArrayList<>();
	public ArrayList<Procesador> solucion = new ArrayList<>();
	
	public void buscarAsignacionOptima(ArrayList<Tarea>tareas,ArrayList<Procesador>procesadores){
		
		back(tareas,procesadores);
	}

	private void back(ArrayList<Tarea> tareas, ArrayList<Procesador> procesadores) {
		ArrayList<Procesador> solucionParcial = new ArrayList<>();
		if(tareas.isEmpty()) { //asigne todas las tareas
			solucionParcial.addAll(procesadores);
			
			if(!this.solucion.isEmpty()) {
				if(this.resultadoOptimo(solucionParcial)) {
					this.cambiarSolucion(solucionParcial);
				}
			}else {
				this.cambiarSolucion(solucionParcial);
			}
			
			//this.copiarEnSoluciones(solucionParcial);
		}else {
			for (Procesador procesador : procesadores) {
				procesador.addTarea(tareas.remove(0));
			
				buscarAsignacionOptima(tareas,procesadores);
			
				
				tareas.add(procesador.removeTarea(procesador.getTareas().size()-1));
			}
		}
	}

	private void cambiarSolucion(ArrayList<Procesador> sp) {
		this.solucion = new ArrayList<>();
		for(Procesador p: sp) {
			Procesador np = new Procesador(p.getId());
			for(Tarea t: p.getTareas()) {
				Tarea nt = new Tarea(t.getId(), t.getTiempo());
				np.addTarea(nt);
			}
			solucion.add(np);
		}
		
	}

	private boolean resultadoOptimo( ArrayList<Procesador> solucionParcial) {
		Double t1 = tiempoMaximo(solucionParcial);
		Double t2 = tiempoMaximo(this.solucion);
		if(t1<t2) {
			return true;
		}
		return false;
	}

	private Double tiempoMaximo(ArrayList<Procesador> ps) {
		ArrayList<Double> tiempos = new ArrayList<>();
		for(Procesador p:ps) {
			tiempos.add(p.getTiempoOcupado());
		}
		return Collections.max(tiempos);
	}

//	private void copiarEnSoluciones(ArrayList<Procesador> sp) {
//		ArrayList<Procesador> ts = new ArrayList<>();
//		for(Procesador p: sp) {
//			Procesador np = new Procesador(p.getId());
//			for(Tarea t: p.getTareas()) {
//				Tarea nt = new Tarea(t.getId(), t.getTiempo());
//				np.addTarea(nt);
//			}
//			ts.add(np);
//		}
//		this.soluciones.add(ts);		
//	}
	
	
}
