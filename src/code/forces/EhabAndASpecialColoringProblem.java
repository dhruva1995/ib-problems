package code.forces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EhabAndASpecialColoringProblem {

	
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(reader.readLine());
		int a[] = new int[n + 1];
		int counter = 1;
		for(int i = 2; i <= n; i++) {
			if(a[i] == 0) {
				for(int j = i; j <= n; j += i) {
					a[j] = counter;
				}
				counter++;
			}
		}
		
		Arrays.stream(a).skip(2).forEach(i -> System.out.println(i + " "));
		
		
		
	}
	
}
