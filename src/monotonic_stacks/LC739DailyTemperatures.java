package monotonic_stacks;

import java.util.Arrays;
import java.util.Stack;

public class LC739DailyTemperatures {
	/*
	 * Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]


Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]

	 */
	public static void main(String[] args) {
		LC739DailyTemperatures sol=new LC739DailyTemperatures();

		int[] temperatures = {89,62,70,58,47,47,46,76,100,70};

		int[]  res = sol.dailyTemperaturesOpt(temperatures);

		System.out.println(Arrays.toString(res));
	}

	public int[] dailyTemperatures(int[] temperatures) {

		int n=temperatures.length;

		int[] res=new int[n];

		for(int i=0;i<n;i++)
		{
			int currTemp=temperatures[i];
			int numberDays=0;
			for(int j=i+1;j<n;j++)
			{
				int nextTemp=temperatures[j];
				if(nextTemp>currTemp)
				{
					numberDays=j-i;
					break;
				}
			}

			res[i]=numberDays;
		}

		return res;
	}

	public int[] dailyTemperaturesOpt(int[] temperatures) {

		int n=temperatures.length;

		Stack<Pair> st=new Stack<>();

		int[] result=new int[n];

		for(int i=n-1;i>=0;i--)
		{
			

			while(!st.isEmpty() && st.peek().getVal()<=temperatures[i])
			{
				st.pop();
			}
			
			if(!st.isEmpty())
			{
				int higherTempIndex = st.peek().getIdx();
				result[i]=higherTempIndex-i;
			}
			
			st.push(new Pair(i, temperatures[i]));
		}

		return result;
	}

	class Pair
	{
		int idx;
		int val;

		public Pair(int idx, int val) {
			super();
			this.idx = idx;
			this.val = val;
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}

		public int getVal() {
			return val;
		}

		public void setVal(int val) {
			this.val = val;
		}


	}
}