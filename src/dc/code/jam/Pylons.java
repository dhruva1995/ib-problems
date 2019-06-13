package dc.code.jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class Pylons {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	private static int r = -1, c = -1;

	public static void main(String[] args) throws Exception {

		int T = Integer.parseInt(reader.readLine());

		for (int t = 1; t <= T; t++) {
			int rc[] = readInts(reader);
			int r = rc[0], c = rc[1];
			int prevX = -1, prevY = -1;
			int hitCount = 0;
			for (int i = c - 1; i >= 0; i--) {
				int cc = i;
				ArrayList<Pair> pair = new ArrayList<>();
				for (int j = 0; j < r; j++) {
					pair.add(new Pair(j, cc));
					cc = (cc + 2) % c;
				}
				Iterator<Pair> it = pair.iterator();
				Pair test;
				boolean hit = false;
				while (it.hasNext()) {
					test = it.next();
					if (validate(test.x, test.y, prevX, prevY)) {
						it.remove();
						hit  = true;
						pair.add(0, test);
						break;
					}
				}
				if(hit == false) {
					System.out.println("Case #" + t + ": IMPOSSIBLE");
					break;
				} else {
					hitCount++;
					prevX = pair.get(pair.size() - 1).x;
					prevY = pair.get(pair.size() - 1).y;
				}
			}

		}

	}

	private static boolean validate(int x, int y, int r, int c) {
		if (r == -1 || c == -1) {
			return true;
		}

		if (r == x || c == y || r - c == x - y || r + c == x + y) {
			return false;
		}
		return true;

	}

	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}

	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s"))
				.mapToInt(Integer::parseInt)
				.toArray();
	}

	private static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return x + " " + y;
		}
	}
}
