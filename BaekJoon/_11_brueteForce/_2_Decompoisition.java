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
				sum += num % 10; // ���� �ڸ����� ����
				num /= 10; // �� �ڸ��� ����
			}while(num != 0); // 0�� �ɶ����� �ݺ� (��� �ڸ����� ����)
			
			if(sum == N) { // i�� ������(=sum)�� N�� ���ٸ� -> i�� N�� �����ڶ��
				return i;
			}
		}
		
		return 0;
	}
}

// ���� �б� 3��
// ���� Ǯ�� 13��
// ���� ��� ����غ��� 4��
