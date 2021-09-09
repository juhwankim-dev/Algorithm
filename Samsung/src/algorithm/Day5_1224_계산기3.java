package algorithm;

import java.io.*;
import java.util.*;

public class Day5_1224_계산기3 {
	static HashMap<Character, Integer> priority = new HashMap<>(); // 우선순위

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('(', Integer.MIN_VALUE);

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			String postfix = infixToPostfix(br.readLine());
			System.out.println(postfix);
			int result = calPostfix(postfix);
			sb.append("#" + tc + " " + result + "\n");
		}

		System.out.println(sb.toString());
	}

	public static String infixToPostfix(String str) {
		Stack<Character> stack = new Stack<Character>();
		StringBuilder postfix = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (Character.isDigit(ch)) { // 숫자인 경우
				postfix.append(ch);
			} else if (stack.isEmpty() || ch == '(') { // 스택이 비어있거나 '('인 경우
				stack.add(ch);
			} else if (ch == ')') { // ')'인 경우
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix.append(stack.pop());
				}
				stack.pop(); // '(' 버리기
			} else { // 연산자가 들어오는 경우
				while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(ch)) {
					postfix.append(stack.pop());
				}
				stack.add(ch);
			}
		}

		while (!stack.isEmpty()) {
			postfix.append(stack.pop());
		}

		return postfix.toString();
	}

	public static int calPostfix(String str) {
		Stack<Integer> numStack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (Character.isDigit(ch)) {
				numStack.add(ch - '0');
			} else {
				int right = numStack.pop();
				int left = numStack.pop();
				numStack.add(calculate(left, right, ch));
			}
		}

		return numStack.pop();
	}

	public static int calculate(int a, int b, char op) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		default:
			return a / b;
		}
	}
}
