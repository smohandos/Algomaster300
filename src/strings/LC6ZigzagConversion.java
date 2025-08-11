package strings;

public class LC6ZigzagConversion {
	/*
	 * Example 1:

	Input: s = "PAYPALISHIRING", numRows = 3
	Output: "PAHNAPLSIIGYIR"
	Example 2:

	Input: s = "PAYPALISHIRING", numRows = 4
	Output: "PINALSIGYAHRPI"
	Explanation:
	P     I    N
	A   L S  I G
	Y A   H R
	P     I
	Example 3:

	Input: s = "A", numRows = 1
	Output: "A"
	 */
	public static void main(String[] args) {
		String s = "AB";

		int numRows = 1;

		LC6ZigzagConversion sol=new LC6ZigzagConversion();

		String res=sol.convert(s, numRows);

		System.out.println(res);

	}

	public String convert(String s, int numRows) {

		if(numRows==1)
		{
			return s;
		}
		boolean goingDown=false;

		int currRow=0;

		StringBuilder[] rows=new StringBuilder[numRows];


		for(int i=0;i<numRows;i++)
		{
			rows[i]=new StringBuilder();
		}


		for(char c:s.toCharArray())
		{
			rows[currRow].append(c);

			if(currRow==0 || currRow==numRows-1) goingDown=!goingDown;

			currRow+=goingDown?1:-1;
		}

		StringBuilder res=new StringBuilder();

		for(int i=0;i<rows.length;i++)
		{
			res.append(rows[i]);
		}

		return res.toString();

	}
}
