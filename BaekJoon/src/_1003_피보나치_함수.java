package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003_피보나치_함수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		int[] fibo = new int[41];
		fibo[0] = 0;
		fibo[1] = 1;

		for (int i = 2; i < 41; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}

		for (int tc = 1; tc <= testCase; tc++) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				sb.append("1 0\n");
			} else if (n == 1) {
				sb.append("0 1\n");
			} else {
				sb.append(fibo[n - 1]).append(" ").append(fibo[n]).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
