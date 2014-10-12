import java.util.*;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;

public class FindPalindromes {

    public static void main(String[] args) throws FileNotFoundException,IOException {
		
		File file = new File(args[0]); //input txt file
		FileReader fileReader = new FileReader(file); // read the file
		BufferedReader br = new BufferedReader(fileReader);
		String line; // set String for each line
		int all = 0; // used to count how many lines in the txt file
		int count=0; // used to count palindrome lines
		while ((line = br.readLine()) != null) {
		   // process each line.
		   all++; // count the line
           MyStack stack = new MyStack(); // set the new stack for this line
		   String inputString = line.replaceAll("[^a-zA-Z ]", "").toLowerCase(); // set all letters to lowercase
		   inputString = inputString.replaceAll(" ",""); //  remove all the spaces in the string
		   
		   // push all the chars in the string line to the stack
           for (int i = 0; i < inputString.length(); i++) {
               stack.push(inputString.charAt(i));
           }
		   
		   // initialize the reverseString
           String reverseString = "";
		   
		   // pop out the stack and set to reverseString
           while (!stack.isEmpty()) {
               reverseString = reverseString+stack.pop();
           }
		   
		   // check if it is a palindrome
           if (inputString.equals(reverseString)){
               System.out.println( '"' + line + '"' + " is a palindrome.");
			   count++;
		   
		   }
		   
		}
		br.close();
		
		System.out.println(" ");
		System.out.println("Total line # is " + all + " and total palindrome # is " + count + ".");
	
    }
}