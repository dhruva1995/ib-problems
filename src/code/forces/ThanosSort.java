package code.forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class ThanosSort {

	
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		reader.readLine();
		
		int[] input = readInts(reader);
		
		for(int width = input.length; width > 1; width /= 2) {
			for(int i = 0; i < input.length; i += width) {
				if(isSorted(i, width, input)) {
					System.out.println(width);
					return;
				}
			}
		}
		System.out.println(1);
		
	}

	private static boolean isSorted(int i, int width, int[] input) {
		for(int j = i + 1; j <= i + width - 1; j++) {
			if(input[j] < input[j - 1]) {
				return false;
			}
			
		}
		return true;
	}
	
	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}
	
	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
}
