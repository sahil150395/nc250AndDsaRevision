package AlgoRevision;

public class LinearSearch {

    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{1,2,3,4,5,6,7,8,9,10}, 9));
    }

    public static int linearSearch(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
