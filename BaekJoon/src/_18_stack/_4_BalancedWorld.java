package _18_stack;

import java.io.*;
import java.util.*;

public class _4_BalancedWorld {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String match = "[^\\(\\)\\[\\]]";

		String line = br.readLine();
		while (!line.equals(".")) {
			line = line.replaceAll(match, "");
			sb.append(isBalanced(line, line.length()));
			line = br.readLine();
		}

		System.out.printf(sb.toString());
	}

	public static String isBalanced(String line, int len) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < len; i++) {
			char c = line.charAt(i);
			if (c == '(' || c == '[') {
				stack.push(c);
				continue;
			} else if (c == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					return "no\n";
				} else {
					stack.pop();
				}
			} else if (c == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					return "no\n";
				} else {
					stack.pop();
				}
			}
		}

		if (stack.isEmpty())
			return "yes\n";
		return "no\n";
	}
}