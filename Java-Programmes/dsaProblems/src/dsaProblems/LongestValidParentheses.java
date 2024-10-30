/*
 * Problem:
 * Given a string str consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

	A parenthesis string is valid if:
	For every opening parenthesis, there is a closing parenthesis. Opening parenthesis must be closed in the correct order.
	Examples :
	Input: str = ((()
	Output: 2
	Explaination: The longest valid parenthesis substring is "()".
	
	Input: str = )()())
	Output: 4
	Explaination: The longest valid parenthesis substring is "()()".
 */
package dsaProblems;

import java.io.*;
import java.util.*;

class LongestValidParentheses{
  public static void main(String args[])throws IOException
  {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());
      while(t-- > 0){
          String str = in.readLine();
          
          System.out.println(maxLength(str));
      }
  }
  
  static int maxLength(String str){
      // code here
      Stack<Integer> st = new Stack<>();
      
      // push -1 to handle edge cases
      st.push(-1);
      
      // Initialize result
      int maxLength = 0;
      for(int i=0;i<str.length();i++){
          if(str.charAt(i) == '('){
              st.push(i);
          }
          else if(str.charAt(i) == ')'){
              st.pop();
              
              if(!st.isEmpty()){
                  maxLength = Math.max(maxLength, i-st.peek());
              }
              else{
                  st.push(i);
              }
          }
      }
      return maxLength;
  }
}

/*
* Approach:
* Stack Initialization:

	A stack stack is initialized and a value of -1 is pushed onto it. This serves as a sentinel value to handle edge cases.
	Iteration:
	
	The code iterates through each character in the input string str.
	For each character:
	If the character is an opening parenthesis '(', its index i is pushed onto the stack.
	If the character is a closing parenthesis ')':
	The top element is popped from the stack.
	If the stack is not empty, it means there's a corresponding opening parenthesis, and the length of the valid substring is calculated as i - stack.peek(). 
	This length is compared with the current maxLength and updated if necessary.
	If the stack is empty, it indicates an unbalanced parentheses sequence, so the current index i is pushed onto the stack.
	Maximum Length Calculation:
	
	After iterating through the entire string, the maxLength variable holds the length of the longest valid parentheses substring.
	Explanation:
	
	The stack is used to keep track of the indices of opening parentheses.
	When a closing parenthesis is encountered, the top index is popped to check for a corresponding opening parenthesis.
	If a corresponding opening parenthesis is found, the length of the valid substring is calculated.
	The -1 sentinel value helps handle cases where the first character is a closing parenthesis or there's no valid parentheses substring.
*/