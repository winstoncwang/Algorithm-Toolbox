import java.util.Scanner;

class LastDigitSumOfFibNum {
    //Given an integer n, find the last digit of the sum F0+F1+F2...Fn
    //Input format. single integer n
    //Constraints 0<=n<=10^18
    //Output format. output the last digit of F0+F1+F2....Fn

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(lastDigitFibSum(n));
    }

    public static int lastDigitFibSum(int n) {
        if (n <= 1) {
            return n;
        }
        //remainder of each fib sequence
        int prev = 0;
        int curr = 1;
        int sum = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = curr;
            curr = curr % 10 + prev % 10;
            prev = temp;
            sum += curr;
        }
        //return single digit
        return sum % 10;

    }
}
