/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author حمزة
 */
public class TicTacToe extends JFrame {
    
    private Board board;
    private JButton resetGame;
    
    public TicTacToe() {
        
        board = new Board();
        resetGame = new JButton("Reset Game");
        resetGame.setFocusable(false);
        resetGame.setActionCommand("Reset Game");
        
        this.getContentPane().add(board, BorderLayout.CENTER);
        this.getContentPane().add(resetGame, BorderLayout.SOUTH);
        
        this.setTitle("Tic Tac Toe");
        this.setVisible(true);
        this.setSize(600, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public JButton getResetGame() {
        return resetGame;
    }

    public void setResetGame(JButton resetGame) {
        this.resetGame = resetGame;
    }
    
    public void reset() {
        this.board.resetBoard();
    }
    
    
}
