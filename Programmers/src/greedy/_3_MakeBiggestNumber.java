package greedy;

import java.util.*;

public class _3_MakeBiggestNumber {

	public static void main(String[] args) {
		System.out.println(solution("66666666", 4));
	}

	// 세상에서 가장 멍청한 풀이 방법
	public static String solution(String number, int k) {
		String answer = "";
		Stack<Integer> stack = new Stack<Integer>();
		String rest = "";

		int numberSize = number.length();
		for (int i = 0; i < numberSize; i++) {
			while (!stack.isEmpty() && stack.peek() < number.charAt(i) - '0' && k != 0) {
				stack.pop(); // 그 값을 빼버리자.
				k--;
			}

			stack.push(number.charAt(i) - '0');
			if (k == 0) {
				rest = number.substring(i + 1, numberSize);
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int num : stack) {
			sb.append(num);
		}

		answer = sb.toString() + rest;
		if (k != 0) {
			answer = answer.substring(0, numberSize - k);
		}
		return answer;
	}
}
