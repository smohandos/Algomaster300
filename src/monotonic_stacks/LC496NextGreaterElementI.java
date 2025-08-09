package monotonic_stacks;
import java.util.*;

public class LC496NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Step 1: Create a map to store the next greater element for each element in nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        // Step 2: Traverse nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
        	
        	int num=nums2[i];
            // Pop elements from the stack that are smaller than the current num
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            // If the stack is not empty, the top element is the next greater element
            if (!stack.isEmpty()) {
                nextGreaterMap.put(num, stack.peek());
            } else {
                nextGreaterMap.put(num, -1);  // No greater element found
            }
            // Push the current number onto the stack
            stack.push(num);
        }
        
        // Step 3: Construct the result for nums1 using the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Create an instance of the Solution class
    	LC496NextGreaterElementI solution = new LC496NextGreaterElementI();
        
        // Test case 1
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] result1 = solution.nextGreaterElement(nums1, nums2);
        
        // Print the result for test case 1
        System.out.println("Test Case 1 Result: " + Arrays.toString(result1));

        // Test case 2
        int[] nums1_2 = {2, 4};
        int[] nums2_2 = {1, 2, 3, 4};
        int[] result2 = solution.nextGreaterElement(nums1_2, nums2_2);
        
        // Print the result for test case 2
        System.out.println("Test Case 2 Result: " + Arrays.toString(result2));

    }
}
