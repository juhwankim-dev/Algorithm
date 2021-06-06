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

		return min;
	}

	public static void dfs(Robot me) {
		if (me.isArrive()) {
			min = Math.min(min, me.step);
			return;
		}

		if ((me.y > me.LIMIT_U) && me.moveUp()) {
			dfs(me);
		}

		if ((me.y < me.LIMIT_D) && me.moveDown()) {
			dfs(me);
		}

		if ((me.x < me.LIMIT_R) && me.moveRight()) {
			dfs(me);
		}

		if ((me.x > me.LIMIT_L) && me.moveLeft()) {
			dfs(me);
		}
	}
}

class Game {
	static int[][] maps;
	int LIMIT_U;
	int LIMIT_D;
	int LIMIT_R;
	int LIMIT_L;
	static int DEST_Y;
	static int DEST_X;
	
	Game(int[][] maps, int m, int n) {
		this.maps = maps;
		LIMIT_U = 0;
		LIMIT_D = m;
		LIMIT_R = n;
		LIMIT_L = 0;
		DEST_Y = m - 1;
		DEST_X = n - 1;
	}
	
	public static boolean isArrive(int y, int x) {
		return (y == DEST_Y) && (x == DEST_X);
	}
	
	public static boolean isBlocked(int y, int x) {
		return (maps[y][x] == 0) ? true : false;
	}
}

class Robot extends Game{
	static int y;
	static int x;
	boolean[][] visited;
	int step;

	Robot(int[][] maps, int m, int n) {
		super(maps, m, n);
		this.y = 0;
		this.x = 0;
		this.step = 0;
		visited = new boolean[m][n];
	}
	
	public static boolean isArrive() {
		return Game.isArrive(y, x);
	}
	
	public static boolean isBlocked(int y, int x) {
		return Game.isBlocked(y, x);
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
			visited[y][x] = true;
			y--;
			step++;
			return true;
		}
		
		return false;
	}

	boolean moveDown() {
		if (isFirstVisit(y+1, x) && !isBlocked(y+1, x)) {
			visited[y][x] = true;
			y++;
			step++;
			return true;
		}
		
		return false;
	}

	boolean moveRight() {
		if (isFirstVisit(y, x+1) && !isBlocked(y, x+1)) {
			visited[y][x] = true;
			x++;
			step++;
			return true;
		}
		
		return false;
	}

	boolean moveLeft() {
		if (isFirstVisit(y, x-1) && !isBlocked(y, x-1)) {
			visited[y][x] = true;
			x--;
			step++;
			return true;
		}
		
		return false;
	}
}