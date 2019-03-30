package strings;

import java.util.ArrayList;

public class PrettyJson {

	private int readIndex;
	
	private ArrayList<String> results = new ArrayList<>();
	
	private String input;
	
	private int prettness;
	
	private StringBuilder sb;
	
	
	public static void main(String[] args) {
		new PrettyJson().prettyJSON("[]").forEach(System.out::println);
	}
	
	
	public ArrayList<String> prettyJSON(String A) {
		input = A.trim();
		readIndex = 0;
		results.clear();
		prettness = 0;
		sb = new StringBuilder();
		prettyJsonElement();
		return results;
    }
	
	
	private void prettyJsonElement() {
		
		if(nextChar() == '{') {
			prettyJsonObject();
		} else if(nextChar() == '[') {
			prettyJsonArray();
		} else {
			skipWhiteSpaces();
			char chr = nextChar();
			while(chr != ']' && chr != '}' && chr != ',') {
				sb.append(chr);
				readIndex++;
				chr = nextChar();
			}
			if(nextChar() == ',') {
				sb.append(nextChar());
				readIndex++;
			}
			terminateAndGoToNewLine();
		}
		
	}


	private void skipWhiteSpaces() {
		while(Character.isWhitespace(nextChar())) { readIndex++; }
	}


	private char nextChar() {
		return input.charAt(readIndex);
	}


	private void prettyJsonArray() {
		terminateAndGoToNewLine();
		padTabs();
		sb.append('[');
		readIndex++;
		terminateAndGoToNewLine();
		prettness++;
		while(nextChar() != ']') {
			padTabs();
			prettyJsonElement();
			skipWhiteSpaces();
		}
		prettness--;
		padTabs();
		sb.append(']');
		readIndex++;
		if(prettness != 0 && nextChar() == ',') {
			sb.append(',');
			readIndex++;
		}
		terminateAndGoToNewLine();
		
	}


	private void terminateAndGoToNewLine() {
		if(!sb.toString().trim().isEmpty()) {
			results.add(sb.toString());
		}
		sb = new StringBuilder();
	}


	private void padTabs() {
		for(int i = 0; i < prettness; i++) {
			sb.append("\t");
		}
		
	}


	private void prettyJsonObject() {
		terminateAndGoToNewLine();
		padTabs();
		sb.append('{');
		readIndex++;
		prettness++;
		terminateAndGoToNewLine();
		while(nextChar() != '}') {
			padTabs();
			skipWhiteSpaces();
			while(nextChar() != ':') {
				sb.append(nextChar());
				readIndex++;
			}
			sb.append(":");
			readIndex++;
			skipWhiteSpaces();
			prettyJsonElement();
			
		}
		prettness--;
		padTabs();
		sb.append('}');
		readIndex++;
		if(prettness != 0 && nextChar() == ',') {
			sb.append(',');
			readIndex++;
		}
		terminateAndGoToNewLine();
	}
	
}
