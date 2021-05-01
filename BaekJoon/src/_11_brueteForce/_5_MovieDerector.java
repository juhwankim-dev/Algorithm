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

// ���� �а� �����ϱ� 2��
// ���� Ǯ�� 8�� -> ����
// �� ���� ��� �����غ��� 3�� -> �� �𸣰ڴµ�..?