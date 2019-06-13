package code.forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class EhabFailsToBeThanos {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		reader.readLine();
		
		int[] nums = readInts(reader);
		
		int count = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == nums[0]) {
				count++;
			}
		}
		
		if(count == nums.length) {
			System.out.println(-1);
		} else {
			
			Arrays.sort(nums);
			
			Arrays.stream(nums).forEach(num -> System.out.print(num + " "));
			
		}
		
		
		
		
		
	}
	
	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}
	
	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
	
}
