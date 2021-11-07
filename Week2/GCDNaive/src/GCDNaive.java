import java.util.Scanner;

public class GCDNaive {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        System.out.println(GCDNaive(a, b));
    }

    public static int GCDNaive(int a, int b) {
        int gcd = 0;
        if (a == 0 || b == 0) {
            return 0;
        }
        for (int i = 1; i <= a + b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
