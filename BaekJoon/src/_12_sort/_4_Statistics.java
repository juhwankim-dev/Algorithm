package _12_sort;

import java.io.*;
import java.util.*;

public class _4_Statistics {

	static final int MAX = 8001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[MAX];
		
		// ������: �� ���ؼ� N���� ���� ��
		// �߾Ӱ�: ������������ �������� �� ���� �߾ӿ� ��ġ�ϴ� ��
		// �ֺ�: ���� ���� ��Ÿ���� ��
		// ����: �ִ񰪰� �ּڰ��� ����
		int sum=0, mean, median=0, mode=0, diff; 
		int min=4000, max=-4000;
		int count = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()) + 4000;
			arr[num]++;
			if(min > num) min = num;
			if(max < num) max = num;
		}
		
		for(int i=0; i<MAX; i++) {
			if(arr[i] > 0) {
				count += arr[i];
				if(median == 0 && count > N/2) median = i; 
				
				if(arr[i] > mode) {
					mode = i;
				}
				
				while(arr[i]-- > 0) {
					sum += arr[i];
				}
			}
		}
		mean = sum/N;
		diff = max-min;
		
		System.out.println(mean);
		System.out.println(median-4000);
		System.out.println(mode-4000);
		System.out.println(diff);
	}

}



// -4000~4000 �׸��� �ִ� 500,000��

// ���� �а� �����ϱ� 3�� 30��
// ���� Ǯ�� 19�� ������ ��� ��ž..�����ҷ�