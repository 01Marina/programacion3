package ejercicio7ArbolBinario;

public class TreeNode {
	private Integer value;
	private TreeNode left, right;
	
	TreeNode(Integer value){
		this.value = value;
		this.left = right = null;
	}
	
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public TreeNode getLeft() {
		return this.left;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	public TreeNode getRight() {
		return this.right;
	}
}
