package algorithm;

import java.io.*;
import java.util.*;

// 등산로 조성에서도 Point 클래스 쓸꺼라 충돌나서 Potin 클래스 따로 만들엇음

public class Day10_1861_정사각형방 {	
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] arr;
	static boolean[][] visited;
	static int[][] count;
	static Stack<Point> stack = new Stack<>();
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			count = new int[N][N];
			stack.clear();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						dfs(i, j, arr[i][j] - 1);
						backTracking(1);
					}
				}
			}

			int roomNumber = 0;
			int moves = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (count[i][j] > moves) {
						roomNumber = arr[i][j];
						moves = count[i][j];
					} else if(count[i][j] == moves) { // 이동 횟수가 같으면 더 작은 숫자를 출력하기 위함
						roomNumber = Math.min(roomNumber, arr[i][j]);
					}
				}
			}

			sb.append("#" + tc + " " + roomNumber + " " + moves + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int y, int x, int n) {
		if (y < 0 || x < 0 || y >= N || x >= N) // 범위 초과
			return;

		if(n + 1 != arr[y][x]) { // 이전 값+1이 현재값이 아니면 리턴
			return;
		}
		
		if(visited[y][x]) { // 방문한 적이 있으면 백트래킹
			backTracking(count[y][x] + 1);
			return;
		}
		
		stack.add(new Point(y, x));

		for (int i = 0; i < 4; i++) {
			dfs(y + dy[i], x + dx[i], arr[y][x]);
		}
	}

	public static void backTracking(int cnt) {
		while (!stack.isEmpty()) {
			Point p = stack.pop();
			visited[p.y][p.x] = true;
			count[p.y][p.x] = cnt++;
		}
	}
}