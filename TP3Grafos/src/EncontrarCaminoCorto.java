
import java.util.ArrayList;

public class EncontrarCaminoCorto {

	private Grafo<?> grafo;

	public EncontrarCaminoCorto(Grafo<?> grafo) {
		this.grafo = grafo;
	}
	
	public ArrayList<Integer> caminoMasCorto(int origen, int destino) {
		
		ArrayList<Integer> caminoMasCorto = new ArrayList<>();

		EncontrarCaminos e = new EncontrarCaminos(this.grafo);
		
		ArrayList<ArrayList<Integer>> c = e.encontrarCaminos(origen, destino);
		
		if(!c.isEmpty()) {
			caminoMasCorto.addAll(c.get(0));
		
			for(ArrayList<Integer> cc: c) {
				if(cc.size() < caminoMasCorto.size() ) {
					caminoMasCorto.clear();
					caminoMasCorto.addAll(cc);
				}
			}
		}
		
		return caminoMasCorto;
		
	}
	
}