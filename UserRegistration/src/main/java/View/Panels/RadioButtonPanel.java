/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Panels;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
/**
 *
 * @author حمزة
 */
public class RadioButtonPanel extends JPanel{
    private JLabel label;
    private JRadioButton option1, option2;
    private ButtonGroup group;

    public RadioButtonPanel(String label, String option1, String option2) {
        this.label = new JLabel(label);
        this.option1 = new JRadioButton(option1);
        this.option2 = new JRadioButton(option2);
        this.group = new ButtonGroup();
        group.add(this.option1);
        group.add(this.option2);
        
        this.option1.setFocusable(false);
        this.option2.setFocusable(false);
        
        this.option1.setActionCommand(option1);
        this.option2.setActionCommand(option2);
        
        this.add(this.label);
        this.add(this.option1);
        this.add(this.option2);
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JRadioButton getOption1() {
        return option1;
    }

    public void setOption1(JRadioButton option1) {
        this.option1 = option1;
    }

    public JRadioButton getOption2() {
        return option2;
    }

    public void setOption2(JRadioButton option2) {
        this.option2 = option2;
    }

    public ButtonGroup getGroup() {
        return group;
    }

    public void setGroup(ButtonGroup group) {
        this.group = group;
    }
    
    
}
