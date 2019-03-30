package interview.bit.arrays;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;


//Uses BitSet
public class SetMatrixZeros_BitSet {

	
	public static void main(String[] args) {
		List<List<Integer>> matrix = Arrays.asList(
					Arrays.asList(1, 1, 1),
					Arrays.asList(1, 0, 1),
					Arrays.asList(1, 1, 1)
				);
		new SetMatrixZeros_BitSet().setZeroes(matrix);
		matrix.forEach(System.out::println);
	}
	
	public void setZeroes(List<List<Integer>> a) {
        BitSet rows = new BitSet(a.size()), cols = new BitSet(a.get(0).size());
        for(int r = 0; r < a.size(); r++) {
        	List<Integer> row = a.get(r);
        	for(int c = 0; c < row.size(); c++) {
        		int value = row.get(c);
        		if(value == 0) {
        			rows.set(r);
        			cols.set(c);
        		}
        	}
        }
        
        for(int r = 0; r < a.size(); r++) {
        	List<Integer> row = a.get(r);
        	for(int c = 0; c < row.size(); c++) {
        		if(rows.get(r) || cols.get(c)) {
        			row.set(c, 0);
        		}
        	}
        }
    }
	
}
