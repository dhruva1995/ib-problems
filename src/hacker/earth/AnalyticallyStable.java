package hacker.earth;
import java.io.*;
import java.util.*;

public class AnalyticallyStable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String N = br.readLine();

            int out_ = solve(N);
            System.out.println(out_);
         }

         wr.close();
         br.close();
    }
    @SuppressWarnings("unlikely-arg-type")
	static int solve(String N){
        HashMap<Character, Integer> countMap = new HashMap<>();
        int[] nextCounts = new int[N.length()];
        long result = 0;
        countMap.put('0', 0);
        countMap.put('1', 0);
    	countMap.put('2', 0);
    	countMap.put('3', 0);
    	countMap.put('4', 0);
    	countMap.put('5', 0);
    	countMap.put('6', 0);
    	countMap.put('7', 0);
    	countMap.put('8', 0);
    	countMap.put('9', 0);
    	
        
        for(int i = N.length() - 1; i >= 0; i--) {
        	
        	char current = N.charAt(i);
        	
        	if(current != '9') {
       			nextCounts[i] = countMap.get((char)(current + 1));
        	}
        	
        	countMap.compute(current, (key, old) -> old + 1);
        	
        } 

        countMap.put('0', 0);
        countMap.put('1', 0);
    	countMap.put('2', 0);
    	countMap.put('3', 0);
    	countMap.put('4', 0);
    	countMap.put('5', 0);
    	countMap.put('6', 0);
    	countMap.put('7', 0);
    	countMap.put('8', 0);
    	countMap.put('9', 0);
        
        
        for(int i = 0; i < nextCounts.length; i++) {
        	
        	char c = N.charAt(i);
        	
        	if(countMap.get(c) > 0 && nextCounts[i] > 1) {
        		int nextCOunt = nextCounts[i];
        		long nextCombinations =  (nextCOunt * 1L * (nextCOunt - 1)) / 2;
        		result += countMap.get(c) * nextCombinations;
        		result %= 1000_000_009;
        		
        	}
        	countMap.compute(c, (key, old) -> old + 1);
        }
        
        
    	return (int)(result % 1000_000_009);
    	
    	
    	
    
    }
}
