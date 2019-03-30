package hacker.earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class MaximumMoney {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	private static class Shop {

		private static int counter = 1;

		int gold, platinum, diamond;

		boolean visited;

		private final int index;

		public Shop(int[] values) {
			super();
			// System.out.println(Arrays.toString(values));
			index = counter++;
			this.gold = values[0];
			this.platinum = values[1];
			this.diamond = values[2];
		}

		@Override
		public String toString() {
			return "" + this.index + " " + Arrays.asList(this.gold, this.platinum, this.diamond);
		}

	}

	public static void main(String[] args) throws IOException {

		int N = readInts(reader)[0];

		int xyz[] = readInts(reader);

		int x = xyz[0], y = xyz[1], z = xyz[2];

		long result = 0;

		PriorityQueue<Shop> goldHeap = new PriorityQueue<>((s, t) -> -Integer.compare(s.gold, t.gold));
		PriorityQueue<Shop> platHeap = new PriorityQueue<>((s, t) -> -Integer.compare(s.platinum, t.platinum));
		PriorityQueue<Shop> diamondHeap = new PriorityQueue<>((s, t) -> -Integer.compare(s.diamond, t.diamond));

		for (int i = 0; i < N; i++) {
			Shop shop = new Shop(readInts(reader));
			goldHeap.add(shop);
			platHeap.add(shop);
			diamondHeap.add(shop);
		}

		int count = 0;

		while (count < N) {
			removeVisitedOnPoll(goldHeap);
			removeVisitedOnPoll(platHeap);
			removeVisitedOnPoll(diamondHeap);

			if ((goldHeap.peek().gold >= platHeap.peek().platinum || y == 0)
					&& (z == 0 || goldHeap.peek().gold >= diamondHeap.peek().diamond) && x > 0) {
				goldHeap.peek().visited = true;
				result += goldHeap.poll().gold;

				x--;

			} else if ((platHeap.peek().platinum >= goldHeap.peek().gold || x == 0)
					&& (z == 0 || platHeap.peek().platinum >= diamondHeap.peek().diamond && y > 0)) {

				platHeap.peek().visited = true;
				result += platHeap.poll().platinum;
				y--;
			} else {
				diamondHeap.peek().visited = true;
				result += diamondHeap.poll().diamond;
				z--;
			}

			count++;
		}

		System.out.println(result);

	}

	private static void removeVisitedOnPoll(PriorityQueue<Shop> heap) {
		while (heap.peek().visited) {
			heap.poll();
		}
	}
	
	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}
	
	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
	

}
