package binaryBitWise;

public class SumOfTwoIntegers { // do sum without using + and - operators

	public static void main(String[] args) {

      System.out.println(getSumRecursive(3,9));

	}
	
	// iterative approach. TC: O(1) ; (Since integers are 32-bit, the loop runs at most 32 times.)
	// SC: O(1) , only 2 variables used
	
	private static int getSum(int a, int b) {
		
		
		while(b !=0) { // repeat until carry becomes 0
			
			int sum = a ^ b; // XOR operation , diff -> 1, same -> 0 i.e : 1^1, 0^0 = 0; 1^0, 0^1 = 1
			int carry = (a&b)<< 1; // & operation give only carry and <<(left shift operator), shift carry to left by 1 place.
			
			a = sum ;
			b =carry;
	}
		
		return a;

}
	// Recursive approach
	private static int getSumRecursive(int a, int b) {
		
		if( b == 0) return a;
		
		return getSumRecursive( a ^ b, (a & b) <<1 );
	}
	
}
