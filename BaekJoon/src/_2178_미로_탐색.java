package baekjoon;

import java.io.*;
import java.util.*;

public class _2178_¹Ì·Î_Å½»ö {
	static int[][] map;
	static int N, M;
	public static void main(String[] args) throws IOException {
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
	
	public static int BFS() {
		int[] dy = { -1, 1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };
		
		Queue<Pos> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		queue.add(new Pos(0, 0, 0));
		visited[0][0] = true;
		int moves = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			
			if(p.y == N - 1 && p.x == M - 1) {
				moves = p.dist + 1;
				break;
			}
			
			for(int i=0; i<4; i++) {
				int newY = p.y + dy[i];
				int newX = p.x + dx[i];
				
				if(isMovable(newY, newX) && !visited[newY][newX]) {
					visited[newY][newX] = true;
					queue.add(new Pos(newY, newX, p.dist + 1));
				}
			}
		}
		
		return moves;
	}
	
	public static boolean isMovable(int y, int x) {
		if(y < 0 || x < 0 || y >= N || x >= M) {
			return false;
		}
		
		if(map[y][x] == 0) {
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
