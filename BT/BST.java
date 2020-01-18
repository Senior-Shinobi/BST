    package BT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BST extends BinaryTree{
		protected String[] check;
		protected String[] array2;
	// You MUST have a zero argument constructor that
	// creates an empty binary search tree
	// You can can add code to this if you want (or leave it alone).
  // We will create all BSTs for testing using this constructor
  public BST(){super();}



  @Override
  public boolean contains(String s){ 
	return helperContains(s,this.root);
  }

	public boolean helperContains(String s,Node x){
		Boolean contain = false;
		if(x.getData().equals(s)){return true;}
		if(x.left!=null && contain==false){contain = helperContains(s,x.left);}
		if(x.right!=null && contain==false){contain = helperContains(s,x.right);}
		return contain;
	}

  
  public void add(String s){
	if(this.size == 0){
      this.root =  new Node(s); 
      this.size+=1;
      return;
     }
	 this.size+=1;
	  Node current = this.root;
	  
	  while(true){
		 if (s.compareTo(current.getData())<0){
          if (current.left==null){
            current.setLeft(new Node(s));
            return;
          }
        current = current.left;
        }  else {
          if (current.right==null){
            current.setRight(new Node(s));
            return;
          }
        current=current.right;
      }
	  }
	  
  }



  public boolean isValidBST(){ 
  check = new String[this.size];
  for(int i=0;i<check.length;i++){
	  check[i]="[REDACTED]";
  }
   fillArray(this.root); 
   
   for (int i = 0; i < check.length-1;i++){
    if (check[i].compareTo(check[i+1])>0){return false;}
   }
  return true;
 }

  public void fillArray(Node current){
	  if(current==null){return;}
	  fillArray(current.left);
	  int i = 0;
	  while (!(check[i].equals("[REDACTED]"))){i++;}
	  check[i]=current.getData();
	  fillArray(current.right);
  }
  
  public void helpmake(Node current){
	  if(current==null){return;}
	  helpmake(current.left);
	  int i = 0;
	  while (!(array2[i].equals("[REDACTED]"))){i++;}
	  array2[i]=current.getData();
	  helpmake(current.right);
  }
  
 public Node setmake(int l, int r){
  if (l>r){
    return null;
  }

  int m = ((l+r)/2);

  Node current = new Node(array2[m]);

  current.left=setmake(l,m-1);
  current.right=setmake(m+1,r);

  return current;
}

  public BST makeBalanced(){
	BST bst = new BST();
    Node current = this.root;

     array2 = new String[this.size];

    for (int j = 0; j< array2.length;j++){
      array2[j] = "[REDACTED]";
    }

    helpmake(current);

    bst.root = setmake(0,array2.length-1);

    return bst;
  }

  public void PrintTreeINOR(Node c){
    if (c == null){return;}
    PrintTreeINOR(c.left);
    System.out.println(c.data);
    PrintTreeINOR(c.right);

  }

  public static void main(String[] args){
    BST t = new BST();
    String filename = System.getProperty("user.dir") + "\\"+"BT"+ "\\" +args[0];
    System.out.println(filename);
    System.out.println();
      if (args[0].contains(".txt")){
        try {
          FileReader reader = new FileReader(filename);
          BufferedReader br = new BufferedReader(reader);
          String line;
          while ((line = br.readLine()) != null){
            
            t.add(line);
          }
          reader.close();
        } catch (IOException e) {
          System.out.println("File not found.");
        }
        t.PrintTreeINOR(t.getRoot());
        System.out.println("height = " + t.height() + ",  size = " + t.getSize()+"\n");
        System.out.println();
        System.out.println("balancing tree");
        t = t.makeBalanced();
        System.out.println();
        t.PrintTreeINOR(t.getRoot());
        System.out.println("height = " + t.height() + ",  size = " + t.getSize()+"\n");
      } else {
        System.out.println("list a file in the command line");

      }

  }

}
