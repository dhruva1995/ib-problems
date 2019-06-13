package ib.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxContinuousSeriesof1s {

	public static void main(String[] args) {

		System.out.println(new MaxContinuousSeriesof1s().maxone(new ArrayList<>(Arrays.asList(1, 1, 1, 1)), 2));

	}

	public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {

		int start = 0, end = 0;
		int champStart = 0, champLength = 0, champEnd = 0;
		int zerosCount = 0;

		while (start < A.size()) {
			while (end < A.size() && (zerosCount < B || A.get(end) == 1)) {
				if (A.get(end) == 0) {
					zerosCount++;
				}
				end++;
			}
			int tempLength = end - start;
			if (tempLength > champLength) {
				champLength = tempLength;
				champStart = start;
				champEnd = end;
			}
			if (A.get(start) == 0) {
				zerosCount--;
			}
			start++;

		}

		return IntStream.range(champStart, champEnd)
				.boxed()
				.collect(Collectors.toCollection(ArrayList::new));

	}

}
