import java.util.Scanner;

class APlusB {

    public static void main(String[] args) {
        //read in using scanner value (int)
        int a, b;
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();

        //sum method
        System.out.println(SumOfTwoDigits(a, b));
        input.close();
    }

    static int SumOfTwoDigits(int x, int y) {
        return x + y;
    }
}
