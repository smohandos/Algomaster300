package TwoPointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ThreeSumLC15 {
/*
 * Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 */
	public static void main(String[] args) {
		int[] nums= {-1,0,1,2,-1,-4};
	
		ThreeSumLC15 sol=new ThreeSumLC15();
		
		List<List<Integer>> res=sol.threeSum(nums);
		
		res.stream().forEach(System.out::println);
	}


	public List<List<Integer>> threeSum(int[] nums) {
		
		List<List<Integer>> res=new ArrayList<>();
		
		int n=nums.length;
		
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				for(int k=j+1;k<n;k++)
				{
					if(nums[i]+nums[j]+nums[k]==0)
					{
						Set<Integer> set=new TreeSet<>();
						set.add(nums[i]);
						set.add(nums[j]);
						set.add(nums[k]);
						res.add(new ArrayList<>(set));
					}
				}
			}
		}
		
		return res;
	}
}
