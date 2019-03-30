package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {
	
	public static void main(String[] args) {
		new RearrangeArray().arrange(new ArrayList<>(
				Arrays.asList(1, 0, 3, 2, 5, 4)));
	}

	public void arrange(ArrayList<Integer> a) {
        for(int i = 0; i < a.size(); i++) {
            a.set(i, getEncodedValue(a.get(i), getOldValue(a.get(a.get(i)), a.size()), a.size()));
        }
        for(int i = 0; i < a.size(); i++) {
            a.set(i, getNewValue(a.get(i), a.size()));
        }
    }
    
    
    int getOldValue(int encodedValue, int size) {
        return encodedValue % size;
    }
    
    int getNewValue(int encodedValue, int size) {
        return encodedValue / size;
    }
    
    int getEncodedValue(int oldValue, int newValue, int size) {
        return oldValue + (newValue * size);
    }
}
