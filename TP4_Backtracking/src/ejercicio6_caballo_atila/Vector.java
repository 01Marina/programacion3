package ejercicio6_caballo_atila;

public class Vector {
	private int x, y;
	
	public Vector (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "fila :" + y+ " columna: "+x;
	}
}
