package Strings;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String str = "abbcdedfga";
		int[] freq = new int[26];
		String newStr = "";
		for(char c : str.toCharArray()) {
			if(freq[c-'a'] == 0) {
				freq[c-'a']++;
				newStr += c;
			}
		}
		System.out.println(newStr);
	}

}
