package algorithm;

import java.io.*;

public class Day6_1226_미로1 {
	// 상하좌우
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int N = 16;
	static int[][] map = new int[N][N];
	static boolean[][] visited = new boolean[N][N];
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(50);
		
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine(); // 테스트 케이스 번호

			// 입력
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}

			visited = new boolean[N][N];
			result = 0;
			dfs(1, 1);

			sb.append("#" + tc + " " + result + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int y, int x) {
		if (result == 1) {
			return;
		}
		
		// 도착한 경우
		if (isArrive(y, x)) { 
			result = 1;
			return;
		}

		// 상하좌우
		for (int i = 0; i < 4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];
			if(check(newY, newX) && !visited[newY][newX]) {
				visited[y][x] = true;
				dfs(newY, newX);
			}
		}
	}

	public static boolean check(int y, int x) {
		if(y < 0 || x < 0 || y >= N || x >= N) return false;
		if(map[y][x] == 1) return false;
		return true;
	}

	public static boolean isArrive(int y, int x) {
		return (map[y][x] == 3) ? true : false;
	}
}


// 다른거 시도하다가 멈춘거
//package algorithm;
//
//import java.io.*;
//import java.util.*;
//
//// 다른거 시도하다가 멈춤
//public class Day6_1226_미로1 {
//	// 상하좌우
//	static int[] dx = { 0, 0, -1, 1 };
//	static int[] dy = { -1, 1, 0, 0 };
//	static int N = 16;
//	static int[][] map = new int[N][N];
//	static boolean[][] visited;
//	static int result;
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder(50);
//		
//		for (int tc = 1; tc <= 1; tc++) {
//			br.readLine();
//
//			// 입력
//			for (int i = 0; i < N; i++) {
//				String line = br.readLine();
//				for (int j = 0; j < N; j++) {
//					map[i][j] = line.charAt(j) - '0';
//				}
//			}
//
//			Queue<Location> queue = new LinkedList<>();
//			queue.add(new Location(1, 1));
//			visited = new boolean[N][N];
//			
//			while(!queue.isEmpty()) {
//				Location l = queue.poll();
//				
//				// 탐색
//				for (int i = 0; i < 4; i++) {
//					int newY = l.y + dy[i];
//					int newX = l.x + dx[i];
//					if(!visited[newY][newX]) {
//						queue.add(new Location(newY, newX));
//						visited[newY][newX] = true;
//					}
//				}
//			}
//
//			sb.append("#" + tc + " " + result + "\n");
//		}
//		System.out.println(sb.toString());
//	}
//
//	public static boolean isOutOfIdx(int y, int x) {
//		return (y < 0 || x < 0 || y >= N || x >= N) ? true : false;
//	}
//
//	public static boolean isWall(int y, int x) {
//		return (map[y][x] == 1) ? true : false;
//	}
//
//	public static boolean isArrive(int y, int x) {
//		return (map[y][x] == 3) ? true : false;
//	}
//}
//
//class Location {
//	int y;
//	int x;
//	
//	public Location(int y, int x) {
//		this.y = y;
//		this.x = x;
//	}
//}