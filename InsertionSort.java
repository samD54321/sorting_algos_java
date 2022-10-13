public class InsertionSort {
    private int[] values;
    private int size;
    private int comparisons;
    InsertionSort(int[] values){
        this.values = values;
        this.size = this.values.length;
        this.comparisons = 0;
    }
    public void insertionSort() {
        int i;
        for(i = 1; i < size; i++) {
            int t = values[i]; int j;
            comparisons++;
            for( j = i-1; j >= 0 && t < values[j]; j--) {
                values[j + 1] = values[j];
                //comparison between t and values[j]
                comparisons++;
            }
            values[j+1] = t;
        }
    }

    public int getComparisons() {
        return comparisons;
    }
}
