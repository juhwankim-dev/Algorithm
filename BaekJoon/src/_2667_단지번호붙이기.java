package baekjoon;

import java.io.*;
import java.util.*;

public class _2667_단지번호붙이기 {
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int n, cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					cnt = 1;
					map[i][j] = 0;
					DFS(i, j);
					pq.add(cnt);
				}
			}
		}

		System.out.println(pq.size());
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	public static void DFS(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];

			if (isMovable(newY, newX) && map[newY][newX] == 1) {
				map[newY][newX] = 0;
				cnt++;
				DFS(newY, newX);
			}
		}
	}

	public static boolean isMovable(int y, int x) {
		if (x < 0 || y < 0 || x >= n || y >= n) {
			return false;
		}

		return true;
	}
}
