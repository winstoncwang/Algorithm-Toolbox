import java.util.Scanner;

public class FibonacciNaive {

    public static void main(String[] args) {
        //input read
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long timeStart = System.currentTimeMillis();
        System.out.println(FibNaive(n));
        long timeEnd = System.currentTimeMillis();
        System.out.println("Time in milliseconds: "+ (timeEnd-timeStart));
    }
    //n 0 1 2 3 4 5 6 7  8
    //  0 1 1 2 3 5 8 13 21
    //      |
    // where n = 2 result will be fib(n-1)+fib(n-2)

    public static long FibNaive(int n) {
        if (n <= 1) {
            return n;
        }
        return FibNaive(n - 1) + FibNaive(n - 2);
    }
}
