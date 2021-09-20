package algorithm;

import java.io.*;
import java.util.*;

public class Day12_1249_보급로 {
	/*
	static int N;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = input.charAt(j) - '0';
				}
			}
			
			sb.append("#").append(tc).append(" ").append(dijkstra()).append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}

	public static int dijkstra() {
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int y = node.y;
			int x = node.x;
			visited[y][x] = true;
			
			if(y == N - 1 && x == N - 1) {
				return node.weights;
			}
			
			for(int i=0; i<4; i++) {
				int newY = y + dy[i];
				int newX = x + dx[i];
				
				if(check(newY, newX) && !visited[newY][newX]) {
					pq.add(new Node(newY, newX, map[newY][newX] + node.weights));
				}
			}
		}
		
		return -1;
	}
	
	public static boolean check(int y, int x) {
		if(y < 0 || x < 0 || y >= N || x >= N) {
			return false;
		}
		
		return true;
	}
	*/
}

/*
// 좌표와 누적 합을 저장할 노드
class Node implements Comparable<Node> {
	int y;
	int x;
	int weights;

	public Node(int y, int x, int weights) {
		this.y = y;
		this.x = x;
		this.weights = weights;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.weights - o.weights;
	}
}*/