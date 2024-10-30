import java.util.Stack;

public class StackExample1 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Stack st = new Stack(); //empty stack of type object
		st.push(0);
		System.out.println(st);
		st.add(1); //since stack inherit vector class so it inherit all methods of vector
		st.push('c');
		st.add("HANNI");
		System.out.println(st.peek());
		System.out.println(st);
		System.out.println("position of 1 from the top of the stack "+st.search(1));
		System.out.println(st.pop());
		System.out.println(st);
		
		System.out.println("position of 1 from the top of the stack "+st.search(1));
		
		System.out.println("---NEW STACK---\n");
		Stack<Character> stc = new Stack<Character>(); //empty stack of type character
		stc.push('h');
		stc.add('a');
		stc.push('n');
		stc.push('n');
		stc.add('i');
		System.out.println(stc.peek());
		System.out.println(stc);
		System.out.println("position of 'n' from the top of the stack "+stc.search('n'));
		System.out.println(stc.pop());
		System.out.println(stc);
		System.out.println("Is Empty? "+stc.isEmpty());
	}
}
