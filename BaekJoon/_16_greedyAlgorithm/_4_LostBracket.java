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

// -�� �������� ������
// +�� �������� �����鼭 ������ �� ��ģ��.

// �Է��� �� ù��° ���� ������ ������ �� �ֱ���.. �̰� ������ ���߳� ��