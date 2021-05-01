package heap;

public class Test {
	public static int[] heap = {7,6,5,8,3,5,9,1,6};
	public static void main(String[] args) {
		makeMaxHeap();
		
		int len = heap.length;
		for(int i=len-1; i>=0; i--) {
			int temp = heap[0];
			heap[0] = heap[i];
			heap[i] = temp;
			
			makeMaxHeap();
		}
		
		for(int h : heap) {
			System.out.println(h);
		}
	}

	public static void makeMaxHeap() {
		int len = heap.length;
		for(int i=1; i<len; i++) {
			
			int currentNode = i;
			while(currentNode != 0) {
				int parentNode = (currentNode - 1) / 2;
				
				if(heap[parentNode] > heap[currentNode]) {
					int temp = heap[parentNode];
					heap[parentNode] = heap[currentNode];
					heap[currentNode] = temp;
				}
				
				currentNode = parentNode;
			}
		}
	}
}
