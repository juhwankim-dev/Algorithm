package algorithm;

import java.io.*;

public class Day1_1204_최빈수구하기 {
	public static void main(String[] args) throws IOException {
		final int MAX = 101;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int i = 1; i <= tc; i++) {
			br.readLine();

			// 입력을 받아 빈칸을 기준으로 분리해서 배열에 저장
			String[] scoreArr = br.readLine().split(" ");

			// 카운팅 정렬
			int[] counting = new int[MAX];
			for (String score : scoreArr) {
				counting[Integer.valueOf(score)]++;
			}

			// 최빈값 찾기
			int idx = 0;
			for (int j = 1; j < MAX; j++) {
				if (counting[j] >= counting[idx]) {
					idx = j;
				}
			}

			sb.append("#").append(i).append(" ").append(idx).append("\n");
		}

		System.out.println(sb.toString());
	}
}
