import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FibonacciFast {

     public static void main(String[] args) {
       // write your code here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long timeStart = System.currentTimeMillis();
        System.out.println(FibFast(n));
        long timeEnd = System.currentTimeMillis();
        //System.out.println("Time spent in milliseconds: "+(timeEnd-timeStart));
    }

    public static long FibFast(int n) {
        if (n <= 1) {
            return n;
        }
        ArrayList<Long> fibArray = new ArrayList<>(Arrays.asList((long)0,(long)1));
        for (int i = 2; i <= n; i++) {
            fibArray.add(fibArray.get(i - 1) + fibArray.get(i - 2));
        }
        return fibArray.get(n);
    }
}
