package strings;

public class LC392IsSubsequence {

	/*
	 * 
	Example 1:
		Input: s = "abc", t = "ahbgdc"
		Output: true
	
	Example 2:
		Input: s = "axc", t = "ahbgdc"
		Output: false
	 */
	
	public static void main(String[] args) {
		String s="axc";
		
		String t="ahbgdc";
		
		LC392IsSubsequence sol=new LC392IsSubsequence();
		
		boolean res=sol.isSubsequence(s, t);
		
		System.out.println(res);
	}

	public boolean isSubsequence(String s, String t) {
		int m=s.length();
		int n=t.length();

		int i=0,j=0;

		while(i<m && j<n)
		{
			if(s.charAt(i)!=t.charAt(j))
			{
				j++;
				continue;
			}
			else
			{
				i++;
				j++;
			}
		}
		
		if(i==m)
			return true;
		
		return false;
	}
}
