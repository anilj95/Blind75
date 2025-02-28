package ArrayBased;

public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {

             int[] nums = {3,4,5,0,2};
             
             System.out.println(solution(nums));

	}
	// if array is sorted; we can achieve in O(logn) time; here array is sorted but rotated
	// using binary search for sorted array
	private static int solution(int[] nums) {
		
		int low = 0;
		int high = nums.length-1;
		
		while(low< high) {
			
			int mid = low + (high-low)/2;
			
			if(nums[mid] > nums[high]) { // means right array is not sorted, so minimum will be inside unsorted array i.e right side
				
				low = mid+1; // now range is limited to right side only
				
			}else {
				
				high = mid; // if right array is sorted, minimum will be in range low to high, where high changed to mid now.
			}
		}
		
		return nums[low]; // as minimum will be at low only.
		
		
	}

}
