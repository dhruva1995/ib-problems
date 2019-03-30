package hacker.earth;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class CityCoup {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		
		int t = Integer.parseInt(reader.readLine());
		
		for(int i = 0; i < t; i++) {
			
			solveProblem();
			
		}
		
		
	}

	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}
	
	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
	
	private static void solveProblem() throws Exception {
		int n = Integer.parseInt(reader.readLine());
		Point points[] = new Point[n];
		
		
		for(int i = 0; i < n; i++) {
			int[] xy = readInts(reader);
			points[i] = new Point(xy[0], xy[1]);
		}
		
		int[] k = readInts(reader);
		
		Arrays.sort(k);
		
		long[] distances = new long[n];
		
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				int manhattan = Math.abs(points[i].x - points[j].x) + Math.abs(points[i].y - points[j].y);
				distances[i] += manhattan;
				distances[j] += manhattan;
			}
		}
		Arrays.sort(distances);
		
		long totalVernerability = 0;
		
		for(int i = 0; i < n; i++) {
			totalVernerability += k[i] * distances[n - 1 - i];
		}
		
		System.out.println(totalVernerability);
		
	}
	
	
	
}
