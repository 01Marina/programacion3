package ejercicio2;

public interface Iterator<T> {
	void start();
	T get();
	void advance();
	boolean finish();
}
