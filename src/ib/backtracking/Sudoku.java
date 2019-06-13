package ib.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Sudoku {

	private static final int SIDE = 9;
	
	public static void main(String[] args) {
		
		
		ArrayList<ArrayList<Character>> sudoku = new ArrayList<>(Arrays.asList(
				stringToCharList("53467891."),
				stringToCharList("67219534."),
				stringToCharList("19834256."),
				stringToCharList("859761423"),
				stringToCharList("426853791"),
				stringToCharList("713924856"),
				stringToCharList(".61537284"),
				stringToCharList("287419635"),
				stringToCharList(".45286179")
				)
				);
		new Sudoku().solveSudoku(
				sudoku
				);
		
		//[], [], [], [], [], []
		System.out.println(sudoku);
		
		
	}
	
	private static ArrayList<Character> stringToCharList(String a) {
		return a.chars().mapToObj(i -> (char)i).collect(Collectors.toCollection(ArrayList::new));
	}
	
	
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
    	solveSudoku(0, a);
    }	
	
    private boolean solveSudoku(int currentRow, ArrayList<ArrayList<Character>> puzzle) {
    	System.out.println(currentRow);
    	if(currentRow == SIDE) {
    		System.out.println(puzzle);
    		System.out.println("Reached");
    		return true;
    	} else {
    		boolean hasAnyHole = false;
    		for(int c = 0; c < SIDE; c++) {
    			if(!Character.isDigit(puzzle.get(currentRow).get(c))) {
    				hasAnyHole = true;
    				int i = 1;
    				for(; i <= SIDE; i++) {
    					if(isValid(puzzle, currentRow, c, (char) (i + '0'))) {
    						puzzle.get(currentRow).set(c, (char) (i + '0'));
    						boolean result = solveSudoku(currentRow, puzzle);
    						if(result) {
    							return result;
    						}
    					}
    				}
    				if(i > SIDE) {
    					puzzle.get(currentRow).set(c, '.');
    					return false;
    				}
    			}
    		}
    		if(!hasAnyHole) {
    			boolean result = solveSudoku(currentRow + 1, puzzle);
    			if(result) {
    				return result;
    			}
    		}
    	}
		return false;
    	
    	
    }

	private boolean isValid(ArrayList<ArrayList<Character>> puzzle, int currentRow, int currentColumn, char test) {
		for(int r = 0; r < SIDE; r++) {
			if(puzzle.get(r).get(currentColumn) == test) {
				return false;
			}
		}
		
		for(int c = 0; c < SIDE; c++) {
			if(puzzle.get(currentRow).get(c) == test) {
				return false;
			}
		}
		
		for(int i = (currentRow / 3) * 3; i < ((currentRow / 3) * 3) + 3; i++) {
			for(int j = (currentColumn / 3) * 3; j < ((currentColumn / 3) * 3) + 3; j++) {
				if(puzzle.get(i).get(j) == test) {
					return false;
				}
			}
		} 
		
		return true;
	}
    
}
