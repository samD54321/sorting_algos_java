public class MergeSort {
    private int[] values;
    private int size;
    private int comparisons;
    MergeSort(int[] values){
        this.values = values;
        this.size = this.values.length;
        this.comparisons = 0;
    }
    public void mergeSort() {
        mergeSortPart(this.values, 0, size - 1);
    }
    public void mergeSortPart(int[] v,int first,int last){

        if(first < last){
            int mid = (first + last)/2;
            mergeSortPart(v, first, mid);
            mergeSortPart(v, mid + 1, last);
            merge(v,first, mid, last);
        }
    }
    public void merge(int[] v, int first, int mid,int last){
        int temp[] = new int[last+1];
        int first1 = first;
        int last1 = mid;
        int first2 = mid + 1;
        int last2 = last;
        int index = first1;
        while((first1 <= last1) && (first2 <= last2)){
            //comparison between v[first1] and v[first2]
            comparisons++;
            if(v[first1 ]< v[first2])
                temp[index++] = v[first1++];
            else
                temp[index++] = v[first2++];
        }
        while(first1 <= last1) {
            //comparison between first1 and last1
            comparisons++;
            temp[index++] = v[first1++];
        }
        while(first2 <= last2) {
            //comparison between first1 and last1
            comparisons++;
            temp[index++] = v[first2++];
        }
        for(index = first; index <= last; index++)
            v[index] = temp[index];
    }
    public int getComparisons() {
        return this.comparisons;
    }
}
