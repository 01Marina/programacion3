package ejercicio5_procesadores;

import java.util.ArrayList;

public class Procesador {
	private Integer id;
	private ArrayList<Tarea> tareas;
	private Double tiempoOcupado;
	
	public Procesador (Integer id) {
		this.id = id;
		this.tareas = new ArrayList<>();
		this.tiempoOcupado = 0.0;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public ArrayList<Tarea> getTareas(){
		return this.tareas;
	}
	
	public Double getTiempoOcupado() {
		return this.tiempoOcupado;
	}
	
	public void addTarea(Tarea t) {
		if(!this.tareas.contains(t)) {
			this.tiempoOcupado = this.tiempoOcupado + t.getTiempo();
			this.tareas.add(t);
		}
	}
	
	public Boolean equals(Procesador p) {
		return this.id.equals(p.getId());
	}
	
	public String toString() {
		return System.lineSeparator()+"Id procesador: "+this.id.toString()+System.lineSeparator()
		+ "Tiempo total:"+this.tiempoOcupado.toString()+System.lineSeparator()+
		this.tareas.toString()+System.lineSeparator();
	}


	public void setTiempoOcupado(Double tm) {
		this.tiempoOcupado = tm;
		
	}

	public Tarea removeTarea(int i) {
		this.tiempoOcupado = this.tiempoOcupado - this.tareas.get(i).getTiempo();
		return this.tareas.remove(i);
	}
	
}
