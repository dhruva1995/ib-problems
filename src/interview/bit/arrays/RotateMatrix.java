package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateMatrix {

	
	
	public static void main(String[] args) {
		List<List<Integer>> input = Arrays.asList(
					Arrays.asList(1)
				);
		new RotateMatrix().rotate(input);
		input.forEach(System.out::println);
	}
	
	public void rotate(List<List<Integer>> a) {
		int top = 0, left = 0, bottom = a.size() - 1, right = a.size() - 1;
		
		
		while (top <= bottom && left <= right) {
			int read, write;
			for (int i = 0; i < bottom - top; i++) {
				write = a.get(top).get(left + i);
				
				read = a.get(top + i).get(right);
				a.get(top + i).set(right, write);
				write = read;
				
				
				read = a.get(bottom).get(right - i);
				a.get(bottom).set(right - i, write);
				write = read;
				
				
				read = a.get(bottom - i).get(left);
				a.get(bottom - i).set(left, write);
				
				
				a.get(top).set(left + i, read);
			}
			top++;
			left++;
			bottom--;
			right--;
		}
		
		
    }
	
	
}
