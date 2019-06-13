package dc.code.jam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForegoneSolution {

	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(reader.readLine());

		for (int i = 1; i <= T; i++) {

			String[] pair = solveForNumber(reader.readLine());

			System.out.println("Case #" + i + ": " + pair[0] + " " + pair[1]);

		}

	}

	private static String[] solveForNumber(String readLine) {
		char[] num1 = new char[readLine.length()], num2 = new char[readLine.length()];

		for (int read = 0, write = 0; read < readLine.length(); read++, write++) {
			char c = readLine.charAt(read);
			if (c == '4') {
				num1[write] = '2';
				num2[write] = '2';
			} else {
				num1[write] = c;
				num2[write] = '0';
			}

		}

		return new String[] { removePrefixZeros(num1), removePrefixZeros(num2) };
	}

	private static String removePrefixZeros(char[] num1) {
		int i = 0;
		for (; i < num1.length; i++) {
			if (num1[i] != '0') {
				break;
			}
		}

		return new String(num1, i, num1.length - i);
	}

}
