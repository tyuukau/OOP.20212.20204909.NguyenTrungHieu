package hust.soict.dsai.lab01.JavaBasics.src;

import javax.swing.JOptionPane;
// Exercise 6.1
public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change the first class ticket?");
        JOptionPane.showMessageDialog(null, "You've chosen: "
                + (option == JOptionPane.YES_OPTION? "Yes": "No"));
        System.exit(0);
    }
}