import java.util.Scanner;

public class MoneyChange {
    //Find the minimum number of coins needed to change the input value
    //into coins with denominations 1,5 and 10
    //Input: single integer m
    //Constraints: 1<=m<=10^3
    //Output: minimum number of coins with denominations 1,5,10 that changes m

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        int total = input.nextInt();

        System.out.println(convert(total));
    }

    public static int convert(int total) {
        int coins = 0;
        while (true) {
            if (total / 10 > 0) {
                coins += total / 10;
                total %= 10;
            }
            if (total / 5 > 0) {
                coins += total / 5;
                total %= 5;
            }
            if (total / 1 > 0) {
                coins += total / 1;
            }
            return coins;
        }
    }

}
