package etc;

import java.util.*;

public class SortFiles {

	public static void main(String[] args) {
		String[] files = {
				"foo9.txt",
				"foo010bar020.zip",
				"F-15"
		};
		
		solution(files);
	}

    public static String[] solution(String[] files) {
        Name[] names = new Name[files.length];
        for(int i=0; i<files.length; i++) {
        	// HEAD ���ϱ�
        	int idxH = 0;
        	while(!Character.isDigit(files[i].charAt(idxH))) {
        		idxH++;
        	}
        	String head = files[i].substring(0, idxH);
        	
        	// NUMBER ���ϱ�
        	int idxN = idxH;
        	int fileLen = files[i].length();
        	while(idxN < fileLen && Character.isDigit((files[i].charAt(idxN)))) {
        		idxN++;
        	}
        	String number = files[i].substring(idxH, idxN);
        	
        	// TAIL ���ϱ�
        	String tail = (fileLen == idxN) ? "" : files[i].substring(idxN, fileLen);
        	
        	names[i] = new Name(head, number, tail);
        }
        
        // ����
        Arrays.sort(names, new Comparator<>() {
			@Override
			public int compare(Name o1, Name o2) {
				return o1.compareTo(o2);
			}
        });
        
        String[] answer = new String[files.length];
        for(int i=0; i<files.length; i++) {
        	answer[i] = names[i].getFullName();
        }
        
        return answer;
    }
}

class Name implements Comparable<Name> {
	private String head;
	private String number;
	private String tail;
	
	public Name(String head, String number, String tail) {
		this.head = head;
		this.number = number;
		this.tail = tail;
	}

	public String getFullName() {
		StringBuilder sb = new StringBuilder();
		sb.append(head).append(number).append(tail);
		return sb.toString();
	}
	
	@Override
	public int compareTo(Name name) {
		// ��ҹ��� ������ ���ֱ� ���� ��� �빮�ڷ� ��ȯ
		String head1 = this.head.toUpperCase();
		String head2 = name.head.toUpperCase();
		
		// HEAD�� ���� ���� ��� ���ؼ� ����
		if(head1.compareTo(head2) != 0) {
			return head1.compareTo(head2);
		}
		
		// ���ڷ� ��ȯ�ϸ� ���ǹ��� 0�� �����
		int number1 = Integer.parseInt(this.number);
		int number2 = Integer.parseInt(name.number);
		
		// NUMBER ��
		return number1 - number2;
	}
}