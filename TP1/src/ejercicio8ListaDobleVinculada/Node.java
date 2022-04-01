package ejercicio8ListaDobleVinculada;


public class Node<T> {

	private T info;
	private Node<T> prev;
	private Node<T> next;

	public Node() {
		this(null,null, null);
	}
	
	public Node(T info,Node<T> prev, Node<T> next) {
		this.setInfo(info);
		this.setprev(prev);
		this.setNext(next);
	}
	
	public Node<T> getPrev() {
		return prev;
	}

	public void setprev(Node<T> prev) {
		this.prev = prev;
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
		return this.info.equals(node.getInfo()) && this.next == node.getNext() && this.prev==node.getPrev();
	}

}
