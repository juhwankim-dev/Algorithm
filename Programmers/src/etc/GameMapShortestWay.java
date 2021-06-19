package etc;

public class GameMapShortestWay {
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		int[][] maps = {
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}
		};
		System.out.println(solution(maps));
	}

	public static int solution(int[][] maps) {
		int m = maps.length;
		int n = maps[0].length;

		Robot me = new Robot(maps, m, n);
		dfs(me);

		return (min == Integer.MAX_VALUE) ? -1 : min + 1;
	}

	public static void dfs(Robot me) {
		if (me.isArrive(me.y, me.x)) {
			min = Math.min(min, me.step);
			me.visited[me.y][me.x] = false;
			return;
		}

		if ((me.y > me.LIMIT_U) && me.moveUp()) {
			dfs(me);
			me.step--;
			me.visited[me.y++][me.x] = false;
		}

		if ((me.y < me.LIMIT_D) && me.moveDown()) {
			dfs(me);
			me.step--;
			me.visited[me.y--][me.x] = false;
		}

		if ((me.x < me.LIMIT_R) && me.moveRight()) {
			dfs(me);
			me.step--;
			me.visited[me.y][me.x--] = false;
		}

		if ((me.x > me.LIMIT_L) && me.moveLeft()) {
			dfs(me);
			me.step--;
			me.visited[me.y][me.x++] = false;
		}
	}
}

class Game {
	int[][] maps;
	int LIMIT_U;
	int LIMIT_D;
	int LIMIT_R;
	int LIMIT_L;
	static int DEST_Y;
	static int DEST_X;
	
	Game(int[][] maps, int m, int n) {
		this.maps = maps;
		LIMIT_U = 0;
		LIMIT_D = m - 1;
		LIMIT_R = n - 1;
		LIMIT_L = 0;
		DEST_Y = m - 1;
		DEST_X = n - 1;
	}
	
	public boolean isArrive(int y, int x) {
		return (y == DEST_Y) && (x == DEST_X);
	}
	
	public boolean isBlocked(int y, int x) {
		return maps[y][x] == 0;
	}
}

class Robot extends Game{
	int y;
	int x;
	boolean[][] visited;
	int step;

	Robot(int[][] maps, int m, int n) {
		super(maps, m, n);
		y = 0;
		x = 0;
		step = 0;
		visited = new boolean[m][n];
	}

	private boolean isFirstVisit(int y, int x) {
		if (visited[y][x]) {
			return false;
		} else {
			visited[y][x] = true;
			return true;
		}
	}
	
	boolean moveUp() {
		if (isFirstVisit(y-1, x) && !isBlocked(y-1, x)) {
			visited[y--][x] = true;
			step++;
			return true;
		}
		
		return false;
	}

	boolean moveDown() {
		if (isFirstVisit(y+1, x) && !isBlocked(y+1, x)) {
			visited[y++][x] = true;
			step++;
			return true;
		}
		
		return false;
	}

	boolean moveRight() {
		if (isFirstVisit(y, x+1) && !isBlocked(y, x+1)) {
			visited[y][x++] = true;
			step++;
			return true;
		}
		
		return false;
	}

	boolean moveLeft() {
		if (isFirstVisit(y, x-1) && !isBlocked(y, x-1)) {
			visited[y][x--] = true;
			step++;
			return true;
		}
		
		return false;
	}
}