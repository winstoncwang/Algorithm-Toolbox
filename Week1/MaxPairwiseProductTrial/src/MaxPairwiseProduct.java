import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxPairwiseProduct {

    public static void main(String[] args) {
        long[] arr = readArrayInput();
        System.out.println(arrayQuicksort(arr));
        //stressTest(10,999999);
    }

    public static void stressTest(int test, long max) {
        //generate random number of test sample
        int n;
        for (int i = 0; i < test; i++) {
            n = (int) (Math.random() * 20) + 2; //minimum two numbers in an array
            System.out.println("Array Size: " + n);
            long[] testArr = new long[n];
            for (int j = 0; j < n; j++) {
                testArr[j] = (long) (Math.random() * max);
            }
            System.out.println(Arrays.toString(testArr));
            if (arrayQuicksort(testArr) != getMaxPairwiseProduct(testArr)) {
                System.out.println("Wrong Answer");
            } else {
                System.out.println("OK");
            }
        }
    }

    static long getMaxPairwiseProduct(long[] numbers) {
        long max_product = 0;
        int n = numbers.length;

        for (int first = 0; first < n; ++first) {
            for (int second = first + 1; second < n; ++second) {
                max_product = Math.max(max_product,
                        numbers[first] * numbers[second]);
            }
        }

        return max_product;
    }

    public static long arrayQuicksort(long[] noneNegative) {
        //sort
        Arrays.sort(noneNegative);
        //System.out.println(Arrays.toString(noneNegative));
        int n = noneNegative.length;
        //find next smallest
        int i = n - 1;
        long a = noneNegative[n - 1];
        long b = noneNegative[n - 2];
//        while (b == -1) {
//            if (noneNegative[i - 1] < noneNegative[i]) {
//                b = noneNegative[i - 1];
//            }
//            i--;
//        }
        //print product
        return (a * b);
    }

    public static long[] readArrayInput() {
        //scan input
        int n;
        FastScanner intScan = new FastScanner(System.in);
        n = intScan.nextInt();
        //input array
        long[] noneNegative = new long[n];
        for (int i = 0; i < n; i++) {
            noneNegative[i] = intScan.nextLong();
        }
        return noneNegative;

    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
