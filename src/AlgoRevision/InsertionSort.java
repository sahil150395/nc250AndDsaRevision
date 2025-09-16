package AlgoRevision;

public class InsertionSort {

    public static void main(String[] args) {
        int[] myArray = sort(new int[]{9, 8, 3, 13, 87, 12, 99});

        for (int num : myArray) {
            System.out.println(num);
        }
    }

    private static int[] sort(int[] nums) {
        for (int unsortedPortionIndex = 1; unsortedPortionIndex < nums.length; unsortedPortionIndex++) {
            int element = nums[unsortedPortionIndex]; // element to be moved from unsorted part to sorted part
            int sortedPortionLastIndex = unsortedPortionIndex - 1;

            while (sortedPortionLastIndex >= 0 && nums[sortedPortionLastIndex] > element) {
                nums[sortedPortionLastIndex + 1] = nums[sortedPortionLastIndex];
                sortedPortionLastIndex--;
            }
            nums[sortedPortionLastIndex + 1] = element;
        }

        return nums;
    }
}
