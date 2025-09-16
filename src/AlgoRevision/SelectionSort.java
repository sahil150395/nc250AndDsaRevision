package AlgoRevision;

public class SelectionSort {

    public static void main(String[] args) {
        int[] myArray = sort(new int[]{9, 8, 3, 13, 87, 12, 99});

        for (int num : myArray) {
            System.out.println(num);
        }
    }

    private static int[] sort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int minimum = i;

            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[minimum]) {
                    minimum = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[minimum];
            nums[minimum] = temp;

        }

        return nums;
    }
}
