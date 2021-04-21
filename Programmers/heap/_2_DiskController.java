package heap;

import java.util.*;

public class _2_DiskController {

	public static void main(String[] args) {
		int[][] jobs = {
				{0,3}, {1,9}, {2, 6}
		};
		
		System.out.println(solution(jobs));
	}

    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // 요청시간 순서대로 jobs 배열 정렬
        PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]); // 소요시간 순대대로 pQueue정렬

        int jobLen = jobs.length;
        int i=0;
        int curTime = 0; // 현재 시간
        int allTime = 0; // 총 걸린 시간
        int finishedJobs = 0;
        while(finishedJobs < jobLen) {
        	while(i < jobLen && jobs[i][0] <= curTime) {
        		pQueue.add(jobs[i++]);
        	}
        	
        	if(pQueue.isEmpty()) {
        		curTime++;
        	} else {
        		int[] temp = pQueue.poll();
        		curTime += temp[1];
        		allTime += curTime - temp[0];
        		finishedJobs++;
        	}
        }
        /*
        int jobsSize = jobs.length;
        _jobs = new Job[jobsSize];

        while(i < jobsSize-1) {
        	while(i < jobsSize-1 && waiting[i][0] <= curTime) {
        		addNode(new Job(waiting[i][0], waiting[i++][1]));
        	}
        	
        	if(_jobs[0].requestTime > curTime) {
        		curTime++;
        		continue;
        	} else {
            	curTime += _jobs[0].requiredTime;
            	allTime += curTime - _jobs[0].requestTime; // 각각의 job이 걸린 시간은 (현재 시간 - 요청시간)
            	
            	removeNode();
        	}
        }*/
        
        return allTime / jobLen;
    }
   
}

// 우선순위 큐를 만들고
// 배열에 정렬된 job들을 넣은다음
// 1초마다 job을 하나씩 꺼내 우선순위 큐에 넣는다.
// 우선순위 큐에서는 현재 작업중인 일이 없을때마다 우선순위가 높은놈을 remove
// 여기서 우선순위란 가장 걸리는 시간이 가장 짧은 작업을 뜻함

// 유의할점은 아마 요청이 같은시간에 여러개 들어올수있다는거고
// 작업을 수행하고 있지 않을때는 먼저 요청이 들어온 작업부터 처리한다는 것.



/* 열심히 짠거 아쉬워서 백업
class Solution {
    public static Job[] _jobs;
    public int solution(int[][] jobs) {
        int len = jobs.length;
        _jobs = new Job[len];
        int i=0;
        for(int[] j : jobs) {
        	_jobs[i++] = new Job(j[0], j[1]);
        }
        
        makeMaxHeap();
        
        for(i=len-1; i>=0; i--) {
        	Job temp = _jobs[0];
        	_jobs[0] = _jobs[i];
        	_jobs[i] = temp;
        	
        	makeMaxHeap();
        }
        
        int curTime = 0; // 현재 시간
        int allTime = 0; // 총 걸린 시간
        while(_jobs.length > 0) {
        	if(_jobs[0].requestTime > curTime) {
        		curTime++;
        		continue;
        	} else {
            	curTime += _jobs[0].requiredTime;
            	allTime += curTime - _jobs[0].requestTime; // 각각의 job이 걸린 시간은 (현재 시간 - 요청시간)
            	
            	remove();
        	}
        }
        
        return allTime / len;
    }
    
    public static void makeMaxHeap() {
    	int len = _jobs.length;
    	for(int i=1; i<len; i++) {
    		int currentNode = i;
    		
    		while(currentNode != 0 ) {
    			int parentNode = (currentNode - 1) / 2;
    			
        		if(compareJob(_jobs[parentNode], _jobs[currentNode]) == 1) {
        			Job temp = _jobs[parentNode];
        			_jobs[parentNode] = _jobs[currentNode];
        			_jobs[currentNode] = temp;
        		}
        		
        		currentNode = parentNode;
    		}
    	}
    }
    
    // a가 크면 1, b가 크면 -1
    public static int compareJob(Job a, Job b) {
    	if(a.requiredTime > b.requiredTime) {
    		return 1;
    	} else if(a.requiredTime < b.requiredTime) {
    		return -1;
    	} else {
    		if(a.requestTime > b.requestTime) {
    			return 1;
    		}
    	}
    	return -1;
    }
    
    public static void remove() {
    	int len = _jobs.length;
    	_jobs[0] = _jobs[len-1]; // 마지막 노드를 루트 노드로
    	
    	// 새로운 사이즈 배열에 복사
    	Job[] _newJobs = new Job[len - 1];
    	for(int i=0; i<len-1; i++) {
    		_newJobs[i] = _jobs[i];
    	}
    	
    	_jobs = null; // GC가 주워갈수있도록...
    	_jobs = _newJobs;
    	
    	makeMaxHeap();
    }
}

class Job {
	int requestTime; // 요청시간
	int requiredTime; // 소요시간
	
	Job (int requestTime, int requiredTime){
		this.requestTime = requestTime;
		this.requiredTime = requiredTime;
	}
}
*/

/*
public static int solution(int[][] jobs) {
	// 요청할 일들을 요청시간 순서대로 정렬
	int[][] waiting = jobs;
    Arrays.sort(waiting, new Comparator<int[]>() {

		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0]-o2[0];
		}
    });
    
    /*
    int len = jobs.length;
    _jobs = new Job[len];
    int i=0;
    for(int[] j : jobs) {
    	_jobs[i++] = new Job(j[0], j[1]);
    }
    
    makeMaxHeap();
    
    for(i=len-1; i>=0; i--) {
    	Job temp = _jobs[0];
    	_jobs[0] = _jobs[i];
    	_jobs[i] = temp;
    	
    	makeMaxHeap();
    }
    */
    /*
    int jobsSize = jobs.length;
    _jobs = new Job[jobsSize];
    int curTime = 0; // 현재 시간
    int allTime = 0; // 총 걸린 시간
    int i = 0;
    while(i < jobsSize-1) {
    	while(i < jobsSize-1 && waiting[i][0] <= curTime) {
    		addNode(new Job(waiting[i][0], waiting[i++][1]));
    	}
    	
    	if(_jobs[0].requestTime > curTime) {
    		curTime++;
    		continue;
    	} else {
        	curTime += _jobs[0].requiredTime;
        	allTime += curTime - _jobs[0].requestTime; // 각각의 job이 걸린 시간은 (현재 시간 - 요청시간)
        	
        	removeNode();
    	}
    }
    
    return allTime / jobsSize;
}

public static void makeMaxHeap() {
	for(int i=1; i<heapSize; i++) {
		int currentNode = i;
		
		while(currentNode != 0 ) {
			int parentNode = (currentNode - 1) / 2;
			
    		if(compareJob(_jobs[parentNode], _jobs[currentNode]) == 1) {
    			Job temp = _jobs[parentNode];
    			_jobs[parentNode] = _jobs[currentNode];
    			_jobs[currentNode] = temp;
    		}
    		
    		currentNode = parentNode;
		}
	}
}

// a가 크면 1, b가 크면 -1
public static int compareJob(Job a, Job b) {
	if(a.requiredTime > b.requiredTime) {
		return 1;
	} else if(a.requiredTime < b.requiredTime) {
		return -1;
	} else {
		if(a.requestTime > b.requestTime) {
			return 1;
		}
	}
	return -1;
}

public static void removeNode() {
	if(heapSize > 0) {
    	_jobs[0] = _jobs[heapSize-- -1]; // 마지막 노드를 루트 노드로
    	makeMaxHeap();
	}
}

public static void addNode(Job job) {
	_jobs[++heapSize -1] = job; // heapSize가 1일때 0번째 인덱스에 값을 넣어야 하니까..
	makeMaxHeap();
}
}

class Job {
int requestTime; // 요청시간
int requiredTime; // 소요시간

Job (int requestTime, int requiredTime){
	this.requestTime = requestTime;
	this.requiredTime = requiredTime;
}
}
*/