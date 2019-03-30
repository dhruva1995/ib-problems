package math;

public class LargestCoprimeDivisor {
	
	
	public static void main(String[] args) {
		System.out.println(new LargestCoprimeDivisor().cpFact(30, 12));
	}
	
	public int cpFact(int A, int B) {
		int result = -1;
		for(int i = 1; i <= Math.sqrt(A); i++) {
			if(A % i == 0) {
				if(gcd(A / i, B) == 1) {
					return A/ i;
				} else if(gcd(i, B) == 1) {
					result = i;
				}
			}
		}
		return result;
    }
	
	
	private int gcd(int a, int b) {
		if(a > b) {
			int temp = a;
			a = b;
			b = temp;
		}
		int remainder = b % a;
		if(remainder == 0) {
			return a;
		} 
		return gcd(a, remainder);
		
	}

}
