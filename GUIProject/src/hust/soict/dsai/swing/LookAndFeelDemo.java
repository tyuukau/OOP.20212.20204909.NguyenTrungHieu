package hust.soict.dsai.swing;

import java.awt.*;
import javax.swing.*;    
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
        setSize(380, 150);
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

        // UIManager.LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
        // String[] lafNames = new String[lafInfos.length]; 
        // for (int i = 0; i < lafInfos.length; i++) { 
        //     lafNames[i] = lafInfos[i].getName(); 
        // }
        // JComboBox<String> cbLookAndFeel = new JComboBox(lafNames); 

        ArrayList<String> lafClassNames = new ArrayList<String>();
        ArrayList<String> lafNames = new ArrayList<String>();

        for (UIManager.LookAndFeelInfo look : UIManager.getInstalledLookAndFeels()) {
            lafClassNames.add(look.getClassName());
            lafNames.add(look.getName());
        }
        lafClassNames.add(UIManager.getCrossPlatformLookAndFeelClassName());
        lafClassNames.add(UIManager.getSystemLookAndFeelClassName());
        lafNames.add("Cross Platform");
        lafNames.add("System");
        JComboBox<String> cbLookAndFeel = new JComboBox(lafNames.toArray()); 

        cp.add(cbLookAndFeel);

        //handle change look and feel 
        JFrame frame = this; 
        cbLookAndFeel.addActionListener(new ActionListener(){ 
            @Override 
            public void actionPerformed(ActionEvent ae) { 
                int index = cbLookAndFeel.getSelectedIndex(); 
                try { 
                    UIManager.setLookAndFeel(lafClassNames.get(index));
                } catch (Exception e) {
                    e.printStackTrace(); 
                }
                SwingUtilities.updateComponentTreeUI(frame); 
                setTitle(lafNames.get(index) + " Look And Feel");
            }
        });
    }
    
}