/********************************************************************* 
Purpose/Description: The purpose of the program is to find the index of a number in an integer 
array that is present more than half the time in the array.
Author’s Panther ID: 3914479
Certification:
I hereby certify that this work is my own and none of it is the work of any other person.
********************************************************************/
import java.util.Arrays;
public class P2 {

	/**
	 * This method returns the index of an element in a list that appears more than half the time.
	 * The time complexity of this method is O(N) because the consecutive for loops are both done in linear time.
	 * The first for loop traverses all the elements in the array and counting until the end. That is done in linear time.
	 * The second for loop traverses all the elements in the array counting if the leader number occurs more than half the time.
	 * The if statement is constant. 
	 * @param A The integer array to search the leader element in.
	 * @return returns the index of the leader element in A or -1 if the leader element is not found in A.
	 */
	private static int leader(int[] A){
		
		int half = A.length/2;
		int leaderIndex = 0;
		int count = 1;
		
		for(int i = 1; i < A.length; i++){// start with the second element in the array and iterate until the last element.
			
			if(A[leaderIndex] == A[i]){count++;}// if there is a duplicate of the current leader increase the count by 1.
			else{count--;}// if the current number in the array is different from the leader number then decrease the count by 1.
			// if the count is 0 then there is no current leader number.
			if(count == 0){ 
				leaderIndex = i;//Assign the current value to be leader.
				count = 1;}//Start counting occurrence of the current leader number.
		}// for loop.
		
		for(int i = 0; i < A.length;i++){// Traverse the array and count the occurrence of the proposed leader number.
			if(A[leaderIndex] == A[i]){
				leaderIndex = i;// keeps track of the index location of the proposed leader number.
				count++;}
		}// for loop
		// if the proposed leader number appears more than half the time in the array then return the index of the leader number.
		if(count > half){return leaderIndex;}
		else{return -1;}// else no leader exist.	
	}

	public static void main (String[] args){
		
		int[] a = {23, 23, 67, 23, 67, 23, 45}; 
		int[] b = {23, 24, 67, 23, 67, 23, 45}; 
		
		if(P2.leader(a) > 0){
			System.out.println("The leader number in the array " + Arrays.toString(a) +" is in index " + P2.leader(a) + ".");}
		else{System.out.println("There is no leader number in the array " + Arrays.toString(b)  + ".");}
		
		if(P2.leader(b) > 0){
			System.out.println("The leader number in the array " + Arrays.toString(a) +" is in index " + P2.leader(b) + ".");}
		else{System.out.println("There is no leader number in the array " + Arrays.toString(b) + ".");}
	}
}
