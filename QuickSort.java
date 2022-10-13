public class QuickSort {
    private int[] values;
    private int size;
    private int comparisons;
    QuickSort(int[] values){
        this.values = values;
        this.size = this.values.length;
        this.comparisons = 0;
    }
    public void quickSort(){
        quickSortPart(this.values, 0, this.size-1);
    }
    public void quickSortPart(int[] v,int left, int right){
        int pivot = partition(v,left,right);
        if (left < pivot-1){
            quickSortPart(v, left, pivot-1);
        }
        if(pivot+1<right) {
            quickSortPart(v, pivot + 1, right);
        }
    }
    public int partition(int[] v, int left, int right){
        while(true){
            while(left < right && v[left]< v[right]) {
                //comparison between v[left] and v[right]
                comparisons++;
                right--;
            }
            if(left < right)
                swap(v, left++, right);
            else
                return left;
            while(left < right && v[left]<v[right]) {
                //comparison between v[left] and v[right]
                comparisons++;
                left++;
            }
            if(left < right)
                swap(v, left, right--);
            else
                return right;
        }
    }
    public void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int getComparisons(){
        return this.comparisons;
    }
}
