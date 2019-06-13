package code.forces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TilingChallenge {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws Exception {
		
		int n = Integer.parseInt(reader.readLine());
		
		char[][] board = new char[n][];
		
		for(int i = 0; i < n; i++) {
			board[i] = reader.readLine().toCharArray();
		}
		
		
		for(int i = 1; i < n - 1; i++) {
			for(int j = 1; j < n - 1; j++) {
				if(board[i + 1][j] == '.' && board[i - 1][j] == '.' && board[i][j + 1] == '.' && board[i][j - 1] == '.' && board[i][j] == '.') {
					board[i + 1][j] = '#'; board[i - 1][j] = '#'; board[i][j + 1] = '#'; board[i][j - 1] = '#'; board[i][j] = '#';
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(board[i][j] == '.') {
					System.out.println("NO");
					return;
				}
			}
		}
		System.out.println("YES");
	}
	
}
