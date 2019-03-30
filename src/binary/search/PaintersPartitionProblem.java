package binary.search;

import java.util.ArrayList;
import java.util.Arrays;

public class PaintersPartitionProblem {

	
	public static void main(String[] args) {
		System.out.println(new PaintersPartitionProblem().paint(2, 5, new ArrayList<>(Arrays.asList(1, 10))));
	}
	
	public int paint(int noOfPainters, int timeForUnitWork, ArrayList<Integer> work) {
        long max = work.stream().mapToLong(i -> (long)i).sum();
        long min = work.stream().mapToInt(i -> i).min().getAsInt();
        long actualResult = -1;
        while(min <= max) {
        	long mid = min + (max - min) / 2;
        	if(isPossible(mid, noOfPainters, work)) {
        		actualResult = mid;
        		max = mid - 1;
        	} else {
        		min = mid + 1;
        	}
        }
        
        return (int) (((actualResult) % 10000003 * (timeForUnitWork) % 10000003) % 10000003);
        
    }
	
	private boolean isPossible(long maxWorkLoadForEachPainter, int noOfPainters, ArrayList<Integer> work) {
		
		int workOfCurrentPainter = 0;
		int w = 0, p = 0;
		while (w < work.size() && p < noOfPainters) {
			
			if(workOfCurrentPainter + (work.get(w)) > maxWorkLoadForEachPainter) {
				p++;
				workOfCurrentPainter= 0;
				continue;
			} else {
				workOfCurrentPainter += work.get(w);
				w++;
			}
			
			
		}
		if(w == work.size() && 
				(p < noOfPainters - 1 || (p == noOfPainters - 1 && workOfCurrentPainter <= maxWorkLoadForEachPainter))) {
			return true;
		}
		return false;
	}
	
	
}
