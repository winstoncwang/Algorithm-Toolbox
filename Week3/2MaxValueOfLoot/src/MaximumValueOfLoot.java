import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumValueOfLoot {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //number of different item for loot
        int weightCap = scan.nextInt(); //total weight capacity
        int[] value = new int[n];
        int[] weight = new int[n];
        double[] valuePerWeight = new double[n];
        for (int i = 0; i < n; i++) {
            value[i] = scan.nextInt();
            weight[i] = scan.nextInt();
            valuePerWeight[i] = ((double) value[i]) / ((double) weight[i]);
        }
        System.out.printf("%.4f",maximumLoop(n, weightCap, value, weight, valuePerWeight));
    }

    public static double maximumLoop(int n, int cap, int[] value, int[] weight, double[] valuePerWeight) {
        int highestValue = 0;
        double totalValue = 0;
        boolean empty = false;
        while (cap != 0) {

            //workout highest value
            for (int i = 1; i < n; i++) {
                if (valuePerWeight[i] > valuePerWeight[highestValue]) {
                    highestValue = i;
                }
            }
            //check capacity
            if (weight[highestValue] <= cap && weight[highestValue]!=0) {
                //add into the bag
                totalValue += value[highestValue];
                cap -= weight[highestValue];

            } else {
                totalValue += cap * valuePerWeight[highestValue];
                cap = 0;
            }
            // remove the item
            valuePerWeight[highestValue] = 0;
            value[highestValue] = 0;
            weight[highestValue] = 0;
            highestValue = 0;
            //check if array is empty
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        return totalValue;
    }
}
