package code.forces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class PrefixSumPrimes {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws Exception {
		
		int n = Integer.parseInt(reader.readLine());
		
		int[] tiles = readInts(reader);
		
		int oneCount = 0, twoCount = 0;
		
		for(int i = 0; i < n; i++) {
			if(tiles[i] == 1) {
				oneCount++;
			} else {
				twoCount++;
			}
		}
		
		if(oneCount == 0) {
			for(int i = 0; i < twoCount; i++) {
				writer.append(2 + " ");
			}
		} else if(twoCount > 0) {
			writer.append("2 1 ");
			for(int i = 0; i < twoCount - 1; i++) {
				writer.append("2 ");
			}
			for(int i = 0; i < oneCount - 1; i++) {
				writer.append("1 ");
			}
		} else {
			for(int i = 0; i < oneCount; i++) {
				writer.append(1 + " ");
			}
		}
		
		writer.flush();
		
	}
	
	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}
	
	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
	
}
