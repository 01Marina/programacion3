package ejercicio4_subparticion;

public class Main {

	public static void main(String[] args) {
		Backtracking b = new Backtracking(6);
		
		
		Numero n1 = new Numero(1);
		Numero n2 = new Numero(2);
		Numero n3 = new Numero(3);
//		Numero n4 = new Numero(4);
//		Numero n5 = new Numero(5);
//		Numero n6 = new Numero(6);
		
		n1.addVecino(n2);
		n1.addVecino(n3);
//		n1.addVecino(n4);
//		n1.addVecino(n5);
//		n1.addVecino(n6);
		
		n2.addVecino(n1);
		n2.addVecino(n3);
//		n2.addVecino(n4);
//		n2.addVecino(n5);
//		n2.addVecino(n6);
		
		n3.addVecino(n1);
		n3.addVecino(n2);
//		n3.addVecino(n4);
//		n3.addVecino(n5);
//		n3.addVecino(n6);
		
//		n4.addVecino(n1);
//		n4.addVecino(n2);
//		n4.addVecino(n3);
//		n4.addVecino(n5);
//		n4.addVecino(n6);
//		
//		n5.addVecino(n1);
//		n5.addVecino(n2);
//		n5.addVecino(n3);
//		n5.addVecino(n4);
//		n5.addVecino(n6);
//		
//		n6.addVecino(n1);
//		n6.addVecino(n2);
//		n6.addVecino(n3);
//		n6.addVecino(n4);
//		n6.addVecino(n5);
//		
		b.back(n1);
		
		System.out.println(b.solucion);

	}

}
