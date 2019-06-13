package code.forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class ServalAndBus {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		
		int nt[] = readInts(reader);
		int n = nt[0], t = nt[1];
		int champIndex = -1, champWait = Integer.MAX_VALUE;
		for(int i = 1; i <= n; i++) {
			
			int sd[] = readInts(reader);
			int s = sd[0], d = sd[1];
			
			int nthTerm = Math.max(1, (int) (Math.ceil(((double)t - s) / d) + 1));
			
			int nextValue = s + ((nthTerm - 1) * d);
			
			if(nextValue - t < champWait) {
				champIndex = i;
				champWait = nextValue - t;
			}
		}
		
		System.out.println(champIndex);
		
	}
	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}
	
	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
	
	
}
