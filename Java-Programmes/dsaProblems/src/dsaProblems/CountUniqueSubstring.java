/*
 * Count Unique Substring Problem:
    Given a string of length n of lowercase alphabet characters,
    we need to count total number of distinct substring of this string.
    Example: 
    Input: str = "ababa"
    Output: 10
    Explaination: all distinct substring are = 
        "", "a", "b","ab","ba", "aba", "bab", "abab", "baba", "ababa"
 */
package dsaProblems;

public class CountUniqueSubstring {

    static int countTrieNodes(TrieNode root){
        if(root == null){
            return 0;
        }

        int count = 0;
        for(int i=0;i<root.children.length;i++){
            if(root.children[i] != null){
                count += countTrieNodes(root.children[i]);
            }
        }
        return count+1;
    }
    
    public static void main(String[] args) {
        String str = "ababa";
        Trie trie = new Trie();
        
        //creating trie for all suffix
        for(int i=0;i<str.length();i++){
            trie.insert(str.substring(i));
        }

        System.out.println(countTrieNodes(trie.root));
    }
}
/*
 * Approach:
 *  find  all unique prefix of all  suffix
 *  no. of unique substring = no. of nodes in trie
 * 
 *  class TrieNode{
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode(){
        children = new TrieNode[26];
        for(int i=0;i<children.length;i++){
            children[i] = null;
        }
        endOfWord = false;
    }
}

class Trie{
    TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode curr = root;
        
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
            if(i == word.length()-1){
                curr.endOfWord = true;
            }
        }
    }
}

 */