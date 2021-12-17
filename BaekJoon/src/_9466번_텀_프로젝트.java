package baekjoon;

import java.io.*;
import java.util.*;

public class _9466번_텀_프로젝트 {
	static int[] student;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			int n = Integer.parseInt(br.readLine());
			student = new int[n + 1];
			st = new StringTokenizer(br.readLine());

			for (int i = 1; i < n + 1; i++) {
				int partner = Integer.parseInt(st.nextToken());
				if (i != partner) {
					student[i] = partner;
				}
			}

			int alone = 0;
			for (int i = 1; i < n + 1; i++) {
				if (student[i] != 0) {
					alone += removeCycle(i);
				}
			}

			System.out.println(alone);
		}
	}

	public static int removeCycle(int num) {
		HashMap<Integer, Integer> hs = new HashMap<>();

		int idx = 0;
		while (true) {
			if (hs.containsKey(num)) {
				return hs.get(num);
			} else if (student[num] == 0) {
				return idx;
			}

			hs.put(num, idx++);
			int next = student[num];
			student[num] = 0;
			num = next;
		}
	}
}
