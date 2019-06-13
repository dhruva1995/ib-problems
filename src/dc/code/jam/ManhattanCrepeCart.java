package dc.code.jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class ManhattanCrepeCart {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		int t = Integer.parseInt(reader.readLine());
		
		for(int i = 1; i <= t; i++) {
			
			String solution = solve();
			System.out.println("Case #" + i + ": " + solution);
			
		}
		
		
		
	}

	
	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}
	
	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
	
	private static String solve() throws Exception {
		int[] pq = readInts(reader);
		int p = pq[0], q = pq[1];
		
		int[] e = new int[q + 1], w = new int[q + 1], n = new int[q + 1], s = new int[q + 1];
		
		for(int i = 0; i < p; i++) {
			String[] person = reader.readLine().split("\\s");
			int x = Integer.parseInt(person[0]), y = Integer.parseInt(person[1]);
			switch(person[2]) {
			case "N" :
				n[y]++;
				break;
			case "S":
				s[y]++;
				break;
			case "E":
				e[x]++;
				break;
			case "W":
				w[x]++;
				break;
			}
		}
		int[] y = new int[q + 1];
		int counter = s[q];
		for(int i = q - 1; i >= 0; i--) {
			y[i] += counter;
			counter += s[i];
		}
		
		counter = n[0];
		for(int i = 1; i <= q; i++) {
			y[i] += counter;
			counter += n[i];
		}
		
		int[] x = new int[q + 1];
		counter = e[0];
		for(int i = 1; i <= q; i++) {
			x[i] += counter;
			counter += e[i];
		}
		
		counter = w[q];
		for(int i = q - 1; i >= 0; i--) {
			x[i] += counter;
			counter += w[i];
		}
		
		int xMax = 0;
		for(int i = 1; i <= q; i++) {
			if(x[i] > x[xMax]) {
				xMax = i;
			}
		}
		
		int yMax = 0;
		for(int i = 1; i <= q; i++) {
			if(y[i] > y[yMax]) {
				yMax = i;
			}
		}
		
		
		return xMax + " " + yMax;
	}
	
	
}
