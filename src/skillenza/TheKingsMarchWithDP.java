package skillenza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheKingsMarchWithDP {
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

		board[n - 1][n - 1] = '0';
		
		MaxCoinsAndPathsCount[][] memo = new MaxCoinsAndPathsCount[n][];
		
		for(int i = 0; i < n; i++) {
			memo[i] = new MaxCoinsAndPathsCount[n];
		}
		
		memo[0][0] = new MaxCoinsAndPathsCount();
		memo[0][0].pathsCount = 1;
		
		for(int k = 1; k <= ((2 * n) - 2); k++) {
			int y = Math.min(k, n - 1), x = k - y;
			while(y >= 0 && x < n && x >= 0 && y < n) {
				if(board[x][y] == 'x') {
					memo[x][y] = new MaxCoinsAndPathsCount();
				} else {
					
					List<MaxCoinsAndPathsCount> possibilities = new ArrayList<>(3);
					if (isValid(x - 1, y, n) && (board[x - 1][y] != 'x')) {
						possibilities.add(memo[x - 1][y]);
					} 
					
					if (isValid(x, y - 1, n) && (board[x][y - 1] != 'x')) {
						possibilities.add(memo[x][y - 1]);
					} 
					
					if (isValid(x - 1, y - 1, n) && (board[x - 1][y - 1] != 'x')) {
						possibilities.add(memo[x - 1][y - 1]);
					} 
					
					memo[x][y] = MaxCoinsAndPathsCount.club(possibilities);
					memo[x][y].maxCoins += (board[x][y] - '0');
				}
				y--;
				x = k - y;
			}
			
		}
		System.out.println(memo[n - 1][n - 1].maxCoins + " " + memo[n - 1][n - 1].pathsCount);
	}
	
	private static boolean isValid(int x, int y, int n) {
		return (x < 0 || x >= n || y < 0 || y >= n) ? false : true;
	}

	
	private static class MaxCoinsAndPathsCount {
		
		private long maxCoins;
		
		private long pathsCount;
		
		
		static MaxCoinsAndPathsCount club(List<MaxCoinsAndPathsCount> possiblePaths) {
			if(possiblePaths.isEmpty()) {
				return new MaxCoinsAndPathsCount();
			}
			
			
			Collections.sort(possiblePaths, (a, b) -> -Long.compare(a.maxCoins, b.maxCoins));
			MaxCoinsAndPathsCount max = possiblePaths.get(0);
			int pathsCount = 0;
			for(int i = 0; i < possiblePaths.size() && possiblePaths.get(i).maxCoins == max.maxCoins; i++) {
				pathsCount += possiblePaths.get(i).pathsCount;
			}
			
			MaxCoinsAndPathsCount newCoinsAndPathCounts = new MaxCoinsAndPathsCount();
			
			newCoinsAndPathCounts.pathsCount = pathsCount;
			if(pathsCount > 0) {
				newCoinsAndPathCounts.maxCoins = max.maxCoins;
			}
			return newCoinsAndPathCounts;
			
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
