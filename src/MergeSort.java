import java.util.ArrayList;
import java.util.List;

public class MergeSort extends SortAlgorithm {
    public MergeSort(AlgorithmDelegate del, int[] array){
        super(del, array);
    }


    public void run() {
        int N = array.length;
        mergeSort(array,N);

        delegate.visualizeData(array);
        if (!keepRunning) {
            return;
        }
        tellDelegateSortIsComplete();

    }


    public static void merge(int[] left_array,int[] right_array, int[] array,int left_size, int right_size){

        int i=0,l=0,r = 0;
        //The while loops check the conditions for merging
        while(l<left_size && r<right_size){

            if(left_array[l]<right_array[r]){
                array[i++] = left_array[l++];
            }
            else{
                array[i++] = right_array[r++];
            }
        }
        while(l<left_size){
            array[i++] = left_array[l++];
        }
        while(r<right_size){
            array[i++] = right_array[r++];
        }
    }

    public static void mergeSort(int [] array, int len){
        if (len < 2){return;}

        int mid = len / 2;
        int [] left_array = new int[mid];
        int [] right_array = new int[len-mid];

        //Dividing array into two and copying into two separate arrays
        int k = 0;
        for(int i = 0;i<len;++i){
            if(i<mid){
                left_array[i] = array[i];
            }
            else{
                right_array[k] = array[i];
                k = k+1;
            }
        }
        // Recursively calling the function to divide the subarrays further
        mergeSort(left_array,mid);
        mergeSort(right_array,len-mid);
        // Calling the merge method on each subdivision
        merge(left_array,right_array,array,mid,len-mid);
    }

}

//SOURCE
//https://www.educative.io/edpresso/how-to-implement-a-merge-sort-in-java