package algorithm;

import java.io.*;
import java.util.StringTokenizer;

// 테스트케이스 개수 입력 안받으면 틀림;;; 문제에서는 2개만 주어지는데 실제로는 100개임

public class Day10_6109_추억의2048게임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] dirs = { "left", "down", "right", "up" };
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#" + tc + "\n");
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 회전이 필요한 횟수 구하기
			int dirCnt = 0;
			for (int i = 0; i < dirs.length; i++) {
				if (dirs[i].equals(input[1])) {
					dirCnt = i;
				}
			}

			// 회전해서 방향 통일 시킴
			for (int i = 0; i < dirCnt; i++) {
				rotate(arr, N);
			}

			// 밀기 (중간에 끼어있는 0 없애기)
			int[][] pushed = new int[N][N];
			for (int i = 0; i < N; i++) {
				int idx = 0;
				for (int j = 0; j < N; j++) {
					if (arr[i][j] != 0) {
						pushed[i][idx++] = arr[i][j];
					}
				}
			}

			// 이웃한 같은 숫자 합치기
			int[][] newArr = new int[N][N];
			for (int i = 0; i < N; i++) {
				int idx = 0;
				for (int j = 0; j < N - 1; j++) {
					if (pushed[i][j] == 0)
						break;

					if (pushed[i][j] == pushed[i][j + 1]) {
						newArr[i][idx++] = pushed[i][j] * 2;
						pushed[i][j + 1] = 0;
						j++; // 두 칸을 넘어가기 위함
					} else {
						newArr[i][idx++] = pushed[i][j];
					}

					pushed[i][j] = 0;
				}

				if (pushed[i][N - 1] != 0) {
					newArr[i][idx] = pushed[i][N - 1];
				}
			}

			// 다시 원래대로 회전
			for (int i = 0; i < (4 - dirCnt) % 4; i++) {
				rotate(newArr, N);
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(newArr[i][j] + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	public static void rotate(int[][] arr, int n) {
		int[][] temp = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = arr[n - 1 - j][i];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}
}
