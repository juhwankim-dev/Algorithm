package baekjoon;

import java.io.*;
import java.util.*;

public class _2331_반복수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> hs = new HashMap<>();
		int idx = 0;
		while (true) {
			if (hs.containsKey(A)) {
				System.out.println(hs.get(A));
				break;
			}

			hs.put(A, idx++);

			int sum = 0;
			while (A / 10 != 0) {
				sum += Math.pow(A % 10, P);
				A /= 10;
			}
			sum += Math.pow(A % 10, P);

			A = sum;
		}
	}
}
