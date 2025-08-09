package arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MajorityElementLC169 {
	/*
	 * Example 1:

		Input: nums = [3,2,3]
		Output: 3
		
		Example 2:
		Input: nums = [2,2,1,1,1,2,2]
		Output: 2	
	 */
	public static void main(String[] args) {
		MajorityElementLC169 sol=new MajorityElementLC169();
		
		int[] nums= {3,2,3};
		
		int res=sol.majorityElementWithVerification(nums);
		
		System.out.println(res);
	}

	public int majorityElementBF(int[] nums) {
		
		int res=-1;
		
		int n=nums.length;
		
		Map<Integer, Long> map=Arrays.stream(nums).boxed().collect(Collectors.groupingBy(e->e, Collectors.counting()));
		
		//System.out.println(map);
		
		int minOccReq=n/2;
		
		for(Map.Entry<Integer, Long> entry: map.entrySet())
		{
			if(entry.getValue()>minOccReq)
			{
				return entry.getKey();
			}
		}
		
		return res;
	}
	
	
	public int majorityElementWithVerification(int[] nums) {
	    int candidate = nums[0];
	    int count = 0;

	    for (int num : nums) {
	    	if (num == candidate) {
	    	    count++;  // Increment count if the number matches the candidate
	    	} 
	    	else if (count == 0) {
	    	    candidate = num;
	    	    count = 1;  // Reset count since we are picking a new candidate
	    	} else {
	    	    count--;  // Decrement count if the number is different
	    	}

	    }

	    // Second pass to verify if candidate is actually the majority
	    count = 0;
	    for (int num : nums) {
	        if (num == candidate) {
	            count++;
	        }
	    }

	    return (count > nums.length / 2) ? candidate : -1;  // -1 if no majority
	}

}
