import java.util.*;

// define the cell node of the singly linked list
class Cell{ 
	private TreeNode node;  // value in the cell
	private Cell next;   // the address of the next cell in the list
	
    
	public Cell(TreeNode value, Cell link){
		node = value; //set value to the cell
		next = link;  // link the next cell to this cell
	}
	
	public TreeNode getVal(){
		return node;  // get the value of the cell
	}
	
	public Cell getNext(){
		return next;  // get the next cell
	}
	
    
	public void setNext(Cell link){
		next = link;  // set the next cell
	}

}



//implements a stack as a linked list using the Cell//
public class MyStack{ 
	private Cell top;  // set the top of the stack
	
	public MyStack(){ 
		top = null;  // create an empty stack
	}
	
    
	public void push(TreeNode ob){ 
		top = new Cell(ob, top); //insert Object ob and update the list or stack here
	}
	
  
	public TreeNode pop(){ 
		if ( top == null ){ 
			throw new RuntimeException("Stack error: stack empty. You input format is wrong or unbalanced. Please check."); 
		}
		TreeNode answer = top.getVal(); // Get the top Object and set it as answer
		top = top.getNext();  // set the top to the next one
		return answer; 
	}
	
	
   
	public TreeNode top(){ 
		if ( top == null ){ 
			throw new RuntimeException("Stack error: stack empty. You input format is wrong or unbalanced. Please check."); 
		}
		return top.getVal();  //get top object
	}
	
    
	public boolean isEmpty(){ 
		return (top == null);  //check empty stack
	}

  
}
