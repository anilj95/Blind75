package MatrixBased;

public class SearchInMatrix {

	public static void main(String[] args) {

		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3 ;
        
        System.out.println(solution(matrix, target));

	}
	
	private static boolean solution(int[][] matrix, int target) {
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		// finding left and right pointer to apply binary search as matrix is sorted
		int left = 0;
		int right = m*n-1; // converted 2d matrix to 1D
		
		while(left <= right) {
			
			int midIndex = left + (right-left)/2; 
			//Since each row has n columns, dividing midIndex by n gives us the row number.
			//The remainder when dividing mid by n gives us the column index. midIndex%n
			int midValue = matrix[midIndex/n][midIndex%n]; // this is the formula remember it
			
			if(midValue == target) {
				
				return true;
			}else if( midValue < target) {
				
				left = midIndex+1;;
			}else {
				
				right = midIndex-1; ;
			}
		}
		
		return false;
	}

}
