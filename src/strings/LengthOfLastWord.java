package strings;

public class LengthOfLastWord {

	public static void main(String args[]) {
		System.out.println(new LengthOfLastWord().lengthOfLastWord("  ")); 
	}
	
	public int lengthOfLastWord(final String A) {
		int read = A.length() - 1;
		while(read >= 0 && Character.isWhitespace(A.charAt(read))) {
			read--;
		}
		int endChar = read;
		while(read >= 0 && !Character.isWhitespace(A.charAt(read))) {
			read--;
		}
		return endChar - read;
    }
	
	
	
}
