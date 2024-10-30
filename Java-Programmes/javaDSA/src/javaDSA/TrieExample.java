/*
 * Trie Data Structure:
    - Prefix tree
    - digital search
    - Retrieval tree
    - faster search
    - Time complexity: O(L) where L is length of words

    class Node{
        Node[] children; //26 alphabets
        boolean endOfWord;
    }

    https://www.youtube.com/watch?v=m9zawMC6QAI&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=38

 */
package javaDSA;

public class TrieExample {

    static class TrieNode{
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

    static class Trie{
        TrieNode root = new TrieNode();

        public void insert(String word){
            if(root == null){
                root = new TrieNode();
            }

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

        //searching
        //TC: O(L) where L is length of word
        boolean contains(String word){
            if(root == null){
                return false;
            }

            TrieNode curr = root;
            for(int i=0;i<word.length();i++){
                int index = word.charAt(i)-'a';
                if(curr.children[index] == null){
                    return false;
                }
                curr = curr.children[index];
                if(i == word.length()-1){
                    return curr.endOfWord;
                }
            }
            return true;
        }

        //function to check if there is any word in dictiorary that starts with prefix
        boolean startsWith(String prefix){
            TrieNode curr = root;
            for(int i=0;i<prefix.length();i++){
                int index = prefix.charAt(i)-'a';
                if(curr.children[index] == null){
                    return false;
                }
                curr = curr.children[index];
            }
            return true;
        }
    }
    
    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their","any"};
        Trie trie = new Trie();

        for(String word : words){   
            trie.insert(word);
        }

        if(trie.contains("the")){
            System.out.println("found");
        }
        else{
            System.out.println("Not found");
        }

        System.out.println(trie.startsWith("the"));
    }
}
