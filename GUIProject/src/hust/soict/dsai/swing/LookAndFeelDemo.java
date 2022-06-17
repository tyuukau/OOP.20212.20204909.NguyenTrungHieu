package hust.soict.dsai.swing;

import java.awt.*;
import javax.swing.*;    
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LookAndFeelDemo extends JFrame { 


    public static void main( String args[] )
    {
       LookAndFeelDemo application = new LookAndFeelDemo();
       application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public LookAndFeelDemo() {
        addDemoComponents(); 
        addLookAndFeelComboBox(); 
        
        // setDefaultClose0peration(JFrame.EXIT_ON_CLOSE); 
        setSize(380, 100);
        setVisible(true);
    }
    
    void addDemoComponents() {
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        cp.add(new JLabel("Label:"));
        cp.add(new JTextField("Text field"));
        cp.add(new JRadioButton("Radio button"));
        cp.add(new JButton("Button"));
    }

    void addLookAndFeelComboBox() { 
        Container cp = getContentPane(); 
        cp.add(new JLabel("Change Look and Feel Here: "));
         
        //create the combo box 
        UIManager.LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels(); 
        String[] lafNames = new String[lafInfos.length]; 
        for (int i = 0; i < lafInfos.length; i++) { 
            lafNames[i] = lafInfos[i].getName(); 
        }
        JComboBox<String> cbLookAndFeel = new JComboBox(lafNames); 
        cp.add(cbLookAndFeel);

        //handle change look and feel 
        JFrame frame = this; 
        cbLookAndFeel.addActionListener(new ActionListener(){ 
            @Override 
            public void actionPerformed(ActionEvent ae) { 
                int index = cbLookAndFeel.getSelectedIndex(); 
                try { 
                    UIManager.setLookAndFeel(lafInfos [index].getClassName());
                } catch (Exception e) {
                    e.printStackTrace(); 
                }
                SwingUtilities.updateComponentTreeUI(frame); 
                setTitle(lafInfos[index].getName() + " Look And Feel");
            }
        });
    }
    
}