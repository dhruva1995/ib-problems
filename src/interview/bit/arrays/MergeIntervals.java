package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeIntervals {

	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "(" + start + ", " + end + ")";
		}
	}


	
	
	public static void main(String[] args) {
		MergeIntervals s = new MergeIntervals();

		System.out
				.println(
						s.insert(
								new ArrayList<>(Arrays.asList(new Interval(1, 2), new Interval(3, 4),
										new Interval(5, 6), new Interval(7, 8), new Interval(10, 11))),
								new Interval(0, 110)));
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		
		List<Integer> allOverlappingInterval = 
				IntStream.range(0, intervals.size())
					.boxed()
					.filter(i -> this.overlaps(newInterval, intervals.get(i)))
					.collect(Collectors.toList());
		
		
		
		
		Interval insertion = new Interval();
		if(!allOverlappingInterval.isEmpty()) {
			insertion.start = Math.min(intervals.get(allOverlappingInterval.get(0)).start, newInterval.start);
			insertion.end = Math.max(intervals.get(allOverlappingInterval.get(allOverlappingInterval.size() - 1)).end, newInterval.end);
		} else {
			insertion = newInterval;
		}
		intervals.removeIf(e -> this.overlaps(e, newInterval));
		intervals.add(insertion);
		Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
		return intervals;
	}

	private boolean overlaps(Interval a, Interval b) {
		
		return (a.start <= b.start && b.start <= a.end) || 
				(a.start <= b.end && b.end <= a.end) || 
				(b.start <= a.start && a.start <= b.end) || 
				(b.start <= a.end && a.end <= b.end);
	}
	

}
