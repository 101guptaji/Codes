/*
 * HashMap is implemented using an array of LinkedList.
 * It uses hashing (convert any original value into new encryped value).
 * Hashing gives the index of array for a key.
 * 
 * https://www.youtube.com/watch?v=KDZ_IXvpMG4&list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop&index=36
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapImplementation{

    static class HashMap<K, V>{ //generic class

        private class Node{
            K key;
            V value;

            Node(K key, V val){
                this.key = key;
                this.value = val;
            }
        }

        private int n; //no of nodes
        private int N; //length of array or bucket
        private LinkedList<Node> bucket[]; 

        @SuppressWarnings("unchecked")
        HashMap(){
            this.N = 4;
            bucket = new LinkedList[N];
            for(int i=0;i<N;i++){
                bucket[i] = new LinkedList<>();
            }
        }

        public int getHash(K key){ // 0 to N-1
            int HashedIndex = key.hashCode();
            return Math.abs(HashedIndex) % N;
        }

        public int  searchInLL(K key, int index){
            LinkedList<Node> curr = bucket[index];

            for(int i=0;i<curr.size();i++){
                if(curr.get(i).key == key){
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[] = bucket;
            bucket = new LinkedList[2*N];

            for(int i=0;i<bucket.length;i++){
                bucket[i] = new LinkedList<>();
            }

            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node> curr = oldBucket[i];
                for(int j=0;j<curr.size();j++){
                    Node node = curr.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bi = getHash(key); //bucket index
            int li = searchInLL(key, bi); //linked list index of that key

            //check if that key exist
            if(li == -1){ //not exist
                bucket[bi].add(new Node(key, value));
                n++;
            }
            else{
                Node node = bucket[bi].get(li);
                node.value = value;
            }

            double lambda = (double)(n/N);

            if(lambda > 2.0){
                //rehashing
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = getHash(key);
            int li = searchInLL(key, bi); 

            if(li == -1) { //key doesn't exist
                return false;
            } 
            else { //key exists
                return true;
            }
        }

        public V remove(K key) {
            int bi = getHash(key);
            int li = searchInLL(key, bi); 
            if(li == -1) { //key doesn't exist
                return null;
            } 
            else { //key exists
                Node node = bucket[bi].remove(li);
                n--;
                return node.value;
            }
        }

        public V get(K key) {
            int bi = getHash(key);
            int li = searchInLL(key, bi); //di = -1
            if(li == -1) { //key doesn't exist
                return null;
            } 
            else { //key exists
                Node node = bucket[bi].get(li);
                return node.value;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<bucket.length; i++) { //bi
                LinkedList<Node> ll = bucket[i];
                for(int j=0; j<ll.size(); j++) { //li
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for(int i=0;i<bucket.length;i++){
                for(Node node : bucket[i]){
                    sb.append(node.key+"="+node.value);
                    sb.append(", ");
                }
            }
            if(sb.length()>2)
                sb.delete(sb.length()-2,sb.length());

            sb.append("}");
            return sb.toString();
        }
    }

    public static void main(String[] args) {

        //creating HashMap
        HashMap<String, Integer> map = new HashMap<>();

        //Insertion
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

        //printing
        System.out.println(map);

        //updating
        map.put("China", 180);
        //printing method 2
        for(String  key : map.keySet()){
            System.out.println(key+": "+map.get(key));
        }

        //Searching
        if(map.containsKey("China")) {
            System.out.println("China is present in the map");
        } 
        else {
            System.out.println("China is not present in the map");
        }

        System.out.println("Population of China "+map.get("China")); //key exists
        System.out.println("Population of Indonesia "+map.get("Indonesia")); //key doesn't exist

        //removing
        map.remove("China");
        System.out.println("Map after removing China\n"+map);
    }

}