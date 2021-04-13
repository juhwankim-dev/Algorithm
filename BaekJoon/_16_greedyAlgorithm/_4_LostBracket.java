package _16_greedyAlgorithm;

import java.io.*;
import java.util.*;

public class _4_LostBracket {
	static final int initialValue = -99999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		
		System.out.println(Integer.MAX_VALUE);
		int sum=initialValue;
		StringTokenizer st2;
		
		while(st.hasMoreTokens()) {
			int temp = 0;
			
			st2 = new StringTokenizer(st.nextToken(), "+");
			while(st2.hasMoreTokens()) {
				temp += Integer.parseInt(st2.nextToken());
			}
			
			if(sum == initialValue) {
				sum = temp;
			} else {
				sum -= temp;
			}
		}
		
		System.out.println(sum);
	}
}

// -를 기준으로 나눈다
// +를 기준으로 나누면서 모든수를 다 합친다.

// 입력의 맨 첫번째 값이 음수로 시작할 수 있구나.. 이걸 생각을 못했네 하