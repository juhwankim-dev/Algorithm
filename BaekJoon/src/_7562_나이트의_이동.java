package baekjoon;

import java.io.*;
import java.util.*;

public class _7562_나이트의_이동 {
	static int I, fromX, fromY, toX, toY;
	static int[][] map;
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dx = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testCase = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= testCase; tc++) {
			I = Integer.parseInt(br.readLine());
			map = new int[I][I];

			st = new StringTokenizer(br.readLine());
			fromX = Integer.parseInt(st.nextToken());
			fromY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			toX = Integer.parseInt(st.nextToken());
			toY = Integer.parseInt(st.nextToken());

			System.out.println(BFS());
		}
	}

	static int BFS() {
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(fromY, fromX, 0));
		boolean[][] visited = new boolean[I][I];
		visited[fromY][fromX] = true;

		while (!queue.isEmpty()) {
			Pos p = queue.poll();

			if (p.y == toY && p.x == toX) {
				return p.moves;
			}

			for (int i = 0; i < 8; i++) {
				int newY = p.y + dy[i];
				int newX = p.x + dx[i];

				if (isMovable(newY, newX) && !visited[newY][newX]) {
					visited[newY][newX] = true;
					queue.add(new Pos(newY, newX, p.moves + 1));
				}
			}
		}

		return -1;
	}

	static boolean isMovable(int y, int x) {
		if (y < 0 || x < 0 || y >= I || x >= I) {
			return false;
		}

		return true;
	}

	static class Pos {
		int y;
		int x;
		int moves;

		public Pos(int y, int x, int moves) {
			this.y = y;
			this.x = x;
			this.moves = moves;
		}
	}
}
