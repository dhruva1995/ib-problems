package hash.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.google.common.collect.Sets;

public class MyClass {

	private static final Map<String, Integer> tagAndTagID = new HashMap<>(1_000_0000);
	
	private static final Path input = Paths.get("D:\\eclipse\\workspaces\\ib\\ib-problems\\src\\hash\\code\\d_pet_pictures.txt");
	
	private static final Map<Integer, Set<Integer>> tagAndPhotos = new HashMap<>(1_000_0000);
	
	private static ArrayList<Photo> photos;

	
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader = createReader();
		int noOfPhotos = Integer.parseInt(reader.readLine());
		photos = new ArrayList<>(noOfPhotos);
		AtomicInteger counter = new AtomicInteger(0);
		for(int i = 0; i < noOfPhotos; i++) {
			final int fi = i;
			String[] photo = reader.readLine().split("\\s+");
			char alignment = photo[0].charAt(0);
			Set<Integer> tags = Arrays.stream(photo).skip(2)
					.map(tag -> tagAndTagID.computeIfAbsent(tag, key -> counter.getAndIncrement()))
					.peek(tagId -> tagAndPhotos.computeIfAbsent(tagId, key -> new HashSet<>()).add(fi))
					.collect(Collectors.toSet());
			
			photos.add(new Photo(i, alignment, tags));
		}
		
		ArrayList<Photo> verticalPhotos = photos.stream()
				.filter(photo -> photo.alignment == 'V')
				.collect(Collectors.toCollection(ArrayList::new));
		
		photos.removeIf(photo -> photo.alignment == 'V');
		
		List<VerticalPair> vericalPhotoSlides = getAllVerticalPairs(verticalPhotos);
		
		
		ArrayList<Slide> allSlides = Stream.concat(vericalPhotoSlides.stream(), photos.stream())
				.collect(Collectors.toCollection(ArrayList::new));
		
		//travelling sales person problem with cost as Interesting factor try to maximize the sum instead of minimizing the cost from here....
		
		System.out.println(allSlides.size());
		
		
	}
	
	private static int calculateInterestingFactor(Slide a, Slide b) {
		int intersection = Sets.intersection(a.tags, b.tags).size();
		int aMinusB = Sets.difference(a.tags, b.tags).size();
		int bMinusA = Sets.difference(b.tags, a.tags).size();
		return Math.min(intersection, Math.min(aMinusB, bMinusA));
	}
	
	

	
	private static List<VerticalPair> getAllVerticalPairs(ArrayList<Photo> allVerticalPhotos) {
		
		BitSet visited = new BitSet(allVerticalPhotos.size());
		PriorityQueue<DistantVeritcalPhotos> heap = new PriorityQueue<>();
		
		List<VerticalPair> result = new ArrayList<>();
		
		int counter = 0;
		
		for(int i = 0; i < allVerticalPhotos.size(); i++) {
			
			for(int j = i + 1; j < allVerticalPhotos.size(); j++) {
				
					Photo first = allVerticalPhotos.get(i);
					Photo second = allVerticalPhotos.get(j);
					int unionLength = Sets.union(first.tags, first.tags).size();
				
					heap.add(new DistantVeritcalPhotos(i, j, unionLength));
			}
			
		}
		int evenSize = (allVerticalPhotos.size() / 2) * 2;
		
		while (counter < evenSize){
			
			DistantVeritcalPhotos farthestPair = heap.poll();
			if(visited.get(farthestPair.first) || visited.get(farthestPair.second)) {
				continue;
				
			}else {
				visited.set(farthestPair.first);
				visited.set(farthestPair.second);
				counter += 2;
			}
			
			result.add(new VerticalPair(allVerticalPhotos.get(farthestPair.first), allVerticalPhotos.get(farthestPair.second)));
		}
		return result;
	}
	
	
	private static class DistantVeritcalPhotos implements Comparable<DistantVeritcalPhotos> {
		
		private final int first, second, score;
		
		public DistantVeritcalPhotos(int first, int second, int score) {
			this.first = first;
			this.second = second;
			this.score = score;
		}

		@Override
		public int compareTo(DistantVeritcalPhotos that) {
			return Integer.compare(that.score, this.score);
		}
		
		
	}

	private static class VerticalPair extends Slide {
		
		private final Photo first;
		
		private final  Photo second;
		
		public VerticalPair(Photo first, Photo second) {
			this.first = first;
			this.second = second;
			tags = Sets.union(first.tags, second.tags);
		}
		

		@Override
		public String getPhotoIds() {
			return first.id + " " + second.id;
		}
		
	}

	
	private static abstract class Slide {
		
		protected Set<Integer> tags;
		
		public abstract String getPhotoIds();
		
	}
	
	

	private static BufferedReader createReader() throws Exception {
		return new BufferedReader(new InputStreamReader(Files.newInputStream(input), Charset.defaultCharset()));
	}
	
	

	private static class Photo extends Slide {
		
		private final int id;
		
		private final char alignment;
		

		public Photo(int id, char alignment, Set<Integer> tags) {
			super();
			this.id = id;
			this.alignment = alignment;
			this.tags = tags;
		}
		
		@Override
		public boolean equals(Object obj) {
			Photo that = (Photo)obj;
			return this.id == that.id;
		}

		@Override
		public String getPhotoIds() {
			return Integer.toString(id);
		}
		
		
	}
	
	
	
	
	
}
