package arrays;
import java.util.Arrays;

public class ProductArrayExceptSelfLC238 {

	/*
	 * Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

	 */
	public static void main(String[] args) {
		int[] nums= {1,2,0,0};
		ProductArrayExceptSelfLC238 sol=new ProductArrayExceptSelfLC238();

		int[] res=sol.productExceptSelf3(nums);

		Arrays.stream(res).forEach(System.out::println);
	}

	public int[] productExceptSelfBF(int[] nums) {
		int n=nums.length;

		int[] result=new int[n];

		Arrays.fill(result, 1);

		for(int i=0;i<n;i++)
		{
			for(int j=i-1;j>=0;j--)
			{
				result[i]=result[i]*nums[j];
			}

			for(int j=i+1;j<n;j++)
			{
				result[i]=result[i]*nums[j];
			}

		}
		return result;
	}

	public int[] productExceptSelfUsingDivsion(int[] nums) {
		int countZeros = 0;
		int productWithoutZero = 1;
		for (int i : nums) {
			if (i == 0)
				countZeros++;
			else
				productWithoutZero *= i;
		}

		int[] result = new int[nums.length];

		if(countZeros>1)
		{
			Arrays.fill(result, 0);
			return result;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0 ) {
				result[i] = productWithoutZero;
			}
			else if(countZeros==0)
			{
				result[i] = productWithoutZero/nums[i];
			}
			else {
				result[i] = 0;
			}
		}
		return result;
	}

	public int[] productExceptSelf2(int[] nums) {
		int n = nums.length;
		int[] left = new int[n];
		int[] right = new int[n];
		left[0] = 1;
		right[n - 1] = 1;

		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}

		for (int i = n - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i + 1];
		}

		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = left[i] * right[i];
		}

		return result;
	}

	public int[] productExceptSelf3(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * suffix;
            suffix *= nums[i];
        }

        return result;
    }
	
	public int[] productExceptSelfOpt(int[] nums) {
		int n = nums.length;
		int[] answer = new int[n];

		// Step 1: Compute prefix products and store in answer[]
		answer[0] = 1;
		for (int i = 1; i < n; i++) {
			answer[i] = answer[i - 1] * nums[i - 1];
		}

		// Step 2: Compute suffix products and multiply into answer[]
		int suffix = 1;  // Suffix product
		for (int i = n - 1; i >= 0; i--) {
			answer[i] *= suffix;
			suffix *= nums[i];  // Update suffix product
		}

		return answer;
	}
}
