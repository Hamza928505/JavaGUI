/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author حمزة
 */
public class Rectangle extends JPanel {

    private JLabel label;
    private int row, col;
    private Boolean cell;

    public Rectangle(int row, int col) {
        label = new JLabel();
        this.row = row;
        this.col = col;
        this.cell = null;

        Font font = new Font("Arial", Font.PLAIN, 75);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setSize(200, 200);
        label.setPreferredSize(new Dimension(200, 200));
        label.setFont(font);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(label);
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public void reset() {
        this.setBackground(Color.WHITE);
        this.label.setText("");
        this.cell = null;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Boolean getCell() {
        return cell;
    }

    public void setCell(Boolean cell) {
        this.cell = cell;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(0, 0, 200, 200);
    }

}
