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

// hashMap �Ⱦ��� �����Ѵ��� �ϳ��� ���ߴ��� �ð��ʰ���
// contains�� ����ߴ��� ���λ��� ��� �ܿ� �߰��� ���� ��쵵 ���Խ��ѹ����� �ȵ�
// startsWith��� �޼��尡 �ִٰ� �Ѵ�.. ����..
// HashMap�� ����϶�� ���� �����ϱ� �� ó�� Ǫ�°� ������...
