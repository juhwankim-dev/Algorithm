package baekjoon;

import java.io.*;
import java.util.*;

public class _1012_유기농_배추 {
	static int M, N, K;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로길이
			N = Integer.parseInt(st.nextToken()); // 세로길이
			K = Integer.parseInt(st.nextToken()); // 배추개수

			map = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}

			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						map[i][j] = 0;
						DFS(i, j);
						result++;
					}
				}
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void DFS(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];

			if (check(newY, newX) && map[newY][newX] == 1) {
				map[newY][newX] = 0;
				DFS(newY, newX);
			}
		}
	}

	public static boolean check(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= M) {
			return false;
		}

		return true;
	}
}
