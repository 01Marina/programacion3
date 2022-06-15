package ejercicio5_procesadores;

public class Tarea {
	private Integer id;
	private Double tiempo;
	
	public Tarea(int id, Double tiempo) {
		this.id = id;
		this.tiempo = tiempo;
	}
	
	public Double getTiempo() {
		return this.tiempo;
	}
	public String toString() {
		return "Tarea: "+ this.tiempo.toString()+ "    ";
	}
	
	public Boolean equals(Tarea t) {
		return this.id.equals(t.getId());
	}

	Integer getId() {
		return this.id;
	}
	
}
