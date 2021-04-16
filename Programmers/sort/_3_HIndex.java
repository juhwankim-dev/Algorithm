package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3_HIndex {
	public static final int MAX = 10001;

	public static void main(String[] args) throws IOException {

		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int size = st.countTokens();
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(solution(numbers));
		*/
	}

	public static int solution(int[] citations) {
		int answer = 0;

		// 카운팅 정렬
		int[] radixArr = new int[MAX];
		int size = citations.length;
		for (int i = 0; i < size; i++) {
			radixArr[citations[i]]++;
		}

		int overCnt = 0;
		for (int i = MAX - 1; i >= 0; i--) {

			if (overCnt >= i && size - overCnt <= i) {
				answer = i;
				break;
			}

			if (radixArr[i] != 0) {
				overCnt += radixArr[i];
			}
		}

		return answer;
	}

}
