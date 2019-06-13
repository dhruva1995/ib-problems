package dc.code.jam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class RobotProgrammingStrategy {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(reader.readLine());
		
		for(int t = 1; t <= T; t++) {
			
			System.out.format("Case #%d: ", t);
			
			solve();
			
			
		}
		
		
	}

	private static void solve() throws Exception {
		
		int otherRobotsCount = Integer.parseInt(reader.readLine());
		
		LinkedList<String> otherRobots = new LinkedList<>();
		
		for(int i = 0; i < otherRobotsCount; i++) {
			otherRobots.add(reader.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		boolean win = false;
		
		long pointer = 0;
		
		while(!win && !otherRobots.isEmpty()) {
			Set<Character> available = new HashSet<>(Arrays.asList('R', 'P', 'S'));
			Set<Character> eliminate = new HashSet<>();
			
			Iterator<String> remainingRobots = otherRobots.iterator();
			
			
			
			
			while(remainingRobots.hasNext()) {
				
				String other = remainingRobots.next();
				
				char c = other.charAt((int)(pointer % other.length()));
				available.add(c);
				switch (c) {
				case 'R' : 
					eliminate.add('S');
					break;
				case 'S' :
					eliminate.add('P');
					break;
				case 'P':
					eliminate.add('R');
					break;
				}
				
				if(eliminate.size() == 3) {
					System.out.println("IMPOSSIBLE");
					return;
				}
			}
			
			
			if(available.size() == 1) {
				switch (available.iterator().next()) {
				case 'R' : 
					sb.append('P');
					break;
				case 'S' :
					sb.append("R");
					break;
				case 'P':
					sb.append("S");
					break;
				}
				break;
			} else {
				char eliminationChar;
				if(available.contains('P') && available.contains('R')) {
					sb.append("P");
					eliminationChar = 'R';
				} else if(available.contains('P') && available.contains('S')) {
					sb.append("S");
					eliminationChar = 'P';
				} else {
					sb.append("R");
					eliminationChar = 'S';
				}
				remainingRobots = otherRobots.iterator();
				while(remainingRobots.hasNext()) {
					String s = remainingRobots.next();
					
					if(eliminationChar == s.charAt((int)(pointer % s.length()))) {
						remainingRobots.remove();
					}
				}
				
			}
			
			
			
			pointer++;
		}
		
		System.out.println(sb.toString());
		
		
	}
	
	
}
