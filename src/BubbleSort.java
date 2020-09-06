public class BubbleSort extends SortAlgorithm {
    public BubbleSort(AlgorithmDelegate del, int[] array) {
        super(del, array);
    }

    public void run() {
        int N = array.length;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                try {
                    if (array[j] > array[j+1]) {
                        // swap arr[j+1] and arr[i]
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }

                catch (ArrayIndexOutOfBoundsException e){
                    break;
                }

                delegate.visualizeData(array);
                if (!keepRunning) {
                    return;
                }


            }
        }
        tellDelegateSortIsComplete();
    }
}


//SOURCES
//https://www.geeksforgeeks.org/bubble-sort/
