package ejercicio7ArbolBinario;

public class Node<T> {

	private T info;
	private Node<T> next;

	public Node() {
		this(null);
	}
	public Node(T info) {
		this(info, null);
	}
	
	public Node(T info, Node<T> next) {
		this.setInfo(info);
		this.setNext(next);
	}
	
	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}
	
	public String toString() {
		return this.info.toString();
	}
	
	public boolean equals(Node<T> node) {
		return this.info.equals(node.getInfo()) && this.next == node.getNext();
	}

}
