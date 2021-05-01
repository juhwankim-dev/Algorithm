package sort;

public class _1_KthNumber {

	public static void main(String[] args) {
		
	}

    public int[] solution(int[] array, int[][] commands) {
        int cntArray = commands.length;
        int[] answer = new int[cntArray];
        
        for(int i=0; i<cntArray; i++){
            int startIndex = commands[i][0];
            int endIndex = commands[i][1];
            int index = commands[i][2];
            
            // 카운팅 정렬
            int[] radixArr = new int[100];
            for(int j=startIndex-1; j<endIndex; j++){
                radixArr[array[j]-1]++;
            }
            
            for(int j=0; j<100; j++){
                if(radixArr[j] > 0){
                    index -= radixArr[j];
                }
                
                if(index <= 0){
                    answer[i] = j+1;
                    break;
                }
            }
        }
        
        return answer;
    }
}
