package ejercicio8ListaDobleVinculada;

public class Lista<T> {
	private Node<T> first;
	private int size;
	
	public Lista() {
		this.first = null;
		this.size = 0;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null, null);
		tmp.setNext(this.first);
		this.first.setprev(tmp);
		this.first = tmp;
		this.size++;
	}
	
	public T extractFront() {		
		Node<T> extractFirst = this.first;
		if(!this.isEmpty()) {
			this.first.getNext().setprev(null);
			this.first = first.getNext();
			this.size--;
			return extractFirst.getInfo();
		}
		return null;
	}

	public boolean isEmpty() {
		return this.first == null;
	}
	
	public T get(int index) {
		if(index > this.size || index <0) {
			return null;
		}
		Node<T> temp = this.first;
		while(index > 1) {
			temp = temp.getNext();
			index--;
		}
		return temp.getInfo();
	}
	
	public T get2(int index, Node<T> first) {
		int n = index--;
		if(n!=0) {
			return this.get2(n, first.getNext());
		}else {
			return first.getInfo();
		}
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		String toString = "";
		Node<T> temp = this.first;
		while(temp != null) {
			toString += temp.toString()+System.lineSeparator();
			temp = temp.getNext();
		}
		return toString;
	}
}
