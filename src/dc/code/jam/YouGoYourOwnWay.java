package dc.code.jam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class YouGoYourOwnWay {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws Exception {
		int T = Integer.parseInt(reader.readLine());
		
		for(int i = 1; i <= T; i++) {
			
			reader.readLine();
			String input = reader.readLine();
			char[] result = new char[input.length()];
			for(int read = 0; read < input.length(); read++) {
				result[read] = input.charAt(read) == 'S' ? 'E' : 'S';
			}
			System.out.println("Case #" + i + ": " + new String(result));
			
		}
		
		
		
	}
	
	
}
