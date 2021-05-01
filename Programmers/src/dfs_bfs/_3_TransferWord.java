package dfs_bfs;

import java.util.*;

public class _3_TransferWord {
	static int stringLen;
	static int wordsLen;
	static ArrayList<Integer> conversion = new ArrayList<Integer>();

	public static void main(String[] args) {
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution("hit", "cog", words));
	}

    public static int solution(String begin, String target, String[] words) {
        wordsLen = words.length;
        stringLen = begin.length();
        ArrayList<String> process = new ArrayList<String>();
        for(int i=0; i<wordsLen; i++) {
        	dfs(begin, target, words, process);
        }
        
        Collections.sort(conversion);
        return conversion.isEmpty() ? 0 : conversion.get(0);
    }
    
    public static void dfs(String pre, String target, String[] words, ArrayList<String> process) {
    	if(pre.equals(target)) {
    		conversion.add(process.size());
    	}
    	
    	process.add(pre);
        for(int i=0; i<wordsLen; i++) {
        	if(!process.contains(words[i]) && isSimilar(pre, words[i])){
        		dfs(words[i], target, words, process);
        		process.remove(words[i]);
        	}
        }
    }
    
    public static boolean isSimilar(String pre, String cur) {
    	int cnt = 0;
    	
    	for(int i=0; i<stringLen; i++) {
    		if(pre.charAt(i) != cur.charAt(i)) {
    			cnt++;
    		}
    		
    		if(cnt > 1) return false; // 2개이상 다르니까 비슷한거 아님
    	}
    	
    	return true; // 비슷해
    }
}
