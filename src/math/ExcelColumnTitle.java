package math;

public class ExcelColumnTitle {

	public static void main(String[] args) {
		System.out.println(new ExcelColumnTitle().convertToTitle(18307));
	}
	
	
	public String convertToTitle(int A) {
        String result = "";
        if(A <= 0) {
        	return result;
        }
        
        int quo = A / 26;
        int rem = A % 26;
        if(rem == 0) {
        	rem = 26;
        	quo--;
        }
        
        return convertToTitle(quo) + (char)(rem + 'A' - 1);
        
        
        
    }
	
	
}
