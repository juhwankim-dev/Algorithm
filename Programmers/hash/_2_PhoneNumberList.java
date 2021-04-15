package practiceCodingTest;

import java.util.HashMap;

public class _2_PhoneNumberList {

	public static void main(String[] args) {

	}
	
	class Solution {
	    public boolean solution(String[] phone_book) {
	        boolean answer = true;
	        HashMap<String, String> hs = new HashMap<String, String>();
	        
	        for(String num : phone_book){
	            hs.put(num, "temp");
	        }
	        
	        for(String num : phone_book){
	            int length = num.length();
	            for(int i=0; i<length; i++){
	                if(hs.containsKey(num.substring(0, i))){
	                    return false;
	                }
	            }
	        }
	        
	        return answer;
	    }
	}
}

// hashMap 안쓰고 정렬한다음 하나씩 비교했더니 시간초과뜸
// contains를 사용했더니 접두사인 경우 외에 중간에 들어가는 경우도 포함시켜버려서 안됨
// startsWith라는 메서드가 있다고 한다.. 허허..
// HashMap을 사용하라고 만든 문제니까 위 처럼 푸는게 맞을듯...
