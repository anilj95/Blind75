package MatrixBased;

public class RotateMatrix {

	public static void main(String[] args) {

         int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
         
         System.out.println("Before rotation");
         printMatrix(matrix);
         System.out.println("After rotation");
         solution(matrix);
         printMatrix(matrix);

	}
	
	private static int[][] solution(int[][] matrix){
		
		// base check
		if(matrix.length == 0 || matrix == null) return null;
		
		//calculate transpose of matrix
		
		for(int i=0; i< matrix.length;i++) {
			
			for(int j =i+1; j< matrix[0].length;j++) {
				
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		
		// now reverse the columns elements
		
		for(int i =0; i< matrix.length;i++) {
			
			int left =0;
			int right = matrix[0].length-1;
			
			while(left< right){
				
				int temp = matrix[i][left];
				matrix[i][left] = matrix[i][right];
				matrix[i][right] = temp;
				
				left++;
				right--;
			}
		}
		
		return matrix;
	}
	
	private static void printMatrix(int[][] matrix) {
		
		for(int i=0; i<matrix.length;i++) {
			
			for(int j = 0; j<matrix[0].length;j++) {
				
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
