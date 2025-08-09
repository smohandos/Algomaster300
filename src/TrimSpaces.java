public class TrimSpaces {
    public static String trimSpaces(String str) {
        if (str == null || str.isEmpty()) return "";

        char[] chars = str.toCharArray();
        int n = chars.length;
        int index = 0, i = 0;

        // Skip leading spaces
        while (i < n && chars[i] == ' ') i++;

        while (i < n) {
            // Copy non-space characters
            if (chars[i] != ' ') {
                chars[index++] = chars[i];
            } 
            // If it's a space, ensure only one is copied (if previous is not space)
            else if (index > 0 && chars[index - 1] != ' ') {
                chars[index++] = ' ';
            }
            i++;
        }

        // Remove trailing space if exists
     //   if (index > 0 && chars[index - 1] == ' ') index--;
        System.out.println(new String(chars, 0, i).trim());
        return new String(chars, 0, index).trim();
    }

    public static void main(String[] args) {
        String input = "   Hello    world!   This  is   Java.  ";
        String result = trimSpaces(input);
        System.out.println("\"" + result + "\"");
    }
}
