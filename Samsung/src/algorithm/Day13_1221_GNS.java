package algorithm;

import java.io.*;
import java.util.*;

public class Day13_1221_GNS {

	public static void main(String[] args) throws Exception {
		// IO 관련
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		
		// 각 문자열을 key로 잡고 val에 숫자를 넣어 map에 저장
		HashMap<String, Integer> map = new HashMap<>();
		String[] nums = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int tc = 1; tc <= testCase; tc++) {
			int[] counting = new int[10];
			st = new StringTokenizer(br.readLine());
			sb.append(st.nextToken()).append("\n");
			
			// 카운팅 정렬
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				counting[ map.get(st.nextToken()) ]++;
			}
			
			// 출력
			for(int i=0; i<10; i++) {
				for(int j=0; j<counting[i]; j++) {
					sb.append(nums[i]).append(' ');
				}
			}
			
			sb.append("\n");
		}
        bw.write(sb.toString());
        bw.flush();
        bw.close();
	}
}
