import java.util.Scanner;
// Exercise 6.3
public class StarTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the height of the triangle.");
        int n = input.nextInt();
        printTriangle(n);
    }

    static void printTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}