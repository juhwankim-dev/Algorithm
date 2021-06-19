package etc;

import java.util.*;

public class StockPrice {

	public static void main(String[] args) {
		int[] prices = { 3, 2, 1, 2, 3 };
		int[] answer = solution(prices);

		for (int a : answer) {
			System.out.print(a + " ");
		}
	}

	public static int[] solution(int[] prices) {
		int len = prices.length;
		int[] answer = new int[len];
		
		// 가격이 떨어지지 않은 기간 구하기
		Stack<Price> stack = new Stack<>();
		for(int i=0; i<prices.length; i++) {
			while(!stack.isEmpty() && stack.peek().price > prices[i]) {
				Price pre = stack.pop();
				answer[pre.start] = i - pre.start;
			}

			stack.add(new Price(prices[i], i));
		}

		// 끝까지 가격이 떨어지지 않은 놈들 기간 구하기
		while(!stack.isEmpty()) {
			Price price = stack.pop();
			answer[price.start] = (len-1) - price.start;
		}
		
		// 마지막 값은 무조건 0
		answer[len-1] = 0;
		
		return answer;
	}
}

class Price {
	int price; // 가격
	int start; // 가격이 시작한 시점

	Price(int price, int start) {
		this.price = price;
		this.start = start;
	}
}