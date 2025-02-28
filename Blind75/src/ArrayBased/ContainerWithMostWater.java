package ArrayBased;

public class ContainerWithMostWater {

	public static void main(String[] args) {

       int[] height = {1,8,6,2,5,4,8,3,7};
       
       System.out.println(solution(height));

	}
	
	//Approach: need to find max area = length* breadth
	private static int solution(int[] height) {
		
		int maxArea = 0;
		int left = 0;
		int right = height.length-1;
		
		// using two pointers approach
		while(left< right) {
			
			// math.min because, out of two heights, water will stay up to smaller one only
			int area = Math.min(height[left], height[right])* (right-left); // area = length*breadth
			maxArea = Math.max(maxArea, area);
			
			if(height[left] < height[right]) {// trying to finding highest peak to get max area 
				
				left++; 
			}else {
				
				right--;
			}
		}
		
		return maxArea;
		
	}

}
