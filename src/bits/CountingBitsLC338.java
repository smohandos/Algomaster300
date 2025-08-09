package bits;

public class CountingBitsLC338 {
	/*
	 * Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
	 */
	public static void main(String[] args) {
		int n = 5; // Given test case

		CountingBitsLC338 sol=new CountingBitsLC338();

		int[] result = sol.countBitsOpt(n);

		//		System.out.println("n = " + n);
		System.out.print("Result: ");
		for (int num : result) {
			System.out.print(num + " ");
		}
	}

	public int[] countBits(int n) {

		int[] res=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			res[i]=countNoBits(i);
		}

		return res;
	}

	private int countNoBits(int no) {

		int mask=1;

		int count=0;

		for(int i=0;i<32;i++)
		{
			if((mask & no) > 0)
			{
				count++;
			}

			mask=mask<<1;
		}
		return count;
	}

	public static int[] countBitsOpt(int n) {
		int[] result = new int[n + 1]; // Equivalent to vector<int> result(n+1) in C++

		if (n == 0) 
			return result;

		result[1] = 1;

		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				result[i] = result[i / 2]; // Even case
			} else {
				result[i] = result[i / 2] + 1; // Odd case
			}
		}

		return result;
	}
}
