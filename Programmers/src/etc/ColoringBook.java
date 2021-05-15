package etc;

public class ColoringBook {
    static boolean[][] visited;
    static int cnt = 0;
    
	public static void main(String[] args) {
		int[][] picture = {
				{1, 1, 1, 0},
				{1, 2, 2, 0}, 
				{1, 0, 0, 1},
				{0, 0, 0, 1}, 
				{0, 0, 0, 3}, 
				{0, 0, 0, 3}
		};
		
		System.out.println(solution(6, 4, picture));
	}

    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        visited = new boolean[m][n];
        
        for(int y=0; y<m; y++){
            for(int x=0; x<n; x++){
                if(!visited[y][x] && picture[y][x] != 0){
                    cnt = 0;
                    numberOfArea++;
                    dfs(y, x, m, n, picture, picture[y][x]);
                    maxSizeOfOneArea = Math.max(cnt, maxSizeOfOneArea);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public static void dfs(int y, int x, int m, int n, int[][] picture, int color){
        
        // 범위를 벗어나는 경우
        if(y == -1 || y == m || x == -1 || x == n) return;
        
        // 영역이 끊긴 경우
        if(visited[y][x] || picture[y][x] != color) return;
        
        // 방문표시 & 카운트
        visited[y][x] = true;
        cnt++;
        
        // 상하좌우 탐색
        dfs(y-1, x, m, n, picture, color);
        dfs(y+1, x, m, n, picture, color);
        dfs(y, x-1, m, n, picture, color);
        dfs(y, x+1, m, n, picture, color);
    }
}
