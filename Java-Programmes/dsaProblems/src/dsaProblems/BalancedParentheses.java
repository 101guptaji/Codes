package dsaProblems;

import java.util.Scanner;

public class BalancedParentheses {
	static class Stack{
        int MAX_SIZE =101;
         char[] a = new char[MAX_SIZE];
         int top =-1;
        
        void push(char val)
        {
            if(top<MAX_SIZE){
                top++;
                a[top] = val;
            }
            else{
                System.out.println("Stack is full");
            }
        }
        
        char pop()
        {
            if(top>=0){
                char val = a[top];
                top--;
                return val;
            }
            return ' ';
        }
        
        boolean is_empty() {
    	    return top == -1;
    	}
    }
    
    static boolean checkPara(String input){
        if(input.length() == 0)
            return true;
        if(input.length()%2 != 0)
            return false;
        Stack s = new Stack();
        for(int i=0;i<input.length();i++){
        	char x = input.charAt(i);
            if(x == '{' || x == '[' || x == '(')
            {
                s.push(input.charAt(i));   
            }
            else{
                char val = s.pop();
                if(x == '}'){
                    if(val != '{')
                        return false;
                }
                if(x == ']'){
                    if(val != '[')
                        return false;
                }
                if(x == ')'){
                    if(val != '(')
                        return false;
                }
            }
        }
        if(!s.is_empty()) {
        	return false;
        }
        return true;
    }
    
	public static void main(String []argh)
	{
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String input=sc.next();
			    //Complete the code
			    System.out.println(checkPara(input));
			}
		}
		
	}
}
