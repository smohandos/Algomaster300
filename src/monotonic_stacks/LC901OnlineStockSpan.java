package monotonic_stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC901OnlineStockSpan {
	/*
	 Example 1:

	Input
	["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
	[[], [100], [80], [60], [70], [60], [75], [85]]
	Output
	[null, 1, 1, 1, 2, 1, 4, 6]

	Explanation
	StockSpanner stockSpanner = new StockSpanner();
	stockSpanner.next(100); // return 1
	stockSpanner.next(80);  // return 1
	stockSpanner.next(60);  // return 1
	stockSpanner.next(70);  // return 2
	stockSpanner.next(60);  // return 1
	stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
	stockSpanner.next(85);  // return 6
	 */
	public static void main(String[] args) {
		//[[],[28],[14],[28],[35],[46],[53],[66],[80],[87],[88]]
				
		LC901OnlineStockSpan stockSpanner = new LC901OnlineStockSpan();
/*		System.out.println(stockSpanner.nextBF(100)); // returns 1
		System.out.println(stockSpanner.nextBF(80));  // returns 1
		System.out.println(stockSpanner.nextBF(60));  // returns 1
		System.out.println(stockSpanner.nextBF(70));  // returns 2
		System.out.println(stockSpanner.nextBF(60));  // returns 1
		System.out.println(stockSpanner.nextBF(75));  // returns 4
		System.out.println(stockSpanner.nextBF(85));  // returns 6
*/
		System.out.println(stockSpanner.nextBF(28)); 
		System.out.println(stockSpanner.nextBF(14));  
		System.out.println(stockSpanner.nextBF(28));  
		System.out.println(stockSpanner.nextBF(35));  
		System.out.println(stockSpanner.nextBF(46));  
		System.out.println(stockSpanner.nextBF(53));  
		System.out.println(stockSpanner.nextBF(66));  
		System.out.println(stockSpanner.nextBF(80));  
		System.out.println(stockSpanner.nextBF(87));  
		System.out.println(stockSpanner.nextBF(88));  
	
	}

	private Stack<int[]> stack;  // Stack to hold pairs of (price, span)
	private List<Integer> prices;
	
	public LC901OnlineStockSpan() {
		stack = new Stack<>();
		prices=new ArrayList<>();
	}

	public int nextBF(int price) {
		
		int currPrice=price;
		
		prices.add(price);
		
		int res=1;
		
		int n=prices.size();
		
		int curIdx=n-1;
		
		while(curIdx>=1 && currPrice>=prices.get(curIdx-1))
		{
			curIdx--;
			res++;
		}
		
		return res;
	}
	public int next(int price) {

		
		int span = 1;  // Initial span is 1 (the current day itself)

		// Pop from the stack until we find a price greater than or equal to the current price
		while (!stack.isEmpty() && stack.peek()[0] <= price) {
			span += stack.pop()[1];  // Add the span of the previous days to the current span
		}

		// Push the current price and its span onto the stack
		stack.push(new int[] { price, span });

		return span;
	}
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

