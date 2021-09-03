package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Day2_1210_Ladder1 {
	static int[][] arr;
	static final int N = 100;
	static int y = 0;
	static int x = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			arr = new int[N][N];
			int startIdx = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.valueOf(st.nextToken());
					if (arr[i][j] == 2)
						startIdx = j;
				}
			}

			y = N - 1;
			x = startIdx;

			while (true) {
				if (!isUMovable()) {
					sb.append("#").append(tc).append(" ").append(x).append("\n");
					break;
				}
			}
		}

		System.out.println(sb.toString());
	}

	// 왼쪽로 이동이 가능한지 판단하고, 가능하다면 쭉 이동
	public static boolean isLMovable() {
		if (x == 0 || arr[y][x - 1] == 0) return false;
		while (x > 0 && arr[y][x - 1] == 1) x--;
		
		return true;
	}

	// 오른쪽로 이동이 가능한지 판단하고, 가능하다면 쭉 이동
	public static boolean isRMovable() {
		if (x == N - 1 || arr[y][x + 1] == 0) return false;
		while (x < N - 1 && arr[y][x + 1] == 1) x++;
		
		return true;
	}

	// 위로 이동이 가능한지 + 도착했는지 판단하고 이동
	public static boolean isUMovable() {
		while (y > 0 && isLMovable() == false && isRMovable() == false && arr[y - 1][x] == 1) y--;
		if (y == 0) return false; // 도착지에 도착한 경우

		y--; // 좌 혹은 우로 이동하다가 막힌 경우 아래로 한 칸 이동한다.
		return true;
	}
}

/*
 * package algorithm;
 * 
 * import java.util.Scanner;
 * 
 * public class Day2_1210_Ladder1 { static int[][] arr; static final int N =
 * 100; static int y = 0; static int x = 0;
 * 
 * public static void main(String[] args) { Scanner sc = new Scanner(System.in);
 * 
 * // 테스트 케이스만큼 반복 for (int tc = 1; tc <= 10; tc++) { sc.nextInt(); arr = new
 * int[N][N];
 * 
 * // 100개의 숫자 입력 받기 for (int i = 0; i < N; i++) { for (int j = 0; j < N; j++) {
 * arr[i][j] = sc.nextInt(); } }
 * 
 * // 시작 가능한 출발점 찾기 loop: for (int i = 0; i < N; i++) { // 출발지를 찾았다면 if
 * (arr[0][i] == 1) { y = 0; x = i;
 * 
 * while (true) { int D = isDMovable(); if (D == 0) { break; } else if (D == 2)
 * { System.out.println("#" + tc + " " + i); break loop; } } } } } }
 * 
 * // 왼쪽로 이동이 가능한지 판단하고, 가능하다면 쭉 이동 public static boolean isLMovable() { if (x
 * == 0 || arr[y][x - 1] == 0) { return false; }
 * 
 * while (x > 0 && arr[y][x - 1] == 1) { x--; } return true; }
 * 
 * // 오른쪽로 이동이 가능한지 판단하고, 가능하다면 쭉 이동 public static boolean isRMovable() { if (x
 * == N - 1 || arr[y][x + 1] == 0) { return false; }
 * 
 * while (x < N - 1 && arr[y][x + 1] == 1) { x++; } return true; }
 * 
 * // 아래로 이동이 가능한지 + 도착했는지 판단하고 이동 public static int isDMovable() { while (y < N
 * - 1 && isLMovable() == false && isRMovable() == false && arr[y + 1][x] == 1)
 * { y++; }
 * 
 * if (y == N - 1) { return 0; // 이동이 불가능한 경우 }
 * 
 * if (arr[y + 1][x] == 2) { return 2; // 원하는 도착지에 도착한 경우 }
 * 
 * y++; // 좌 혹은 우로 이동하다가 막힌 경우 아래로 한 칸 이동한다. return Integer.MAX_VALUE; } }
 */