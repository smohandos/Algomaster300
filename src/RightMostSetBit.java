public class RightMostSetBit {
    public static void main(String[] args) {
        int n = 18; // Binary: 10010
        
        System.out.println("n="+n+":"+Integer.toBinaryString(n));
        
        int rightmostSetBit = n & ~(n - 1);
        
        System.out.println("n-1="+(n-1)+":"+Integer.toBinaryString(n-1));

        System.out.println("~(n - 1)="+Integer.toBinaryString(~(n - 1)));

        System.out.println("Rightmost set bit: " + rightmostSetBit); 
        
        System.out.println("rightmostSetBit="+rightmostSetBit+":"+Integer.toBinaryString(rightmostSetBit));

    }
}
