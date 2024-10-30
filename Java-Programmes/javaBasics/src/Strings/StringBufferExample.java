package Strings;

public class StringBufferExample {
	
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.capacity()); // default 16
		sb.append("Hello");
		
		sb.append(false);
		System.out.println(sb);
		sb.insert(1, 41.3d);
		System.out.println(sb);
		
		sb.repeat('z', 5);
		System.out.println(sb);
		
		sb.replace(1, 5, "$&@");
		System.out.println(sb);
		
		sb.delete(1, 4);
		System.out.println(sb);
		
		System.out.println(sb.reverse());
		System.out.println("Length "+sb.length());
		System.out.println(sb.capacity()); // Now (16*2)+2=34     i.e (oldcapacity*2)+2
	}
}
