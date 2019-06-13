package code.forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class ServalAndToyBricks {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		
		int nmh[] = readInts(reader);
		
		int n = nmh[0], m = nmh[1], h = nmh[2];
		
		int front[] = readInts(reader);
		
		int left[] = readInts(reader);
		
		int matrix[][] = new int[n][];
		
		for(int i = 0; i < n; i++) {
			matrix[i] = readInts(reader);
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				
				if(matrix[i][j] == 1) {
					matrix[i][j] = Math.min(front[j], left[i]);
				}
				
				
			}
			
		}
		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(matrix[i][j] + " ");
				
			}
			
			System.out.println();
		}
		
		
	}
	
	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}
	
	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
	
	
}
