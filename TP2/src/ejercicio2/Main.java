package ejercicio2;


public class Main {

	public static void main(String[] args) {
		Pila<Integer> p = new Pila<Integer>();
		p.push(1);
		p.push(6);
		p.push(3);
		p.push(8);
		
		System.out.print(search(10, p.getFirst()));
		
		Pila<Integer> p2 = new Pila<Integer>();
		/*p2.push(8);
		p2.push(7);
		p2.push(6);
		p2.push(5);*/
		
		System.out.print(search2(p2, 10));
		
		
		int size = 4;
		int[] array = new int[size];
		
		array[0] = 10;
		array[1] = 2;
		array[2] = 82;
		array[3] = 3;
		
		System.out.print(searchArray(array, 3, 0));
	}
	
	//FUNCIÓN DE LA CONSIGNA 2 DEL TP2
	//en lista/pila DESORDENADA
	public static Integer search(Integer info, Node<Integer> first) {
		if(first == null) {
			return null;
		}
		if(first.getInfo() != info && first.getNext()==null){
			return null;
		}
		if(first.getInfo() != info) {
			return search(info, first.getNext());
		}else {
			return first.getInfo();
		}
	}
	//usando Iterador en Pila ordenada
	public static Integer search2(Pila<Integer> p, Integer x){
		Iterate<Integer> it = new Iterate<Integer>(p.getFirst());
		it.start();
		while(!it.finish()) {
			if(x<it.get()) {
				return null;
			}
			if(it.get()<x) {
				it.advance();
			}
			if(it.finish()) {
				return null;
			}
			if(it.get()==x) {
				return it.get();
			}
		}
		return null;
		
	}
	
	
	
	//en array DESORDENADO
	public static int searchArray(int [] array, int x, int pos) {
		if(pos<array.length-1 && array[pos]!= x) {
			return searchArray(array, x, pos+1);
		}else {
			if(array[pos]!= x) {
				return -1;
			}
			else{
				return array[pos];	
			}
		}
	}

}
