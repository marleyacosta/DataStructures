/********************************************************************* 
Purpose/Description: This program checks if a number is found in a N by N matrix by starting 
at the right-most bottom  side of the matrix(lowest number) and checking if the number is within the range of the matrix.
If the number is within the range the function checks if the number is found by moving up rows and going left for columns.
Author’s Panther ID: 3914479
Certification:
	I hereby certify that this work is my own and none of it is the work of any other person.
********************************************************************/
public class P1 {

	public Boolean numberExist(int[][] m, int num){
		
		// Starting position at bottom right most number in the matrix.
		int row = m.length - 1;
		int col = m[0].length - 1;
		//Checks if the number is less than the lowest number in the matrix.
		boolean lowerThanLowest = num < m[m.length - 1][m[0].length - 1];
		//Checks if the number is greater than the highest number in the matrix.
		boolean higherThanHighest = num > m[0][0];
		
		while((row >= 0 && col >= 0) && !lowerThanLowest && !higherThanHighest){
			
			if(m[row][col] == num){// if the number is found.
				return true;}
		//if the number is greater than the current value and not currently on the last row of the column.
			if(num > m[row][col] && row != 0){
				row--;}// move up a row and stay in the same column.
			else{// if on the last row of the column.
				row =  m.length - 1;// Set the row index to the bottom of the next column.
				col--;}// move to the next column to the left.
		}// numExist closing bracket.
		 
		return false;}// if the number is not found.
	
	// <--- Main --->
	public static void main(String []args){

		int targetNum = 5; // Number to look up.
		// Matrix to search
		int [][] matrix = {
				{26, 22, 17, 10},
				{19, 16, 12, 7},
				{12, 10, 7, 4},
				{5, 4, 2, 1}};
		
		P1 p = new P1();// Construct a P1 object.
		
		if(p.numberExist(matrix, targetNum)){ 
			System.out.println("The number '" + targetNum + "' was found in the matrix.");}
		
		else{ System.out.println("The number '" + targetNum + "' was NOT found in the matrix.");}	
	}// Main closing bracket.
}// P1 class closing bracket.
