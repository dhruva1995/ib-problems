package ib.level.crossing;

import java.util.ArrayList;
import java.util.Arrays;

public class UniquePathsIII {
	
	public static void main(String[] args) {
		
		System.out.println(
				new UniquePathsIII().
					solve(new ArrayList<>(Arrays.asList(
							new ArrayList<>(Arrays.asList(1, 0, 0, 0)),
							new ArrayList<>(Arrays.asList(0, 0, 0, 0)),
							new ArrayList<>(Arrays.asList(0, 0, 2, -1))
							
							
							
							
							
							
							)))
					
				
				
				
				
				
				);
	}
	

	private int count = 0;
	
	public int solve(ArrayList<ArrayList<Integer>> A) {
		int startX = -1, startY = -1, possibleSteps = 0;
		
		for(int i = 0; i < A.size(); i++) {
			for(int j = 0; j < A.get(0).size(); j++) {
				int step = A.get(i).get(j);
				if(step == 1) {
					startX = i; startY = j;
				} else if(step == 0) {
					possibleSteps++;
				}
			}
		}
		solveHelper(A, startX, startY, possibleSteps);
		return this.count;
    }
	
	
	private void solveHelper(ArrayList<ArrayList<Integer>> A, int x, int y, int possibleSteps) {
		if(x < 0 || x >= A.size() || y < 0 || y >= A.get(0).size() || A.get(x).get(y) == -1) {
			return;
		} else if(A.get(x).get(y) == 2 && possibleSteps == 0) {
			count++;
			return;
		} else {
			int prevValue = A.get(x).get(y);
			possibleSteps = prevValue == 0 ? possibleSteps - 1 : possibleSteps;
			A.get(x).set(y, -1);
			solveHelper(A, x, y + 1, possibleSteps);
			solveHelper(A, x, y - 1, possibleSteps);
			solveHelper(A, x + 1, y, possibleSteps);
			solveHelper(A, x - 1, y, possibleSteps);
			A.get(x).set(y, prevValue);
		}
	}
	
	
}
