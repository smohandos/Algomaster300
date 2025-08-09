package strings;
class ReverseWordsInAStringLC151 {
	
	public static void main(String[] args) {
        ReverseWordsInAStringLC151 solution = new ReverseWordsInAStringLC151();
        String input = " hello    world ";
        String result = solution.reverseWords(input);
        System.out.println("Output: \"" + result + "\"");
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
