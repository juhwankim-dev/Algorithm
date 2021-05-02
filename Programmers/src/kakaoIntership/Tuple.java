package kakaoIntership;

import java.util.*;

public class Tuple {

	public static void main(String[] args) {
		int[] test = solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
		
		for(int t : test) {
			System.out.println(t);
		}
	}

    public static int[] solution(String s) {
        s = s.replaceAll("[\\{|\\}]", "");
        StringTokenizer st = new StringTokenizer(s, ",");
        HashMap<Integer, Integer> hs = new HashMap<>();
        
        while(st.hasMoreTokens()) {
        	int num = Integer.parseInt(st.nextToken());
        	hs.put(num, hs.getOrDefault(num, 0) + 1);
        }

        int[][] elements = new int[hs.size()][2];
        int idx=0;
        for(int key : hs.keySet()) {
        	elements[idx][0] = key;
        	elements[idx++][1] = hs.get(key);
        }
        
        Arrays.sort(elements, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
        });
        
        int[] answer = new int[elements.length];
        idx=0;
        for(int[] element : elements) {
        	answer[idx++] = element[0];
        }
        
        return answer;
    }
}