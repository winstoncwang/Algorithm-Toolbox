import java.util.Scanner;

//Task. Compute the last digit of F0^2+F1^2+......Fn^2
//Input Format. Integer n
//Constraints 0<=n<=10^14
//Output Format. The last digit of F0^2+F1^2+......Fn^2


//E.g F5^2 can be calculated using the a grid to represent the width and length of the grid
//F5 = F5 * F6
public class LastDigitSumSquaredFibNum {

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(sumFibSquared(n));
    }

    public static int sumFibSquared(int n) {
        //calculate Fn and Fn+1

        int prev = 0;
        int curr = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = curr;
            curr += prev % 10;
            prev = temp % 10;
        }
        //Fn
        int fibNum = curr % 10;

        //Fn+1
        curr += prev % 10;
        int fibNumberPlus = curr % 10;

        return (fibNum * fibNumberPlus) % 10;
    }

}
