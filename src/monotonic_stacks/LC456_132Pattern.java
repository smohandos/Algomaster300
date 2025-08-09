package monotonic_stacks;

import java.util.Stack;

public class LC456_132Pattern {
	/*
	 Example 1:

	Input: nums = [1,2,3,4]
	Output: false
	Explanation: There is no 132 pattern in the sequence.
	Example 2:

	Input: nums = [3,1,4,2]
	Output: true
	Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
	Example 3:

	Input: nums = [-1,3,2,0]
	Output: true
	Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {4,3,2};

		LC456_132Pattern sol=new LC456_132Pattern();

		boolean res=sol.find132patternOpt(nums);

		System.out.println(res);
	}

	public boolean find132pattern(int[] nums) {
		int n=nums.length;
		//nums[i] < nums[k] < nums[j]
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				for(int k=j+1;k<n;k++)
				{
					if(nums[k] > nums[i] && nums[k]<nums[j])
					{
						return true;
					}
				}
			}
		}

		return false;
	}

	public boolean find132patternOpt(int[] nums) {
		int n = nums.length;
		if (n < 3) return false;

		int num3 = Integer.MIN_VALUE;  // This will track the potential value for nums[k]
		Stack<Integer> stack = new Stack<>();

		for (int i = n - 1; i >= 0; i--) {
			// If the current element is smaller than num3, we found a valid 132 pattern
			if (nums[i] < num3) {
				return true;
			}

			// Update num3 by popping elements from the stack (we want to track the largest possible nums[k])
			while (!stack.isEmpty() && nums[i] > stack.peek()) {
				num3 = stack.pop();
			}

			// Push the current element onto the stack (potential nums[j])
			stack.push(nums[i]);
		}

		return false;
	}
}

