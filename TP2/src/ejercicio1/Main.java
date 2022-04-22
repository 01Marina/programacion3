package ejercicio1;

public class Main {

		public static <T> void main(String[] args) {
			int size = 5;
			int[] array = new int [size];
			for(int i =0; i<size; i++) {
				array[i]=i;
			}
			array[4] = 0;
			for(int i =0; i<array.length; i++) {
				System.out.print(array[i]);
			}
			//System.out.print(arrayOrdenado2(array));
			
			System.out.print(arrayOrdenado(array, 0));
		 
		 
		}
		
		public static boolean arrayOrdenado(int[] array, int pos) {
			if(pos<array.length-1 && array[pos]>array[pos+1]) {
				return false;
			}else {
				if(pos>=array.length) {
					return true;
				}else{
					return arrayOrdenado(array, pos+1);	
				}
			}
		}
		
		
		public static boolean arrayOrdenado2(int[] array) {
			boolean ordenado = true;
			int pos = 0;
			while(ordenado && pos<array.length) {
				if(array[pos]>array[pos++]) {
					ordenado = false;
				}else {
					pos++;
				}
			}
			return ordenado;
		}
}
