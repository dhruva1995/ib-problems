package code.forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class KanbanNumbers {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int[] nums = {1, 2, 3, 5, 10, 17, 29, 46, 75};
		
		int i = Integer.parseInt(reader.readLine());
		
		System.out.println( Arrays.binarySearch(nums, i) > 0 ? "YES" : "NO");
		
		
		
	}
	
	
}
