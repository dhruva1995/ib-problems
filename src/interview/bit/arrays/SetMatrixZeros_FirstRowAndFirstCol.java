package interview.bit.arrays;

import java.util.Arrays;
import java.util.List;

public class SetMatrixZeros_FirstRowAndFirstCol {

	public static void main(String[] args) {
		List<List<Integer>> matrix = Arrays.asList(
				Arrays.asList(0, 1, 1), 
				Arrays.asList(1, 1, 1),
				Arrays.asList(1, 1, 1));
		new SetMatrixZeros_FirstRowAndFirstCol().setZeroes(matrix);
		matrix.forEach(System.out::println);
	}

	public void setZeroes(List<List<Integer>> a) {
		boolean firstRowHasZero = a.get(0).stream().filter(i -> i == 0).count() > 0 ? true : false;
		
		boolean firstColHasZero = a.stream().map(l -> l.get(0)).filter(i -> i == 0).count() > 0 ? true : false;
		
		for(int i = 1; i < a.size(); i++) {
			for(int j = 1; j < a.get(i).size(); j++) {
				if(a.get(i).get(j) == 0) {
					a.get(0).set(j, 0);
					a.get(i).set(0, 0);
				}
			}
		}
		
		for(int i = 1; i < a.size(); i++) {
			for(int j = 1; j < a.get(i).size(); j++) {
				if(a.get(0).get(j) == 0 || a.get(i).get(0) == 0) {
					a.get(i).set(j, 0);
				}
			}
		}
		
		if(firstRowHasZero) {
			for(int i = 0; i < a.get(0).size(); i++) {
				a.get(0).set(i, 0);
			}
		}
		
		if(firstColHasZero) {
			for(int i = 0; i < a.size(); i++) {
				a.get(i).set(0, 0);
			}
		}
		
		
	}

}
