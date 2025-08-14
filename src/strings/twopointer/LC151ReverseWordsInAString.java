package strings.twopointer;

import java.util.Arrays;

class LC151ReverseWordsInAString {
	
	public static void main(String[] args) {
        LC151ReverseWordsInAString solution = new LC151ReverseWordsInAString();
        String input = " hello    world ";
        String result = solution.reverseWordsBF(input);
        System.out.println("Output: \"" + result + "\"");
    }
	
    private String reverseWordsBF(String s) {

    	s=s.trim();
    	
    	String[] words=s.split("\\s+");

    	int n=words.length;
    	

    	//Arrays.stream(words).forEach(System.out::println);

    	StringBuilder res=new StringBuilder();
    	
    	for(int i=n-1;i>=0;i--)
    	{
    		res.append(words[i]);
    		if(i!=0)
    		{
    			res.append(" ");
    		}
    	}
    	
    	return res.toString();
	}

	public String reverseWords(String s) {
        // Convert string to char array for in-place modification
        char[] arr = s.toCharArray();
        int n = arr.length;

        // Step 1: Reverse the entire string
        reverse(arr, 0, n - 1);

        int i = 0, l = 0, r = 0;

        while (i < n) {
            while (i < n && arr[i] != ' ') { // Move i and update r
                arr[r++] = arr[i++];
            }

            if (l < r) { // Found a word, reverse it
                reverse(arr, l, r - 1);
                if (r < n) { // Add space only if it's not the last word
                    arr[r] = ' ';
                }
                r++; 
                l = r; 
            }

            i++; // Move i forward
        }

        return new String(arr, 0, r - 1); // Convert back to string with correct length
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
    
}
