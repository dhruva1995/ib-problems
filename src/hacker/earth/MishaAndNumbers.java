package hacker.earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MishaAndNumbers {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		
		int t = Integer.parseInt(reader.readLine());
		
		for(int i = 0; i < t; i++) {
			solveProblem();
		}
		
		
	}

	private static void solveProblem() throws Exception {
		int n = Integer.parseInt(reader.readLine());
		
		TreeMap<Integer, Long> a = reader.readLine().chars()
			.mapToObj(i -> i - '0')
			.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		
		TreeMap<Integer, Long> b = reader.readLine().chars()
				.mapToObj(i -> i - '0')
				.collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
		
		int[] c = reader.readLine().chars().map(i -> i - '0').toArray();
		
		int index = c.length - 1;
		
		while(index >= 0) {
			
			int first = a.firstKey();
			
			
		}
		
		
		
	}
	
	
}
