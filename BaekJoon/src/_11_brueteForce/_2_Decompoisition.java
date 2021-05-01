package _11_brueteForce;

import java.io.*;
import java.util.*;

public class _2_Decompoisition {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		System.out.println(getLowestGenerator(Integer.parseInt(st.nextToken())));
	}
	
	public static int getLowestGenerator(int N) {
		int sum, num;
		
		for(int i=(int) (N*0.8); i<N; i++) {
			sum = i;
			num = i;
			
			do {
				sum += num % 10; // 일의 자리수를 더함
				num /= 10; // 한 자리수 줄임
			}while(num != 0); // 0이 될때까지 반복 (모든 자리수를 더함)
			
			if(sum == N) { // i의 분해합(=sum)이 N과 같다면 -> i이 N의 생성자라면
				return i;
			}
		}
		
		return 0;
	}
}

// 문제 읽기 3분
// 문제 풀기 13분
// 개선 방법 고민해보기 4분
