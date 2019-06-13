package skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TheKingsMarchWithHeap {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		int t = Integer.parseInt(reader.readLine());

		for (int i = 0; i < t; i++) {

			solve();
		}

	}

	private static void solve() throws Exception {

		int n = Integer.parseInt(reader.readLine());

		char[][] board = readBoard(n);

		int[][] visited = new int[n][];

		for (int i = 0; i < n; i++) {
			visited[i] = new int[n];
		}

		board[n - 1][n - 1] = '0';

		PriorityQueue<Point> heap = new PriorityQueue<>();

		int pathCount = 0, maxCount = 0;

		heap.add(new Point(n - 1, n - 1, 0));

		while (!heap.isEmpty()) {

			Point current = heap.poll();
			if (board[current.x][current.y] == 'e') {
				if (current.currentCoins > maxCount) {
					maxCount = current.currentCoins;
					pathCount = 1;
				} else if (current.currentCoins == maxCount) {
					pathCount++;
				}

			}  else {
				
				
				if(visited[current.x][current.y] > current.currentCoins) {
					continue;
				}
				
				int currentCoints = board[current.x][current.y] - '0';
				
				if (isValid(current.x - 1, current.y, n) && (board[current.x - 1][current.y] != 'x')) {
					Point leftPoint = new Point(current.x - 1, current.y, current.currentCoins + currentCoints);
					heap.add(leftPoint);
				}

				if (isValid(current.x, current.y - 1, n) && (board[current.x][current.y - 1] != 'x')) {
					Point upperPoint = new Point(current.x, current.y - 1, current.currentCoins + currentCoints);
					heap.add(upperPoint);
				}

				if (isValid(current.x - 1, current.y - 1, n) && (board[current.x - 1][current.y - 1] != 'x')) {
					Point topLeft = new Point(current.x - 1, current.y - 1, current.currentCoins + currentCoints);
					heap.add(topLeft);
				}
				visited[current.x][current.y] = current.currentCoins;
			}
		}
		System.out.println(maxCount + " " + pathCount);

	}

	private static boolean isValid(Point p, int n) {
		return isValid(p.x, p.y, n);
	}

	private static boolean isValid(int x, int y, int n) {
		return (x < 0 || x >= n || y < 0 || y >= n) ? false : true;
	}

	private static class Point implements Comparable<Point> {
		int x, y, currentCoins;

		public Point(int x, int y, int currentCoins) {
			super();
			this.x = x;
			this.y = y;
			this.currentCoins = currentCoins;
		}

		@Override
		public int compareTo(Point that) {
			return -Integer.compare(this.currentCoins, that.currentCoins);
		}

	}

	private static char[][] readBoard(int n) throws IOException {

		char[][] board = new char[n][];

		for (int i = 0; i < n; i++) {
			board[i] = new char[n];
			String[] row = reader.readLine()
					.split("\\s");
			for (int j = 0; j < n; j++) {
				board[i][j] = row[j].charAt(0);
			}
		}
		return board;
	}

}
