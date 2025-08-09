
public class CharacterDemo {

	public static void main(String[] args) {
		String s = "A man 123 !~#";

		char[] cArr=s.toCharArray();
		
		for(int i=0;i<cArr.length;i++)
		{
			//System.out.println(cArr[i]);
		}
		
		System.out.println(Character.isLetterOrDigit('a'));
		System.out.println(Character.isLetterOrDigit('1'));
		System.out.println("---------");
		System.out.println(Character.isLetter('1'));
		System.out.println(Character.isLetterOrDigit('!'));
		System.out.println("---------");		
		System.out.println(Character.isDigit('!'));
		System.out.println(Character.isDigit('1'));
		System.out.println("---------");		
		System.out.println(Character.toLowerCase('!'));
		System.out.println(Character.toLowerCase('1'));
		System.out.println(Character.toLowerCase('A'));
		System.out.println(Character.toLowerCase('a'));
		System.out.println("---------");		
		System.out.println(Character.toUpperCase('!'));
		System.out.println(Character.toUpperCase('1'));
		System.out.println(Character.toUpperCase('A'));
		System.out.println(Character.toUpperCase('a'));
	}
}
