package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Day2_1220_Magnetic {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = 100;

		// 테스트 케이스만큼 반복
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			int[][] arr = new int[N][N];
			
			// 입력
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.valueOf(st.nextToken());
				}
			}
			
			// 카운트
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				boolean Nturn = true;
				for (int j = 0; j < N; j++) {
					if(Nturn && arr[j][i] == 1) {
						Nturn = false;
					} else if(!Nturn && arr[j][i] == 2) {
						cnt++;
						Nturn = true;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}

/*
 package algorithm;

import java.util.Scanner;
import java.io.FileInputStream;

public class Day2_1220_Magnetic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int N = 100;

		// 테스트 케이스만큼 반복
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			int[][] arr = new int[N][N];
			
			// 100개의 숫자 입력 받기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				boolean Nturn = true;
				for (int j = 0; j < N; j++) {
					if(Nturn && arr[j][i] == 1) {
						Nturn = false;
					} else if(!Nturn && arr[j][i] == 2) {
						cnt++;
						Nturn = true;
					}
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}

}
*/
