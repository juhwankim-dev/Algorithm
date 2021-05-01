package _16_greedyAlgorithm;

import java.io.*;
import java.util.*;

public class _5_GasStation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		
		long minPrice = Integer.MAX_VALUE; // ���� ������ �ֹ��� ����
		long totalPrice = 0; // �� ����
		
		for(int i=0; i<N-1; i++) { // ������ ������ �����Ҵ� ��ǻ� �ǹ̰� ���� ������ -1
			
			long distance = Integer.parseInt(st1.nextToken());
			long price = Integer.parseInt(st2.nextToken());
			
			minPrice = Math.min(price, minPrice);
			totalPrice += minPrice*distance;
		}
		
		System.out.println(totalPrice);
	}

}

// if������ �˻��ϰ� �ּڰ� �ִ°Ŷ�
// Math.min���� �ּڰ� ã�°Ŷ�
// ���� ������ 4ms���� Math.min�� ������.
// ������ ���� ���� �ȳ��� �Ÿ� Math�� �� �������� ���� ������..?
// min �����ϱ� ���׿����� ���ų� ��û�����Ѱſ���...

// �������� �־����� �Է� ���� ������ Ŀ�� Long�� ����ؾ� �Ѵٴ� ���� �����ߴ�.