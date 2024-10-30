/*
 * Longest Word With all prefixes:
    Find the longest string in a dictionary of words such that 
    every prefix of it is also a word in dictionary.
    Note: If there are more than one word with longest length,
        return which comes lexicographically first.
    Example:
    Input: dict={"a","banana", "app", "appl", "apply","apple"}
    Output: "apple"
 */
package dsaProblems;

public class LongestWordWithAllPrefixes {
    
    public static String ans = "";
    public static void findLongestWord(TrieNode root, StringBuilder temp){
        if(root == null){
            return;
        }

        for(int i=0; i<26; i++) {
            if(root.children[i] != null && root.children[i].endOfWord) {
                temp.append((char)(i+'a'));
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }
                findLongestWord(root.children[i], temp);

                temp.deleteCharAt(temp.length()-1);
            }
        }
 
    }

    public static void main(String[] args) {
        String words[] = {"a","banana", "app", "appl", "ap", "apply","apple"};

        Trie trie = new Trie();
        for(int i=0;i<words.length;i++){   
            trie.insert(words[i]);
        }

        findLongestWord(trie.root, new StringBuilder(""));
        System.out.println(ans);
    }
}

/*
 * https://www.youtube.com/watch?v=m9zawMC6QAI&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&t=1h46m58s
 * 
 * class TrieNode{
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

 * 
 */
