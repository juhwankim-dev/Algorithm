package etc;

public class FindLargestSquare {

	public static void main(String[] args) {
		int[][] board = {
				{0,1,1,1},
				{1,1,1,1},
				{1,1,1,1},
				{0,0,1,0}
		};
		
		System.out.println(solution(board));
	}

    public static int solution(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] arr = new int[row+1][col+1];
        
        // board를 arr로 복사
        for(int i=0; i<row; i++) {
        	for(int j=0; j<col; j++) {
        		arr[i+1][j+1] = board[i][j];
        	}
        }
        
        // 정사각형 개수 구하기
        int answer = 0;
        for(int i=1; i<row+1; i++) {
        	for(int j=1; j<col+1; j++) {
        		if(arr[i][j] != 0) {
            		int squareCnt = getMin(arr[i-1][j-1], arr[i-1][j], arr[i][j-1]) + 1;
            		arr[i][j] = squareCnt;
            		
            		if(squareCnt > answer) {
            			answer = squareCnt;
            		}
        		}
        	}
        }

        return answer*answer;
    }
    
    public static int getMin(int a, int b, int c) {
    	return Math.min(a, Math.min(b, c));
    }
}
