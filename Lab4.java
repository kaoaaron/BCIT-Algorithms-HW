import java.util.Arrays;
import java.util.Random;

public class Lab4 {
	
	//finds largest position of array
	public static int LargestPos(int[] arr, int min, int max) {
		
		if(min == max) {
			return min + 1;
		}
		
		if(max - min == 1) {
			if(arr[min] > arr[max]) {
				return min + 1;
			}else {
				return max + 1;
			}
		}
		
		int mid = (min + max)/2;
		int left = LargestPos(arr, min, mid);
		int right = LargestPos(arr, mid+1, max);
		
		if(arr[left - 1] > arr[right - 1]) {
			return left;
		}else {
			return right;
		}

	}
	
	//generate random array between 1-100 of size : size
	public static int[] randomArr(int size) {
		int[] arr = new int[size];
		Random random = new Random();
		
		for(int i = 0; i < arr.length; i++){
		    arr[i]=random.nextInt(100);
		}
		return arr;
	}
	
	//perform mergeSort
	public static void mergeSort(int [] A, int min, int max) {
		
		//simply return if down to 1 element
		if(min >= max) {
			return;
		}

		//recursive operations
		int mid = (min+max)/2;
		mergeSort(A, min, mid);
		mergeSort(A, mid+1, max);
			
		/*
		 * Everything below here is for merging two lists
		 */
		
		int lowSize = mid-min + 1;
		int highSize = max-mid;
		
		int left[] = new int[lowSize];
		int right[] = new int[highSize];
		
		//for loops used to copy left and right arrays from A
		for(int i = 0; i < lowSize; i++) {
			left[i] = A[min + i];
		}
		
		for(int i = 0; i < highSize; i++) {
			right[i] = A[mid + 1 + i];
		}
		
		int i = 0, j = 0, k = min;
		
		//iterate left and right until one is iterated
		while(i < lowSize && j < highSize) {
			if(left[i] <= right[j]) {
				A[k] = left[i];
				i++;
			}else {
				A[k] = right[j];
				j++;
			}
			k++;
		}
		
		//following while loops complete the iteration if necessary and copies back to A
		while (i < lowSize) {
            A[k] = left[i];
            i++;
            k++;
        }
 
        while (j < highSize) {
            A[k] = right[j];
            j++;
            k++;
        }
        
	}
	
	public static void main(String [] args) {
		//part1
		System.out.println("***********Part 1**************");
		
		int testArr [] = {2,5,8,3,6,9,1,6,5};
		int x = LargestPos(testArr, 0, testArr.length - 1);
		System.out.println(Arrays.toString(testArr) + ": MaxPos = " + x + "\n");
		
		//part2
		System.out.println("***********Part 2**************");
		
		int A [] = randomArr(10);
		System.out.println("Original: " + Arrays.toString(A));
		mergeSort(A, 0, A.length - 1);
		System.out.println("Sorted: " + Arrays.toString(A));
	}
}
