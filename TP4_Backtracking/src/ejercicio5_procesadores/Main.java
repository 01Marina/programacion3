package ejercicio5_procesadores;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		Procesador p1 = new Procesador(1);
		Procesador p2 = new Procesador(2);
		Procesador p3 = new Procesador(3);
		Procesador p4 = new Procesador(4);
		Procesador p5 = new Procesador(5);


		
		Tarea t1 = new Tarea(1, 23.0);
		Tarea t2 = new Tarea(2, 80.0);
		Tarea t3 = new Tarea(3, 56.0);
		Tarea t4 = new Tarea(4, 2.0);
		Tarea t5 = new Tarea(5, 88.0);
		Tarea t6 = new Tarea(6, 1.0);
		Tarea t7 = new Tarea(7, 21.0);
		Tarea t8 = new Tarea(8, 12.0);
		Tarea t9 = new Tarea(9, 1.0);
		Tarea t10 = new Tarea(10, 0.5);
		
		ArrayList<Tarea> ts = new ArrayList<>();
		ts.add(t1);
		ts.add(t2);
		ts.add(t3);
//		ts.add(t4);
//		ts.add(t5);
//		ts.add(t6);
//		ts.add(t7);
//		ts.add(t8);
//		ts.add(t9);
//		ts.add(t10);
//		
		
		
		
		ArrayList<Procesador> prr = new ArrayList<>();
		prr.add(p1);
		prr.add(p2);
		prr.add(p3);
		
		Backtracking3 b3 = new Backtracking3();
		
		b3.buscarAsignacionOptima(ts, prr);
		
		System.out.println(b3.solucion);
		

	}

}
