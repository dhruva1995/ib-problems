package hacker.earth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class KRemoval {

    public static void main(String args[] ) throws Exception {
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	
    	int nk[] = readInts(reader);
    	
    	int n = nk[0], k = nk[1];
    	
    	int arr[] = readInts(reader);
    	
    	Node head = null, trav = null;
    	
    	for(int i = 0; i < arr.length; i++) {
    		
    		Node newNode = new Node(arr[i]);
    		
    		if(head == null) {
    			head = newNode;
    		} else {
    			trav.next = newNode;
    			newNode.prev = trav;
    		}
    		
    		trav = newNode;
    	}
    	
    	
    	for(int i = 0; i < Math.min(k, 20); i++) {
    		head = deleteMin(head);
    	}
    	
    	
    	System.out.println(getMax(head));
    	
    	
    }
    
    
    private static long getMax(Node trav) {
    	if(trav == null) {
    		return 0;
    	} else if(trav.next == null) {
    		return 0;
    	}
    	
    	
    	
    	
    	long champMinValue = 0;
    	
    	while(trav.next != null) {
    		champMinValue += Math.abs(trav.data - trav.next.data);
    		
    		
    		
    		trav = trav.next;
    	}
    	
    	
    	return champMinValue;
    	
    	
    }
    
    
    private static Node deleteMin(Node trav) {
    	Node champMin = trav;
    	Node rememberHead = trav;
    	if(trav.next == null) {
    		return null;
    	}
    	
    	int champMinValue = 0 - Math.abs(champMin.data - champMin.next.data);
    	trav = trav.next;
    	while(trav.next != null) {
    		int currentMin = Math.abs(trav.prev.data - trav.next.data) - (Math.abs(trav.data - trav.prev.data) + Math.abs(trav.data - trav.next.data));
    		
    		if(champMinValue < currentMin) {
    			champMin = trav;
    			champMinValue = currentMin;
    		}
    		
    		trav = trav.next;
    	}
    	
    	if(champMinValue < 0 - Math.abs(trav.data - trav.prev.data)) {
    		
    		trav.prev.next = null;
    		return rememberHead;
    		
    	}
    	
    	if(champMin == rememberHead) {
    		champMin.next.prev = null;
    		return champMin.next;
    	} else {
    		champMin.prev.next = champMin.next;
    		champMin.next.prev = champMin.prev;
    		return rememberHead;
    	}
    	
    	
    }
    
	
    
    private static class Node {
    	
    	private int data;
    	
    	private Node prev, next;
    	
    	Node(int data) {
    		this.data = data;
    	}
    	
    }
    
	public static int[] readInts(BufferedReader reader) throws IOException {
		return toIntArray(reader.readLine());
	}
	
	public static int[] toIntArray(String s) {
		return Stream.of(s.split("\\s")).mapToInt(Integer::parseInt).toArray();
	}
	
}
