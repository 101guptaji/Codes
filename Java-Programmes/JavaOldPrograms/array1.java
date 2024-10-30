// Java program to illustrate creating an array 
// of integers, puts some values in the array, 
// and prints each value to standard output. 

class array1
{ 
	public static void main (String[] args) 
	{		 
	// declares an Array of integers. 
	int[] arr; 
		
	// allocating memory for 5 integers. 
	arr = new int[5]; 
		
	// initialize the first elements of the array 
	arr[0] = 10; 
		
	// initialize the second elements of the array 
	arr[1] = 20; 
		
	//so on... 
	arr[2] = 30; 
	arr[3] = 40; //output prompto
	arr[4] = 50; 
		
	// accessing the elements of the specified array 
	for (int i = 0; i < arr.length; i++) 
		System.out.println("Element at index " + i + 
									" : "+ arr[i]);		 
	
	int numbers[] = {5, 6, 7};
        
    for(int i=0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        } 
} 
}
