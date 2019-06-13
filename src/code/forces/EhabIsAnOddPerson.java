package code.forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class EhabIsAnOddPerson {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		reader.readLine();
		
		int[] a = readInts(reader);
		
		int evenCount = 0, oddCount = 0;
		
		for(int i : a) {
			
			if((i & 1) == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
			
		}
		
		if(evenCount != 0 && oddCount != 0) {
			Arrays.sort(a);
		}
		
		
		Arrays.stream(a).forEach(i -> System.out.print(i + " "));
		
		
	}
	
	
	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}
	
	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
	
	
	
}
