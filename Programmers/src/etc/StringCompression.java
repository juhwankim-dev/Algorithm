package etc;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
	}

    public static int solution(String s) {
        int min = Integer.MAX_VALUE;

        StringBuilder original = new StringBuilder();
        StringBuilder compress = new StringBuilder();
        original.append(s);
        
        for(int i=1; i<=s.length()/2; i++) {
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
        	min = Math.min(min, cnt);
        }
        
        return min;
    }
}
