package _12_sort;

import java.io.*;
import java.util.*;

public class _3_SortNumber3 {

	static final int MAX = 10001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[MAX];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())]++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<MAX; i++) {
			while(arr[i]-- > 0) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}

// Ä«¿îÆÃ Á¤·ÄÀÌ ¹ºÁö ¸ô¶ó¼­ Ã£¾Æº½ ¤Ð