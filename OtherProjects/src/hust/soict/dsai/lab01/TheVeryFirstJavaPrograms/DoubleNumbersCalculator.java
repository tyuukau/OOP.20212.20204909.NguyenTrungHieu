package hust.soict.dsai.lab01.TheVeryFirstJavaPrograms;

import javax.swing.JOptionPane;
// Exercise 2.2.5
public class DoubleNumbersCalculator {
        public static void main(String[] args) {
                double num1 = Double.parseDouble(JOptionPane.showInputDialog("Please input the first number: "));
                double num2 = Double.parseDouble(JOptionPane.showInputDialog("Please input the second number: "));

                String sum = Double.toString(num1 + num2);
                String difference = (num1 > num2) ? Double.toString(num1 - num2) : Double.toString(num2 - num1);
                String product = Double.toString(num1 * num2);
                String quotient = (num2 == 0) ? "Division by 0!" : Double.toString(num1/num2);

                String title = "Solutions for " + num1 + " and " + num2;
                String content = "Sum: " + sum + "\n" + "Difference: " + difference + "\n" + "Product: " + product + "\n" + "Quotient: " + quotient;

                JOptionPane.showMessageDialog(null, content, title, JOptionPane.INFORMATION_MESSAGE);
        }
}
