package skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.stream.Stream;

public class NumberOfFudges {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		int t = Integer.parseInt(reader.readLine());
		
		for(int i = 0; i < t; i++) {
			
			solve();
			
		}
		
		
	}

	private static void solve() throws IOException {
		
		int[] allCakesWeight =  Stream.of(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).skip(1).toArray();
		
		int n = Integer.parseInt(reader.readLine());
		int m = allCakesWeight.length;
		BitSet[] possiblities = new BitSet[n + 1];
		for(int i = 0; i < possiblities.length; i++) {
			possiblities[i] = new BitSet(m + 1);
		}
		
		for(int j = 0; j <= m;  j++) {
			possiblities[0].set(j);
		}
		
		for(int j = 1; j <= n; j++) {
			possiblities[n].clear(j);
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				possiblities[i].set(j, possiblities[i].get(j - 1));
				
				if(i >= allCakesWeight[j - 1]) {
					boolean temp = possiblities[i].get(j) || possiblities[i - allCakesWeight[j - 1]].get(j - 1);
					possiblities[i].set(j, temp);
				}
			}
			
		}
		
		System.out.println(possiblities[n].get(m) ? "YES" :"NO");
		
	}
	
	

}
