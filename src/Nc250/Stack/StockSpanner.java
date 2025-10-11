package Nc250.Stack;

import java.util.Stack;

public class StockSpanner {

    /*
     * We will be using a monotonically decreasing stack for this purpose.
     * the stockPrice will maintain the pair of the stock price and span before it, meaning the count of all values
     * less than it, so that we wont have to check individual prices all over again
     * */
    private Stack<int[]> stockPrice; //pair [price, span]
    //private Stack<Integer> spanTempStack;

    public StockSpanner() {
        this.stockPrice = new Stack<>();
        //this.spanTempStack = new Stack<>();
    }

    public int next(int price) {
        /*stockPrice.push(price);
        int span = 0;

        while (!stockPrice.isEmpty() && price >= stockPrice.peek()) {
            span++;
            spanTempStack.push(stockPrice.pop());
        }

        while (!spanTempStack.isEmpty()) {
            stockPrice.push(spanTempStack.pop());
        }

        return span;*/

        int span = 1;
        while (!stockPrice.isEmpty() && stockPrice.peek()[0] <= price) {
            span += stockPrice.peek()[1];
            stockPrice.pop();
        }

        stockPrice.push(new int[]{price, span});

        return span;
    }
}
