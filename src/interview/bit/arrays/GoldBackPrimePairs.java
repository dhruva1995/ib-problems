package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class GoldBackPrimePairs {
	
	
	public static void main(String[] args) {
		
    	System.out.println(new GoldBackPrimePairs().primesum(36002));
	}
	
	
	
    public ArrayList<Integer> primesum(int A) {
    	for(int i = 2; i <= A / 2; i++) {
    		if(isPrime(i) && isPrime(A - i)) {
    			return new ArrayList<>(Arrays.asList(i, A - i));
    		}
    	}
		throw new RuntimeException("Globback's conjecture is wrong!!!");
    }
    
    
    private boolean isPrime(int number) {
    	PossiblePrimeSequence gen = new PossiblePrimeSequence((int)Math.sqrt(number));
    	while(gen.hasNext()) {
    		int i = gen.next();
    		if(number % i == 0) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public static class PossiblePrimeSequence implements Iterator<Integer>{
    	
    	private final int limit;
    	
    	public PossiblePrimeSequence(int limit) {
    		this.limit = limit;
    	}
    	
    	
    	private enum State {
    		initial, pre, post
    	}
    	
    	private State nextState = State.initial;
    	
    	private boolean first = true;
    	private int base = 0;
    	
    	private int base6 = 0;
    	
    	private int cached = 2;

		@Override
		public boolean hasNext() {
			cached = preCache();
			
			return cached <= limit;
		}

		@Override
		public Integer next() {
			return cached;
		}
		
		private int preCache() {

			State currentState = nextState;
			int result = 0;
			if (currentState == State.initial) {

				if (cached == 2) {
					if (first) {
						result = 2;
						first = false;
					}

					else {
						nextState = State.pre;
						result = 3;
					}
				}
			} else if(currentState == State.pre) {
				base++;
				base6 = (6 * base);
				result = base6 - 1;
				nextState = State.post;
			} else {
				result = base6 + 1;
				nextState = State.pre;
			}
			return result;
		
		}
    	
    	
    	
    	
    }
    
}
