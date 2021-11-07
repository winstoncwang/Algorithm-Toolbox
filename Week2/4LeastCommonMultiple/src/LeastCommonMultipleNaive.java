import java.util.Scanner;

public class LeastCommonMultipleNaive {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        long b = input.nextLong();
        System.out.println(LeastCommonMultiple(a, b));
    }

    public static long LeastCommonMultiple(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        //multiple of both number. Hence a number x that is bigger than both numbers, and divisible by both.
        if (b > a) {
            long temp = a;
            a = b;
            b = temp;
        }
        long lcm = a;
        while (lcm <= a * b) {
            if (lcm % a == 0 && lcm % b == 0) {
                return lcm;
            } else {
                lcm += a;
            }
        }
        return -1;
    }
}
