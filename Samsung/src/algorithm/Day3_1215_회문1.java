package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day3_1215_회문1 {
	static final int N = 8;
	static char[][] arr = new char[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			int len = Integer.valueOf(br.readLine());
			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				String test = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = test.charAt(j);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - len; j++) {
					if(isColPalindrome(i, j, len)) cnt++;
					if(isRowPalindrome(j, i, len)) cnt++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static boolean isColPalindrome(int y, int x, int len) {
		for (int k = 0; k < len / 2; k++) {
			if(arr[y][x + k] != arr[y][x + len - 1 - k]) return false;
		}
		return true;
	}
	
	public static boolean isRowPalindrome(int y, int x, int len) {
		for (int k = 0; k < len / 2; k++) {
			if(arr[y + k][x] != arr[y + len - 1 - k][x]) return false;
		}
		return true;
	}
}

/*
package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day3_1215_회문1 {
	static final int N = 8;
	static char[][] arr = new char[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스만큼 반복
		for (int tc = 1; tc <= 10; tc++) {
			int len = Integer.valueOf(br.readLine());
			int cnt = 0;
			// 8x8 배열 입력받기
			for (int i = 0; i < N; i++) {
				String test = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = test.charAt(j);
				}
			}

			// 회문 검사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - len; j++) {
					if(isColPalindrome(i, j, len)) cnt++;
					if(isRowPalindrome(j, i, len)) cnt++;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static boolean isColPalindrome(int y, int x, int len) {
		for (int k = 0; k < len / 2; k++) {
			if(arr[y][x + k] != arr[y][x + len - 1 - k]) {
				return false;
			}
		}
		
		String temp = "";
		for (int k = 0; k < len; k++) {
			temp += arr[y][x + k];
		}
		System.out.println(temp);
		
		return true;
	}
	
	public static boolean isRowPalindrome(int y, int x, int len) {
		for (int k = 0; k < len / 2; k++) {
			if(arr[y + k][x] != arr[y + len - 1 - k][x]) {
				return false;
			}
		}
		
		String temp = "";
		for (int k = 0; k < len; k++) {
			temp += arr[y + k][x];
		}
		System.out.println(temp);
		
		return true;
	}
}
*/