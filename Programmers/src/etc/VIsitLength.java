package etc;

import java.util.*;

public class VIsitLength {

	public static void main(String[] args) {
		System.out.println(solution("UDU"));
	}

	public static int solution(String dirs) {
		GameCharacter me = new GameCharacter();

		for (int i = 0; i < dirs.length(); i++) {
			char direction = dirs.charAt(i);

			switch (direction) {
			case 'U':
				me.moveUp();
				break;
			case 'D':
				me.moveDown();
				break;
			case 'R':
				me.moveRight();
				break;
			case 'L':
				me.moveLeft();
				break;
			}
		}
		
		return me.visitedWay.size()/2;
	}
}

class GameCharacter {
	static final int LIMIT_U = 0;
	static final int LIMIT_D = 10;
	static final int LIMIT_R = 10;
	static final int LIMIT_L = 0;
	int y;
	int x;
	HashSet<String> visitedWay = new HashSet<>();
	StringBuilder start = new StringBuilder();
	StringBuilder end = new StringBuilder();
	
	GameCharacter() {
		this.y = 5;
		this.x = 5;
	}

	private boolean canMove(int y, int x) {
		if (y < LIMIT_U || y > LIMIT_D || x < LIMIT_L || x > LIMIT_R) {
			return false;
		}

		return true;
	}
	
	void makeLog(int y1, int x1, int y2, int x2) {
		start.append(y1).append(x1);
		end.append(y2).append(x2);
		visitedWay.add(start.toString() + end.toString());
		visitedWay.add(end.toString() + start.toString());
		
		start.setLength(0);
		end.setLength(0);
	}

	void moveUp() {
		if (canMove(y-1, x)) {
			makeLog(y, x, --y, x);
		}
	}

	void moveDown() {
		if (canMove(y+1, x)) {
			makeLog(y, x, ++y, x);
		}
	}

	void moveRight() {
		if (canMove(y, x+1)) {
			makeLog(y, x, y, ++x);
		}
	}

	void moveLeft() {
		if (canMove(y, x-1)) {
			makeLog(y, x, y, --x);
		}
	}
}

/*
 * public class VIsitLength { static final int LIMIT_U = 0; static final int
 * LIMIT_D = 10; static final int LIMIT_R = 10; static final int LIMIT_L = 0;
 * 
 * public static void main(String[] args) {
 * System.out.println(solution("ULURRDLLU")); }
 * 
 * public static int solution(String dirs) { GameCharacter me = new
 * GameCharacter();
 * 
 * for (int i = 0; i < dirs.length(); i++) { char direction = dirs.charAt(i);
 * 
 * switch (direction) { case 'U': if (me.y > LIMIT_U) { me.moveUp(); } break;
 * case 'D': if (me.y < LIMIT_D) { me.moveDown(); } break; case 'R': if (me.x <
 * LIMIT_R) { me.moveRight(); } break; case 'L': if (me.x > LIMIT_L) {
 * me.moveLeft(); } break; } }
 * 
 * return me.step; } }
 * 
 * class GameCharacter { int y; int x; boolean[][] visited; int step;
 * 
 * GameCharacter() { this.y = 5; this.x = 5; this.step = 0; visited = new
 * boolean[10][10]; }
 * 
 * private boolean isFirstVisit(int y, int x) { if (visited[y][x]) { return
 * false; } else { visited[y][x] = true; return true; } }
 * 
 * void moveUp() { if (isFirstVisit(y--, x)) { step++; } }
 * 
 * void moveDown() { if (isFirstVisit(y++, x)) { step++; } }
 * 
 * void moveRight() { if (isFirstVisit(y, x++)) { step++; } }
 * 
 * void moveLeft() { if (isFirstVisit(y, x--)) { step++; } } }
 */
