package algorithm;

public class Day2_사방더하기 {

	public static void main(String[] args) {
		final int N = 2;
		int[] dx = { 0, 0, -1, 1 }; // 상하좌우
		int[] dy = { -1, 1, 0, 0 };

		int[][] map = new int[N+2][N+2];
		int sum = 0;

		// 랜덤한 숫자 넣기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = (int) ((Math.random() * 5) + 1);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		// 절대값의 합 구하기
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 0; k < 4; k++) {
					int around = map[i + dx[k]][j + dy[k]];
					if(around != 0) {
						sum += Math.abs(map[i][j] - around);
					}
				}
			}
		}
		
		System.out.println(sum);
	}
}
