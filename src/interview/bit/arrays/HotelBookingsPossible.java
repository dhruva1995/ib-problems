package interview.bit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HotelBookingsPossible {

	
	private static enum EventType {
		ARRIVAL, DEPARTURE
	}
	
	private static class Event implements Comparable<Event>{
		
		public int getAt() {
			return at;
		}

		public final EventType eventType;
		
		public final int at;
		
		public Event(EventType eventType, int at) {
			this.eventType = eventType;
			this.at = at;
		}

		@Override
		public int compareTo(Event that) {
			return (that.at != this.at) ?
				Integer.compare(this.at, that.at) :
				Integer.compare(this.eventType.ordinal(), that.eventType.ordinal());
		}
		
		@Override
		public String toString() {
			return this.eventType.name() + " @ " + this.at;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new HotelBookingsPossible().hotel(
				Arrays.asList(36, 45, 41, 7, 3, 44, 40, 46, 3, 16, 24, 3, 8, 33), 
				Arrays.asList(71, 73, 85, 8, 11, 62, 64, 76, 25, 65, 25, 30, 36, 81), 
				14
				)
			);
	}
	
	public boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        
		List<Event> allHotelEvents = new ArrayList<>();
		
        for (int i = 0; i < arrive.size(); i++) {
        	allHotelEvents.add(new Event(EventType.ARRIVAL, arrive.get(i)));
        	allHotelEvents.add(new Event(EventType.DEPARTURE, depart.get(i)));
        }
        
        
        TreeMap<Integer, Integer> eventsOnDate = allHotelEvents.stream()
        	.collect(Collectors.groupingBy(Event::getAt, 
        			TreeMap::new, 
        			Collectors.summingInt(event -> event.eventType == EventType.ARRIVAL ? 1 : -1)));
        
        int counter = 0;
        
        for(int summary : eventsOnDate.values()) {
        	counter += summary;
        	if(counter > K || counter < 0) {
        		return false;
        	}
        }
        return true;
    }
	
}
