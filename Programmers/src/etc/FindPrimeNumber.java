package etc;

public class FindPrimeNumber {

	public static void main(String[] args) {
		System.out.println(solution(10));
	}

	public static int solution(int n) {
		// �Ҽ��� 0���� �Ϲ� ���ڴ� 1�� ������ ����
		int[] isPrime = new int[n + 1];

		for (int i = 2; i * i < n; i++) {
			if (isPrime[i] == 0) {
				for (int j = 2; i * j <= n; j++) {
					isPrime[i * j] = 1;
				}
			}
		}

		int cnt = -2; // �ε��� 0, 1�� �Ҽ��� �ƴϴ�.
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