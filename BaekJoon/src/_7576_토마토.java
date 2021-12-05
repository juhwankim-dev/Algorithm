package baekjoon;

import java.io.*;
import java.util.*;

public class _7576_토마토 {
	static int M, N, ripen = 0, empty = 0;
	static int[][] box;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static Queue<Pos> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					queue.add(new Pos(i, j, 0));
					ripen++;
				} else if (box[i][j] == -1) {
					empty++;
				}
			}
		}

		int day = BFS();
		System.out.println((ripen == N * M - empty) ? day : -1);
	}

	public static int BFS() {
		boolean[][] visited = new boolean[N][M];

		while (!queue.isEmpty()) {
			Pos p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int newY = p.y + dy[i];
				int newX = p.x + dx[i];

				if (isMovable(newY, newX) && !visited[newY][newX]) {
					box[newY][newX] = 1;
					visited[newY][newX] = true;
					ripen++;
					queue.add(new Pos(newY, newX, p.day + 1));
				}
			}

			if (queue.isEmpty()) {
				return p.day;
			}
		}

		return Integer.MAX_VALUE; // 여기로 올 일은 없음
	}

	public static boolean isMovable(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= M) {
			return false;
		}

		if (box[y][x] == -1 || box[y][x] == 1) {
			return false;
		}

		return true;
	}

	static class Pos {
		int y;
		int x;
		int day;

		public Pos(int y, int x, int day) {
			this.y = y;
			this.x = x;
			this.day = day;
		}
	}
}
