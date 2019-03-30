package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MergeOverlappingIntervals {

	public static class Interval {
	    int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
	}	
	
	
	public static void main(String[] args) {
		
		
		
	}
	
	
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < intervals.size(); i++) {
        	Interval examinee = intervals.get(i);
        	map.computeIfAbsent(examinee.start, key -> 0);
        	map.computeIfAbsent(examinee.end, key -> 0);
        	map.compute(examinee.start, (k, oldValue) -> oldValue + 1);
        	map.compute(examinee.end, (k, oldValue) -> oldValue - 1);
        	
        }
        
        ArrayList<Interval> result = new ArrayList<>();
        long sum = 0;
        Interval newInterval = null;
        for(Entry<Integer, Integer> e : map.entrySet()) {
        	if(sum == 0) {
        		newInterval = new Interval();
        		newInterval.start = e.getKey();
        	}
        	sum += e.getValue();
        	if(sum == 0) {
        		newInterval.end = e.getKey();
        		result.add(newInterval);
        		newInterval = null;
        	}
        }
        return result;
        
    }
	
}
