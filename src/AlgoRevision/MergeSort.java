package AlgoRevision;

public class MergeSort {

    public static void main(String[] args) {
        int[] inputArray = {9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 3, 0};
        mergeSort(inputArray);

        for (int num : inputArray) {
            System.out.println(num);
        }
    }

    /*
    Only drawback of merge sort as compared to selection and insertion sort is that it requires making
    complete copies of the array, whereas the other two sort the array in place.
    If space is a tight constraint for you then merge sort may not be an option for sorting.
    Its running time is O(nlogn) worst case as compared to running time of O(n2) of the other two search algos.
    */

    public static void mergeSort(int[] inputArray) {
        sort(inputArray, 0, inputArray.length - 1);
    }

    private static void sort(int[] inputArray, int start, int end) {
        if (end <= start) {
            return;
        }

        int mid = (start + end) / 2;
        sort(inputArray, start, mid);
        sort(inputArray, mid + 1, end);
        merge(inputArray, start, mid, end);
    }

    private static void merge(int[] inputArray, int start, int mid, int end) {
        int[] tempArray = new int[end - start + 1];
        int leftSlot = start; // index position of first slot on the left side of the array
        int rightSlot = mid + 1; // index position of first slot on the right side of the array
        int k = 0;

        while (leftSlot <= mid && rightSlot <= end) {
            if (inputArray[leftSlot] < inputArray[rightSlot]) {
                tempArray[k] = inputArray[leftSlot];
                leftSlot++;
            } else {
                tempArray[k] = inputArray[rightSlot];
                rightSlot++;
            }
            k++;
        }

        /*
         * The above look has completed, so both the left and right side of the subarray
         * can be considered sorted.
         * */

        if (leftSlot <= mid) {
            //consider the right side done being sorted. Left must be sorted already.
            while (leftSlot <= mid) {
                tempArray[k] = inputArray[leftSlot];
                leftSlot++;
                k++;
            }
        } else if (rightSlot <= end) {
            //consider the left side done being sorted. Right must be sorted already.
            while (rightSlot <= end) {
                tempArray[k] = inputArray[rightSlot];
                rightSlot++;
                k++;
            }
        }

        // copy over the sorted tempArray to the appropriate slots of the inputArray
        for (int i = 0; i < tempArray.length; i++) {
            inputArray[start + i] = tempArray[i];
        }
    }
}
