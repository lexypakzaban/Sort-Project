public class SelectionSort extends SortAlgorithm{
    public SelectionSort(AlgorithmDelegate del, int[] array){
        super(del,array);
    }

    public void run(){
        int N = array.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < N-1; i++) {

            // Find the minimum element in unsorted array
            int min_idx = i;

            for (int j = i+1; j < N; j++) {
                if (array[j] < array[min_idx]) {
                    min_idx = j;
                }

            }

            // Swap the found minimum element with the first
            // element
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;

            delegate.visualizeData(array);
            if (!keepRunning) {
                return;
            }

        }
        tellDelegateSortIsComplete();
    }
}

//SOURCES
//https://www.geeksforgeeks.org/selection-sort/
