package AlgoRevision;

public class BinarySearch {

    //data has to be sorted to use binary search algorithm
    public static void main(String[] args) {
        int[] arr = new int[]{22, 55, 76, 89, 129};
        System.out.println(binarySearch(arr, 89));
        System.out.println(recursiveBinarySearch(arr, 0, arr.length - 1, 89));
    }

    public static int binarySearch(int[] arr, int key) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] > key) {
                end = mid - 1;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                return mid;
            }

        }

        return -1;
    }

    public static int recursiveBinarySearch(int[] arr, int start, int end, int key) {
        if (start > end) return -1;
        else {
            int mid = (start + end) / 2;
            if (key < arr[mid]) {
                return recursiveBinarySearch(arr, start, mid - 1, key);
            } else if (key > arr[mid]) {
                return recursiveBinarySearch(arr, mid + 1, end, key);
            } else {
                return mid;
            }
        }
    }
}
