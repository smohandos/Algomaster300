package bits;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberIIILC260 {
	/*
	 * Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]

	 */
	
	
	public static void main(String[] args) {
		SingleNumberIIILC260 sol=new SingleNumberIIILC260();
		int[] nums = {-1,0};
		int[] res=sol.singleNumber(nums);
		System.out.println(res[0]+":"+res[1]);
	}

	public int[] singleNumberBF(int[] nums) {
		
		int[] res=new int[2];
		
		Map<Integer, Integer> map=new HashMap<>();
		
		for(int i:nums)
		{
			map.put(i,map.getOrDefault(i, 0)+1);
		}
		
		int count=0;
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet())
		{
			if(entry.getValue()==1)
			{
				res[count++]=entry.getKey();
			}
		}
		
		return res;
	}
	
	public int[] singleNumber(int[] nums) {
        // Step 1: XOR all numbers to get the XOR of the two unique numbers
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        
        int RMSB = (xor ^ ~(xor - 1));
        
        // Step 3: Partition the array into two groups and XOR within each group
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & RMSB) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        
        return new int[]{num1, num2};
    }
}

