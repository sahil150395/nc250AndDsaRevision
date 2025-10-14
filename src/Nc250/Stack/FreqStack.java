package Nc250.Stack;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class FreqStack {
    private Map<Integer, Integer> frequencyMap; // it maintains the frequency of each value pushed onto the stack
    private int maxCount; // specifies the count of the maximum value
    private Map<Integer, Stack<Integer>> countStacksMap;

    /*
     * countStacksMap is the map that holds the stacks of values corresponding to each frequency
     * Suppose we are pushing 5,7,5,7,4,5
     * 5 occurs 3 times, 7 occurs 2 times, 4 occurs once
     * So we will have the following values in countStacksMap
     * 1 -> 5,7,4
     * 2 -> 5,7
     * 3 -> 5
     * 5 occurs once, then twice and then 3 times as we proceed, so will have it in all the three buckets
     * if we pop the maxFrequency value, i.e. 5 after all push's, then we will po 5 from stack corresponding to 3
     * and the maxCount will reduce to 2
     * */

    public FreqStack() {
        this.frequencyMap = new HashMap<>();
        this.maxCount = 0;
        this.countStacksMap = new HashMap<>();
    }

    public void push(int val) {
        // increment the count of the value in the frequencyMap
        int valCnt = frequencyMap.getOrDefault(val, 0) + 1;
        frequencyMap.put(val, valCnt);
        if (valCnt > maxCount) {
            /*
             * if the count of the value being inserted is greater than the maxCount, we need to add
             * a new stack corresponding to the new max value and then push it onto the stack
             * */
            maxCount = valCnt;
            countStacksMap.putIfAbsent(maxCount, new Stack<>()); // insert an empty stack if the maxValue is updated
        }
        countStacksMap.get(valCnt).push(val); // then push the value onto the stack
    }

    public int pop() {
        int result = countStacksMap.get(maxCount).pop(); // pop the maxValue number from the countStacksMap
        frequencyMap.put(result, frequencyMap.get(result) - 1); // decrement the frequency of the num being popped
        if (countStacksMap.get(maxCount).isEmpty()) {
            // if the stack becomes empty after popping the maxValue the maxCount is reduced
            maxCount--;
        }

        return result;
    }
}
