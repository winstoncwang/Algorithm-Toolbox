import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LastDigitOfLargeFibonacciNumber {
    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long timeStart = System.currentTimeMillis();
        System.out.println(LastDigitLargeFibFast(n));
        long timeEnd = System.currentTimeMillis();
        //System.out.println("Time spent in milliseconds: "+(timeEnd-timeStart));
    }

    public static long LastDigitLargeFibFast(int n) {
        if (n <= 1) {
            return n;
        }
        ArrayList<Integer> largeFibArr = new ArrayList<>(Arrays.asList(0, 1));
        for (int i = 2; i <= n; i++) {
            int lastFib = largeFibArr.get(i - 1) % 10 + largeFibArr.get(i - 2) % 10;
            largeFibArr.add(lastFib % 10);
        }
        return largeFibArr.get(n);
    }
}
