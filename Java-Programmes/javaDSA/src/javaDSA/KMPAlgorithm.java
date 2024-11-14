/*
 * KMP Pattern Searching Algorithm:
    The Knuth-Morris-Pratt (KMP) algorithm is a string-searching algorithm which is used to find a pattern within large texts efficiently. Unlike naive pattern searching algorithm which starts from the beginning of the pattern after each mismatch, KMP uses the structure of the pattern to avoid redundant comparisons. It preprocesses the pattern string and creates an array called the Longest Prefix Suffix (lps) array which indicates how much of the pattern can be reused after a mismatch.

    LPS Array
    LPS is the Longest Proper Prefix which is also a Suffix. A proper prefix is a prefix that doesn’t include whole string. For example, prefixes of “abc” are “”, “a”, “ab” and “abc” but proper prefixes are “”, “a” and “ab” only. Suffixes of the string are “”, “c”, “bc”, and “abc”.
    Each value, lps[i] is the length of longest proper prefix of pat[0..i] which is also a suffix of pat[0..i].

    Implementation of KMP Algorithm
    We initialize two pointers, one for the text string and another for the pattern. 
    When the characters at both pointers match, we increment both pointers and continue the comparison. 
    If they do not match, we reset the pattern pointer to the last value from the LPS array, because that portion of the pattern has already been matched with the text string. 
    Similarly, if we have traversed the entire pattern string, we add the starting index of occurrence of pattern in text, to the result and continue the search from the lps value of last element of the pattern.
 */
package javaDSA;

import java.util.ArrayList;

// Java program to search the pattern in given text using KMP Algorithm
class KMPAlgorithm {
    
    static void constructLps(String pat, int[] lps) {
        
        // len stores the length of longest prefix which 
        // is also a suffix for the previous index
        int len = 0;

        // lps[0] is always 0
        lps[0] = 0;

        int i = 1;
        while (i < pat.length()) {
            
            // If characters match, increment the size of lps
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            
            // If there is a mismatch
            else {
                if (len != 0) {
                    
                    // Update len to the previous lps value 
                    // to avoid redundant comparisons
                    len = lps[len - 1];
                } 
                else {
                    
                    // If no matching prefix found, set lps[i] to 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    static ArrayList<Integer> search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();

        int[] lps = new int[m];
        ArrayList<Integer> res = new ArrayList<>();

        constructLps(pat, lps);

        // Pointers i and j, for traversing 
        // the text and pattern
        int i = 0;
        int j = 0;

        while (i < n) {
            // If characters match, move both pointers forward
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                // If the entire pattern is matched 
                // store the start index in result
                if (j == m) {
                    res.add(i - j);
                    
                    // Use LPS of previous index to 
                    // skip unnecessary comparisons
                    j = lps[j - 1];
                }
            }
            
            // If there is a mismatch
            else {
                
                // Use lps value of previous index
                // to avoid redundant comparisons
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return res; 
    }

    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba"; 
        String pat = "aaba"; 

        ArrayList<Integer> res = search(pat, txt);
        for (int i = 0; i < res.size(); i++) 
            System.out.print(res.get(i) + " ");
    }
}
