package baekjoon;

import java.io.*;
import java.util.*;

public class _1697_¼û¹Ù²ÀÁú {
	static int N, K;
	static int[] dx = { -1, 1, 2 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		System.out.println(BFS());
	}

	public static int BFS() {
		Queue<Pos> queue = new LinkedList<>();
		//HashSet<Integer> visited = new HashSet<>();
		boolean[] visited = new boolean[100001];
		
		queue.add(new Pos(N, 0));
		//visited.add(N);
		visited[N] = true;

		while (!queue.isEmpty()) {
			Pos p = queue.poll();

			if (p.x == K) {
				return p.moves;
			}

			for (int i = 0; i < 3; i++) {
				int newX = (i < 2) ? p.x + dx[i] : p.x * dx[i];

//				if (isMovable(newX) && !visited.contains(newX)) {
//					visited.add(newX);
//					queue.add(new Pos(newX, p.moves + 1));
//				}
				if (isMovable(newX) && !visited[newX]) {
					visited[newX] = true;
					queue.add(new Pos(newX, p.moves + 1));
				}
			}
		}

		return -1;
	}

	public static boolean isMovable(int x) {
		if (x < 0 || x > 100000) {
			return false;
		}

		return true;
	}

	static class Pos {
		int x;
		int moves;

		public Pos(int x, int moves) {
			this.x = x;
			this.moves = moves;
		}
	}
}
