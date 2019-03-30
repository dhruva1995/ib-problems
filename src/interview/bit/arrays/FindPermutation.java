package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FindPermutation {

	public static void main(String[] args) {
		String input = "DDDIIDDDII";
		System.out.println(new FindPermutation().findPerm(input, input.length() + 1));
	}

	public ArrayList<Integer> findPerm(final String A, int B) {
		int[] result = new int[B];
		int credits = 1, read = 0, write = 0;
		if(A.charAt(0) == 'I') {
			result[write++] = 1;
			credits = 2;
		} else {
			while(read < A.length() && A.charAt(read) == 'D') {
				read++;
			}
			for(write = read; write >= 0; write--) {
				result[write] = credits++;
			}
			write = read + 1;
		}
		
		while (read < A.length()) {
			int startOfISegment = read;
			while (read < A.length() && A.charAt(read) == 'I') {
				read++;
			}

			if (read == A.length()) {
				for (; write < result.length; write++) {
					result[write] = credits++;
				}
				return convertArrayToArrayList(result);
			} else {
				int lastIPosition = read - 1;
				for(int i = startOfISegment; i < lastIPosition; i++) {
					result[write++] = credits++;
				}
				
				while(read < A.length() && A.charAt(read) == 'D') {
					read++;
				}
				int lastDPosition = read - 1;
				for(int i = lastDPosition; i >= lastIPosition; i--) {
					result[i + 1] = credits++;
				}
				write = read + 1;
			}
			
		}
		
		
		
		
		
		return convertArrayToArrayList(result);
	}

	private ArrayList<Integer> convertArrayToArrayList(int[] result) {
		return Arrays.stream(result).boxed().collect(Collectors.toCollection(ArrayList::new));
	}

}
