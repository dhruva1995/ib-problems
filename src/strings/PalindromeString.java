package strings;

public class PalindromeString {

    public int isPalindrome(String A) {
    	
    	int low = 0, high = A.length() - 1;
    	
    	while(low < high) {
    		
    		while(low < A.length() && !Character.isLetterOrDigit(A.charAt(low))) {
    			low++;
    		}
    		
    		while(high >= 0 && !Character.isLetterOrDigit(A.charAt(high))) {
    			high--;
    		}
    		
    		if(low < high) {
    			int a = Character.toLowerCase(A.charAt(low));
    			int b = Character.toLowerCase(A.charAt(high));
    			
    			if(a != b) {
    				return 0;
    			}
    			low++;
    			high--;
    		}
    	}
    	return 1;
    	
    }
	
	
}
