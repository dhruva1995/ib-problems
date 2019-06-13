package ib.stacks.queus;

import java.util.Arrays;
import java.util.List;

public class RainWaterTrapped {
	
	public static void main(String[] args) {
		System.out.println(
				new RainWaterTrapped().trap(Arrays.asList(6, 4, 2, 2, 9, 1, 1, 8, 9))
				
				
				);
		
	}
	
	
	public int trap(final List<Integer> A) {
		int[] leftMax = new int[A.size()];
		int[] rightMax = new int[A.size()];
		int champLeftMax = 0;
		leftMax[0] = -1;
		for(int i = 1; i < A.size(); i++) {
			if(A.get(champLeftMax) <= A.get(i)) {
				leftMax[i] = -1;
				champLeftMax = i;
			} else {
				leftMax[i] = champLeftMax;
			}
		}
		rightMax[rightMax.length - 1] = -1;
		int champRight = rightMax.length - 1;
		for(int i = rightMax.length - 2; i >= 0; i--) {
			if(A.get(champRight) <= A.get(i)) {
				rightMax[i] = -1;
				champRight = i;
			} else {
				rightMax[i] = champRight;
			}
			
		}
		int sum = 0;
		for(int i = 0; i < A.size(); i++) {
			if(leftMax[i] == -1 || rightMax[i] == -1) {
				continue;
			}
			sum += Math.min(A.get(leftMax[i]), A.get(rightMax[i])) - A.get(i);
		}
		return sum;
    }
	
}
