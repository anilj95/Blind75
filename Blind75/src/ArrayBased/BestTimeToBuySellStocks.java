package ArrayBased;

public class BestTimeToBuySellStocks {

	public static void main(String[] args) {


		int[]  prices = {7,1,5,3,6,4};
		
		System.out.println(solution2(prices));

	}
	// Approach: Make a minimum variable, compare with every elements and maintain minimum, then keep
	//deducting every element with minimum
	private static int solution(int[] prices) {
		
		int minimum = Integer.MAX_VALUE; 
		
		int maxProfit = 0;
		
		for(int i = 0; i< prices.length;i++) {
			
			if(prices[i] < minimum) {
				
				minimum = prices[i];
			}
			

			maxProfit = Math.max(maxProfit, prices[i] - minimum);
		}
		
		return maxProfit;
		
	}
	
	// same question but now, you can sell every day to make profit. now tell me the max profit.
	//Approach: 1st day you can not sell, so from 2nd day, keep comparing, if next value is greater than previous value,
	//make a profit variable and keep adding to profit variable
	private static int solution2(int[] prices) {
		
		int profit = 0;
		
		for(int i=1; i< prices.length;i++) {
			
			if(prices[i]> prices[i-1]) {
				
				profit += prices[i] - prices[i-1];
			}
		}
		
		return profit;
		
	}

}
