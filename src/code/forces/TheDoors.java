package code.forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class TheDoors {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		reader.readLine();
		
		int[] doors = readInts(reader);
		
		
		int lastDoor = doors.length - 2;
		
		while(doors[lastDoor] == doors[doors.length - 1]) {
			lastDoor--;
		}
		
		System.out.println(lastDoor + 1);
	}
	
	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}
	
	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
	
}
