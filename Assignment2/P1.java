/********************************************************************* 
Purpose/Description: The purpose of the program is to find if given any type of list of comparable items then
what is the difference between the two lists and are the lists disjoint.
Author’s Panther ID: 3914479
Certification:
I hereby certify that this work is my own and none of it is the work of any other person.
********************************************************************/

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class P1 {

	/**
	 * This method determines if given two sorted list of comparable items are disjoint lists.
	 * The time complexity of this method is O(N + M) where N and M are the sizes of the two sorted lists.
	 * In the worse case scenario the method will have to iterate through all the elements of both lists until a shared element is found
	 * or not found at the end of both lists.
	 * In the best case scenario the method will have a constant time complexity if the first two elements of both list are equal.
	 * @param L1 A sorted list.
	 * @param L2 A sorted list.
	 * @return Returns true if the lists are disjoint.
	 */
	public static <AnyType extends Comparable<? super AnyType>> boolean disjoint(List<AnyType> L1, List<AnyType> L2){
		
		int sizeOfL1 = L1.size();// How many elements are in L1?
		int sizeOfL2 = L2.size();// How many elements are in L2?
		
		// Start at the first element of each list.
		int indexOfL1 = 0;
		int indexOfL2 = 0;
		
		while(indexOfL1 < sizeOfL1 && indexOfL2 < sizeOfL2){// while both list are not at their last element + 1.
			
			/*If a greater number in L2 is found, move to the next number in L1 
			 * until you find a number in L1 that is greater than the current number in L2.
			 */
			if(L1.get(indexOfL1).compareTo(L2.get(indexOfL2)) < 0){
				indexOfL1++;
			}
			/* If a greater number in L1 is found, move to the next number in L2 
			 * until you find a number in L2 that is greater than the current number in L1.
			 */
			else if(L1.get(indexOfL1).compareTo(L2.get(indexOfL2)) > 0){
				indexOfL2++;
			}
			/* if the current number in L1 is neither greater than or less than the current number in L2
			 * then they must be equal.
			 */
			else{return false;}
		}	
	return true;// no element in common is found.
	}
	/**
	 * This method adds the elements in a list that aren't found in a second list into a different list.
	 * The time complexity of this method is O(N + M) where N and M are the sizes of the two sorted lists.
	 * The method will have to iterate through all the elements of both lists to check for union between both lists.
	 * Even if the method is done iterating the smallest list but not the largest list then the remaining elements in 
	 * the largest list will need to be added to the difference list since they are not present in the smallest list.
	 * @param L1 A sorted list.
	 * @param L2 A sorted list.
	 * @param Difference A list of items that aren't shared by both list L1 and list L2.
	 */
	public static <AnyType extends Comparable<? super AnyType>> void difference(List<AnyType> L1, List<AnyType> L2,List<AnyType> Difference){
		
		ListIterator <AnyType> iter1 =  L1.listIterator();
		ListIterator <AnyType> iter2 =  L2.listIterator();
		
		AnyType element1 = null;
		AnyType element2 = null;
		
		if(iter1.hasNext() && iter2.hasNext()){// Get the first elements of both lists.
			 element1 = iter1.next();
			 element2 = iter2.next();
		}
		
		while(element1 != null && element2 != null){// while the current element in both list are not null.
			
			int compare = element1.compareTo(element2);// compare the elements.
			
			if(compare > 0){// If element1 is greater than element2.
				Difference.add(element2);// Add element2 in the Difference list.
				element2 = iter2.hasNext()?iter2.next():null;// Get the next element in L2.
			}
			else if(compare < 0){// else if the next element1 is less than element2.
				Difference.add(element1);// Add element1 in the Difference list.
				element1 = iter1.hasNext()?iter1.next():null;// Get the next element in L1.
			}
			else{// else element1 is equal to element2.
				element1 = iter1.hasNext()?iter1.next():null;// Get the next element in L1.
				element2 = iter2.hasNext()?iter2.next():null;// Get the next element in L2.	
			}	
		}
		// Add the remaining elements of the larger list.
		while(element1 != null){// While L1 still has more elements.
			Difference.add(element1);// Add them to the Difference list.
			element1 = iter1.hasNext()?iter1.next():null;// Get the next element in L1.
		}
		while(element2 != null){// While L1 still has more elements.
			Difference.add(element2);// Add them to the Difference list.
			element2 = iter2.hasNext()?iter2.next():null;// Get the next element in L1.
		}
	}
	public static void main (String [] args){
		
		//Difference list
		List<Integer> diffNumber = new ArrayList<Integer>();
		List<String> diffWord = new ArrayList<String>();
		
		// Test with numbers.
		List<Integer> numberList1 = new ArrayList<Integer>();
		List<Integer> numberList2 = new ArrayList<Integer>();
		List<Integer> numberList3 = new ArrayList<Integer>();
		
		// Generate a list of numbers.
		for(int i = 4; i <= 12;i+=2){numberList1.add(i);}
		for(int i = 1; i <= 10;i++){numberList2.add(i);}
		for(int i = 0; i <= 3;i++){numberList3.add(i);}
		
		// Test with letters.
		List<String> wordList1 = new ArrayList<String>();
		List<String> wordList2 = new ArrayList<String>();
		List<String> wordList3 = new ArrayList<String>();
		
		String alphabet1 = "abcdefgh";
		String alphabet2 = "defghijkl";
		String alphabet3 = "wxyz";
		
		// Generate a list of letters.
		for(int i = 0; i < alphabet1.length();i++){wordList1.add(Character.toString(alphabet1.charAt(i)));}
		for(int i = 0; i < alphabet2.length();i++){wordList2.add(Character.toString(alphabet2.charAt(i)));}
		for(int i = 0; i < alphabet3.length();i++){wordList3.add(Character.toString(alphabet3.charAt(i)));}
		
		
		if(P1.disjoint(numberList1, numberList2)){System.out.println("The following lists "+ numberList1 + " and " + numberList2 + " are disjoint.\n");}
		else{System.out.println("The following lists "+ numberList1 + " and " + numberList2 + " are NOT disjoint.\n");}
		
		if(P1.disjoint(numberList1, numberList3)){System.out.println("The following lists "+ numberList1 + " and " + numberList3 + " are disjoint.\n");}
		else{System.out.println("The following lists "+ numberList1 + " and " + numberList3 + " are NOT disjoint.\n");}
		
		if(P1.disjoint(wordList1, wordList2)){System.out.println("The following lists "+ wordList1 + " and " + wordList2 + " are disjoint.\n");}
		else{System.out.println("The following lists "+ wordList1 + " and " + wordList2 + " are NOT disjoint.\n");}
		
		if(P1.disjoint(wordList1, wordList3)){System.out.println("The following lists "+ wordList1 + " and " + wordList3 + " are disjoint.\n");}
		else{System.out.println("The following lists "+ wordList1 + " and " + wordList3 + " are NOT disjoint.\n");}
		
		P1.difference(numberList1,numberList2, diffNumber);
		P1.difference(wordList1, wordList2, diffWord);
		
		System.out.println("The difference of the lists "+ numberList1 + " and " + numberList2 + " is " + diffNumber +".\n");
		System.out.println("The difference of the lists "+ wordList1 + " and " + wordList2 + " is " + diffWord +".\n");
	}

}
