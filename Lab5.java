import java.util.Comparator;
import java.util.PriorityQueue;

public class Lab5 {

	public static PriorityQueue<Integer> minNumbers(int [] arr, int k) {
		MaxComparator pqMaxComparetor = new MaxComparator();
		PriorityQueue<Integer> pq = new PriorityQueue<>(arr.length, pqMaxComparetor);
		
		//returns empty pq if k is 0 or k > length(arr)
		if(k == 0) {
			return pq;
		}
		
		//if specified k greater than length of array, return entire array as pq
		if(k > arr.length) {
			k = arr.length;
		}
		
		//initialize max heap with values
		for(int i = 0; i < k; i++) {
			pq.offer(arr[i]);
		}
		
		//replaces max heap values if meets conditions
		for(int i = k; i < arr.length; i++) {
			if(arr[i] < pq.peek()) {
				pq.poll();
				pq.offer(arr[i]);
			}
		}
		
		return pq;
	}
	
	static class MaxComparator implements Comparator<Integer> {
		
		//converts min heap to max heap
        public int compare(Integer one, Integer two) {
        	if(one < two) {
        		return 1;
        	}
        	
        	return -1;
        }
    }
	
    public static void main(String[] args) {
        int[] a = {4, 5, 1, 6, 2, -7, 7, 8}; //test array
        int k = 7; //k smallest numbers
        System.out.println(minNumbers(a, k)); //prints k smallest numbers
    }

}
