package baekjoon;

import java.io.*;
import java.util.*;

public class _10451_순열_사이클 {
	static HashMap<Integer, Integer> hs = new HashMap<>();
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			hs.clear();
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				hs.put(i, Integer.parseInt(st.nextToken()));
			}

			int cycle = 0;
			for (int i = 1; i < N + 1; i++) {
				if (hs.containsKey(i)) {
					cycle++;

					int idx = i;
					while (hs.containsKey(idx)) {
						idx = hs.remove(idx);
					}
				}
			}

			System.out.println(cycle);
		}
	}
}
