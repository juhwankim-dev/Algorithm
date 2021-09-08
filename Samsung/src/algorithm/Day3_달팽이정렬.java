package algorithm;

public class Day3_달팽이정렬 {
	static final int N = 5;
	static int y = 0;
	static int x = 0;
	static char direction = 'R';
	static int[][] arr = {
			{9, 20, 2, 18, 11},
			{19, 1, 25, 3, 21},
			{8, 24, 10, 17, 7},
			{15, 4, 16, 5, 6},
			{12, 13, 22, 23, 14}
	};
	
	public static void main(String[] args) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		int idx = 0;
		
		while(idx != 25) {
			
			// 우측으로 이동
			for(int i=x; !isWall(y, i) || i < N; i++) {
				
			}
		}
	}
	
	public static void dfs() {
		if(y == N/2 && x == N/2) {
			return;
		}
		
		// 오른쪽 방향
		if(direction == 'R') {
			while(!isWall(y, x)) {
				x++;
			}
			direction = 'D';
		}
		
		// 아래쪽 방향
		if(direction == 'R') {
			while(!isWall(y, x)) {
				x++;
			}
			direction = 'D';
		}
		
		// 왼쪽 방향
		if(direction == 'R') {
			while(!isWall(y, x)) {
				x++;
			}
			direction = 'D';
		}
		
		// 위쪽 방향
		if(direction == 'R') {
			while(!isWall(y, x)) {
				x++;
			}
			direction = 'D';
		}
	}
	

	public static boolean isWall(int y, int x) {
		if(x < 0 || x >= 5 || y < 0 || y >= 5) {
			return true;
		}
		
		return false;
	}
}
