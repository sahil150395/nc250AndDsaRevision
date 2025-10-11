package Nc250.Stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    public static void main(String[] args) {
        System.out.println(carFleet(10, new int[]{4,1,0,7}, new int[]{2,2,1,1}));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int[][] positionSpeedPair = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            positionSpeedPair[i][0] = position[i]; //position
            positionSpeedPair[i][1] = speed[i]; //speed
        }
        /*
         * this will form a 2-matrix of size  position.length(rows) * 2(columns)
         * poistion -> [4,1,0,7], speed -> [2,2,1,1]
         * result -> [[4,2],[1,2],[0,1],[7,1]]
         *
         * We will sort the resultant array in decreasing order because it is a single lane
         * and no car can pass another car, so it has to catch the car at front, and we can calculate
         * the time each car takes that is behind the car at the right most position to reach the target.
         * If the time it takes is less than or equal to the time leader takes, it is a fleet.
         * We will use a stack to maintain the fleet count based on this calculation.
         * If the time is same or less, we will not keep it on stack.
         * The fleet count will be the length of the stack.
         * */

        //sorting in descending order based on position
        Arrays.sort(positionSpeedPair, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> timeStack = new Stack<>();
        for (int[] pair : positionSpeedPair) {
            // we calculate the current position takes to cover the remaining distance to the target
            // we push it onto the stack, since it will be the new top, we will compare it with the time
            // the car at the front takes, if the time is less than or equal to it, it is one fleet
            // so we can pop it from the stack
            timeStack.push((double) (target - pair[0]) / pair[1]);
            if (timeStack.size() >= 2 && timeStack.peek() <= timeStack.get(timeStack.size() - 2)) {
                timeStack.pop();
            }
        }

        return timeStack.size();
    }
}
