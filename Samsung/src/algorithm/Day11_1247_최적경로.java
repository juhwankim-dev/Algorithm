package algorithm;

import java.io.*;
import java.util.*;

public class Day11_1247_최적경로 {
	static int N;
	static int shortestRoute;
	static boolean[] visited;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine()) + 2;
			map = new int[N][N]; // 거리
			int[][] xy = new int[N][2]; // 좌표
			visited = new boolean[N]; // 방문여부

			// 좌표 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				xy[i][0] = Integer.parseInt(st.nextToken());
				xy[i][1] = Integer.parseInt(st.nextToken());
			}

			// 거리 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int dist = Math.abs(xy[i][0] - xy[j][0]) + Math.abs(xy[i][1] - xy[j][1]);
					map[i][j] = dist;
				}
			}

			shortestRoute = Integer.MAX_VALUE;
			visited[0] = true;
			dfs(0, 1, 0);

			System.out.println("#" + tc + " " + shortestRoute);
		}
	}

	public static void dfs(int from, int cnt, int dist) {
		if (from == 1) {
			if (cnt == N) {
				if(dist < shortestRoute) {
					shortestRoute = dist;
				}
			} else {
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if(!visited[i] && map[from][i] != 0 && dist + map[from][i] < shortestRoute) {
				visited[i] = true;
				dfs(i, cnt + 1, dist + map[from][i]);
				visited[i] = false;
			}
		}
	}
}

// 다익스트라 개념을 이용해보려고 했는데. 이건 아닌 것 같다.
/*
 * package algorithm;
 * 
 * import java.io.*; import java.util.*;
 * 
 * public class Day11_1247_최적경로 {
 * 
 * public static void main(String[] args) throws NumberFormatException,
 * IOException { BufferedReader br = new BufferedReader(new
 * InputStreamReader(System.in)); int testCase =
 * Integer.parseInt(br.readLine()); StringTokenizer st;
 * 
 * for (int tc = 1; tc <= testCase; tc++) { int N =
 * Integer.parseInt(br.readLine()); int[][] map = new int[N][N]; // 거리 int[][]
 * xy = new int[N][2]; // 좌표 boolean[] visited = new boolean[N]; // 방문여부
 * 
 * // 좌표 저장 st = new StringTokenizer(br.readLine()); for (int i = 0; i < N; i++)
 * { xy[i][0] = Integer.parseInt(st.nextToken()); xy[i][1] =
 * Integer.parseInt(st.nextToken()); }
 * 
 * //
 * 
 * // 거리 저장 for (int i = 0; i < N; i++) { for (int j = 0; j < N; j++) { int dist
 * = Math.abs(xy[i][0] - xy[j][0]) + Math.abs(xy[i][1] - xy[j][1]); map[i][j] =
 * dist; } }
 * 
 * visited[0] = true; // 0번 위치 부터 시작 int result = 0; int cnt = 0;
 * 
 * while (cnt <= N) { int minX = 0; int minY = 0; int min = Integer.MAX_VALUE;
 * for (int i = 0; i < N; i++) { if (visited[i]) { // 방문한 곳 중에서 for (int j = 0;
 * j < N; j++) { // 가장 짧은 거리가 있는 곳을 찾는다. if (!visited[j] && map[i][j] != 0 &&
 * map[i][j] < min) { minY = i; minX = j; min = map[i][j]; } } } } visited[minX]
 * = true; result += map[minY][minX]; map[minY][minX] = 0; map[minX][minY] = 0;
 * cnt++; }
 * 
 * System.out.println("#" + tc + " " + result); } }
 * 
 * }
 * 
 */