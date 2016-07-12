/********************************************************************* 
Purpose/Description: This program contains a method that replaces a key in a min heap and restores the min-heap property
by using the methods percolate up and percolate down.
Author’s Panther ID: 3914479
Certification:
I hereby certify that this work is my own and none of it is the work of any other person.
********************************************************************/
import java.util.Arrays;

public class P1{
	
	Integer [] array ; // the array list that contains the min heap.
	
	/**
	 * The P1 Constructor method.
	 * @param array The array that contains the min heap.
	 */
	public P1(Integer [] array){this.array = array;}
	
	/**
	 * This methods returns the array min heap into a string.
	 */
	public String toString(){return Arrays.toString(array);}
	
	/**
	 * This method moves up an element in the min heap until the min heap property is restored.
	 * Worst case time complexity: O(logn)
	 * @param index The current location of the element being move up the min heap.
	 */
	private void percolateUp(int index){
		
		int parent = index / 2; // the location of the index's parent.
		//While the newKey is not the root AND the parent is greater than the newKey.
		while((index >= 1) && (array[parent] > array[index])){
			
			//swap elements
			Integer temp = array[index];
			array[index] = array[index / 2];
			array[index / 2] = temp;
			
			// update
			index = parent;
			parent = index / 2;
			
			
			
		}
	}
	
	/**
	 * This method moves down an element in the min heap until the min heap property is restored.
	 * Worst case time complexity: O(logn)
	 * @param index The current location of the element being move down the min heap.
	 */
	public void percolateDown(int index)  
	   {
		int minimum, temp;			

		int left = 2 * index + 1;  // left child
		int right = 2 * index + 2; // right child

	  	if(left < array.length && array[left] < array[index]){	// find the smallest child
	     		minimum = left;          // save the index of the smaller child
	  	}
	  	else{minimum = index;} 

	  	if(right < array.length && array[right] < array[minimum])
	     		minimum = right;           		// save index of smaller child

	  	if(minimum != index)	 			// swap and percolate down
	  	{
	  		//swap elements
	      		temp = array[index];      		
	      		array[index] = array[minimum];
	      		array[minimum] = temp;
	      		
	      		percolateDown(minimum); 			

	     	}
	   }
	 

	/**
	 * This method replaces a key in the min heap array and restores the min heap property.
	 * The running time complexity is O(N) because in the worse case scenario the element 
	 * is at the end of the list and the for loop is iterated N times (O(N)).
	 *  The for loop is then followed by an if statement containing the methods perlocateUp and 
	 *  perlocateDown where each has a time complexity of O(log n ).
	 *  So, maximum of the complexities is O(N)
	 * @param oldKey The key to be found.
	 * @param newKey The key to replaces the oldKey.
	 */
	public void replaceKey(Integer oldKey, Integer newKey){
		
		boolean found = false;
		
		int i = 0;
		
		for(; i < array.length; i++){// Iterate the array
			
			if(array[i].equals(oldKey)){ // if the current position in the array equals the old key.
				found = true; // set found to true
				break;// and break from the for loop.
			}		
		}
		if(found){// if the old key was found.
			array[i] = newKey;	// Change the value to the new value.
			
			// restore min heap property.
			percolateUp(i);
			percolateDown(i);
			
		}
		// else the old key wasn't found.
		else{System.out.println("The key " + oldKey + " was not found in the array.");}
	}
	
	public static void main (String [] args){
		
		// array representing the min heap
		Integer [] array = {5, 10, 9, 11, 15, 10, 12, 13, 14, 16, 18};
		
		P1 h = new P1(array);
		
		System.out.println("Original: " + h.toString() ); 
		h.replaceKey(new Integer(10), new Integer(3));
		System.out.println("After replace method: " + h.toString() + "\n");
		
		System.out.println("Original: " + h.toString() ); 
		h.replaceKey(new Integer(19), new Integer(3));
		System.out.println("After replace method: " + h.toString() + "\n");

		System.out.println("Original: " + h.toString()); 
		h.replaceKey(new Integer(10), new Integer(20));
		System.out.println("After replace method: " + h.toString() + "\n");
	}
}