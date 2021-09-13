package algorithm;

import java.io.*;
import java.util.*;

public class Day6_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = 8;
		
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			// 입력
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// queue에 삽입
			queue.clear();
			for(int num : arr) {
				queue.add(num);
			}
			
			int cnt = 0;
			while(true) {
				int newNumber = queue.poll() - (cnt++ % 5 + 1);
				if(newNumber > 0) {
					queue.add(newNumber);
				} else {
					queue.add(0);
					break;
				}
			}
			
			sb.append("#" + tc);
			while(!queue.isEmpty()) sb.append(" " + queue.poll());
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
