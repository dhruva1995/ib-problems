package interview.bit.arrays;
public class IsPalindrome {
	
	
	public static void main(String[] args) {
		System.out.println(new IsPalindrome().isPalindrome(11));
	}
	
    public int isPalindrome(int A) {
        if(A == 0) {
            return 1;
        } else if (A < 0){
            return 0;
        }
        int length = 0;
        int copy = A;	
        while(copy > 0) {
            copy = copy / 10;
            length++;
        }
        
        int left = length - 1, right = 0;
        
        while(left >= right) {
            if(getDigitAtGivenPosition(A, left) != getDigitAtGivenPosition(A, right)) {
                return 0;
            }
            left--;
            right++;
        }
        return 1;
    }
    
    int getDigitAtGivenPosition(int number, int position) {
        
        int residue = number % (int) Math.pow(10, position + 1);
        return residue / (int) Math.pow(10, position);
    }
    
}
