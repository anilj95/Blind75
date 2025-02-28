package IntervalBased;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {

	public static void main(String[] args) {
		
        int[][] interval = {{0,30},{5,10},{15,20},{15,40}};
		
		System.out.println(""+solution(interval));

	}
     
	private static int solution(int[][] intervals) {
		
		//base check
		if(intervals.length == 0) return 0;
		
		Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));
		
		//using PriorityQueue to add end points and check if its peak(minimum of all) is >= starting point
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int[] interval : intervals) {
			
			if(pq.isEmpty()) {
				
				pq.add(interval[1]); // adding only endPoints to check with starting point of second and further elements
			}
			
			if( pq.peek() >= interval[0]) {// is end point >= starting point
				
				pq.poll(); // remove , as we can have both meetings in one room
			}
			
			pq.add(interval[1]); // adding end point  
		}
		
		return pq.size(); // returning no. of rooms required 
	}
}
