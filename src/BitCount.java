public class BitCount {
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1); // Check LSB
            n >>= 1; // Right shift
        }
        System.out.println("n="+n);
        return count;
    }

    public static void main(String[] args) {
        int n = 29;
        System.out.println(countSetBits(n)); // Output: 4
    }
}
