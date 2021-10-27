package baekjoon;

import java.io.*;
import java.util.*;

public class 바이러스_2606번 {
	static boolean[][] map;
	static boolean[] visited;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int V = Integer.parseInt(br.readLine());

		map = new boolean[N + 1][N + 1];
		for (int i = 1; i < V + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			map[from][to] = true;
			map[to][from] = true;
		}

		visited = new boolean[N + 1];
		visited[1] = true;
		DFS(1);

		int member = 0;
		for (int i = 2; i < N + 1; i++) {
			if (visited[i])
				member++;
		}

		System.out.println(member);
	}

	public static void DFS(int computer) {
		for (int i = 1; i < N + 1; i++) {
			if (map[computer][i] == true && !visited[i]) {
				visited[i] = true;
				DFS(i);
			}
		}
	}
}
