package etc;

public class LandWar {

	public static void main(String[] args) {
		int[][] land = {
				{1,2,3,5},
				{5,6,7,8},
				{4,3,2,1}
		};
		System.out.println(solution(land));
	}

    static int solution(int[][] land) {
        for(int i=0; i<land.length-1; i++) {
        	land[i+1][0] = findBestCombination(land[i][1], land[i][2], land[i][3], land[i+1][0]);
        	land[i+1][1] = findBestCombination(land[i][0], land[i][2], land[i][3], land[i+1][1]);
        	land[i+1][2] = findBestCombination(land[i][0], land[i][1], land[i][3], land[i+1][2]);
        	land[i+1][3] = findBestCombination(land[i][0], land[i][1], land[i][2], land[i+1][3]);
        }
        
        int lastIdx = land.length - 1;
        return findMaxValue(land[lastIdx][0], land[lastIdx][1], land[lastIdx][2], land[lastIdx][3]);
    }
    
    static int findBestCombination(int a, int b, int c, int target) {
    	a += target;
    	b += target;
    	c += target;
    	
    	return Math.max(Math.max(a, b), c);
    }
    
    static int findMaxValue(int a, int b, int c, int d) {
    	return Math.max(Math.max(Math.max(a, b), c), d);
    }
}

/*
     static int solution(int[][] land) {
        int sum = 0;
        int preIndex = Integer.MAX_VALUE;
        
        for(int i=0; i<land.length; i++) {
        	int max = 0;
        	int maxIndex = Integer.MAX_VALUE;
        	
        	for(int j=0; j<4; j++) {
        		if(j == preIndex) continue;
        		
        		if(max < land[i][j]) {
        			max = land[i][j];
        			maxIndex = j;
        		}
        	}
        	preIndex = maxIndex;
        	sum += max;
        }

        return sum;
    }
    
    */
