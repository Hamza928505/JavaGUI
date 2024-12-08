/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Panels;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;

/**
 *
 * @author حمزة
 */
public class TextFieldPanel extends JPanel {
    private JLabel label;
    private JTextField textField;

    public TextFieldPanel(String label) {
        this.label = new JLabel(label);
        this.textField = new JTextField(10);
        
        this.label.setPreferredSize(new Dimension(120, 20));
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 30, 10);
        this.setLayout(flowLayout);
        
        this.add(this.label);
        this.add(this.textField);
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }
    
}
