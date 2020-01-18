
package BT;


public class BinaryTree {
	protected Node root;
  protected int  size;

	public BinaryTree(){
		size = 0;
	}

  public BinaryTree(String s){
		root = new Node(s);
		size = 1;
	}

	public int getSize(){ return this.size; }
	public Node getRoot(){ return this.root; }


	public boolean contains(String target){
		if( root == null ){ return false; }
		if( root.getData().equals(target) ){
			return true;
		}
		return false;
	}

	/** Computes the height of the binary tree
	  *
		* The height is the length of the longest path from
		* the root of the tree to any other node.
		*
		* @return the height of the tree
		*/
	public int height(){
	  if( root == null ){ return -1; }
		return heightRecursive(root);
	}
	protected static int heightRecursive(Node root){
			if( root == null ){
			  return -1;
			}
			int leftHeight = heightRecursive(root.getLeft());
			int rightHeight = heightRecursive(root.getRight());
			if( leftHeight < rightHeight){
				return 1 + rightHeight;
			}else{
			  return 1 + leftHeight;
			}
		}



}
