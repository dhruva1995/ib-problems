package strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AddBinaryStrings {
	
	
	public static void main(String[] args) {
		System.out.println(new AddBinaryStrings().addBinary("1111", "010"));
	}

    public String addBinary(String A, String B) {
    	
    	String large, small;
    	
    	if("".equals(A) && "".equals(B)) {
    		return "0";
    	}
        
    	if(A.length() > B.length()) {
    		large = A;
    		small = B;
    	} else {
    		large = B;
    		small = A;
    	}
        
        int sizeDiff = large.length() - small.length();
        
        small = IntStream.range(0, sizeDiff).mapToObj( i -> "0").collect(Collectors.joining("")) + small;
        
        char[] result = new char[large.length() + 1];
        int carry = 0;
        for(int read = result.length - 2, write = result.length - 1; read >= 0; read--, write--) {
        	
        	int a = large.charAt(read) - '0';
        	int b = small.charAt(read) - '0';
        	result[write] = (char) (((a + b + carry) % 2) + '0');
        	carry = (a + b + carry) / 2;
        }
        
       	result[0] = carry == 1 ? '1' : '0';
        return (carry == 1) ? new String(result) : new String(result).substring(1, result.length); 
    }
	
}
