package Nc250.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    private boolean hasDuplicate(int[] nums) {

        //this approach is faster as compared to using streams
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
