/********************************************************************* 
Purpose/Description: 
Author’s Panther ID: 3914479
Certification:
	I hereby certify that this work is my own and none of it is the work of any other person.
********************************************************************/
import java.math.BigInteger;
public class P2 {
	
	BigInteger fibonacci(long number){
		/* Create this matrix: (1 1)
							   (1 0) */
		BigInteger[][] T = {{BigInteger.ONE,BigInteger.ONE},{BigInteger.ONE,BigInteger.ZERO}};
		
		if(number == 0){return BigInteger.ZERO;}// matrix^-1 returns T[0][0] = 0
		
		power(T,number - 1);
		
		return T[0][0];// returns the nth fibonacci number.
	}
	void power(BigInteger[][] T, long number){
		
		if(number == 0 || number == 1){return;}// Exit method if first or second fibonacci number.
		
		/* Create this matrix: (1 1)
		   					   (1 0) */
		BigInteger[][] A = {{BigInteger.ONE,BigInteger.ONE},{BigInteger.ONE,BigInteger.ZERO}};
		
		power(T, number / 2);
		multiply(T,T);
		
		if(number % 2 != 0){multiply(T,A);}//A*A^(p-1)
		
	}
	void multiply(BigInteger[][] T, BigInteger[][] A){
		
		//Matrix multiplication by rows of T and columns of A.
		BigInteger a = T[0][0].multiply(A[0][0]).add(T[0][1].multiply(A[1][0]));
		BigInteger b = T[0][0].multiply(A[0][1]).add(T[0][1].multiply(A[1][1]));
		BigInteger c = T[1][0].multiply(A[0][0]).add(T[1][1].multiply(A[1][0]));
		BigInteger d = T[1][0].multiply(A[0][1]).add(T[1][1].multiply(A[1][1]));
		//Update new values.
		T[0][0] = a;
		T[0][1] = b;
		T[1][0] = c;
		T[1][1] = d;
	}
	public static void main (String[] args){
		
		P2 p = new P2();
		long testNum = 250;
		
		System.out.println("The " + testNum + "th number in the Fibonacci Sequence is: " + p.fibonacci(testNum));
	}// Main closing bracket.
}// P2 closing bracket.
