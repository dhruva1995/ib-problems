package strings;

import java.util.ArrayList;

public class ValidIpAddresses {

	
	public static void main(String[] args) {
		
		new ValidIpAddresses().restoreIpAddresses("25525511135").forEach(System.out::println);
	}
	
	
	public ArrayList<String> restoreIpAddresses(String input) {
		ArrayList<String> result = new ArrayList<>();
		
        if(input.length() > 0 && input.length() <= 12) {
        	char[] buffer = new char[input.length() + 3];
        	fillInternal(result, buffer, 0, 0, input, 0);
        }
        return result;
    }

	private void fillInternal(ArrayList<String> result, char[] buffer, int stage, int readIndex, String input, int writeIndex) {
		
		if(stage == 4) {
			//System.out.println(new String(buffer));
			if(readIndex == input.length()) {
				result.add(new String(buffer));
			}
			return;
		}
		
		
		for (int shiftOfPeriod = 1; 
				shiftOfPeriod <= 3 && 
				readIndex + shiftOfPeriod <= input.length() && 
				isValidPart(input.substring(readIndex, readIndex + shiftOfPeriod));
				shiftOfPeriod++) {
			buffer[writeIndex + shiftOfPeriod - 1] = input.charAt(readIndex + shiftOfPeriod - 1);
			if(stage != 3) {
				buffer[writeIndex + shiftOfPeriod] = '.';
			}
			fillInternal(result, buffer, stage + 1, readIndex + shiftOfPeriod, input, writeIndex + shiftOfPeriod + 1);
		}
		
	}
	
	private boolean isValidPart(String ipPart) {
		if(ipPart.length() == 0) {
			return false;
		}
		
		if(ipPart.length() > 1 && ipPart.charAt(0) == '0') {
			return false;
		}
		return Integer.parseInt(ipPart) <= 255;
	}
	
	
}
