package ib.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PointsOnTheStraightLine {

	public static void main(String[] args) {
		//"-6 -17 5 -16 -18 -17 2 -4 5 -13 -2 20";

		System.out.println(new PointsOnTheStraightLine().maxPoints(new ArrayList<>(Arrays.asList(-6, 5, -18, 2, 5, -2)),
				new ArrayList<>(Arrays.asList(-17, -16, -17, -4, -13, 20))));

	}

	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		
		Map<Point, Long> pointCount = IntStream.range(0, a.size())
			.mapToObj(i -> new Point(a.get(i), b.get(i)))
			.collect(Collectors.groupingBy(p -> p, Collectors.counting()));
			
		Point[] points = pointCount.keySet().toArray(new Point[pointCount.size()]);
		
		int champCount = 0;
		
		for(int i = 0; i < points.length; i++) {
			HashMap<Double, Integer> slopeCount = new HashMap<>();
			for(int j = i + 1; j < points.length; j++) {
				final Point other = points[j];
				double slope = calculateSlope(points[i], points[j]);
				slopeCount.computeIfAbsent(slope, key -> 0);
				slopeCount.compute(slope, (key, oldValue) -> oldValue + pointCount.get(other).intValue());
			}
			int tempChamp = slopeCount.values().stream().max(Comparator.naturalOrder()).orElse(0);
			champCount = Math.max(champCount, tempChamp + pointCount.get(points[i]).intValue());
		}
		
		return champCount;
		
		
	}

	
	private double calculateSlope(Point a, Point b) {
		long numerator = b.y - a.y, denominator = b.x - a.x;
		
		if(denominator == 0) {
			return Double.POSITIVE_INFINITY;
		} else if(numerator == 0) {
			return 0d;
		}
		
		return (double)numerator / denominator;
	}


	private static class Point {

		private long x, y;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (x ^ (x >>> 32));
			result = prime * result + (int) (y ^ (y >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	
}
