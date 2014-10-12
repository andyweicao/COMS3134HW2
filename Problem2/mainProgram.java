import java.util.*;
import java.io.*;
import javax.swing.JOptionPane; // program uses JOptionPane
import javax.swing.UIManager;

  


public class mainProgram{
	
	// set the prefix from the expression tree
	public void prefix(TreeNode t,StringBuilder sb){
		while(t != null){
			sb.append(t.data).append(" ");
			
			prefix(t.left,sb);
			t = t.right;
		}
	}
	
	// set the infix from the expression tree
	public void infix(TreeNode t,StringBuilder sb){
		if(t != null){
			if(t.hasChild())
				sb.append("(").append(" ");
			
			infix(t.left,sb);
			sb.append(t.data).append(" ");
			infix(t.right,sb);
			
			if(t.hasChild())
				sb.append(") ");
		}
	}
	
	// evaluate the value of the expression
	public double evaluate(TreeNode t){
		double value; // set the value
		
		if(!t.hasChild())
			value = (double)(t.data-'0'); // every leaf is a operand, don't need to make calculation
		else{ // if the node is a operator
			double left,right;
			char operator = t.data;
			left = evaluate(t.left); // get left value
			right = evaluate(t.right); // get right value
			// make calculation
			switch(operator){
				case '+': value = left + right; break;
				case '-': value = left - right; break;
				case '*': value = left * right; break;
				case '/': value = left / right; break;
				default: System.out.println("Unrecognized operator: " + operator);value = 0; break;
			}
		}
		
		return value;
		
		
	}
	
	
	
	public static void main(String[] args)throws IOException{
		String input;
		mainProgram anw = new mainProgram();
		while(true){
	    	
			
			UIManager.put("OptionPane.cancelButtonText", "Close");// Press close to close the program
			UIManager.put("OptionPane.okButtonText", "Enter");
			// set input window
	        input =                                      
	               (String)JOptionPane.showInputDialog(null, "Enter your postfix:","Postfix Converter",
					   JOptionPane.QUESTION_MESSAGE);
			
			UIManager.put("OptionPane.okButtonText", "OK");
			
			if(input ==null){return;}
			else if(input.equals("")){
				JOptionPane.showMessageDialog(null,"You entered nothing!","Warning",JOptionPane.WARNING_MESSAGE);
				
			}
			else{
				try { 
					input.replaceAll("\\s+",""); // remove spaces 	
					ExpTree tree = new ExpTree(); // set new expression tree
					TreeNode result = tree.expression(input); //  get the result treenode
			
					
					StringBuilder pre = new StringBuilder();
					anw.prefix(result,pre); // get prefix result
					//System.out.println("prefix: "+pre.toString());
			
					
					StringBuilder infi = new StringBuilder();
					anw.infix(result,infi); // get infix result
					//System.out.println("Infix: "+infi.toString());
			
					
					double answer = anw.evaluate(result); // calculate the value
					//System.out.println("The final answer is " + answer + ".");
					
					// display the results
					JOptionPane.showMessageDialog( null, "The result is " + answer + "\n"+ "The prefix expression is: " + 
						pre.toString() + "\n" + "The infix expression is: " + infi.toString(),
							"Sum of Two Integers",  JOptionPane.PLAIN_MESSAGE );
				}
				catch (Exception e) { 
			             JOptionPane.showMessageDialog(null, "You input format is wrong! Please CHECK! \n Possible errors:\n" +
							 "1. Unbalanced expression of operands and operators.\n" + 
								 "2. Wrong character detected. ( neither operands(0-9) nor operators(+-*/) )\n"+
								 "3. Wrong order of operands and operators.",
			                  "Warning",JOptionPane.WARNING_MESSAGE); // catch all possible exceptions
					 }
				 }  
		
		}
	}
}