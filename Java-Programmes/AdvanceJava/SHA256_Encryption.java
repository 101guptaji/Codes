/*
 * Cryptographic hash functions are mathematical operations run on digital data; by comparing the computed hash 
 * (i.e., the output produced by executing a hashing algorithm) to a known and expected hash value, a person can determine the data's integrity. 
 * For example, computing the hash of a downloaded file and comparing the result to a previously published hash result can show whether 
 * the download has been modified or tampered with. In addition, cryptographic hash functions are extremely collision-resistant; 
 * in other words, it should be extremely difficult to produce the same hash output from two different input values using a cryptographic 
 * hash function.

	Secure Hash Algorithm 2 (SHA-2) is a set of cryptographic hash functions designed by the National Security Agency (NSA). 
	It consists of six identical hashing algorithms (i.e., SHA-256, SHA-512, SHA-224, SHA-384, SHA-512/224, SHA-512/256) with a variable 
	digest size.
	SHA-256 is a 256-bit hashing algorithm which can calculate a hash code for an input of up to 264-1 bits. 
	It undergoes 64 rounds of hashing and calculates a hash code that is a 64-digit hexadecimal number.
	
	Given a string,s , print its SHA-256 hash value.
	Input Format
	A single alphanumeric string denoting .
	
	Constraints
	String  consists of English alphabetic letters and/or decimal digits only.
	
	Output Format
	Print the SHA-256 encryption value of  on a new line.
	
	Sample Input 0
	HelloWorld
	
	Sample Output 0
	872e4e50ce9990d8b041330c47c9ddd11bec6b503ae9386a99da8584e9bb12c4
	
	Sample Input 1
	Javarmi123
	
	Sample Output 1
	f1d5f8d75bb55c777207c251d07d9091dc10fe7d6682db869106aacb4b7df678
 */

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class SHA256_Encryption {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        try{
            String str = sc.nextLine();
            //System.out.println(str.hashCode());
            System.out.println(toHexString(getSHA(str)));
        }
        catch(NoSuchAlgorithmException e){
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        finally{
            sc.close();
        }
    }
    
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
 
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
     
    public static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }
        
        return hexString.toString();
    }
}
