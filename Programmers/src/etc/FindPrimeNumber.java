package etc;

public class FindPrimeNumber {

	public static void main(String[] args) {
		System.out.println(solution(10));
	}

	public static int solution(int n) {
		// 소수는 0으로 일반 숫자는 1로 저장할 거임
		int[] isPrime = new int[n + 1];

		for (int i = 2; i * i < n; i++) {
			if (isPrime[i] == 0) {
				for (int j = 2; i * j <= n; j++) {
					isPrime[i * j] = 1;
				}
			}
		}

		int cnt = -2; // 인덱스 0, 1은 소수가 아니다.
		for (int num : isPrime) {
			if (num == 0) {
				cnt++;
			}
		}

		return cnt;
	}
}

/*

Boolean[] isPrime = new Boolean[n + 1];
isPrime[0] = false;
isPrime[1] = false;

for (int i = 2; i * i < n; i++) {
	if (isPrime[i] == null) {
		isPrime[i] = true;

		for (int j = 2; i * j <= n; j++) {
			isPrime[i * j] = false;
		}
	}
}

int cnt = 0;
for (Boolean prime : isPrime) {
	if (prime == null || prime) {
		cnt++;
	}
}

return cnt;

*/