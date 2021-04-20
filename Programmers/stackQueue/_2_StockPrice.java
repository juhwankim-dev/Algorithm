package stackQueue;

import java.util.*;

public class _2_StockPrice {

	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3, 3, 1};
		int[] answer = solution(prices);

		for (int a : answer) {
			System.out.print(a + " ");
		}
	}

	public static int[] solution(int[] prices) {
		int len = prices.length;

		Price[] stock = new Price[len];
		Stack<Price> stack = new Stack<>();

		for (int i = 0; i < len; i++) {
			stock[i] = new Price(prices[i], len);
		}

		stack.push(stock[0]);
		for (int i = 1; i < len; i++) {
			while (stack.peek().price > stock[i].price) { // ������ �������� ��������
				stack.pop().fall = i; // �������� �����ϰ� pop
			}

			stack.push(stock[i]);
		}

		int[] answer = new int[len];
		for (int i = 0; i < len; i++) {
			answer[i] = stock[i].fall - i;
		}

		return answer;
	}
}

class Price {
	int price; // ����
	int fall; // ������ ������ ����

	Price(int price, int len) {
		this.price = price;
		this.fall = len - 1;
	}
}