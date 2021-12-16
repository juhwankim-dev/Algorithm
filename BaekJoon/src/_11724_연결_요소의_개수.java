package baekjoon;

import java.io.*;
import java.util.*;

public class _11724_연결_요소의_개수 {
	static int[][] map;
	static boolean[] visited;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = map[to][from] = 1;
		}

		visited = new boolean[N + 1];
		int cnt = 0;
		for (int i = 1; i < N + 1; i++) {
			if (!visited[i]) {
				DFS(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	public static void DFS(int v) {
		visited[v] = true;

		for (int i = 1; i < N + 1; i++) {
			if (map[v][i] > 0) {
				map[v][i] = map[i][v] = 0;
				DFS(i);
			}
		}
	}
}
