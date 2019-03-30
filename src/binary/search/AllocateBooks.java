package binary.search;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {

	public static void main(String[] args) {
		System.out.println(new AllocateBooks().books(new ArrayList<>(Arrays.asList(98, 42, 99, 68, 12, 60, 57, 94, 8, 95, 68, 13, 30, 6, 62, 42)), 16));
	}
	
	
	public int books(ArrayList<Integer> books, int noOfStudents) {
		if(books.size() < noOfStudents) {
			return -1;
		}
		
		long maxNoOfPages = books.stream().mapToLong(i -> i).sum();
		long minNoOfPages = (long) Math.ceil(books.stream().mapToLong(i -> i).sum() / noOfStudents);
		long result = -1;
		while(minNoOfPages <= maxNoOfPages) {
			long mid = minNoOfPages + (maxNoOfPages - minNoOfPages) / 2;
			
			if(isMaxNumbersOfPagesPerStudentValid(mid, books, noOfStudents)) {
				result = mid;
				maxNoOfPages = mid - 1;
			} else {
				minNoOfPages = mid + 1;
			}
		}
		
		return new Long(result).intValue();
		
		
    }
	
	private long getMinSumOfNoOfStudentsBookPages(ArrayList<Integer> books, int dequeSize) {
		int champMin = 0;
		for(int i = 0; i < dequeSize; i++) {
			champMin += books.get(i);
		}
		int currentSum = champMin;
		for(int i = dequeSize; i < books.size(); i++) {
			currentSum -= books.get(i - dequeSize);
			currentSum += books.get(i);
			champMin = Math.min(champMin, currentSum);
		}
		return champMin;
	}

	private boolean isMaxNumbersOfPagesPerStudentValid(long maxNoOfPagesAStudentCanRead, ArrayList<Integer> books, int noOfStudents) {
		int book = 0;
		int student = 0;
		long pagesForCurrentStudent = 0;
		while(book < books.size() && student < noOfStudents) {
			if(pagesForCurrentStudent + books.get(book) > maxNoOfPagesAStudentCanRead) {
				student++;
				pagesForCurrentStudent= 0;
			} else {
				pagesForCurrentStudent += books.get(book);
				book++;
			}
		}
		
		if(book == books.size() && (student < noOfStudents - 1 || (student == noOfStudents - 1 && pagesForCurrentStudent <= maxNoOfPagesAStudentCanRead)) ) {
			return true;
		}
		
		return false;
	}
	
	
}
