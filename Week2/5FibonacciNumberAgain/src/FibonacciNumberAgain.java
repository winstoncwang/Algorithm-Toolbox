import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciNumberAgain {
//    In this problem, your goal is to compute 𝐹𝑛 modulo 𝑚, where 𝑛 may be really huge: up to 1018. For such
//    values of 𝑛, an algorithm looping for 𝑛 iterations will not fit into one second for sure. Therefore we need to
//    avoid such a loop.
//    To get an idea how to solve this problem without going through all 𝐹𝑖 for 𝑖 from 0 to 𝑛, let’s see what
//    happens when 𝑚 is small — say, 𝑚 = 2 or 𝑚 = 3.
//           𝑖 0 1 2 3 4 5 6 7  8  9  10 11 12  13  14  15

//          𝐹𝑖 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610     pisano period
//    𝐹𝑖 mod2  0 1 1|0 1 1 0 1  1  0  1  1  0   1   1   0       3
//    𝐹𝑖 mod3  0 1 1 2 0 2 2 1| 0  1  1  2  0   2   2   1       8
//    𝐹𝑖 mod4  0 1 1 2 3 1|0 1  1  2  3  1  0   1   1   2       6
//    𝐹𝑖 mod5  0 1 1 2 3 0 3 3  1  4  0  4  4   3   2   0       20

    //hint: each Fi of mod m can be calculated by adding the previous modulus and current modulus % by m
    //prev+curr%m
    //hint: pisano period is calculated by finding next 01 beginning. And add all none 01 sequences.
    //hint: for loop to m*m or while loop until 01 sequence is found.

//    Take a detailed look at this table. Do you see? Both these sequences are periodic! For 𝑚 = 2, the period
//    is 011 and has length 3, while for 𝑚 = 3 the period is 01120221 and has length 8. Therefore, to compute,
//    say, 𝐹2015 mod 3 we just need to find the remainder of 2015 when divided by 8. Since 2015 = 251 · 8 + 7, we
//    conclude that 𝐹2015 mod 3 = 𝐹7 mod 3 = 1.
//    This is true in general: for any integer 𝑚 ≥ 2, the sequence 𝐹𝑛 mod 𝑚 is periodic. The period always
//    starts with 01 and is known as Pisano period.

//    Task. Given two integers 𝑛 and 𝑚, output 𝐹𝑛 mod 𝑚 (that is, the remainder of 𝐹𝑛 when divided by 𝑚).
//    Input Format. The input consists of two integers 𝑛 and 𝑚 given on the same line (separated by a space).
//    Constraints. 1 ≤ 𝑛 ≤ 1018, 2 ≤ 𝑚 ≤ 103.
//    Output Format. Output 𝐹𝑛 mod 𝑚.

    public static void main(String[] args) {
        // write your code here
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        int m = input.nextInt();

        //the idea is to use pisano period to reduce large fibonacci number to smaller/more manageable fib number
        //and calculate modulus of that number since everything has a repeated sequence.
        System.out.println(pisano(m));


    }

    public static long fibNumNaive(long n, int m) {
        long previous = 0;
        long current = 1;

        if (n <= 1) {
            System.out.println(n);
            return n;
        }
        for (long i = 0; i < n - 1; i++) {
            long temp = previous + current;
            previous = current;
            current = temp;
        }
        //System.out.println(current);
        return current % m;
    }

    public static long pisano(long m)
    {
        long prev = 0;
        long curr = 1;
        long res = 0;

        for(int i = 0; i < m * m; i++)
        {
            long temp = 0;
            temp = curr;
            curr = (prev + curr) % m;
            prev = temp;
            System.out.println("prev:"+prev+" curr:"+curr+" res:"+res);
            //result always repeats on 01 pattern
            if (prev == 0 && curr == 1)
                res= i + 1;
        }
        return res;
    }
}
