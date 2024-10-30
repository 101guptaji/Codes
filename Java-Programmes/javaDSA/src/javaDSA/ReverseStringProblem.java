package javaDSA;

class StackChar {
    int MAX_SIZE = 101;
    char[] a = new char[MAX_SIZE];
    int top = -1;

    void push(char ele) {
        if(top < MAX_SIZE){
            top++;
            a[top] = ele;
        }
        else{
            System.out.println("stack is full");
        }
    }
    

    char pop() {
        if(top >= 0){
            char ele = a[top];
            top--;
            return ele;
        }
        else{
            return ' ';
        }
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top >= MAX_SIZE;
    }
}
public class ReverseStringProblem {
	public static void main(String[] args) {
        String originalString = "Hello, World!";
        int stringLength = originalString.length();

        StackChar stack = new StackChar();

        // Push each character onto the stack
        for (int i = 0; i < stringLength; i++) {
            char c = originalString.charAt(i);
            stack.push(c);
        }

        // Pop the characters from the stack to construct the reversed string
        StringBuilder reversedString = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        System.out.println(reversedString.toString());
    }
}
