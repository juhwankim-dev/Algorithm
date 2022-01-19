package baekjoon;

import java.io.*;
import java.util.*;

public class _17298_¿ÀÅ«¼ö {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<E> stack = new Stack<>();
		int[] answer = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && stack.peek().num < cur) {
				answer[stack.pop().idx] = cur;
			}

			stack.add(new E(i, cur));
		}

		while (!stack.isEmpty()) {
			answer[stack.pop().idx] = -1;
		}

		StringBuilder sb = new StringBuilder(N * 2);
		for (int i = 0; i < N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

	static class E {
		int idx;
		int num;

		public E(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
	}
}
