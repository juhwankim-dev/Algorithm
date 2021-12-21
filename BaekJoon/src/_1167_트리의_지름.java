package baekjoon;

import java.io.*;
import java.util.*;

// �Ÿ��� ���ڸ����� �������� �ʴ´ٱ�... - '0' �Ҷ� �����϶�..
// �� ������ ���� �հ��� ã�� �ű⼭ ���� �հ��� ã���� �װ� ������
// https://www.acmicpc.net/board/view/67245

public class _1167_Ʈ����_���� {
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
