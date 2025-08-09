package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElementIILC229 {
	/*
	Example 1:

		Input: nums = [3,2,3]
		Output: [3]
		Example 2:

		Input: nums = [1]
		Output: [1]
		Example 3:

		Input: nums = [1,2]
		Output: [1,2]
	*/
	public static void main(String[] args) {
		MajorityElementIILC229 sol=new MajorityElementIILC229();
		
		int[] nums= {2,2,2};	
		
		List<Integer> res=sol.majorityElementWithVerification(nums);
		
		System.out.println(res);
	}

	public List<Integer> majorityElementBF(int[] nums) {
		
		List<Integer> res=new ArrayList<>();
		
		int n=nums.length;
		
		Map<Integer, Long> map=Arrays.stream(nums).boxed().collect(Collectors.groupingBy(e->e, Collectors.counting()));
		
		//System.out.println(map);
		
		int minOccReq=n/3;
		
		for(Map.Entry<Integer, Long> entry: map.entrySet())
		{
			if(entry.getValue()>minOccReq)
			{
				res.add(entry.getKey());
			}
		}
		
		return res;
	}
	
	
	public List<Integer> majorityElementWithVerification(int[] nums) {
		
		int n=nums.length;
		
		List<Integer> res=new ArrayList<>();

	    int c1 = Integer.MIN_VALUE;
	    int freq1 = 0;

	    int c2 = Integer.MIN_VALUE;
	    int freq2 = 0;
	    
	    for (int num : nums) {
	    	if (freq1 == 0  && num!=c2) {
	    	    c1 = num;
	    	}
	    	else if (freq2 == 0 && num!=c1) {
	    	    c2 = num;
	    	}
	    	
	    	if (num == c1) {
	    	    freq1++; 
	    	} 
	    	else if (num == c2) {
	    	    freq2++; 
	    	}
	    	else
	    	{
	    		freq1--;
	    		freq2--;
	    	}
	    	
	    	

	    }
	    // Second pass to verify if candidate is actually the majority
	    freq1 = 0;
	    freq2 = 0;

	    for (int num : nums) {
	        if (num == c1) {
	            freq1++;
	        }
	        
	        if (num == c2) {
	            freq2++;
	        }
	    }

	    int reqFreq=n/3;
        
        if(freq1>reqFreq)
        {
        	res.add(c1);
        }
        
        if(freq2>reqFreq)
        {
        	res.add(c2);
        }
	    return res;
	}
	
	public int majorityElementNoVerification(int[] nums) {
	    int candidate = nums[0];
	    int freq = 0;

	    for (int num : nums) {
	    	if (freq == 0) {
	    	    candidate = num;
	    	}
	    	if (num == candidate) {
	    	    freq++;  // Increment count if the number matches the candidate
	    	} 
	    	else {
	    	    freq--;  // Decrement count if the number is different
	    	}

	    }
	    return candidate;
	  
	}


}
