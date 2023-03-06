package exercise3;

import java.util.*;

public class StockSpan {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0); 
        spans[0] = 1;

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                spans[i] = i + 1;
            }
            else {
                spans[i] = i - stack.peek();
            }

            stack.push(i);
        }

        return spans;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);
        System.out.println(Arrays.toString(spans)); // [1, 1, 1, 2, 1, 4, 6]
    }
}
