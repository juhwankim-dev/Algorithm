package algorithm;

import java.io.*;
import java.util.*;

public class Day13_1257_K번째_문자열 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			int K = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String[] SA = new String[str.length()]; // suffix Array
			int[] LCP = new int[str.length()];

			// 접미사 저장 ex) love, ove, ve, e
			for (int i = 0; i < str.length(); i++) {
				SA[i] = str.substring(i, str.length());
			}

			// 사전순으로 정렬
			Arrays.sort(SA);

			// LCP 구하기
			for (int i = 1; i < str.length(); i++) {
				LCP[i] = getLCP(SA[i - 1], SA[i]);
			}

			// K번째 부분집합이 포함된 SA 인덱스 찾기
			int cnt = 0;
			for (int i = 0; i < str.length(); i++) {
				cnt += SA[i].length() - LCP[i];

				if (cnt >= K) {
					String result = SA[i].substring(0, SA[i].length() - (cnt - K));
					sb.append("#").append(tc).append(" ").append(result).append("\n");
					break;
				}
			}

			if (cnt < K) {
				sb.append("#").append(tc).append(" ").append("none").append("\n");
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static int getLCP(String s1, String s2) {
		int len = Math.min(s1.length(), s2.length());
		int cnt = 0;

		for (int i = 0; i < len; i++) {
			if (s1.charAt(i) != s2.charAt(i))
				break;
			cnt++;
		}

		return cnt;
	}
}