public class InsertionSort extends SortAlgorithm {
    public InsertionSort(AlgorithmDelegate del, int[] array){
        super(del,array);
    }

    public void run(){
        int N = array.length;

        for (int i = 1; i < N; ++i) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;

            delegate.visualizeData(array);
            if (!keepRunning) {
                return;
            }
        }
        tellDelegateSortIsComplete();
    }
}

//SOURCE
//https://www.geeksforgeeks.org/insertion-sort/
