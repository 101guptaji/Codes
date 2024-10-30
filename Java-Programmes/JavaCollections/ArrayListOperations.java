/* Problem:
 * Given an ArrayList of lowercase characters initially empty. You are given queries of two types to perform on ArrayList:
    'i' and 'c': append character 'c' in the ArrayList.
    'f' and 'c': find the frequency of character 'c' in ArrayList, if not present then print -1.
	Note: use add() to append an element to the list and contains() to check whether an element is present or not in the list and Collections.frequency() to find the frequency of the element in the list.
	
	Examples:
	Input: i g i e i e i k i s f e
	Output: 2
	Explanation: Inserting g, e, e, k, s into the list. The frequency of e is 2 in the list.
	Input: i c i p i p f f
	Output: -1
	Explanation: Inserting c, p, p into the list. The frequency of f is 0 in the list.
	Constraints:
	1 <= q <= 106
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Driver class with driver code
class ArrayListOperations {
  // Driver code
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(br.readLine());

      while (t-- > 0) {
          // Declaring ArrayList
          ArrayList<Character> clist = new ArrayList<Character>();

          String q = br.readLine();

          // Looping for queries
          for (int i = 0; i < q.length(); i += 4) {
              char ch = q.charAt(i);
              Operation obj = new Operation();

              if (ch == 'i') {
                  char c = q.charAt(i + 2);
                  obj.insert(clist, c);
              }

              if (ch == 'f') {
                  char c = q.charAt(i + 2);
                  obj.freq(clist, c);
              }
          }
          // System.out.println("~");
      }
  }
}

//Operation class with functions insert and freq
//insert : to insert element into ArrayList
//freq : function to count frequency of element
class Operation {
  // Function to insert element
  public void insert(ArrayList<Character> clist, char c) {
      // your code
      clist.add(c);
  }

  // Function to count frequency of element
  public void freq(ArrayList<Character> clist, char c) {
      // your code
      if(!clist.contains(c)){
          System.out.println(-1);
          return;
      }
      else{
          System.out.println(Collections.frequency(clist, c));
      }
  }
}
