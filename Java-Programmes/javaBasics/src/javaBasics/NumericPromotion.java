package javaBasics;
// Java Program to Demonstrate 
// Replacing of Conditional Operator
// with If-else and viceversa

public class NumericPromotion {

    // Main driver method
    public static void main (String[] args) {

        // Expression 1 (using ?: )
        // Automatic promotion in conditional expression
        Object o1 = true ? new Integer(4) : new Float(2.0); 

        // Printing the output using conditional operator
        System.out.println(o1); //output: 4.0

        // Expression 2 (Using if-else)
        // No promotion in if else statement
        Object o2;
        if (true)
            o2 = new Integer(4);
        else
            o2 = new Float(2.0);

        // Printing the output using if-else statement
        System.out.println(o2); //output: 4
    }
}

/*
 * According to Java Language Specification Section 15.25, the conditional operator will implement numeric type promotion 
 * if there are two different types as 2nd and 3rd operand.  
 * The rules of conversion are defined at Binary Numeric Promotion. 
 * Therefore, according to the rules given, If either operand is of type double, the other is converted to double and hence 4 becomes 4.0. 
 * Whereas, the, if/else construct, does not perform numeric promotion and hence behaves as expected.
 */

