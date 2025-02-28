package MatrixBased;

import java.util.*;

public class SpiralMatrixPrint {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		
		System.out.println("Before Rotation:");
		printMatrix(matrix);
		System.out.println("After Rotation:"+solution(matrix));
		

	}
	
	private static List<Integer> solution(int[][] matrix) {
		
		int rowbegin =0;
		int rowend = matrix.length-1;
		int colomnbegin =0;
		int colomnend = matrix[0].length;
		
		ArrayList<Integer> res = new ArrayList<>();// to add each element and show them at the end
		
		// applying bounding condition
		
		while(rowbegin<= rowend && colomnbegin<= colomnend) {
			
			//applying base check
			
			if(matrix == null || matrix.length ==0) return res;
			
			//traverse left
			
			for(int i = colomnbegin ; i<=colomnend; i++) {
				
				res.add(matrix[rowbegin][i]);
			}
			  
			//move downward
			rowbegin++;
			
			for(int i = rowbegin; i<=rowend ;i++) {
				
				res.add(matrix[i][colomnend]);
			}
			//move left side
			colomnend--;
			
			for(int i = colomnend ; i>=colomnbegin ; i--) {
				
				res.add(matrix[rowend][i]);
			}
			
			//move upside
			rowend--;
			
			for(int i=rowend ; i>=rowbegin ;i--) {
				
				res.add(matrix[i][colomnbegin]);
				
			}
			
			//move right side for remaining element
			colomnbegin++;
		}
		
		return res;
		
		
	}
	
	private static void printMatrix(int[][] matrix) {
		
		for(int i =0; i< matrix.length;i++) {
		
			for(int j =0; j< matrix[0].length; j++) {
				
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
