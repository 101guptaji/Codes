import java.util.regex.*;

public class PatternClassExample {
	public static void main(String[] args) {
		//pattern for any alphabetical word of length 3
		Pattern p = Pattern.compile("[a-z]{3}", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher("how ARE you");
		
		while(m.find()) {
			System.out.println(m.start()+"-"+m.end()); //Output : 0-3, 4-7, 8-11
		}
		
		System.out.println("Flag is "+ p.flags());
		System.out.println(m.matches()); //false as the whole text does not matches with pattern. 
		System.out.println(m.groupCount()); //Output : 0
		
		System.out.println(p.pattern()); //Output :[a-zA-Z]{3}
		
		System.out.println(Pattern.matches("an[0-9]*","an101")); ////Output : true
	}
}
