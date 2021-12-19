package baekjoon;

import java.io.*;
import java.util.*;

public class _4963_섬의_개수 {
	static int[][] map;
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 시계방향
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int w, h;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new int[h][w];

			if (w == 0 && h == 0)
				break;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int island = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						island++;
						map[i][j] = 0;
						DFS(i, j);
					}
				}
			}

			System.out.println(island);
		}
	}

	public static void DFS(int y, int x) {
		for (int i = 0; i < 8; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];

			if (isMovable(newY, newX) && map[newY][newX] == 1) {
				map[newY][newX] = 0;
				DFS(newY, newX);
			}
		}
	}

	public static boolean isMovable(int y, int x) {
		if (y < 0 || x < 0 || y >= h || x >= w) {
			return false;
		}

		return true;
	}
}
