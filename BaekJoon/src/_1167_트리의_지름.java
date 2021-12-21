package baekjoon;

import java.io.*;
import java.util.*;

// 거리가 한자리수만 나오지는 않는다구... - '0' 할땐 유의하라구..
// 한 점에서 가장 먼곳을 찾고 거기서 가장 먼곳을 찾으면 그게 지름임
// https://www.acmicpc.net/board/view/67245

public class _1167_트리의_지름 {
	static ArrayList<Node>[] tree;
	static boolean[] visited;
	static int V, farNode, maxDist = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		for (int i = 0; i < V + 1; i++) {
			tree[i] = new ArrayList<Node>();
		}

		for (int i = 1; i < V + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int cur = Integer.parseInt(st.nextToken());

			while (true) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1) break;
				int dist = Integer.parseInt(st.nextToken());
				tree[cur].add(new Node(num, dist));
			}
		}

		visited[1] = true;
		DFS(1, 0);

		maxDist = Integer.MIN_VALUE;
		visited = new boolean[V + 1];
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
