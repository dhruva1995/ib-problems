package ib.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class NQueens {

	public static void main(String[] args) {
		System.out.println(new NQueens().solveNQueens(1).size());
		System.out.println("Done");
		
	}
	
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
    	LinkedList<Pair> queens = new LinkedList<>();
    	ArrayList<ArrayList<String>> result = new ArrayList<>();
    	solveNQueensHelper(queens, 0, result, a);
    	return result;
    }	
	
	
    private void solveNQueensHelper(LinkedList<Pair> queens, int currentRow, ArrayList<ArrayList<String>> result, int size) {
    	if(currentRow == size && queens.size() == size) {
    		addQueensToResult(queens, result);
    	} else {
    		for(int column = 0; column < size; column++) {
    			if(nonConflicting(queens, currentRow, column)) {
    				queens.addLast(new Pair(currentRow, column));
    				solveNQueensHelper(queens, currentRow + 1, result, size);
    				queens.removeLast();
    			}
    		}
    	}
	}


	private boolean nonConflicting(LinkedList<Pair> queens, int currentRow, int currentColumn) {
		for(Pair p : queens) {
			if(currentColumn == p.c || currentRow + currentColumn == p.r + p.c || currentRow - currentColumn == p.r - p.c) {
				return false;
			}
			
		}
		return true;
	}


	private void addQueensToResult(LinkedList<Pair> queens, ArrayList<ArrayList<String>> result) {
		ArrayList<String> grid = new ArrayList<>();
		for(Pair p : queens) {
			char[] row = new char[queens.size()];
			Arrays.fill(row, '.');
			row[p.c] = 'Q';
			grid.add(new String(row));
		}
		result.add(grid);
	}


	private static class Pair {
    	final int r, c;
    	Pair(int r, int c) {
    		this.r = r;
    		this.c = c;
    	}
    }
    
	
}
