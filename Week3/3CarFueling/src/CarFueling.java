import java.util.Arrays;
import java.util.Scanner;

public class CarFueling {

    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int d = scan.nextInt(); //total distance
        int m = scan.nextInt(); //full tank distance
        int totalStops = scan.nextInt() + 2;
        int[] stations = new int[totalStops];
        stations[0] = 0;
        stations[totalStops - 1] = d;
        for (int i = 1; i <= totalStops - 2; i++) {
            stations[i] = scan.nextInt();
        }

        //System.out.println(Arrays.toString(stations));
        System.out.println(minRefill(stations, totalStops-2, m));
    }

    public static int minRefill(int[] stations, int n, int m) {
        int numRefill = 0;
        int currentRefillPosition = 0;
        //check car is on the left of B
        while (currentRefillPosition <= n) {
            int lastRefillPosition = currentRefillPosition;
            //check car is on the left of B and distance to the next refill is within the full tank allowance m
            //distance between current to the next refill station should be less than m
            while (currentRefillPosition <= n && (stations[currentRefillPosition + 1] - stations[lastRefillPosition]) <= m) {
                currentRefillPosition += 1;
            }
            //this determines if the car can go further to the next position.
            //if yes, currentRefillPosition will be more than lastRefillPosition.
            if (currentRefillPosition == lastRefillPosition) {
                return -1;
            }
            if (currentRefillPosition <= n) {
                numRefill += 1;
            }
        }
        return numRefill;
    }
}
