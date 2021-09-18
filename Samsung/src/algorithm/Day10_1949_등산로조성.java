package algorithm;

import java.io.*;
import java.util.*;

public class Day10_1949_등산로조성 {
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] arr;
	static int answer, N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 봉우리 후보 찾기
			int peak = 0;
			ArrayList<Point> peaks = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] > peak) {
						peak = arr[i][j];
						peaks.clear();
						peaks.add(new Point(i, j));
					} else if (arr[i][j] == peak) {
						peaks.add(new Point(i, j));
					}
				}
			}

			// 봉우리에서 시작해서 가장 긴 길 찾기
			answer = 0;
			for (Point p : peaks) {
				for (int k = 1; k <= K; k++) {
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							arr[i][j] -= k;
							dfs(p.y, p.x, 1);
							arr[i][j] += k;
						}
					}
				}
			}
			
			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int y, int x, int len) {
		answer = Math.max(answer, len);

		for (int i = 0; i < 4; i++) {
			int newY = y + dy[i];
			int newX = x + dx[i];

			if (!isWall(newY, newX) && arr[y][x] > arr[newY][newX]) {
				dfs(newY, newX, len + 1);
			}
		}
	}
	
	public static boolean isWall(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N) return true;
		return false;
	}
}

/*
 * 
 * package algorithm;
 * 
 * import java.io.*; import java.util.*;
 * 
 * public class Day10_1949_등산로조성 { static int[] dx = { 0, 0, 1, -1 }; static
 * int[] dy = { 1, -1, 0, 0 }; static int[][] arr; static boolean[][] visited;
 * static int[][] count; static Stack<Point> stack = new Stack<>(); static int
 * N;
 * 
 * public static void main(String[] args) throws NumberFormatException,
 * IOException { BufferedReader br = new BufferedReader(new
 * InputStreamReader(System.in)); StringBuilder sb = new StringBuilder(); int
 * testCase = Integer.parseInt(br.readLine());
 * 
 * for (int tc = 1; tc <= testCase; tc++) { StringTokenizer st = new
 * StringTokenizer(br.readLine()); N = Integer.parseInt(st.nextToken()); int K =
 * Integer.parseInt(st.nextToken());
 * 
 * arr = new int[N][N]; visited = new boolean[N][N]; count = new int[N][N];
 * stack.clear();
 * 
 * for (int i = 0; i < N; i++) { st = new StringTokenizer(br.readLine(), " ");
 * for (int j = 0; j < N; j++) { arr[i][j] = Integer.parseInt(st.nextToken()); }
 * }
 * 
 * // 봉우리 후보 찾기 int peak = 0; ArrayList<Point> peaks = new ArrayList<>(); for
 * (int i = 0; i < N; i++) { for (int j = 0; j < N; j++) { if(arr[i][j] > peak)
 * { peak = arr[i][j]; peaks.clear(); } else if(arr[i][j] == peak) {
 * peaks.add(new Point(i, j)); } } }
 * 
 * // 봉우리에서 시작해서 가장 긴 길 찾기 for(Point p : peaks) { dfs(p.y, p.x, arr[p.y][p.x] +
 * 1); backTracking(1); } } System.out.println(sb.toString()); }
 * 
 * public static void dfs(int y, int x, int n) { if (y < 0 || x < 0 || y >= N ||
 * x >= N) // 범위 초과 return;
 * 
 * if(n <= arr[y][x]) { return; }
 * 
 * if(visited[y][x]) { // 방문한 적이 있으면 백트래킹 backTracking(count[y][x] + 1); return;
 * }
 * 
 * stack.add(new Point(y, x));
 * 
 * for (int i = 0; i < 4; i++) { dfs(y + dy[i], x + dx[i], arr[y][x]); }
 * 
 * backTracking(1); }
 * 
 * public static void backTracking(int cnt) { while (!stack.isEmpty()) { Point p
 * = stack.pop(); visited[p.y][p.x] = true;
 * 
 * if(count[p.y][p.x] > cnt) { cnt = count[p.y][p.x]; } else { count[p.y][p.x] =
 * cnt++; } }
 * 
 * printArr(); }
 * 
 * public static void printArr() { for (int i = 0; i < N; i++) { for (int j = 0;
 * j < N; j++) { System.out.print(count[i][j] + " "); } System.out.println(); }
 * System.out.println(); } }
 * 
 */