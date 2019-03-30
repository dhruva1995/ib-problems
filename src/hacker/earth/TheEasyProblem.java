package hacker.earth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TheEasyProblem {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		
		int t = Integer.parseInt(reader.readLine());
		
		for(int i = 0; i < t; i++) {
			
			String test = reader.readLine();
			
			printLexographicallySmalSubStrWithMaxFreq(test);
			
		}
		
	}

	private static void printLexographicallySmalSubStrWithMaxFreq(String test) {
		
		test.chars()
			.mapToObj(i -> (char)i)
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
			.entrySet()
			.stream()
			.sorted((e1, e2) -> Long.compare(e1.getValue(), e2.getValue()) == 0 ? Integer.compare(e1.getKey(), e2.getKey()) :  Long.compare(e1.getValue(), e2.getValue()))
			.findFirst()
			.ifPresent(e -> System.out.println(e.getKey()));

		
		
		
	}
	
	
}
