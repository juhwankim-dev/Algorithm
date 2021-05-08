package kakaoIntership;

import java.util.*;

public class TrackConstruction {
	static int[][] minFare;
	static final int WIDTH = 0;
	static final int HEIGHT = 1;	
	static int size;
	
	public static void main(String[] args) {
		int[][] board = {
				/*
				{0,0,0},
				{0,0,0},
				{0,0,0}
				*/
				/*
				{0,0,0,0,0,0,0,1},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,1,0,0},
				{0,0,0,0,1,0,0,0},
				{0,0,0,1,0,0,0,1},
				{0,0,1,0,0,0,1,0},
				{0,1,0,0,0,1,0,0},
				{1,0,0,0,0,0,0,0}
				*/
				{0,0,1},
				{1,0,0},
				{1,1,0}
		};
		System.out.println(solution(board));
	}

    public static int solution(int[][] board) {
        size = board.length;
        minFare = new int[size][size];
        for(int[] m : minFare) {
        	Arrays.fill(m, Integer.MAX_VALUE);
        }
        dfs(0, 0, board, 0, -1);
        
        return minFare[size-1][size-1];
    }
    
    // direction: 0은 가로 1은 세로
    public static void dfs(int y, int x, int[][] board, int fare, int direction) {
    	if(minFare[y][x] <= fare) {
    		return;
    	} else {
    		board[y][x] = 1;
    		minFare[y][x] = fare;
    	}
    	
    	if(x < size-1 && board[y][x+1] == 0) { // Right
    		if(direction == HEIGHT) 
    			dfs(y, x+1, board, fare+600, WIDTH);
    		else 
    			dfs(y, x+1, board, fare+100, WIDTH);
    	}
    	if(y < size-1 && board[y+1][x] == 0) { // Down
    		if(direction == WIDTH) 
    			dfs(y+1, x, board, fare+600, HEIGHT);
    		else 
    			dfs(y+1, x, board, fare+100, HEIGHT);
    	}
    	if(x > 0 && board[y][x-1] == 0) { // Left
    		if(direction == HEIGHT) 
    			dfs(y, x-1, board, fare+600, WIDTH);
    		else 
    			dfs(y, x-1, board, fare+100, WIDTH);
    	}
    	if(y > 0 && board[y-1][x] == 0) { // Up
    		if(direction == WIDTH) 
    			dfs(y-1, x, board, fare+600, HEIGHT);
    		else 
    			dfs(y-1, x, board, fare+100, HEIGHT);
    	}
    	board[y][x] = 0;
    }
}

/*
public class TrackConstruction {
	static int minFare = Integer.MAX_VALUE;
	static final int WIDTH = 0;
	static final int HEIGHT = 1;	
	static int size;
	
	public static void main(String[] args) {
		int[][] board = {
				{0,0,0,0,0,0,0,1},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,1,0,0},
				{0,0,0,0,1,0,0,0},
				{0,0,0,1,0,0,0,1},
				{0,0,1,0,0,0,1,0},
				{0,1,0,0,0,1,0,0},
				{1,0,0,0,0,0,0,0}
		};
		System.out.println(solution(board));
	}

    public static int solution(int[][] board) {
        size = board.length;
        dfs(0, 0, board, 0, -1);
        
        return minFare;
    }
    
    // direction: 0은 가로 1은 세로
    public static void dfs(int y, int x, int[][] board, int fare, int direction) {
    	board[y][x] = 1;
    	
    	if(y == size-1 && x == size-1) {
    		minFare = Math.min(minFare, fare);
    	}
    	
    	if(x < size-1 && board[y][x+1] == 0) { // Right
    		if(direction == HEIGHT) 
    			dfs(y, x+1, board, fare+600, WIDTH);
    		else 
    			dfs(y, x+1, board, fare+100, WIDTH);
    	}
    	if(y < size-1 && board[y+1][x] == 0) { // Down
    		if(direction == WIDTH) 
    			dfs(y+1, x, board, fare+600, HEIGHT);
    		else 
    			dfs(y+1, x, board, fare+100, HEIGHT);
    	}
    	if(x > 1 && board[y][x-1] == 0) { // Left
    		if(direction == HEIGHT) 
    			dfs(y, x-1, board, fare+600, WIDTH);
    		else 
    			dfs(y, x-1, board, fare+100, WIDTH);
    	}
    	if(y > 1 && board[y-1][x] == 0) { // Up
    		if(direction == WIDTH) 
    			dfs(y-1, x, board, fare+600, HEIGHT);
    		else 
    			dfs(y-1, x, board, fare+100, HEIGHT);
    	}
    	board[y][x] = 0;
    }
}
*/
