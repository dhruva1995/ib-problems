package ib.level.crossing;

import java.util.ArrayList;
import java.util.Arrays;

public class NUMRANGE {

	
	
	public static void main(String[] args) {
		System.out.println(new NUMRANGE().numRange(new ArrayList<>(Arrays.asList()), 6, 8));
	}
	
	
	public int numRange(ArrayList<Integer> A, int sumGE, int sumLE) {
		
		int countOfSubSeq = 0;
		int leftBound = 0, rightBound = 0; long leftSum = 0, rightSum = 0;
		for(int i = 0; i < A.size(); i++) {
			leftBound = Math.max(i, leftBound);
			leftSum = Math.max(0, leftSum);
			while(leftBound < A.size() && leftSum + A.get(leftBound) < sumGE) {
				leftSum += A.get(leftBound);
				leftBound++;
			}
			rightBound = leftBound;
			rightSum = leftSum;
			while(rightBound < A.size() && rightSum + A.get(rightBound) <= sumLE) {
				rightSum += A.get(rightBound);
				rightBound++;
			}
			countOfSubSeq += rightBound - leftBound;
			leftSum -= A.get(i);
			
			
		}
		return countOfSubSeq;
		
		
    }
	
}
