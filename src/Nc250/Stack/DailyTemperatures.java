package Nc250.Stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperaturesBruteForce(new int[]{30, 38, 30, 36, 35, 40, 28})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 38, 30, 36, 35, 40, 28})));
        System.out.println(Arrays.toString(dailyTemperaturesBruteForce(new int[]{22, 21, 20})));
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{22, 21, 20})));
    }

    public static int[] dailyTemperaturesBruteForce(int[] temperatures) {

        // O(n2) time complexity and O(n) space complexity
        int n = temperatures.length;
        int result[] = new int[n];
        Arrays.fill(result, 0);// fills all indexes of an array with the same value

        for (int i = 0; i < n; i++) {
            // we need to find the number of days till we find a day
            // that has the temperature greater than the current day
            int maxTemperatureIndex = -1;
            for (int j = i + 1; j < n; j++) {
                if (temperatures[j] > temperatures[i]) {
                    maxTemperatureIndex = j;
                    break;
                }
            }

            if (maxTemperatureIndex != -1) {
                result[i] = maxTemperatureIndex - i;
            }

        }

        return result;
    }


    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int result[] = new int[n];
        Arrays.fill(result, 0);

        /*
         * We will be using a monotonically decreasing stack technique, where the moment we
         * encounter a temeprature greater than the current top, we pop the top as long as
         * the condition is satisfied after calculating the days using the index difference
         * and then push the current temperature and index pair on the stack
         * */
        Stack<int[]> temperatureIndexPairStack = new Stack<>(); // [temp, index]

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while (!temperatureIndexPairStack.isEmpty() && (t > temperatureIndexPairStack.peek()[0])) {
                int[] tempIndexPair = temperatureIndexPairStack.pop();
                result[tempIndexPair[1]] = i - tempIndexPair[1];
            }

            temperatureIndexPairStack.push(new int[]{t, i});
        }

        return result;
    }
}
