package ejercicio3Pila;

public class Main {

		public static <T> void main(String[] args) {
			Pila<Integer> p = new Pila<Integer>();
			Integer e = 1;
			Integer s = 2;
			Integer d = 3;
			Integer f = 4;
			
			p.push(e);
			p.push(s);
			p.push(d);
			p.push(f);
			System.out.print(p);
			
			Pila<Integer> reverse = p.reverse();
			System.out.print(reverse);
			
			System.out.print("  ");
			System.out.print(reverse.top());
			System.out.print(reverse.pop());
			System.out.print(reverse);
		}
}
