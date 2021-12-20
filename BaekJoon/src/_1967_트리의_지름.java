package baekjoon;

import java.io.*;
import java.util.*;

public class _1967_트리의_지름 {
	static ArrayList<Node>[] tree;
	static boolean[] visited;
	static int n, farNode, maxDist = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++) {
			tree[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			tree[cur].add(new Node(num, dist));
			tree[num].add(new Node(cur, dist));
		}

		visited[1] = true;
		DFS(1, 0);

		maxDist = Integer.MIN_VALUE;
		visited = new boolean[n + 1];
		visited[farNode] = true;
		DFS(farNode, 0);
		System.out.println(maxDist);
	}

	public static void DFS(int cur, int totalDist) {
		if (totalDist > maxDist) {
			maxDist = totalDist;
			farNode = cur;
		}

		for (int i = 0; i < tree[cur].size(); i++) {
			Node node = tree[cur].get(i);
			if (!visited[node.num]) {
				visited[node.num] = true;
				DFS(node.num, totalDist + node.dist);
			}
		}
	}

	static class Node {
		int num;
		int dist;

		public Node(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}
}
