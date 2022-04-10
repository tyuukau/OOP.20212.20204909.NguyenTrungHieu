import java.util.*;
// Exercise 6.5
public class NumericArray {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Input the array length: ");
        int n = input.nextInt();
        double[] arr = new double[n];
        double sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Input the next element in the array: ");
            arr[i] = input.nextDouble();
            sum += arr[i];
        }

        System.out.println("Array:" + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Array (Sorted): " + Arrays.toString(arr));
        System.out.println("Sum of elements: " + String.valueOf(sum));
        System.out.println("Average value of elements: " + String.valueOf(sum/n));

    }

}