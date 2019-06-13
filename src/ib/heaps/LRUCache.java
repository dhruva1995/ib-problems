package ib.heaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    
	private int counter = 0;
	
	private final LinkedList<Event> events = new LinkedList<>();
	
	private final Map<Integer, Event> data = new HashMap<>();
	
	private final int maxCapacity;
	
    public LRUCache(int capacity) {
    	maxCapacity = capacity;
    }
    
    public int get(int key) {
        
    	if(data.containsKey(key)) {
    		int tick = nextTick();
    		events.add(new Event(tick, key));
    		Event orgData = data.get(key);
    		orgData.tickCount = tick;
    		return orgData.data;
    	} else {
    		return -1;
    	}
    }
    
    public void set(int key, int value) {
    	
    	if(!data.containsKey(key)) {
    		
    		while(data.size() >= this.maxCapacity) {
    			Event keyEvent = events.poll();
    			
    			if(data.containsKey(keyEvent.data) && data.get(keyEvent.data).tickCount == keyEvent.tickCount) {
    				data.remove(keyEvent.data);
    			}
    		}
    		
    	}
    	
    	int tick = nextTick();
		events.add(new Event(tick, key));
		data.put(key, new Event(tick, value));
    	
    	
    }

    
    private static class Event implements Comparable<Event> {
    	
    	private int tickCount, data;
    	
    	Event(int tickCount, int data) {
    		this.data = data;
    		this.tickCount = tickCount;
    	}

		@Override
		public int compareTo(Event that) {
			return Integer.compare(this.tickCount, that.tickCount);
		}
    }

    
    private int nextTick() {
    	return ++counter;
    }
    
}
