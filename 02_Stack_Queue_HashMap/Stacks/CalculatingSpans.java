import java.util.*;

public class CalculatingSpans {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
          
            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
                st.pop();
            }

            
            span[i] = (st.isEmpty()) ? (i + 1) : (i - st.peek());

            st.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        System.out.println("Stock Spans:");
        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
