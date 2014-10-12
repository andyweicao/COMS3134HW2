import java.util.*;

// quite straightforward, set node in the expression tree
public class TreeNode{
	TreeNode left; // left node
	TreeNode right; // right node
	char data; // data in the node
	
	public TreeNode(){}
		
	public TreeNode(char c){
		this.data = c; // set data in the node
	}
	
	public char getVal(){
		return data; // get node content
	}
	
	// following methods are easy to understand.
	public boolean hasChild(){
		if(left == null&& right == null)
			return false;
		else
			return true;
	}
	
	public boolean hasLeft(){
		if (left == null)
			return false;
		else 
			return true; 
	}
	
	public boolean hasRight(){
		if (right == null)
			return false;
		else 
			return true; 
	}
	
	public void removeLeft(){
		left = null;
	}
	
	public void removeRight(){
		right = null;
	}
}