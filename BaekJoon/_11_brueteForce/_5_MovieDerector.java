package _11_brueteForce;

import java.io.*;
import java.util.*;

public class _5_MovieDerector {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		System.out.println(findNthSeries(N));
	}

	public static int findNthSeries(int N) {
		int num=665;
		
		while(N != 0) {
			num++;
			if(Integer.toString(num).contains("666")) {
				N--;
			}
		}
		
		return num;
	}
}

// 문제 읽고 생각하기 2분
// 문제 풀기 8분 -> 성공
// 더 좋은 방법 생각해보기 3분 -> 잘 모르겠는데..?