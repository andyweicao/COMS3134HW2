import java.util.*;


public class ExpTree{
	
	public TreeNode expression(String s){
		MyStack stack = new MyStack(); //initialize the stack
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(ch>='0'&&ch<='9'){ //push operand into the stack one by one
				TreeNode node = new TreeNode(ch);
				stack.push(node); 
			}
			else if ((ch == '+')||(ch == '-')||(ch == '*')||(ch == '/')){ // if the node is a operator node
				TreeNode a = new TreeNode();
				TreeNode b = new TreeNode();
				//pop out previous two operands and use this operator to connect the operands
				TreeNode root = new TreeNode(ch);
				a = stack.pop();
				b = stack.pop();
				root.left = b;
				root.right = a;
				stack.push(root); // push the tree back to stack
			}
			else {			
				throw new RuntimeException("Error: Wrong operands or operators detected. Please check!"); 
			}			
							
		}
		TreeNode finish = new TreeNode();
		finish	= stack.pop(); // pop out the final expression tree
		if(!stack.isEmpty()){ // if the stack is not empty now, the input postfix expression is unbalanced.
			throw new RuntimeException("You entered more operands. Please check your input.");
		}
		return finish;
		
		
	}
}