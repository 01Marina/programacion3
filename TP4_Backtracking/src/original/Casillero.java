package original;

import java.util.ArrayList;

public class Casillero {

	private boolean norte;
	private boolean sur;
	private boolean este;
	private boolean oeste;
	private int x;
	private int y;
	private int valor;

	public ArrayList<Casillero> getVecinos() {
		// Devuelve las casillas vecinas a las que puede acceder este casillero
		return null;
	}

	public boolean isNorte() {
		return norte;
	}

	public void setNorte(boolean norte) {
		this.norte = norte;
	}

	public boolean isSur() {
		return sur;
	}

	public void setSur(boolean sur) {
		this.sur = sur;
	}

	public boolean isEste() {
		return este;
	}

	public void setEste(boolean este) {
		this.este = este;
	}

	public boolean isOeste() {
		return oeste;
	}

	public void setOeste(boolean oeste) {
		this.oeste = oeste;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
