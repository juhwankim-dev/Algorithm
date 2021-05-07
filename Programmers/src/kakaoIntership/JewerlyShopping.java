package kakaoIntership;

import java.util.*;

public class JewerlyShopping {
	static int start=0;
	static int end=0;
	
	public static void main(String[] args) {
		String[] gems = {
				//"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
				//"AA", "AB", "AC", "AA", "AC"
				//"ZZZ", "YYY", "NNNN", "YYY", "BBB"
				"A", "A", "B"
		};
		
		int[] answer = solution(gems);
		
		for(int a : answer) {
			System.out.println(a);
		}
	}

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        // 중복 제거 (보석 리스트 구하기)
        HashSet<String> jewerlyList = new HashSet<>();
        for(String gem : gems) {
        	jewerlyList.add(gem);
        }
        
        int high = gems.length;
        int low = jewerlyList.size();
        
        while(low <= high) {
        	int mid = (low + high) / 2;
        	if(canBuyJewerl(gems, jewerlyList.size(), mid)) {
        		high = mid - 1;
        	} else {
        		low = mid + 1;
        	}
        }
        
        answer[0] = (start==0) ? 1 : start;
        answer[1] = (end==0) ? gems.length : end;
        return answer;
    }
    
    public static boolean canBuyJewerl(String[] gems, int kind, int mid) {
    	HashMap<String, Integer> list = new HashMap<>(); // 쇼핑 리스트
    	for(int i=0; i<mid; i++) {
    		list.put(gems[i], list.getOrDefault(gems[i], 0) + 1);
    	}
    	
    	for(int i=0; i<=gems.length - mid; i++) {
    		if(list.size() == kind) {
    			start = i+1;
    			end = i+mid;
    			return true;
    		}
    		
    		int test = list.get(gems[i]);
    		if(test == 1) list.remove(gems[i]);
    		else list.put(gems[i], test - 1);
    		
    		if(i+mid<gems.length)
    			list.put(gems[i+mid], list.getOrDefault(gems[i+mid], 0) + 1);
    	}
    	return false;
    }
}

/* 처음 시도한 방법. 이분탐색으로 할 수 있을것 같은데 안돼서 일단 가장 쉬운 방법으로 부딪혀봄 (역시 시간초과)
    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        // 중복 제거 (보석 리스트 구하기)
        HashSet<String> hs = new HashSet<>();
        for(String gem : gems) {
        	hs.add(gem);
        }
        
        int min = Integer.MAX_VALUE;
        ArrayList<String> shoppingList = new ArrayList<>();
        for(int i=0; i<gems.length; i++) {
    		while(hasAllJewerl(shoppingList, hs)) {
    			if(shoppingList.size() < min) {
        			answer[0] = i - shoppingList.size() + 1;
        			answer[1] = i;
        			min = shoppingList.size();
        		}
    			shoppingList.remove(0);
    		}
    		shoppingList.add(gems[i]);
        }
        
        if(min==Integer.MAX_VALUE) {
        	answer[0] = 1;
        	answer[1] = shoppingList.size();
        }
        
        return answer;
    }
    
    public static boolean hasAllJewerl(ArrayList<String> shoppingList, HashSet<String> hs) {
    	for(String h : hs) {
    		if(!shoppingList.contains(h)) return false;
    	}
    	
    	return true;
    }
    */

/* 두 번째 시도한 방법, 이분탐색으로 하는 방법을 알아냄 하지만 여전히 시간초과
public static int[] solution(String[] gems) {
    int[] answer = new int[2];
    
    // 중복 제거 (보석 리스트 구하기)
    HashSet<String> jewerlyList = new HashSet<>();
    for(String gem : gems) {
    	jewerlyList.add(gem);
    }
    
    int high = gems.length;
    int low = jewerlyList.size();
    
    while(low <= high) {
    	int mid = (low + high) / 2;
    	if(canBuyJewerl(gems, jewerlyList, mid)) {
    		high = mid - 1;
    	} else {
    		low = mid + 1;
    	}
    }
    
    answer[0] = start;
    answer[1] = end;
    return answer;
}

public static boolean canBuyJewerl(String[] gems, HashSet<String> jewerlyList, int mid) {
	HashSet<String> shoppingList = new HashSet<>();
	
	for(int i=0; i<=gems.length - mid; i++) {
		shoppingList.clear();
    	for(int j=i; j<i+mid; j++) {
    		shoppingList.add(gems[j]);
    		
    		if(shoppingList.size() == jewerlyList.size()) {
    			start = i+1;
    			end = j+1;
    			return true;
    		}
    	}
	}
	return false;
}
*/
