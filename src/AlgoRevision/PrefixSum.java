package AlgoRevision;

import java.util.ArrayList;
import java.util.List;

public class PrefixSum {

    List<Integer> prefixSums;

    public PrefixSum(int[] nums) {
        prefixSums = new ArrayList<>();
        int total = 0;
        for (int n : nums) {
            total += n;
            prefixSums.add(total);
        }
    }

    public int rangeSum(int left, int right) {
        int prefixSumRight = prefixSums.get(right);
        int prefixSumLeft = left > 0 ? prefixSums.get(left - 1) : 0;
        return prefixSumRight - prefixSumLeft;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        PrefixSum ps = new PrefixSum(nums);
        System.out.println(ps.rangeSum(3, 5));
    }
}
