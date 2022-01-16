package baekjoon;

import java.io.*;
import java.util.*;

public class _14503_로봇_청소기 {
	static int N, M, direc, cleaned;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int startY = Integer.parseInt(st.nextToken());
		int startX = Integer.parseInt(st.nextToken());
		direc = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(startY, startX, direc);
		System.out.println(cleaned);
	}

	public static void DFS(int y, int x, int direc) {
		// 1번 작업
		if (!visited[y][x]) {
			visited[y][x] = true;
			cleaned++;
		}

		// 2-a, 2-b
		for (int i = 0; i < 4; i++) {
			int newY = y + dy[(direc + 3) % 4];
			int newX = x + dx[(direc + 3) % 4];
			if (isMovable(newY, newX) && !visited[newY][newX]) {
				DFS(newY, newX, (direc + 3) % 4);
				return;
			}

			direc = (direc + 3) % 4;
		}

		// 2-c
		int newY = y + dy[(direc + 2) % 4];
		int newX = x + dx[(direc + 2) % 4];
		if (isMovable(newY, newX)) {
			DFS(newY, newX, direc);
			return;
		}

		// 2-d
		return;
	}

	public static boolean isMovable(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= M) {
			return false;
		}

		if (map[y][x] == 1) {
			return false;
		}

		return true;
	}
}
