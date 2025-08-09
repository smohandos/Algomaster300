package hashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsLC49 {
/*Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]
*/
	public static void main(String[] args) {
		GroupAnagramsLC49 sol=new GroupAnagramsLC49();
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		
		List<List<String>> res=sol.groupAnagrams(strs);
		
		res.stream().forEach(System.out::println);
		
	}

	 public List<List<String>> groupAnagrams(String[] strs) {
	        Map<String, List<String>> map = new HashMap<>();

	        for (String str : strs) {
	            int[] count = new int[26]; // Frequency array for 'a' to 'z'
	            for (char c : str.toCharArray()) {
	                count[c - 'a']++; // Increment frequency
	            }

	            // Convert count array to a string key
	            String key = Arrays.toString(count);
	            
	            

	            // Group anagrams in the map
	            map.putIfAbsent(key, new ArrayList<>());
	            map.get(key).add(str);
	        }

	        return new ArrayList<>(map.values());
	    }

	 
	public List<List<String>> groupAnagramsBF(String[] strs) {
		
		int n=strs.length;
		
		List<List<String>> res= new ArrayList<>();
		
		boolean[] used=new boolean[n];
		
		Arrays.fill(used, false);
		
		for(int i=0;i<n;i++)
		{
			if(used[i]) continue; 
			
			List<String> group=new ArrayList<>();
			
			group.add(strs[i]);
			used[i]=true;
			
			for(int j=i+1;j<n;j++)
			{
				if(isAnagrams(strs[i], strs[j]))
				{
					group.add(strs[j]);
					used[j]=true;
				}
			}
			res.add(group);
		}
		return res;
	}

	private boolean isAnagrams(String s1, String s2) {
		
		char[] c1=s1.toCharArray();
		
		char[] c2=s2.toCharArray();
		
		Arrays.sort(c1);
		
		Arrays.sort(c2);
		
		s1=new String(c1);
		
		s2=new String(c2);
		
		if(s1.equals(s2)) return true;
		
		return false;
	}
}
