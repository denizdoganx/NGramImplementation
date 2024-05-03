package algorithm;

import model.INGramObject;

public class HeapSort {
	
	private static HeapSort instance = null;
	
	private HeapSort() {
		
	}
	
	public static HeapSort getInstance() {
		if(instance == null) {
			instance = new HeapSort();
		}
		return instance;
	}
	
    public void sort(INGramObject arr[])
    {
        int N = arr.length;
 
        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);
 
        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
        	INGramObject temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }
 
    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(INGramObject arr[], int N, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l < N && arr[l].getFrequency() > arr[largest].getFrequency())
            largest = l;
 
        // If right child is larger than largest so far
        if (r < N && arr[r].getFrequency() > arr[largest].getFrequency())
            largest = r;
 
        // If largest is not root
        if (largest != i) {
            INGramObject swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }
   
}
