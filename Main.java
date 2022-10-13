import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Read n and trials as user input
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter length of array (n): ");
        int n = myScanner.nextInt();
        System.out.println("Enter number of trials: ");
        int trials = myScanner.nextInt();

        //create an array of sort objects for "trials" number of initializations
        InsertionSort[] insertion = new InsertionSort[trials];
        MergeSort[] merge = new MergeSort[trials];
        QuickSort[] quick = new QuickSort[trials];

        //Declaring arrays for comparisons in 3 different sorting algorithms
        int[] IS_comps  = new int[trials]; //comparisons in InsertionSort
        int[] MS_comps  = new int[trials]; //comparisons in MergeSort
        int[] QS_comps  = new int[trials]; //comparisons in QuickSort

        //run loop for the number of trials
        for(int i =0; i<trials; i++){
            //generate permutation for new trial
            int[] myArray = generatePermutation(n);

            //initialize empty arrays for InsertionSort(IS), MergeSort(MS), and QuickSort(QS)
            int[] arrayIS = new int[n];
            int[] arrayMS = new int[n];
            int[] arrayQS = new int[n];

            //perform deep copy of permutation array
            System.arraycopy(myArray, 0, arrayQS, 0, n);
            System.arraycopy(myArray, 0, arrayIS, 0, n);
            System.arraycopy(myArray, 0, arrayMS, 0, n);

            //initialize sort objects and perform sort on the permutation array
            insertion[i] = new InsertionSort(arrayIS);
            insertion[i].insertionSort();
            merge[i] = new MergeSort(arrayMS);
            merge[i].mergeSort();
            quick[i] = new QuickSort(arrayQS);
            quick[i].quickSort();

            //fetch comparison counters from the sorting process
            IS_comps[i] = insertion[i].getComparisons();
            MS_comps[i] = merge[i].getComparisons();
            QS_comps[i] = quick[i].getComparisons();
        }

        //insert average comparisons in a hashmap
        Map<String, Double> avg_comparisons = new HashMap<String, Double>();
        avg_comparisons.put("insertion", sum(IS_comps)/trials);
        avg_comparisons.put("merge", sum(MS_comps)/trials);
        avg_comparisons.put("quick", sum(QS_comps)/trials);

        //display average comparisons
        System.out.println("Average comparisons for Insertion Sort: "+ Double.toString(avg_comparisons.get("insertion")));
        System.out.println("Average comparisons for Merge Sort: "+ Double.toString(avg_comparisons.get("merge")));
        System.out.println("Average comparisons for Quick Sort: "+ Double.toString(avg_comparisons.get("quick")));
    }

    static int[] generatePermutation(int n){
        int[] values = new int[n];
        //Initializing a sorted array of first n numbers
        for (int i = 0; i < n; i++)
            values[i] = i+1;

        //Utilizing the variant of Algorithm P to generate a permutation
        for(int j = n-1; j>0; j--) {
            double u = new Random().nextDouble();
            int k = (int) Math.floor((j + 1) * u);
            int temp = values[j];
            values[j] = values[k];
            values[k] = temp;
        }

        return values;
    }
    public static double sum(int[] values){
        double result = 0;
        for(double value:values)
            result+=value;
        return result;
    }
}