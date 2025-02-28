package StringBased;

public class ValidPalindrom {

	public static void main(String[] args) {

         String str = "A man, a plan, a canal: Panama";
		
		System.out.println(solution(str));

	}
	
	private static boolean solution(String str) {
		
		String sorted = str.toLowerCase().replaceAll("[^A-za-z0-9]", "");
		
		int left = 0;
		int right = sorted.length()-1;
		
		while(left<=right) {
			
			if(sorted.charAt(left++) != sorted.charAt(right--)) {
				
				return false;
			}
		}
		
		return true;
	}

}
