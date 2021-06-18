package etc;

import java.util.*;
import java.util.Map.Entry;

public class MenuRenewal {
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static int[][] orders_; // 무슨 알파벳이 나왔는지 0, 1로 표현한다.

	public static void main(String[] args) {
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };

		int[] courses = { 2, 3, 4 };

		solution(orders, courses);
	}

	public static Queue<String> solution(String[] orders, int[] courses) {
		// 메뉴 목록 구하기
		HashSet<Character> set = new HashSet<Character>();
		orders_ = new int[orders.length][26];
		for (int i = 0; i < orders.length; i++) {
			for (int j = 0; j < orders[i].length(); j++) {
				char ch = orders[i].charAt(j);
				set.add(ch);
				orders_[i][ch - 'A'] = 1;
			}
		}

		// 메뉴 목록을 문자열로 만들기
		StringBuilder sb = new StringBuilder();
		for (char ch : set) {
			sb.append(ch);
		}
		String menus = sb.toString();

		// 메뉴 조합 구하기
		Queue<String> queue = new LinkedList<>();
		for (int course : courses) {
			dfs(menus, "", course);

			// Map.Entry 리스트 작성
			List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());

			Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
				public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
					// 내림차순 정렬
					return obj2.getValue().compareTo(obj1.getValue());
				}
			});

			// 가장 많이 주문된 셋트 추가하기
			int max = list_entries.get(0).getValue();
			for (Entry<String, Integer> entry : list_entries) {
				if (max == entry.getValue()) {
					queue.add(entry.getKey());
				}
			}
		}

		return queue;
	}

	public static void dfs(String menus, String courseMenu, int course) {
		// 지정한 단품메뉴 개수를 초과하면 리턴
		if (courseMenu.length() > course) {
			return;
		} else if (courseMenu.length() == course) { // 같다면 추가
			int orderCnt = 0;
			for(int i=0; i<orders_.length; i++) {
				for(int j=0; j<courseMenu.length(); j++) {
					if(orders_[i][courseMenu.charAt(j) - 'A'] == 0) {
						
					}
				}
			}
			map.put(courseMenu, orderCnt);
		} else {
			for (int i = 0; i < menus.length(); i++) {
				char menu = menus.charAt(i);
				dfs(menus.substring(i + 1, menus.length()), courseMenu + menu, course);
			}
		}
	}
}
