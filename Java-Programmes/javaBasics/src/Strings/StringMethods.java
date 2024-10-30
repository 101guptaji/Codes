package Strings;

import java.util.Comparator;

public class StringMethods {

	public static void main (String[] args)
    {
        String s= "Gupta Himanshu Gupta";
        // or String s= new String ("GeeksforGeeks");
        
        // Returns the number of characters in the String.
        System.out.println("String length = " + s.length());

        // Returns the character at ith index.
        System.out.println("Character at 3rd position = "
                           + s.charAt(6));

        // Return the substring from the ith  index character
        // to end of string
        System.out.println("Substring: " + s.substring(6));

        // Returns the substring from i to j-1 index.
        System.out.println("Substring:  = " + s.substring(6,9));

        // Concatenates string2 to the end of string1.
        String s1 = "him";
        String s2 = "gupta";
        System.out.println("Concatenated string  = " +
                            s1.concat(s2));

        // Returns the index within the string
        // of the first occurrence of the specified string.
        String s4 = "Gupta Himanshu Gupta";
        System.out.println("Index of Him: " + 
                           s4.indexOf("Him"));

        // Returns the index within the string of the
        // first occurrence of the specified string,
        // starting at the specified index.
        System.out.println("Index of a: " + 
                           s4.indexOf('a',5));

        // Checking equality of Strings
        Boolean out = "Gupta".equals("gupta");
        System.out.println("Checking Equality:  " + out);
        out = "Gupta".equals("Gupta");
        System.out.println("Checking Equality:  " + out);

        out = "Gupta".equalsIgnoreCase("gUpTa");
        System.out.println("Checking Equality ignore case:" + out);
        
        //If ASCII difference is zero then the two strings are similar
        int out1 = s1.compareTo(s2);
        System.out.println("the difference between ASCII value is="+out1);
        
        // Converting cases
        String word1 = "GupTa";
        System.out.println("Changing to lower Case " +
                            word1.toLowerCase());

        // Converting cases
        String word2 = "guPTa";
        System.out.println("Changing to UPPER Case " + 
                            word2.toUpperCase());

        // Trimming the word
        String word4 = " Learn Share Learn ";
        System.out.println("Trim the word " + word4.trim());

        // Replacing characters
        String str1 = "gupta himanshu Gupta";
        System.out.println("Original String " + str1);
        String str2 = str1.replace('h' ,'d') ;
        System.out.println("Replaced h with d -> " + str2);
        

        for(char c: s.toCharArray()) {
        	System.out.print(c+" ");
        }
        System.out.println();
        
        System.out.println("Himanshu".contains("Him"));
        
        char[] cq = {'a', 'b','c','d','e','f','g','h','i'};
        System.out.println(String.copyValueOf(cq, 3, 5));
        
        System.out.println("guptaji".endsWith("ji"));
        
        for(byte b: "abcABC".getBytes()) {
        	System.out.print(b+" ");
        }
        System.out.println();
        
        char[] dst = new char[3];
        "himanshu".getChars(1, 3, dst, 1);
        System.out.println(dst);
        
        System.out.println("abc".hashCode());
        
        System.out.println("hima".indexOf(97));
        
        System.out.println("hamanata".lastIndexOf("a",4));
        
        System.out.println("hima".matches("h.*"));
        
        for(String str: "boo:and:foo".split("o")) {
        	System.out.print("\'"+str+" \'");
        }
        System.out.println();
        
        //CharSequence subSequence(int beginIndex, int endIndex): Returns a character sequence that is a subsequence of this sequence.
        System.out.println("abcde".subSequence(1, 3));
        
        System.out.println(String.valueOf(5.5));
    } 
}
