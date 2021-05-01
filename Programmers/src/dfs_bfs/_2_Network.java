package dfs_bfs;

public class _2_Network {

	public static void main(String[] args) {
		int[][] computers = {
				{1,1,0},
				{1,1,1},
				{0,1,1}
		};
		
		System.out.println(solution(3, computers));
	}

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        int cntComputer = computers.length;
        for(int i=0; i<cntComputer; i++) {
        	answer += findNetwork(n, computers, i);
        }
        
        return answer;
    }
    
    // n: 컴퓨터가 총 몇개인지
    // index: 몇번째 컴퓨터인지
    public static int findNetwork(int n, int[][] computers, int index) {
    	for(int i=0; i<n; i++) {
    		if(computers[index][i] == -1) {
    			return 0;
    		}
    		
    		if(index != i && computers[index][i] == 1) { // 자기 자신 제외하고 1인 값이 있으면 = 이어져 있다면
    			computers[index][i] = -1; // 지나갔다고 흔적남기고
    			findNetwork(n, computers, i); // 그 노드도 검사하러 감
    		}
    	}

    	return 1;
    }
}
