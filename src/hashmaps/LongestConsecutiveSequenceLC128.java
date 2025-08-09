package hashmaps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestConsecutiveSequenceLC128 {
/*
 * Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3
 */
	public static void main(String[] args) {
		int[] nums = {1,0,1,2};
	
		LongestConsecutiveSequenceLC128 sol=new LongestConsecutiveSequenceLC128();
		
		int res= sol.longestConsecutive(nums);
		
		System.out.println(res);
	}

	public int longestConsecutive(int[] nums) {
		
		int max=1;
		int currMax=1;
		
		
		Arrays.sort(nums);
		
		List<Integer> list=Arrays.stream(nums).distinct().mapToObj(Integer::new).collect(Collectors.toList());
		
		int n=list.size();

		for(int i=1;i<n;i++)
		{
			
			if(list.get(i)-list.get(i-1)==1)
			{
				currMax++;
			}
			else
			{
				max=Math.max(currMax, max);
				currMax=1;
			}
		}
		
		max=Math.max(currMax, max);
		return max;
	}
}
