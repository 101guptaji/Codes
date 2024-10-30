package Strings;

public class FirstLastOccurance {

	public static void main(String[] args) {
		String str = "axgfdo dox ox oxbow";
		char ele = 'x';
		int first = -1, last = -1;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == ele) {
				if(first == -1) {
					first = i;
				}
				else {
					last = i;
				}
			}
		}
		System.out.println("First and Last occurance of "+ele+" is "+first+", "+last );
	}

}
