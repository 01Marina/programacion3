package ejercicio9Palindromo;

public class Main {
	
	//Verificar si una cadena de texto es palindroma (capicua)

	public static void main(String[] args) {
		System.out.print(palindroma("olor"));
	}
	
	public static boolean palindroma(String palabra) {
		boolean capicua = true;
		String[] array = palabra.split("");
		int i = 0;
		int tamanio = array.length;
		while(capicua && i < tamanio/2 && i <= tamanio-1) {
			if(!array[i].equals(array[(tamanio-1)-i])){
                capicua = false;
            }
            i++;
		}
		return capicua;
	}
}
