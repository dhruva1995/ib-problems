package ib.stacks.queus;

import java.util.Stack;
import java.util.stream.Collectors;

public class SimplifyDirectoryPath {
	
	
	public static void main(String[] args) {
		System.out.println(new SimplifyDirectoryPath().simplifyPath("/../"));
	}
	

	public String simplifyPath(String inputString) {
		String[] pathElements = inputString.split("/");
		
		Stack<String> stack = new Stack<>();
		
		for(String pathElement : pathElements) {
			if(pathElement.isEmpty() || ".".equals(pathElement)) {
				continue;
			} else if("..".equals(pathElement)) {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.push(pathElement);
			}
		}
		
		return "/" + stack.stream().collect(Collectors.joining("/"));
		
		
		
    }	
	
}
