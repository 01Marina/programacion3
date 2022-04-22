package ejercicio2;

public class Iterate<T> implements  Iterator<T>{
	
	private Node<T> first, cursor;
	 
	 public Iterate(Node<T> first){
		 this.first = first;
		 this.cursor = null;
	 }

	@Override
	public void start() {
		this.cursor = this.first;
		
	}

	@Override
	public T get() {
		return this.cursor.getInfo();
	}

	@Override
	public void advance() {
		this.cursor = this.cursor.getNext();
		
	}

	@Override
	public boolean finish() {
		return this.cursor==null;
	}
 
}
