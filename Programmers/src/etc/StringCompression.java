package etc;

import java.util.*;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(solution("a"));
	}

    public static int solution(String s) {
        int min = Integer.MAX_VALUE;
        StringBuilder str = new StringBuilder();
        StringBuilder compressedStr = new StringBuilder();
        String unit;
        
        for(int i=1; i<=s.length()/2; i++) { // ��� ������ �߶� �����Ұ���
        	str.append(s);
        	String pattern = "";
        	int cnt=1;
        	
        	while(str.length() >= i) { // ���̻� �ڸ� str�� ���� ������ �ݺ�
        		// ���ڿ� �ڸ���
        		unit = str.substring(0, i);
        		str.delete(0, i);
        		
        		// ���� ���ڿ��� ���� ���ϰ� ���ٸ�
        		if(unit.equals(pattern)) {
        			cnt++; // ī��Ʈ
        		} else { // ���� �ʴٸ�
        			if(cnt != 1) {
            			compressedStr.append(cnt); // ���ڸ� �ְ�
            			cnt = 1; // ���� �ʱ�ȭ
        			}
        			compressedStr.append(unit); // ������ �ְ�
        			pattern = unit; // ���� ����
        		}
        	}
        	
        	// ���ڸ� ���ְ� while���� ������ ��츦 ����
			if(cnt != 1) {
    			compressedStr.append(cnt);
			}
			
			// ���� ���ڿ��� �������� �۾Ƽ� ���� ��츦 ����
        	compressedStr.append(str.substring(0, str.length()));

        	min = Math.min(min, compressedStr.length());
        	compressedStr.setLength(0);
        	str.setLength(0);
        }
        
        return min;
    }
}

/*
public class StringCompression {

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
	}

    public static int solution(String s) {
        int min = Integer.MAX_VALUE;
        String word="";
        int cnt=0;
        StringBuilder original = new StringBuilder();
        StringBuilder compress = new StringBuilder();
        original.append(s);
        
        for(int i=1; i<=s.length()/2; i++) {
        	for(int j=0; j<s.length(); j=j+i) {
        		String pattern = original.substring(0, i);
        		cnt = compress(pattern, original.toString());
        		
        		if(cnt == 0) {
        			compress.append(pattern);
        		}
        		
        		if(word.equals(original.substring(j, j+i))) { // ������ ������ ���
        			cnt++;
        		} else { // ���̻� ������ �Ұ��� �� ���
        			if(cnt != 1) { // ����� �� ������ ���ڳְ� cnt �ʱ�ȭ
        				compress.append(cnt);
        				cnt = 1; // �ʱ�ȭ
        			}
    				compress.append(word);
    				word = original.substring(j, j+i); // ���ο� ���ڸ� �������� ��´�.
        		}
        	}
        	
			if(cnt != 1) { // ����� �� ������ ���ڳְ� cnt �ʱ�ȭ
				compress.append(cnt);
			}
			compress.append(word);
			
        	min = Math.min(min, compress.length());
        	compress.setLength(0);
        }
        
        return min;
    }
    
    public static int compress(String pattern, String s) {
    	int pLen = pattern.length();
    	int	sLen = s.length();
    	
    	if(pLen > sLen) {
    		return 0;
    	}
    	
    	if(pattern.equals(s.substring(0, pLen))) {
    		return 1 + compress(pattern, s.substring(pLen, sLen));
    	} else {
    		return 0;
    	}
    }
}
 */

/*
    public static int solution(String s) {
        int min = Integer.MAX_VALUE;

        StringBuilder original = new StringBuilder();
        StringBuilder compress = new StringBuilder();
        original.append(s);
        
        for(int i=3; i<=s.length()/2; i++) {
        	int cnt = 1;
        	String word = original.substring(0, i); // ������ �Ǵ� ����
        	for(int j=i; j<s.length(); j=j+i) {
        		if(word.equals(original.substring(j, j+i))) { // ������ ������ ���
        			cnt++;
        		} else { // ���̻� ������ �Ұ��� �� ���
        			if(cnt != 1) { // ����� �� ������ ���ڳְ� cnt �ʱ�ȭ
        				compress.append(cnt);
        				cnt = 1; // �ʱ�ȭ
        			}
    				compress.append(word);
    				word = original.substring(j, j+i); // ���ο� ���ڸ� �������� ��´�.
        		}
        	}
        	
			if(cnt != 1) { // ����� �� ������ ���ڳְ� cnt �ʱ�ȭ
				compress.append(cnt);
			}
			compress.append(word);
			
        	min = Math.min(min, compress.length());
        	compress.setLength(0);
        }
        
        return min;
    }
    */
