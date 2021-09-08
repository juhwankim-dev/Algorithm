package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day4_1217_거듭제곱 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();

			String[] num = br.readLine().split(" ");
			int sum = recursive(Integer.parseInt(num[0]), Integer.parseInt(num[1]));
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static int recursive(int N, int M) {
		if(M == 1) return N;
		return N * recursive(N, M - 1);
	}
}
