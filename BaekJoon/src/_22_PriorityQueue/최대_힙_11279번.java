package baekjoon;

import java.io.*;
import java.util.*;

public class ÃÖ´ë_Èü_11279¹ø {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(N);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		while(N-- > 0) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) {
				int top = (pq.isEmpty()) ? 0 : pq.poll();
				sb.append(top).append('\n');
			} else {
				pq.add(input);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
