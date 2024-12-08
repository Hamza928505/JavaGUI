/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author حمزة
 */
public class Board extends JPanel {

    private Rectangle[][] board;
    
    public Board() {
        board = new Rectangle[3][3];
        this.setLayout(new GridLayout(3, 3));
        
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                board[row][col] = new Rectangle(row, col);
                this.add(board[row][col]);
            }
        }
        
    }

    public Rectangle[][] getBoard() {
        return board;
    }

    public void setBoard(Rectangle[][] board) {
        this.board = board;
    }
    
    public void resetBoard() {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                this.board[row][col].reset();
            }
        }
    }
    
    public Rectangle getRectangle(int row, int col) {
        return this.board[row][col];
    }
    
}
