package ejercicio7ArbolBinario;

public class Main {

	public static void main(String[] args) {
		BinaryTree t = new BinaryTree(6);
		
		t.add(3);
		t.add(1);
		t.add(5);
		t.add(4);
		t.add(7);
		t.add(9);
		t.add(8);
		t.add(12);/**/
		
		t.printPreorder();
		System.out.print("\n");
		t.printPosOrder();
		System.out.print("\n");		
		t.printInOrder();
		
		System.out.print("\n");
		System.out.print(t.hasElem(4));System.out.print("\n");
		System.out.print(t.hasElem(5));System.out.print("\n");
		System.out.print(t.hasElem(9));System.out.print("\n");
		System.out.print(t.hasElem(7));System.out.print("\n");
		System.out.print(t.hasElem(10));System.out.print("\n");
		System.out.print(t.hasElem(2));System.out.print("\n");
		System.out.print(t.hasElem(3));
		
		System.out.print("\n");
		System.out.print(t.getHeight());
		System.out.print("\n");
		t.imprimir();
		
		System.out.print("\n");
		System.out.print("delete");
		System.out.print(t.delete(33));
		System.out.print(t.getHeight());
		System.out.print("\n");
		t.imprimir();
		
		System.out.print("\n");
		System.out.print(t.getMaxElem());
		
		System.out.print("\n");
		System.out.print(t.getElemAtLevel(2));
		
		System.out.print("\n");
		System.out.print(t.getFrontera());
		
		System.out.print("\n");
		System.out.print(t.getLongestBranch());
		
		
	}

}
