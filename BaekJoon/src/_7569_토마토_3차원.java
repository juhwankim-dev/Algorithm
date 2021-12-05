package baekjoon;

import java.io.*;
import java.util.*;

public class _7569_토마토_3차원 {
	static int M, N, H, ripen = 0, empty = 0;
	static int[][][] box;
	static int[] dy = { -1, 1, 0, 0, 0, 0 };
	static int[] dx = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static Queue<Pos> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if (box[i][j][k] == 1) {
						queue.add(new Pos(i, j, k, 0));
						ripen++;
					} else if (box[i][j][k] == -1) {
						empty++;
					}
				}
			}
		}

		int day = BFS();
		System.out.println((ripen == H * N * M - empty) ? day : -1);
	}

	public static int BFS() {
		boolean[][][] visited = new boolean[H][N][M];

		while (!queue.isEmpty()) {
			Pos p = queue.poll();

			for (int i = 0; i < 6; i++) {
				int newZ = p.z + dz[i];
				int newY = p.y + dy[i];
				int newX = p.x + dx[i];

				if (isMovable(newZ, newY, newX) && !visited[newZ][newY][newX]) {
					box[newZ][newY][newX] = 1;
					visited[newZ][newY][newX] = true;
					ripen++;
					queue.add(new Pos(newZ, newY, newX, p.day + 1));
				}
			}

			if (queue.isEmpty()) {
				return p.day;
			}
		}

		return Integer.MAX_VALUE; // 여기로 올 일은 없음
	}

	public static boolean isMovable(int z, int y, int x) {
		if (z < 0 || y < 0 || x < 0 || z >= H || y >= N || x >= M) {
			return false;
		}

		if (box[z][y][x] == -1 || box[z][y][x] == 1) {
			return false;
		}

		return true;
	}

	static class Pos {
		int z;
		int y;
		int x;
		int day;

		public Pos(int z, int y, int x, int day) {
			this.z = z;
			this.y = y;
			this.x = x;
			this.day = day;
		}
	}
}
