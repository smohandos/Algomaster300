import java.util.Arrays;

public class StringDemo {

	public static void main(String[] args) {
        String s = " hello    world ";
       
    	String[] words=s.split("\\s+");
		
    	Arrays.stream(words).forEach(System.out::println);

	}

}
