package ejercicio6ComparacionConIteradores;
import ejercicio5IteradorIterable.Iterate;
import ejercicio5IteradorIterable.Pila;

public class Main {

	public static void main(String[] args) {
		Pila<Integer> p1 = new Pila<Integer>();
		Pila<Integer> p2 = new Pila<Integer>();
		p1.push(4);
		p1.push(3);
		p1.push(2);
		p1.push(1);
		
		p2.push(10);
		p2.push(4);
		p2.push(3);
		p2.push(2);
		
		System.out.print(p1);
		System.out.print(p2);
		
		Pila<Integer> r = pilaValorComun(p1, p2);
		System.out.print(r);

	}
	
	public static Pila<Integer> pilaValorComun(Pila<Integer> p1, Pila<Integer>p2){
		Pila<Integer> pila = new Pila<Integer>();
		Iterate<Integer> it1 = new Iterate<Integer>(p1.getFirst());
		Iterate<Integer> it2 = new Iterate<Integer>(p2.getFirst());
		it1.start();
		it2.start();
		while(!it1.finish()) {//&& !it2.finish()
			if(it2.get()<it1.get()) {
				it2.advance();
			}
			if(it1.get()<it2.get()) {
				it1.advance();
			}
			if(it1.get()==it2.get()) {
				pila.push(it1.get());	
				it1.advance();
				it2.advance();
			}
		}
		return pila;
	}

}
