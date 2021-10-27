package baekjoon;

import java.util.*;
import java.io.*;

public class DFS¿Í_BFS_1260¹ø {
	static int N;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = map[to][from] = 1;
		}

		// DFS
		visited = new boolean[N + 1];
		visited[V] = true;
		DFS(V);
		System.out.println();

		// BFS
		visited = new boolean[N + 1];
		visited[V] = true;
		BFS(V);
	}

	public static void DFS(int V) {
		System.out.print(V + " ");

		for (int i = 1; i < N + 1; i++) {
			if (map[V][i] == 1 && !visited[i]) {
				visited[i] = true;
				DFS(i);
			}
		}
	}

	public static void BFS(int V) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);

		while (!queue.isEmpty()) {
			int num = queue.poll();
			System.out.print(num + " ");

			for (int i = 1; i < N + 1; i++) {
				if (map[num][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
