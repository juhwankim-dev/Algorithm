package baekjoon;

import java.io.*;
import java.util.*;

public class _11725_트리의_부모_찾기 {
	static ArrayList<Integer>[] tree;
	static int[] parents;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		parents = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			tree[from].add(to);
			tree[to].add(from);
		}

		prefix(1, -1);

		for (int i = 2; i < N + 1; i++) {
			System.out.println(parents[i]);
		}
	}

	public static void prefix(int cur, int parent) {
		parents[cur] = parent;
		for (int child : tree[cur]) {
			if (parents[child] == 0) prefix(child, cur);
		}
	}
}
