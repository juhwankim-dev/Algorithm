package baekjoon;

import java.io.*;
import java.util.*;

public class _2146_다리_만들기 {
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int N, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		// 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 2; // 섬에 번호를 매긴다. (2부터 시작)
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) { // 1이면 아직 번호를 매기지 않은 섬
					map[i][j] = cnt;
					visited[i][j] = true;
					DFS(i, j, cnt++); // DFS를 이용해 번호를 매겨준다.
				}

				if (map[i][j] != 0) { // 현재 위치가 섬이라면
					BFS(i, j); // BFS를 이용해서 다른 섬까지 도달하는데 필요한 다리의 길이를 구한다.
				}
			}
		}

		System.out.println(min);
	}

	public static void DFS(int y, int x, int cnt) {
		for (int i = 0; i < 4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];

			if (isMovable(newY, newX) && !visited[newY][newX] && map[newY][newX] == 1) {
				visited[newY][newX] = true;
				map[newY][newX] = cnt; // 섬에 번호를 매겨준다.
				DFS(newY, newX, cnt);
			}
		}
	}

	public static void BFS(int y, int x) {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(y, x, 0));
		boolean[][] visited = new boolean[N][N];
		visited[y][x] = true;

		while (!queue.isEmpty()) {
			Pos p = queue.poll();

			// 가지치기. 다리의 길이가 이전에 구한 가장 짧은 다리의 길이보다 구하면 더이상 조사할 필요가없다.
			if (p.dist >= min) {
				return;
			}

			for (int i = 0; i < 4; i++) {
				int newY = p.y + dy[i];
				int newX = p.x + dx[i];

				if (isMovable(newY, newX) && !visited[newY][newX]) {
					if (map[newY][newX] == 0) { // 바다라면
						visited[newY][newX] = true;
						queue.add(new Pos(newY, newX, p.dist + 1)); // 다리 길이 + 1
					}

					else if (map[newY][newX] != map[y][x]) { // 다른 섬에 도달했다면
						min = Math.min(min, p.dist); // 다리 길이를 비교해서 작은 값을 저장한다.
					}
				}
			}
		}
	}

	public static boolean isMovable(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N) {
			return false;
		}

		return true;
	}

	static class Pos {
		int y;
		int x;
		int dist;

		public Pos(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}
}
