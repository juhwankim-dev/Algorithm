package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Day2_1209_Sum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = 100;
			
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int[][] arr = new int[N][N];
			int max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.valueOf(st.nextToken());
				}
			}
			
			int[] rowSum = new int[N];
			for (int i = 0; i < N; i++) {
				int sum = 0;
				
				for (int j = 0; j < N; j++) {
					sum += arr[i][j]; // 가로방향 합계
					rowSum[j] += arr[i][j]; // 세로방향 합계
				}
				
				if(sum > max) max = sum; // 가로방향 합계의 최대값 구하기
			}
			
			for(int s : rowSum) {
				if(s > max) max = s; // 세로방향 합계의 최대값 구하기
			}
			
			int diagonalSum = 0; // 대각선의 합
			int revDiagonalSum = 0; // 역 대각선의 합
			for(int i=0; i<N; i++) {
				diagonalSum += arr[i][i];
				revDiagonalSum += arr[i][N-1-i];
			}
			
			if(diagonalSum > max) max = diagonalSum;
			if(revDiagonalSum > max) max = revDiagonalSum;
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}

/*
package algorithm;

import java.util.Scanner;

public class Day2_1209_Sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int N = 100;

		// 테스트 케이스만큼 반복
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			int[][] arr = new int[N][N];
			int max = Integer.MIN_VALUE;
			
			// 100개의 숫자 입력 받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 합계 구하기
			int[] rowSum = new int[N];
			for (int i = 0; i < N; i++) {
				int sum = 0;
				
				for (int j = 0; j < N; j++) {
					sum += arr[i][j]; // 가로방향 합계
					rowSum[j] += arr[i][j]; // 세로방향 합계
				}
				
				if(sum > max) max = sum; // 가로방향 합계의 최대값 구하기
			}
			
			for(int s : rowSum) {
				if(s > max) max = s; // 세로방향 합계의 최대값 구하기
			}
			
			int diagonalSum = 0; // 대각선의 합
			int revDiagonalSum = 0; // 역 대각선의 합
			for(int i=0; i<N; i++) {
				diagonalSum += arr[i][i];
				revDiagonalSum += arr[i][N-1-i];
			}
			
			if(diagonalSum > max) max = diagonalSum;
			if(revDiagonalSum > max) max = revDiagonalSum;
			
			System.out.println("#" + tc + " " + max);
		}
	}

}
*/