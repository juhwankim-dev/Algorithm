package algorithm;

import java.io.*;
import java.util.*;

public class Day14_1259_금속막대 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			HashMap<Integer, Integer> map = new HashMap<>();

			// 암나사, 수나사를 map에 저장
			for (int i = 0; i < n; i++) {
				int male = Integer.parseInt(st.nextToken());
				int female = Integer.parseInt(st.nextToken());
				map.put(male, female);
			}

			// 시작 번호 구하기
			int idx = 0;
			for (int key : map.keySet()) {
				if (!map.containsValue(key)) {
					idx = key;
					break;
				}
			}

			// 순서 구하기
			sb.append("#").append(tc).append(" ");
			while (map.containsKey(idx)) {
				sb.append(idx).append(" ").append(map.get(idx)).append(" ");
				idx = map.get(idx);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
