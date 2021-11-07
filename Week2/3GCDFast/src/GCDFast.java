import java.util.Scanner;

public class GCDFast {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println(EuclidGCD(a, b));
    }

    //Euclidean Algorithm state: if one number is zero, the other will be the greatest common divisor
    //gcd(a,b) = gcd(a',b) = gcd(b,a')   a' is the remainder of a/b
    public static int EuclidGCD(int a, int b) {
        //Cant divide by zero
        if (b == 0) {
            return a;
        }
        int r = a % b;
        return EuclidGCD(b, r); //passing the divisor and remainder (b,a') where a' is the remainder
    }
}
