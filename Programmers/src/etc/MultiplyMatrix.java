package etc;

public class MultiplyMatrix {

	public static void main(String[] args) {
		
	}

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        
        for(int i1=0; i1<arr1.length; i1++) {
        	for(int i2=0; i2<arr2[0].length; i2++) {
        		for(int j=0; j<arr1[0].length; j++) {
        			answer[i1][i2] += arr1[i1][j] * arr2[j][i2];
        		}
        	}
        }
        
        return answer;
    }
}
