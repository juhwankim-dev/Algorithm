package _16_greedyAlgorithm;

import java.io.*;
import java.util.*;

public class _5_GasStation {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		
		long minPrice = Integer.MAX_VALUE; // 가장 저렴한 휘발유 가격
		long totalPrice = 0; // 총 가격
		
		for(int i=0; i<N-1; i++) { // 마지막 도시의 주유소는 사실상 의미가 없기 때문에 -1
			
			long distance = Integer.parseInt(st1.nextToken());
			long price = Integer.parseInt(st2.nextToken());
			
			minPrice = Math.min(price, minPrice);
			totalPrice += minPrice*distance;
		}
		
		System.out.println(totalPrice);
	}

}

// if문으로 검사하고 최솟값 넣는거랑
// Math.min으로 최솟값 찾는거랑
// 거의 같은데 4ms정도 Math.min이 빨랏음.
// 어차피 별로 차이 안나는 거면 Math가 더 가독성이 좋지 않을까..?
// min 들어가보니까 삼항연산자 쓴거네 엄청간단한거였군...

// 문제에서 주어지는 입력 값의 범위가 커서 Long을 사용해야 한다는 것을 간과했다.