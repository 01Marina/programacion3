package ejercicio3;

public class Main {

	public static void main(String[] args) {
		
		System.out.print(decimalBinario(4, ""));

	}
	
	public static String decimalBinario(int decimal, String binario) {
		if(decimal>0) {
			binario = decimal%2+binario;
			return decimalBinario(decimal/2, binario);
		}
		return decimal%2+binario;
	}

}
