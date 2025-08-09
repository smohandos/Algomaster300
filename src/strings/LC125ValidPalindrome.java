package strings;

public class LC125ValidPalindrome {
	/*
	 * Example 1:

	Input: s = "A man, a plan, a canal: Panama"
	Output: true
	Explanation: "amanaplanacanalpanama" is a palindrome.
	Example 2:

	Input: s = "race a car"
	Output: false
	Explanation: "raceacar" is not a palindrome.
	Example 3:

	Input: s = " "
	Output: true
	Explanation: s is an empty string "" after removing non-alphanumeric characters.
	Since an empty string reads the same forward and backward, it is a palindrome.

	 */
	public static void main(String[] args) {
		LC125ValidPalindrome sol=new LC125ValidPalindrome();

		String s = "  ";

		boolean res=sol.isPalindrome(s);

		System.out.println(res);
	}

	public boolean isPalindrome(String s) {

		StringBuilder cleaned=new StringBuilder();

		int n=s.length();

		for(char c: s.toCharArray())
		{
			if(Character.isLetterOrDigit(c))
			{
				cleaned.append(c);
			}
		}
		System.out.println(cleaned);
		return checkPalindrome(cleaned.toString());
	}

	private boolean checkPalindrome(String s) {
		int n=s.length();

		int l=0,r=n-1;

		while(l<r)
		{
			if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r)))
				return false;

			l++;
			r--;
		}

		return true;
	}

	public boolean isPalindromeOpt(String s) {

		int n=s.length();

		int l=0,r=n-1;

		while(l<r)
		{
			while(l<r && !Character.isLetterOrDigit(s.charAt(l)))
			{
				l++;
			}

			while(l<r && !Character.isLetterOrDigit(s.charAt(r)))
			{
				r--;
			}

			if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r)))
				return false;

			
			l++;
			r--;
		}

		return true;

	}
}
