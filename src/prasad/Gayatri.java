package prasad;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Gayatri {

	
	public static void main(String[] args) {
		
		String s = "abczdfw";
		long champ = Long.MAX_VALUE;
		for(int i = 1; i < s.length(); i++) {
			String a = s.substring(0, i);
			long suma = getMinCharAndSum(a);
			
			String b = s.substring(i);
			long sumb = getMinCharAndSum(b);
			System.out.println(a + " - " + b  + " -> "  + (suma + sumb));
			champ = Math.min(champ, suma + sumb);
			
		}
		
		System.out.println(champ);
		
		
	}
	
	
	public static long getMinCharAndSum(String s) {
		
		
		int[][] distances = new int[s.length()][];
		
		for(int i = 0; i < s.length(); i++) {
			distances[i] = new int[s.length()];
		}
		
		for(int i = 0; i < s.length(); i++) {
			
			for(int j = 0; j < s.length(); j++) {
				distances[j][i] = s.charAt(j) - s.charAt(i);
				if(distances[j][i] < 0) {
					distances[j][i] += 26;
				}
			}
			
		}
		Arrays.stream(distances)
			.map(Arrays::toString)
			.forEach(System.out::println);
		
		
		return IntStream.range(0, distances.length)
			.boxed()
			.min((a, b) -> Long.compare(sum(distances[a]), sum(distances[b])))
			.map((i) -> sum(distances[i]))
			.get();
	}
	
	static long sum(int[] a) {
		return Arrays.stream(a)
			.asLongStream()
			.sum();
	}
	
}
