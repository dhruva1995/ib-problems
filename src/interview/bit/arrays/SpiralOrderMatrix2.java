package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpiralOrderMatrix2 {

	public static void main(String[] args) {
		new SpiralOrderMatrix2().generateMatrix(5)
			.forEach(System.out::println);
	}

	public ArrayList<ArrayList<Integer>> generateMatrix(int dimension) {
		int top, bottom, left, right, count = 1;
		top = left = 0; bottom = right = dimension - 1;
		int[][] square = IntStream.range(0, dimension)
			.mapToObj(i -> new int[dimension])
			.toArray(n -> new int[n][]);
		
		while (top <= bottom && left <= right) {
			for(int i = left; i <= right; i++) {
				square[top][i] = count++;
			}
			top++;
			
			for(int i = top; i <= bottom; i++) {
				square[i][right] = count++;
			}
			right--;
			for(int i = right; i >= left; i--) {
				square[bottom][i] = count++;
			}
			bottom--;
			for(int i = bottom; i >= top; i--) {
				square[i][left] = count++;
			}
			left++;
		}		
		
		return Arrays.stream(square)
			.map(array -> Arrays.stream(array).boxed().collect(Collectors.toCollection(ArrayList::new)))
			.collect(Collectors.toCollection(ArrayList::new));
	}

}
