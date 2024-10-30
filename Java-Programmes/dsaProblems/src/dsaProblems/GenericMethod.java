package dsaProblems;
/*
 * Generic methods are a very efficient way to handle multiple datatypes using a single method. This problem will test your knowledge on Java Generic methods.

Let's say you have an integer array and a string array. You have to write a single method printArray that can print all the elements of both arrays. The method should be able to accept both integer arrays or string arrays.

You are given code in the editor. Complete the code so that it prints the following lines:

1
2
3
Hello
World
 */

class Generic{
    <T> void printArray(T[] obj){
        for(int i=0;i<obj.length;i++){
            System.out.println(obj[i]);
        }
    }
}

public class GenericMethod {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Integer[] a = {1,2,3};
        String[] b = {"Hello", "World"};
        Generic printA = new Generic();
        printA.printArray(a);
        printA.printArray(b);
        System.out.println(10+20.1f+"Ab"+"CD");
    }
}
