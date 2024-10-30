/*
 * Word Break Problem:
    Given an input string and a dictionary of words, 
    find out if the input string can be broken into a space-
    seperated sequence of dictionary words.
    Example:
    Input: 
        words[] = {i,like,sam,samsung,mobile,ice}
        key = "ilikesamsung"
    Output: true
 */
package dsaProblems;

class TrieNode{
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
    public TrieNode root = new TrieNode();

    public void insert(String word){
        TrieNode curr = root;
        
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];

        }
        curr.endOfWord = true;
    }
}

public class WordBreakProblemUsingTrie {

    //TC: O(L) where L = length of key
    static boolean findKey(TrieNode root, String key){
        if(root == null){
            return false;
        }

        TrieNode curr = root;
        for(int i=0;i<key.length();i++){
            int index = key.charAt(i)-'a';

            if(curr.endOfWord && curr.children[index] == null){
                return findKey(root, key.substring(i));
            }

            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];

            if(i == key.length()-1){
                return curr.endOfWord;
            }
            
        }
        return true;
    }

    public static void main(String[] args) {

        String words[] = {"i","like","sam","samsung","mobile","ice"};
        String key = "ilikesamsung";

        Trie trie = new Trie();

        for(String word : words){   
            trie.insert(word);
        }

        System.out.println(findKey(trie.root, key));
        
    }
}
