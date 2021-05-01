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
    
    // n: ��ǻ�Ͱ� �� �����
    // index: ���° ��ǻ������
    public static int findNetwork(int n, int[][] computers, int index) {
    	for(int i=0; i<n; i++) {
    		if(computers[index][i] == -1) {
    			return 0;
    		}
    		
    		if(index != i && computers[index][i] == 1) { // �ڱ� �ڽ� �����ϰ� 1�� ���� ������ = �̾��� �ִٸ�
    			computers[index][i] = -1; // �������ٰ� ���������
    			findNetwork(n, computers, i); // �� ��嵵 �˻��Ϸ� ��
    		}
    	}

    	return 1;
    }
}
