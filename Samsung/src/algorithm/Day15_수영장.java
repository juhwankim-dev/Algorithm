package algorithm;

import java.io.*;
import java.util.*;

public class Day15_수영장 {
	static int[] prices; // 티켓 가격
	static int[] plans; // 수영장을 몇번 이용할건지 계획
	static int[] min; // 월별 최소 예상금액
	static final int TYPECNT = 4; // 티켓의 종류
	static final int MONCNT = 12; // 12개월
	static int bestPrice;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			prices = new int[TYPECNT];
			plans = new int[MONCNT + 1];
			min = new int[MONCNT + 1];

			// 이용권 금액
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < TYPECNT; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}

			// 이용 계획
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= MONCNT; i++) {
				plans[i] = Integer.parseInt(st.nextToken());
			}

			// 1일권과 1달권 중 이득인 것 선택하기
			for (int i = 1; i <= MONCNT; i++) {
				min[i] = Math.min(prices[1], prices[0] * plans[i]);
			}

			bestPrice = prices[3];
			dfs(1, 0);
			sb.append("#").append(tc).append(" ").append(bestPrice).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	public static void dfs(int idx, int sum) {
		// 탐색이 끝났다면
		if (idx == 13) {
			// 최소 비용 업데이트
			if (sum < bestPrice) {
				bestPrice = sum;
				return;
			}
		}

		// 가지치기
		if (sum >= bestPrice) {
			return;
		}

		if(idx <= 10) dfs(idx + 3, sum + prices[2]); // 3달 이용권으로 결제해버려~
		dfs(idx + 1, sum + min[idx]); // 한 달은 그냥 긁고 다음 3개월치 조사해보자.
	}
}
