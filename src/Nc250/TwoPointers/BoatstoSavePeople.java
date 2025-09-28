package Nc250.TwoPointers;

import java.util.Arrays;

public class BoatstoSavePeople {

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{5, 1, 4, 2}, 6));
        System.out.println(numRescueBoats(new int[]{1, 3, 2, 3, 2}, 3));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int minRescueBoats = 0;
        int left = 0, right = people.length - 1;

        Arrays.sort(people);
        while (left <= right) {
            int remainingWeight = limit - people[right]; // we take the heaviest person and put them on the boat
            right--; // since we placed the person on the boat, we decrement the right pointer and increase the boat counr
            minRescueBoats++;

            // then we check if we have a remaining weight that can take the person on the left
            // on the same boat
            if(left <= right && remainingWeight >= people[left]) {
                left++;
            }
        }

        return minRescueBoats;
    }
}
