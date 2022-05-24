package hust.soict.dsai.lab01.Exercise66.src;

import java.util.*;

public class AddTwoMatrices {

    public static void main(String[] args) {

        System.out.println("The size of the matrix will be m x n.");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please input m.");
        int m = keyboard.nextInt();
        System.out.println("Please input n.");
        int n = keyboard.nextInt();

        System.out.println("Enter the first matrix.");
        double[][] arr1 = inputMatrix(m, n);
        System.out.println("Enter the second matrix.");
        double[][] arr2 = inputMatrix(m, n);

        double[][] sum = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        System.out.println("The sum of them is:");
        printMatrix(sum);

    }

    public static double[][] inputMatrix(int m, int n) {
        Scanner input = new Scanner(System.in);
        double[][] arr = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(". . .");
                arr[i][j] = input.nextDouble();
            }
        }
        System.out.println("This matrix is:");
        printMatrix(arr);
        System.out.println();
        return arr;
    }

    public static void printMatrix(double[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

}