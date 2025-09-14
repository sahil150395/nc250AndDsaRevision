package AlgoRevision;

public class LinearSearch {

    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
        System.out.println(recursiveLinearSearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 6));
    }

    public static int linearSearch(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int recursiveLinearSearch(int[] arr, int index, int key) {
        if (index > arr.length - 1) {
            return -1;
        } else if (arr[index] == key) {
            return index;
        } else {
            return recursiveLinearSearch(arr, index + 1, key);
        }
    }
}
