package Nc250.BinarySearch;

public class CapacitytoShipPackagesWithinDDays {

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{2, 4, 6, 1, 3, 10}, 10));
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(shipWithinDays(new int[]{1, 5, 4, 4, 2, 3}, 3));
    }


    /* Approach: Find minimum ship capacity to ship all packages within `days`.
    1. Intuition
   - If the ship capacity increases, the number of days needed to ship all packages
     never increases (monotonic). Therefore we can binary-search the minimum capacity.
   - For a fixed capacity C, we can simulate loading packages in order and count how
     many days it would take: group consecutive packages whose total weight ≤ C.
   - If the required days ≤ given `days`, capacity C is feasible; otherwise it is too small.

   2. Search bounds
   - low  = max(weights)      // must be at least the heaviest single package
   - high = sum(weights)      // at most ship everything in one day

   3. Feasibility check (simulate for a given capacity C)
   - Initialize currentLoad = 0, dayCount = 1.
   - Iterate weights in order:
       - If currentLoad + weight <= C: add weight to currentLoad (same day).
       - Else: start a new day -> dayCount++, set currentLoad = weight.
       - If dayCount > days at any point -> C is not feasible (early exit).
   - After processing all packages, if dayCount <= days -> C is feasible.

   4. Binary search loop
   - While low < high:
       - mid = low + (high - low) // 2   // candidate capacity
       - If feasible(mid) -> high = mid  // try smaller capacity
       - Else -> low = mid + 1           // need larger capacity
   - Return low (or high) as the minimal feasible capacity.

   5. Complexity
   - Each feasibility check is O(n) where n = weights.length.
   - Binary search range is from low..high but effectively log(sum(weights) - max(weights)) steps.
   - Overall time = O(n * log S) where S ≈ sum(weights).
   - Space = O(1) extra.

   6. Edge cases
   - If days == weights.length -> answer = max(weights) (one package per day).
   - If days == 1 -> answer = sum(weights) (all packages in one day).
   - weights length and values may be large; use types that avoid overflow when summing.
*/


    //Time complexity: O(nlogS) - n is the number of elements in the weights array, S is the sum of all weights
    //Space complexity: O(1)
    public static int shipWithinDays(int[] weights, int days) {
        int lowestCapacity = 0, maxCapacity = 0;

        for (int weight : weights) {
            lowestCapacity = Math.max(lowestCapacity, weight);
            maxCapacity += weight;
        }

        int result = maxCapacity;

        // Important: Use either (low < high, high = mid) or (low <= high, high = mid - 1)
        // Mixing them can cause an infinite loop when low == high == mid.
        while (lowestCapacity <= maxCapacity) {

            int midCapacity = lowestCapacity + (maxCapacity - lowestCapacity) / 2;

            if (isFeasible(weights, midCapacity, days)) {
                // Use high = mid (not mid - 1) because we're finding the smallest feasible capacity.
                // When isFeasible(mid) is true, mid might still be the minimum valid answer, so we keep it in range.
                maxCapacity = midCapacity - 1;
                result = Math.min(result, midCapacity);
            } else {
                lowestCapacity = midCapacity + 1;
            }
        }

        return result;
    }

    private static boolean isFeasible(int[] weights, int capacity, int days) {

        int currentLoad = 0, dayCount = 1;
        for (int weight : weights) {
            if (currentLoad + weight <= capacity) {
                currentLoad += weight;
            } else {
                currentLoad = weight;
                dayCount++;
            }
        }

        return dayCount <= days;
    }

    public static int shipWithinDaysBruteForce(int[] weights, int days) {
        int res = 0;
        for (int weight : weights) {
            res = Math.max(res, weight);
        }
        while (true) {
            int ships = 1;
            int cap = res;
            for (int weight : weights) {
                if (cap - weight < 0) {
                    ships++;
                    cap = res;
                }
                cap -= weight;
            }
            if (ships <= days) {
                return res;
            }
            res++;
        }
    }
}
