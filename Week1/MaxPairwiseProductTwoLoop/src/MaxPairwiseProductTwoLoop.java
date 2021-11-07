import java.util.*;
import java.io.*;


public class MaxPairwiseProductTwoLoop {
    static long getMaxPairwiseProduct(long[] numbers) {
//    this solution is based on comparing all products within the array of numbers (O(n^2)
//        long max_product = 0;
//        int n = numbers.length;
//
//        for (int first = 0; first < n; ++first) {
//            for (int second = first + 1; second < n; ++second) {
//                max_product = Math.max(max_product,
//                        numbers[first] * numbers[second]);
//            }
//        }
//
//        return max_product;

        //this is a faster solution, only scans for two max value for a max products O(n)
        int aIndex = 0;
        int bIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[aIndex]) {
                aIndex = i;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > numbers[bIndex] && i != aIndex) {
                bIndex = i;
            }
        }
        return (long)numbers[aIndex]* (long)numbers[bIndex];
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextLong();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
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


