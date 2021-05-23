package etc;

public class SecretMap {

	public static void main(String[] args) {
		int[] arr1 = { 9,20,28,18,11 };
		int[] arr2 = { 30,1,21,17,28 };
		
		String[] mergeMap = solution(5, arr1, arr2);
		for(String m : mergeMap) {
			System.out.println(m);
		}
		
		test();
	}

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] mergeMap = new String[n];
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        
        for(int i=0; i<n; i++) {
        	String map1 = Integer.toBinaryString(arr1[i]);
        	String map2 = Integer.toBinaryString(arr2[i]);
        	
        	// ù ��° ���� ������ ������
        	for(int j=0; j<n-map1.length(); j++) {
        		sb1.append("0");
        	}
        	sb1.append(map1);
        	
        	// �� ��° ���� ������ ������
        	for(int j=0; j<n-map2.length(); j++) {
        		sb2.append("0");
        	}
        	sb2.append(map2);
        	
        	// or ���� �� ���ڷ� ��ȯ
        	for(int j=0; j<n; j++) {
        		int num1 = sb1.charAt(j) - '0';
        		int num2 = sb2.charAt(j) - '0';
        		char ch = ((num1 | num2) == 1) ? '#' : ' ';
        		sb3.append(ch);
        	}
        	
        	// ���� �� �ʱ�ȭ
        	mergeMap[i] = sb3.toString();
        	sb1.setLength(0);
        	sb2.setLength(0);
        	sb3.setLength(0);
        }
        
        return mergeMap;
    }
    
    public static void test() {
        System.out.println(30 | 9);
        System.out.println(Integer.toBinaryString(39));
        System.out.println(Integer.toBinaryString(30 | 9));
    }
}
