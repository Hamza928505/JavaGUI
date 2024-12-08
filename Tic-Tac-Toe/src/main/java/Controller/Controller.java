/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.*;
import Model.Model;
import java.awt.Color;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author حمزة
 */
public class Controller extends MouseAdapter implements ActionListener {

    private TicTacToe XO;
    private Model model;

    public Controller(TicTacToe XO, Model model) {
        this.XO = XO;
        this.model = model;

        // Set Listeners.
        this.XO.getResetGame().addActionListener(this);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.XO.getBoard().getRectangle(row, col).addMouseListener(this);
            }
        }

    }

    public TicTacToe getXO() {
        return XO;
    }

    public void setXO(TicTacToe XO) {
        this.XO = XO;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getActionCommand().equals("Reset Game")) {
                model.reset();
                XO.reset();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            if (model.isRun()) {

                Object source = e.getSource();
                Rectangle rect = (Rectangle) source;

                if (model.setCell(rect.getRow(), rect.getCol(), model.isTurn())) {
                    if (model.isTurn()) {
                        rect.getLabel().setText("X");
                    } else {
                        rect.getLabel().setText("O");
                    }
                    rect.setCell(model.isTurn());
                    model.setTurn(!model.isTurn());
                } else {
                    return;
                }
                model.incrementDraw();

                Boolean winner = model.checkWinner();
                if (winner != null) {
                    if (winner) {
                        JOptionPane.showMessageDialog(null, "Player X Wins!", "Win", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Player O Wins!", "Win", JOptionPane.INFORMATION_MESSAGE);
                    }

                    model.setRun(false);
                    return;
                }

                if (model.getDraw() == 9) {
                    JOptionPane.showMessageDialog(null, "Draw!", "Draw", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace(); // Print exception for debugging
        }
        
        Thread computerTurn = new Thread(() -> {
            try {
                Thread.sleep(500); // Simulate delay for computer thinking
                computerMove();
                // Computer move logic here
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        
        computerTurn.start();
        
    }

    public void computerMove() {
        Random random = new Random();
        int row, col;
        Rectangle rect;
        do {
            // Generate random row and column indices
            row = random.nextInt(3);       // Random row index
            col = random.nextInt(3);   // Random column index
            rect = XO.getBoard().getRectangle(row, col);
        } while (rect.getCell() != null);

        if (model.setCell(row, col, model.isTurn())) {
            if (model.isTurn()) {
                rect.getLabel().setText("X");
            } else {
                rect.getLabel().setText("O");
            }
            rect.setCell(model.isTurn());
            model.setTurn(!model.isTurn());
        } else {
            return;
        }
        model.incrementDraw();

        Boolean winner = model.checkWinner();
        if (winner != null) {
            if (winner) {
                JOptionPane.showMessageDialog(null, "Player X Wins!", "Win", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Player O Wins!", "Win", JOptionPane.INFORMATION_MESSAGE);
            }

            model.setRun(false);
            return;
        }

        if (model.getDraw() == 9) {
            JOptionPane.showMessageDialog(null, "Draw!", "Draw", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Controller cont = new Controller(new TicTacToe(), new Model());
    }
}
