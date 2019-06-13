package code.forces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class CatchOverflow {

	private static final long LIMIT = 4294967295L;
	
	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {

		Stack<Pair> stack = new Stack<>();

		int l = Integer.parseInt(reader.readLine());

		for (int i = 0; i < l; i++) {

			String operation = reader.readLine();

			switch (operation) {
			case "add": {
				stack.push(Pair.add());
				break;
			}
			case "end": {
				long eval = 0;
				while (!stack.peek().mulOperation) {
					eval += stack.pop().value;
					if (eval > LIMIT) {
						System.out.println("OVERFLOW!!!");
						return;
					}
				}
				Pair p = new Pair();

				if (stack.peek().value * eval > LIMIT) {
					System.out.println("OVERFLOW!!!");
					return;
				}

				p.value = stack.pop().value * eval;
				p.mulOperation = false;
				stack.push(p);

				break;
			}
			default: {
				long forLoopCount = Long.parseLong(operation.split("\\s")[1]);

				Pair p = new Pair();
				p.mulOperation = true;
				p.value = forLoopCount;
				stack.push(p);
			}

			}
			
			

		}
		long result = 0;
		
		while(!stack.empty()) {
			result += stack.pop().value;
			if(result > LIMIT) {

				System.out.println("OVERFLOW!!!");
				return;
			}
		}
		System.out.println(result);

	}

	private static class Pair {

		private boolean mulOperation;

		private long value;
		
		static Pair add() {
			Pair p = new Pair();
			p.mulOperation = false;
			p.value = 1;
			return p;
		}

		

	}

}
