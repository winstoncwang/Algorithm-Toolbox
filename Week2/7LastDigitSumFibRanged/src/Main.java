import java.util.Scanner;

public class Main {

    //Given two non-negative integers m and n, where m<=n, find the last digit of the sum Fm+F(m+1)+.....+Fn
    //Input format. consists of two non-negative integers m and n
    //Constraints. 0<=m<=n<=10^18
    //Output format last digit of Fm+F(m+1)+....+Fn

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        System.out.println(lastDigitRangedSum(m, n));
    }

    public static int lastDigitRangedSum(int m, int n) {
        if (n <= 1) {
            return n;
        }

        int prev = 0;
        int curr = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int temp = curr;
            curr = curr % 10 + prev % 10;
            prev = temp;
            if (i >= m - 1) {
                sum += prev;
            }
        }
        return sum % 10;
    }
}
