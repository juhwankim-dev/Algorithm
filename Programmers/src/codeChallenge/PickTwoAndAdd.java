package codeChallenge;

import java.util.*;

public class PickTwoAndAdd {
    static int zero = 0;
    static int one = 0;
	public static void main(String[] args) {
		
	}

	public int[] solution(int[][] arr) {
        int len = arr.length;
        compression(arr, 0, 0, len-1, len-1, len/2);
        
        int[] answer = new int[2];
        answer[0] = zero;
        answer[1] = one;
        
        return answer;
    }
	
	public void compression(int[][] arr, int y1, int x1, int y2, int x2, int size){
        // 1개 짜리로 쪼개지거나 압축이 가능하면
        if(y1 == y2 || isCompressionable(arr, y1, x1, y2, x2)){
            if(arr[y1][x1] == 0) zero++;
            else one++;
            return;
        }
        
        compression(arr, y1, x1, y2-size, x2-size, size/2);
        compression(arr, y1, x1+size, y2-size, x2, size/2);
        compression(arr, y1+size, x1, y2, x2-size, size/2);
        compression(arr, y1+size, x1+size, y2, x2, size/2);
    }
    
    public boolean isCompressionable(int[][] arr, int y1, int x1, int y2, int x2){
        int criteria = arr[y1][x1];
        
        for(int i=y1; i<=y2; i++){
            for(int j=x1; j<=x2; j++){
                if(arr[i][j] != criteria) return false;
            }
        }
        
        return true;
    }
}
