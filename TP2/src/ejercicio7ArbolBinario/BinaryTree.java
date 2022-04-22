package ejercicio7ArbolBinario;


public class BinaryTree {
	private TreeNode root;
	
	BinaryTree(){
		this.root = null;
	}
	
	BinaryTree(Integer value){
		this.root = new TreeNode(value);
	}
	
	public void add(Integer value) {
		if (this.root == null) {
			this.root = new TreeNode(value);
		}else {
			this.add(this.root,value);
		}
	}
	
	private void add(TreeNode node, Integer value) {
		if (node.getValue() > value) {
			if (node.getLeft() == null) {
				TreeNode temp = new TreeNode(value);
				node.setLeft(temp);
			} else {
				add(node.getLeft(),value);
			}
		} else if (node.getValue() < value) {
			if (node.getRight() == null) {
				TreeNode temp = new TreeNode(value);
				node.setRight(temp);
			} else {
				add(node.getRight(),value);
			}
		}
	}
	
	public Integer getRoot() {
		return this.root.getValue();
	}
	
	public boolean hasElem(Integer value) {
		return hasElement(this.root, value);
	}
	
	private boolean hasElement(TreeNode node, Integer value) {
		if(node == null) {
			return false;
		}else if (node.getValue() > value) {
			return hasElement(node.getLeft(),value);
		}else if (node.getValue() < value){
			return hasElement(node.getRight(),value);
		}
		return true;
	}
	
	public boolean isEmpty() {
		return this.root == null;
	}
	
	public boolean delete(Integer value) {
		return delete(this.root, null, value);
	}

	private boolean delete(TreeNode node,TreeNode father, Integer value) {
		if(node == null) {
			return false;
		}else {
			if (node.getValue() > value) {
				return delete(node.getLeft(), node, value);
			}else if (node.getValue() < value) {
				return delete(node.getRight(), node, value);
			}else {//acá value es igual al valor del nodo
				if (node.getLeft() != null && node.getRight() != null) {
					//busco el izquierdo más grande (hoja)
		            TreeNode maxLeft = maxLeft(node.getLeft());
		            //cambio valor al mayor izquierdo
		            node.setValue(maxLeft.getValue());
		            //elimino de su posición original al mayor izquierdo
		            delete(maxLeft, node, maxLeft.getValue());
		        } else if (node.getLeft() != null) {
		            node.setValue(node.getLeft().getValue());
		            delete(node.getLeft(),node, node.getLeft().getValue());
		        } else if (node.getRight() != null) {
		        	node.setValue(node.getRight().getValue());
		            delete(node.getRight(), node, node.getRight().getValue());
		        } else {//si es nodo hoja
		        	if(father.getLeft().getValue() == node.getValue()) {
		    			father.setLeft(null);
		    		}else {
		    			father.setRight(null);
		    		}
		        }
				return true;
			}
		}
	}

	private  TreeNode maxLeft(TreeNode node) {
	    if (node.getRight() == null) {
	        return node;
	    } else {
	        return maxLeft(node.getRight());
	    }
	}
	
	public void printPreorder() {
		printPreorder(this.root);
	}
	
	private void printPreorder(TreeNode node){
		if (node == null) {
			System.out.print("-");
		}else {
			System.out.print(node.getValue() + " ");
			printPreorder(node.getLeft());
			printPreorder(node.getRight());
		}
		
	}
	public void printPosOrder() {
		printPosOrder(this.root);
	}
	private void printPosOrder(TreeNode node) {
		if (node == null) {
			System.out.print("-");
		}else {
			printPreorder(node.getLeft());
			printPreorder(node.getRight());
			System.out.print(node.getValue() + " ");
		}
	}
	
	public void printInOrder() {
		printInOrder(this.root);
	}

	private void printInOrder(TreeNode node) {
		if (node == null) {
			System.out.print("-");
		}else {
			printPreorder(node.getLeft());
			System.out.print(node.getValue() + " ");
			printPreorder(node.getRight());
		}
	}
	public int getHeight() {
		return getHeight(this.root);
	}
	
	private int getHeight(TreeNode node) {
		if (node == null ||(node.getLeft() == null && node.getRight() == null)) {
		    return 0; 
		} else if (node.getLeft() == null) {
			return 1 + getHeight(node.getRight());
		} else if (node.getRight() == null) {
			return 1 + getHeight(node.getLeft());
		} else {
			return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
		}
	}
	
	public Integer getMaxElem() {
		return getMaxElement(this.root);
	}
	private Integer getMaxElement(TreeNode node) {
		if(node == null) {
			return null;
		}else if(node.getRight() != null) {
			return getMaxElement(node.getRight());
		}else {
			return node.getValue();
		}
	}
	
	public List<Integer> getElemAtLevel(int level) {
		return getElemAtLevel(new List<Integer>(),this.root, 0, level);
	}

	private List<Integer> getElemAtLevel(List<Integer> list, TreeNode node, int level, int inLevel) {
		if(node !=null){
			if(level == inLevel) {
				list.push(node.getValue());
			}
        	getElemAtLevel(list, node.getLeft(),level+1, inLevel);
        	getElemAtLevel(list, node.getRight(),level+1, inLevel);
        }
		return list;
	}
	
	public List<Integer> getFrontera(){
		return getFrontera(new List<Integer>(),this.root);
	}
	private List<Integer> getFrontera(List<Integer> list, TreeNode node) {
		if(node !=null){
			if(node.getLeft() == null && node.getRight() == null) {
				list.push(node.getValue());
			}
			getFrontera(list, node.getLeft());
			getFrontera(list, node.getRight());
        }
		return list;
	}

	public List<Integer> getLongestBranch(){
		return getLongestBranch(new List<Integer>(), new List<Integer>(),this.root, 0, this.getHeight());
	}

	private List<Integer> getLongestBranch(List<Integer> list,List<Integer> listAux, TreeNode node,int level, int height) {
		if(node !=null){
			listAux.push(node.getValue());
        	if(level == height && node.getLeft() == null && node.getRight() == null) {
        		//listAux = listAux.reverse();
        		while (!listAux.isEmpty()) {
        	    	list.push(listAux.pop());
            	}
        		if(!hasElem(this.root.getValue())) {
        			list.push(this.root.getValue());
        		}
        		//list.push(-1);
			}else if (level != height && node.getLeft() == null && node.getRight() == null){
				int i = height - level;
				while (i !=0) {
        	    	listAux.pop();
        	    	i--;
            	}
			}
        	getLongestBranch(list,listAux, node.getLeft(),level+1, height);
        	getLongestBranch(list,listAux, node.getRight(),level+1, height);
        }
		return list;
	}

	private void imprimirEntreConNivel(TreeNode tmp, int nivel){
        if(tmp !=null){
        	System.out.println(tmp.getValue() + "("+nivel+") - ");
            imprimirEntreConNivel(tmp.getLeft(),nivel+1);
 
                    imprimirEntreConNivel(tmp.getRight(),nivel+1);
        }
    }
	 
	public void imprimir(){
		imprimirEntreConNivel(this.root,0);
		System.out.println();
	}
}
