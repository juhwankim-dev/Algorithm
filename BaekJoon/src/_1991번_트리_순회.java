package baekjoon;

import java.io.*;
import java.util.*;

public class _1991번_트리_순회 {
	static int[][] tree = new int[26][3];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 26; i++) {
			tree[i][0] = i;
		}

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char cur = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			if (isUpperAlphabet(left)) {
				tree[cur - 'A'][1] = left - 'A';
			}

			if (isUpperAlphabet(right)) {
				tree[cur - 'A'][2] = right - 'A';
			}
		}

		prefix(0);
		System.out.println();
		infix(0);
		System.out.println();
		postfix(0);
	}

	public static boolean isUpperAlphabet(char ch) {
		if ('A' <= ch && ch <= 'Z') {
			return true;
		}

		return false;
	}

	public static void prefix(int cur) {
		System.out.print((char) (tree[cur][0] + 'A')); // 부모노드
		if (tree[cur][1] != 0)
			prefix(tree[cur][1]); // 왼쪽 노드
		if (tree[cur][2] != 0)
			prefix(tree[cur][2]); // 오른쪽 노드
	}

	public static void infix(int cur) {
		if (tree[cur][1] != 0)
			infix(tree[cur][1]); // 왼쪽 노드
		System.out.print((char) (tree[cur][0] + 'A')); // 부모노드
		if (tree[cur][2] != 0)
			infix(tree[cur][2]); // 오른쪽 노드
	}

	public static void postfix(int cur) {
		if (tree[cur][1] != 0)
			postfix(tree[cur][1]); // 왼쪽 노드
		if (tree[cur][2] != 0)
			postfix(tree[cur][2]); // 오른쪽 노드
		System.out.print((char) (tree[cur][0] + 'A')); // 부모노드
	}
}
