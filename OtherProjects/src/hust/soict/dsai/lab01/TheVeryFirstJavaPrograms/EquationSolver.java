import javax.swing.JOptionPane;
import java.lang.Math;
// Exercise 2.2.6
public class EquationSolver {
    public static void main(String[] args) {
        final String[] problems = {"Linear equation with one variable",
                "System of linear equations with two variables",
                "Second-degree equation with one variable"};
        boolean cont = true;

        while (cont) {
            String userChoice = (String) JOptionPane.showInputDialog(null, "What do you want to solve?",
                    "Select problem", JOptionPane.QUESTION_MESSAGE, null, problems, problems[0]);

            switch (userChoice) {

                case "Linear equation with one variable":

                    String inputTitle0 = "Input equation ax + b = 0";
                    double a = Double.parseDouble(JOptionPane.showInputDialog(null, "a:", inputTitle0, JOptionPane.INFORMATION_MESSAGE));
                    double b = Double.parseDouble(JOptionPane.showInputDialog(null, "b:", inputTitle0, JOptionPane.INFORMATION_MESSAGE));
                    String title0 = "Solution for the equation " + Double.toString(a) + "x + " + Double.toString(b) + " = 0";

                    if (a == 0) {
                        if (b == 0) {
                            JOptionPane.showMessageDialog(null, "Infinite solutions.", title0, JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No solution.", title0, JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Unique solution: " + "x = " + Double.toString(-b / a), title0, JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case "System of linear equations with two variables":

                    String firstInputTitle = "Input equation a11 * 1 + a12 * x2 = b1";
                    double a11 = Double.parseDouble(JOptionPane.showInputDialog(null, "a11:", firstInputTitle, JOptionPane.INFORMATION_MESSAGE));
                    double a12 = Double.parseDouble(JOptionPane.showInputDialog(null, "a12:", firstInputTitle, JOptionPane.INFORMATION_MESSAGE));
                    double b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "b1:", firstInputTitle, JOptionPane.INFORMATION_MESSAGE));
                    String secndInputTitle = "Input equation a21 * 1 + a22 * x2 = b2";
                    double a21 = Double.parseDouble(JOptionPane.showInputDialog(null, "a21:", secndInputTitle, JOptionPane.INFORMATION_MESSAGE));
                    double a22 = Double.parseDouble(JOptionPane.showInputDialog(null, "a22:", secndInputTitle, JOptionPane.INFORMATION_MESSAGE));
                    double b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "b2:", secndInputTitle, JOptionPane.INFORMATION_MESSAGE));
                    String title1 = "Solution for the equation system";

                    double determinant = a11 * a22 - a21 * a12;
                    if (determinant == 0) {
                        double d1 = a11 * b2 - a21 * b1;
                        if (d1 == 0) {
                            JOptionPane.showMessageDialog(null, "Infinite solutions", title1, JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No solution.", title1, JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else if (a11 != 0) {
                        a22 -= a12 * (a21 / a11);
                        b2 -= b1 * (a21 / a11);
                        double x2 = b2 / a22;
                        double x1 = (b1 - a12 * x2) / a11;
                        JOptionPane.showMessageDialog(null,
                                "Solution: \n"
                                        + "\t" + "x1 = " + Double.toString(x1) + "\n"
                                        + "\t" + "x2 = " + Double.toString(x2) + "\n", title1, JOptionPane.INFORMATION_MESSAGE);
                    } else if (a11 == 0) {
                        double x2 = b1 / a12;
                        double x1 = (b2 - a22 * x2) / a21;
                        JOptionPane.showMessageDialog(null,
                                "Solution: \n"
                                        + "\t" + "x1 = " + Double.toString(x1) + "\n"
                                        + "\t" + "x2 = " + Double.toString(x2) + "\n", title1, JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;

                case "Second-degree equation with one variable":

                    String inputTitle2 = "Input equation ax^2 + bx + c = 0";
                    double aa = Double.parseDouble(JOptionPane.showInputDialog(null, "a:", inputTitle2, JOptionPane.INFORMATION_MESSAGE));
                    double bb = Double.parseDouble(JOptionPane.showInputDialog(null, "b:", inputTitle2, JOptionPane.INFORMATION_MESSAGE));
                    double cc = Double.parseDouble(JOptionPane.showInputDialog(null, "c:", inputTitle2, JOptionPane.INFORMATION_MESSAGE));
                    String title2 = "Solution for the equation " + Double.toString(aa) + "x^2 + " + Double.toString(bb) + "x + " + Double.toString(cc) + " = 0";

                    double delta = bb * bb - 4 * aa * cc;
                    if (aa == 0) {
                        JOptionPane.showMessageDialog(null, "Use linear equation option instead.", "a must not be 0", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        if (delta < 0) {
                            JOptionPane.showMessageDialog(null, "No solution.", title2, JOptionPane.INFORMATION_MESSAGE);
                        } else if (delta == 0) {
                            JOptionPane.showMessageDialog(null, "Solution: " + Double.toString(-bb / (2 * aa)), title2, JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            String x1 = Double.toString((-bb - Math.sqrt(delta)) / (2 * aa));
                            String x2 = Double.toString((-bb + Math.sqrt(delta)) / (2 * aa));
                            JOptionPane.showMessageDialog(null, "Solutions:\n"
                                    + "\t" + "x1 = " + x1 + "\n"
                                    + "\t" + "x2 = " + x2, title2, JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    break;

                default:
                    break;
            }

            cont = (JOptionPane.showConfirmDialog(null, "Do you want continue solving problems?") == JOptionPane.YES_OPTION) ? true : false;
        }
    }
}