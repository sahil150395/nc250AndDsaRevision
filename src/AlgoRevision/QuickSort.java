package AlgoRevision;

public class QuickSort {
    public static void main(String[] args) {
        int[] inputArray = {9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 3, 0};
        sort(inputArray);

        for (int num : inputArray) {
            System.out.println(num);
        }
    }

    public static void sort(int[] inputArray) {
        quickSort(inputArray, 0, inputArray.length - 1);
    }

    private static void quickSort(int[] inputArray, int start, int end) {
        if (start < end) {
            int sortedIndex = partition(inputArray, start, end);
            quickSort(inputArray, start, sortedIndex - 1);
            quickSort(inputArray, sortedIndex + 1, end);
        }
    }

    private static int partition(int[] inputArray, int start, int end) {
        int pivot = inputArray[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (inputArray[j] <= pivot) {
                i++;
                int temp = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = temp;
            }
        }
        int temp = inputArray[i + 1];
        inputArray[i + 1] = pivot;
        inputArray[end] = temp;
        return i + 1;
    }
}
