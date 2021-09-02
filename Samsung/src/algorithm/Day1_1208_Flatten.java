package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Day1_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;

		for (int i = 0; i < T; i++) {
			int moves = Integer.valueOf(br.readLine());
			String[] input = br.readLine().split(" ");
			int[] arr = new int[input.length];
			for (int j = 0; j < input.length; j++) {
				arr[j] = Integer.valueOf(input[j]);
			}

			while (moves-- > 0) {
				Arrays.sort(arr);
				arr[0]++;
				arr[arr.length - 1]--;
			}

			Arrays.sort(arr);
			sb.append("#").append(i + 1).append(" ").append(arr[arr.length - 1] - arr[0]).append("\n");
		}

		System.out.println(sb.toString());
	}
}
