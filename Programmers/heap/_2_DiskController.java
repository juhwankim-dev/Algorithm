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
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]); // ��û�ð� ������� jobs �迭 ����
        PriorityQueue<int[]> pQueue = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]); // �ҿ�ð� ������ pQueue����

        int jobLen = jobs.length;
        int i=0;
        int curTime = 0; // ���� �ð�
        int allTime = 0; // �� �ɸ� �ð�
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
            	allTime += curTime - _jobs[0].requestTime; // ������ job�� �ɸ� �ð��� (���� �ð� - ��û�ð�)
            	
            	removeNode();
        	}
        }*/
        
        return allTime / jobLen;
    }
   
}

// �켱���� ť�� �����
// �迭�� ���ĵ� job���� ��������
// 1�ʸ��� job�� �ϳ��� ���� �켱���� ť�� �ִ´�.
// �켱���� ť������ ���� �۾����� ���� ���������� �켱������ �������� remove
// ���⼭ �켱������ ���� �ɸ��� �ð��� ���� ª�� �۾��� ����

// ���������� �Ƹ� ��û�� �����ð��� ������ ���ü��ִٴ°Ű�
// �۾��� �����ϰ� ���� �������� ���� ��û�� ���� �۾����� ó���Ѵٴ� ��.



/* ������ §�� �ƽ����� ���
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
        
        int curTime = 0; // ���� �ð�
        int allTime = 0; // �� �ɸ� �ð�
        while(_jobs.length > 0) {
        	if(_jobs[0].requestTime > curTime) {
        		curTime++;
        		continue;
        	} else {
            	curTime += _jobs[0].requiredTime;
            	allTime += curTime - _jobs[0].requestTime; // ������ job�� �ɸ� �ð��� (���� �ð� - ��û�ð�)
            	
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
    
    // a�� ũ�� 1, b�� ũ�� -1
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
    	_jobs[0] = _jobs[len-1]; // ������ ��带 ��Ʈ ����
    	
    	// ���ο� ������ �迭�� ����
    	Job[] _newJobs = new Job[len - 1];
    	for(int i=0; i<len-1; i++) {
    		_newJobs[i] = _jobs[i];
    	}
    	
    	_jobs = null; // GC�� �ֿ������ֵ���...
    	_jobs = _newJobs;
    	
    	makeMaxHeap();
    }
}

class Job {
	int requestTime; // ��û�ð�
	int requiredTime; // �ҿ�ð�
	
	Job (int requestTime, int requiredTime){
		this.requestTime = requestTime;
		this.requiredTime = requiredTime;
	}
}
*/

/*
public static int solution(int[][] jobs) {
	// ��û�� �ϵ��� ��û�ð� ������� ����
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
    int curTime = 0; // ���� �ð�
    int allTime = 0; // �� �ɸ� �ð�
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
        	allTime += curTime - _jobs[0].requestTime; // ������ job�� �ɸ� �ð��� (���� �ð� - ��û�ð�)
        	
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

// a�� ũ�� 1, b�� ũ�� -1
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
    	_jobs[0] = _jobs[heapSize-- -1]; // ������ ��带 ��Ʈ ����
    	makeMaxHeap();
	}
}

public static void addNode(Job job) {
	_jobs[++heapSize -1] = job; // heapSize�� 1�϶� 0��° �ε����� ���� �־�� �ϴϱ�..
	makeMaxHeap();
}
}

class Job {
int requestTime; // ��û�ð�
int requiredTime; // �ҿ�ð�

Job (int requestTime, int requiredTime){
	this.requestTime = requestTime;
	this.requiredTime = requiredTime;
}
}
*/