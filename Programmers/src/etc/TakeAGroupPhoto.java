package etc;

import java.util.*;

public class TakeAGroupPhoto {
	static HashSet<String> hs = new HashSet<>();
	static HashSet<String> condition = new HashSet<>();
	
	public static void main(String[] args) {
		String[] data = {
				"N~F=0", "R~T>2"
		};
		
		System.out.println(solution(2, data));
	}

	public static int solution(int n, String[] data) {
		// �̹� ������ �Լ� ���� ���� �ʱ�ȭ�� ������Ѵ�...
		hs.clear();
		condition.clear();
		
		for(String d : data) {
			combination("" + d.charAt(0) + d.charAt(2), d.charAt(3), d.charAt(4) - '0');
		}
		dfs("ACFJMNRT", "", data);
		
		return hs.size();
	}

	// ���ͼ��� �ȵǴ� ������ condition�� �����Ѵ�.
	public static void combination(String people, char symbol, int num) {
		if(symbol == '=') {
			for(int i=0; i<7; i++) {
				if(i != num) {
					condition.add(people + String.valueOf(i));
				}
			}
		} else if(symbol == '>') {
			for(int i=num; i>=0; i--) {
				condition.add(people + i);
			}
		} else {
			for(int i=num; i<7; i++) {
				condition.add(people + i);
			}
		}
	}
	
	// �Ϸķ� �� �� �ִ� ������ �� ������.
	public static void dfs(String s, String prefix, String[] data) {
		if(prefix.length() == 8) {
    		if(isSatisfied(prefix, data)) {
    			hs.add(prefix);
    		}
    		return;
		}
		
    	for(int i=0; i<s.length(); i++) {
    		String order = prefix + s.charAt(i);
    		dfs(s.substring(0, i) + s.substring(i+1, s.length()), order, data);
    	}
	}
	
	// ���ǿ� �´����� �˻��Ѵ�.
	public static boolean isSatisfied(String s, String[] data) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		
		for(String d : data) {
			char p1 = d.charAt(0);
			char p2 = d.charAt(2);
			String distance = String.valueOf(Math.abs(map.get(p1) - map.get(p2)) - 1);
			
			if(condition.contains("" + p1 + p2 + distance) || condition.contains("" + p2 + p1 + distance)) {
				return false;
			}
		}
		
		return true;
	}
}
