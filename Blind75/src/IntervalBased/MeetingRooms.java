package IntervalBased;

import java.util.Arrays;
import java.util.Stack;

public class MeetingRooms {

	public static void main(String[] args) {

       int[][] interval = {{0,5},{4,10},{15,20}};
		
		System.out.println(""+solution(interval));

	}
	
	// find if he can attend all meetings
	private static boolean solution(int[][] interval) {
		
		// base check
		
		if(interval == null || interval.length == 0) return true;
		
		Arrays.sort(interval, (a,b) -> Integer.compare(a[0], b[0]));
		
		//Create a stack to save 1st interval
		
		Stack<int[]> stack = new Stack<>();
		
		stack.add(interval[0]);
		
		for(int i =1; i< interval.length;i++) {
			
			int startPoint2 = interval[i][0]; // starting point of 2nd interval
			
			int[] popArray = stack.pop();
			int endPoint1 = popArray[1]; // end point of 1st interval
			
			if(endPoint1> startPoint2) {
				
				return false;
			}
			
			stack.add(interval[i]); // adding for next iteration 
		}
		
		return true;
		
		
	}

}
