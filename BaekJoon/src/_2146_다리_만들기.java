package baekjoon;

import java.io.*;
import java.util.*;

public class _2146_�ٸ�_����� {
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

		// �Է�
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 2; // ���� ��ȣ�� �ű��. (2���� ����)
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) { // 1�̸� ���� ��ȣ�� �ű��� ���� ��
					map[i][j] = cnt;
					visited[i][j] = true;
					DFS(i, j, cnt++); // DFS�� �̿��� ��ȣ�� �Ű��ش�.
				}

				if (map[i][j] != 0) { // ���� ��ġ�� ���̶��
					BFS(i, j); // BFS�� �̿��ؼ� �ٸ� ������ �����ϴµ� �ʿ��� �ٸ��� ���̸� ���Ѵ�.
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
				map[newY][newX] = cnt; // ���� ��ȣ�� �Ű��ش�.
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

			// ����ġ��. �ٸ��� ���̰� ������ ���� ���� ª�� �ٸ��� ���̺��� ���ϸ� ���̻� ������ �ʿ䰡����.
			if (p.dist >= min) {
				return;
			}

			for (int i = 0; i < 4; i++) {
				int newY = p.y + dy[i];
				int newX = p.x + dx[i];

				if (isMovable(newY, newX) && !visited[newY][newX]) {
					if (map[newY][newX] == 0) { // �ٴٶ��
						visited[newY][newX] = true;
						queue.add(new Pos(newY, newX, p.dist + 1)); // �ٸ� ���� + 1
					}

					else if (map[newY][newX] != map[y][x]) { // �ٸ� ���� �����ߴٸ�
						min = Math.min(min, p.dist); // �ٸ� ���̸� ���ؼ� ���� ���� �����Ѵ�.
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
