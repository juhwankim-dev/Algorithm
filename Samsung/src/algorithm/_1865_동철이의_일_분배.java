package swea;

import java.io.*;
import java.util.*;

public class _1865_동철이의_일_분배 {
	static double[][] arr;
	static boolean[] visited;
	static int N;
	static double max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= testCase; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new double[N][N];
			visited = new boolean[N];
			max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken()) / 100.0;
				}
			}

			DFS(0, 1);
			System.out.println("#" + t + " " + String.format("%.6f", max * 100));
		}
	}

	public static void DFS(int depth, double pro) {
		if (pro <= max) {
			return;
		}

		if (depth == N) {
			max = Math.max(max, pro);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				DFS(depth + 1, pro * arr[depth][i]);
				visited[i] = false;
			}
		}
	}
}
