package ejercicio3Pila;
import ejercicio1.Node;

public class Pila<T> {
	private Node<T> first;
	private int size;
	
	public Pila() {
		this.first = null;
		this.size = 0;
	}
	
	public void push(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public T pop() {		
		Node<T> extractFirst = this.first;
		if(!this.isEmpty()) {
			this.first = this.first.getNext();
			this.size--;
			return extractFirst.getInfo();
		}
		return null;
	}
	
	public T top() {
        return this.first.getInfo();
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
	
	public Pila<T> copy() {
    	Pila<T> pilaCopy = new Pila<T>();
    	pilaCopy.push(this.first.getInfo());
    	pilaCopy.first.setNext(this.first.getNext());
    	return pilaCopy;
    }
    
    public Pila<T> reverse() {
	    Pila<T> pilaCopy = this.copy();
	    Pila<T> pilaReverse = new Pila<T>();
	    while (!pilaCopy.isEmpty()) {
	    	pilaReverse.push(pilaCopy.pop());
    	}
    	return pilaReverse;
    }
	
	@Override
	public String toString() {
		String toString = "Pila"+System.lineSeparator();
		Node<T> temp = this.first;
		while(temp != null) {
			toString += temp.toString()+System.lineSeparator();
			temp = temp.getNext();
		}
		return toString;
	}
}
