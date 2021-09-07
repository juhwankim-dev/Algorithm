package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day3_1216_회문2 {
	static final int N = 100;
	static char[][] arr = new char[N][N];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			StringBuilder sb = new StringBuilder();
			Integer.valueOf(br.readLine());

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			sb.append("#").append(tc).append(" ").append(searchMaxLen());
			System.out.println(sb.toString());
		}
	}
	
	public static int searchMaxLen() {
		for(int i=N; i>0; i--) {
			if(hasRowPalindrome(i)) return i;	
		}
		
		return 1;
	}
	
	public static boolean hasRowPalindrome(int len) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - len; j++) {
				if(isColPalindrome(i, j, len)) return true;
				if(isRowPalindrome(j, i, len)) return true;
			}
		}
		
		return false;
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

public class Day3_1216_회문2 {
	static final int N = 100;
	static char[][] arr = new char[N][N];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 1; tc++) {
			StringBuilder sb = new StringBuilder();
			Integer.valueOf(br.readLine());

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			int longestPadlindrome = binarySearch();
			sb.append("#").append(tc).append(" ").append(longestPadlindrome);
			System.out.println(sb.toString());
		}
	}
	
	public static int binarySearch() {
		int left = 2;
		int right = N;
		int mid = 0;
		
		while(left <= right) {
			mid = (left + right) / 2;
			System.out.println("mid: " + mid + ", left: " + left + ", right: " + right);
			if(hasRowPalindrome(mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return mid;
	}
	
	public static boolean hasRowPalindrome(int len) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N - len; j++) {
				if(isColPalindrome(i, j, len)) return true;
				if(isRowPalindrome(j, i, len)) return true;
			}
		}
		
		return false;
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
*/
