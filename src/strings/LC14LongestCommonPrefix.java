	package strings;

public class LC14LongestCommonPrefix {
	/*
	 * Example 1:

	Input: strs = ["flower","flow","flight"]
	Output: "fl"
	Example 2:

	Input: strs = ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.
	 */
	public static void main(String[] args) {

		//		String[] strs= {"flow","flow"};

		String[] strs= {"a","ab"};

		LC14LongestCommonPrefix sol=new LC14LongestCommonPrefix();

		String res=sol.longestCommonPrefixHorizontal(strs);

		System.out.println(res);
	}

	private String longestCommonPrefixHorizontal(String[] strs) {

		String prefix=strs[0];

		for(int i=1;i<strs.length;i++)
		{
			while(strs[i].indexOf(prefix)!=0)
			{
				prefix=prefix.substring(0, prefix.length()-1);

			}
		}

		return prefix;
	}

	public String longestCommonPrefix(String[] strs) {

		String firstWord=strs[0];

		for (int i = 0; i < firstWord.length(); i++) {
			char c = firstWord.charAt(i);
			for (int j = 1; j < strs.length; j++) {
				// If current word is too short or char doesn't match, return prefix so far
				if (i >= strs[j].length() || strs[j].charAt(i) != c) {
					return firstWord.substring(0, i);
				}
			}
		}
		return firstWord; 
	}
}
