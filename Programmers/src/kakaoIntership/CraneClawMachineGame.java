package kakaoIntership;

import java.util.*;

public class CraneClawMachineGame {

	public static void main(String[] args) {
		int[][] board = {
				{0, 0, 0, 0, 0},
				{0, 0, 1, 0, 3},
				{0, 2, 5, 0, 1},
				{4, 2, 4, 4, 2},
				{3, 5, 1, 3, 1}
		};
		
		int[] moves = {
				1,5,3,5,1,2,1,4
		};
		
		System.out.println(solution(board, moves));
	}

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        int height = board.length; // N x N
        
        for(int move : moves) {
        	for(int i=0; i<height; i++) {
        		int topDoll = board[i][move - 1]; // 맨 위에 있는 인형을 뽑아서
        		
        		if(topDoll != 0) {
        			board[i][move - 1] = 0; // 인형있던 자리를 비우고
        			if(!stack.isEmpty() && stack.peek() == topDoll) { // 스택에 있는 인형과 같으면
        				stack.pop(); // 팡! 터짐
        				answer+=2; // 2개 사라짐
        			} else {
        				stack.add(topDoll); // 아니면 걍 쌓기
        			}
        			break;
        		}
        	}
        }
        
        return answer;
    }
}
