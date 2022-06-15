package ejercicio6_caballo_atila;

public class Backtracking {
	
	public void Atila (Estado e, int nroPisada) { 
		e.marcar(nroPisada); 
		if (!e.HayMovimientos() ) { 
			if(nroPisada== e.cantPisadas() && e.vecinaOrigen()) {
				imprimirSolucion(e); 
			} else { 
				Estado sgte = null; 
				int nrohijo=1; 
				while (hijos(nrohijo, e, sgte)) { 
					if (sgte.esFactible() ) 
						Atila(sgte, nroPisada+1); 
						nrohijo++; 
					} 
				} 
		}
}

	private boolean hijos(int nrohijo, Estado e, Estado sgte) {
		// TODO Auto-generated method stub
		return false;
	}

	private void imprimirSolucion(Estado e) {
		// TODO Auto-generated method stub
		
	}
}
