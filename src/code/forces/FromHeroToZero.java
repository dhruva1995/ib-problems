package code.forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class FromHeroToZero {
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(reader.readLine());
		
		for(int i = 0; i < t; i++) {
			solve();
		}
		
	}

	private static void solve() throws IOException {
		long nk[] = readLongs(reader);
		
		long n = nk[0], k = nk[1];
		
		long count = 0;
		
		while(n > 0) {
			if(n % k == 0) {
				count++;
				n = n / k;
			} else {
				count += n % k;
				n -= (n % k);
			}
		}
		System.out.println(count);
	}
	
	public static long[] readLongs(BufferedReader reader) throws IOException {
		return toLongArray(reader.readLine());
	}
	
	public static long[] toLongArray(String s) {
		return Stream.of(s.split("\\s")).mapToLong(Long::parseLong).toArray();
    }
	
}
