package hash;

import java.util.*;

public class _3_Camouflage {

	public static void main(String[] args) {

	}

	class Solution {
	    public int solution(String[][] clothes) {
	        int answer = 1;
	        
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	        int numClothes = clothes.length;
	        
	        for(int i=0; i<numClothes; i++){
	            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
	        }
	        
	        for (int val : map.values()){
	            answer *= (val+1);
	        }
	        
	        return answer-1;
	    }
	}
}
