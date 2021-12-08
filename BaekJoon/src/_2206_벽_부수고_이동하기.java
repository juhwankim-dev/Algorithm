package baekjoon;

import java.io.*;
import java.util.*;

public class _2206_벽_부수고_이동하기 {
	static int N, M;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		System.out.println(BFS());
	}

	static int BFS() {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(0, 0, 1, 0));
		boolean[][][] visited = new boolean[2][N][M];
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			Pos p = queue.poll();

			if (p.y == N - 1 && p.x == M - 1) {
				return p.moves;
			}

			for (int i = 0; i < 4; i++) {
				int newY = p.y + dy[i];
				int newX = p.x + dx[i];

				if (isMovable(newY, newX)) {
					// 다음 칸이 길이면서 + 방문한적이 없다면
					if (map[newY][newX] == 0 && !visited[p.broken][newY][newX]) {
						queue.add(new Pos(newY, newX, p.moves + 1, p.broken));
						visited[p.broken][newY][newX] = true;
					}

					// 다음 칸이 벽인경우
					else {
						// 뚫은적이 없는 벽이고, 뚫을 수 있는 기회가 남아있다면
						if (!visited[p.broken][newY][newX] && p.broken == 0) {
							queue.add(new Pos(newY, newX, p.moves + 1, 1));
							visited[p.broken][newY][newX] = true;
						}
					}
				}
			}
		}

		return -1;
	}

	static boolean isMovable(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= M) {
			return false;
		}

		return true;
	}

	static class Pos {
		int y;
		int x;
		int moves;
		int broken;

		public Pos(int y, int x, int moves, int broken) {
			this.y = y;
			this.x = x;
			this.moves = moves;
			this.broken = broken;
		}
	}
}