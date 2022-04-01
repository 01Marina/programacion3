package ejercicio4IndexOf;

import ejercicio1.Node;

public class Lista<T> {
	private Node<T> first;
	private int size;
	
	public Lista() {
		this.first = null;
		this.size = 0;
	}
	
	public int indexOF(T info) {
		boolean find = false;
		int index = 1;
		Node<T> tmp = this.first;
		while(index < this.size && !find) {
			if(tmp.equals(info)) {
				find = true;
			}
			tmp = tmp.getNext();
			index++;
		}
		if(index == 0) {
			return -1;
		}
		return index;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public T extractFront() {		
		Node<T> extractFirst = this.first;
		if(extractFirst!=null) {
			this.first = extractFirst.getNext();
			this.size--;
			return extractFirst.getInfo();
		}
		return null;
	}

	public boolean isEmpty() {
		return this.first == null;
	}
	
	public T get(int index) {
		Node<T> temp = this.first;
		while(index > 1) {
			temp = temp.getNext();
			index--;
		}
		return temp.getInfo();
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
