/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author حمزة
 */
public class Model {

    private Boolean[][] board;
    private boolean turn; // true for X, false for O
    private boolean run;
    private int draw;

    // Constructor
    public Model() {
        this.turn = true; // X starts the game
        this.board = new Boolean[3][3]; // Initialize a 3x3 board with null values
        this.run = true;
        this.draw = 0;
    }

    public Boolean[][] getBoard() {
        return board;
    }

    public void setBoard(Boolean[][] board) {
        this.board = board;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }
    
    public void incrementDraw() {
        this.draw++;
    }

    public boolean setCell(int row, int col, boolean turn) {
        if (this.board[row][col] == null) {
            this.board[row][col] = turn;
            return true;
        } else {
            return false;
        }
    }

    public Boolean checkWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != null && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0]; // Row win
            }
            if (board[0][i] != null && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i]; // Column win
            }
        }
        // Check diagonals
        if (board[0][0] != null && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != null && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
        // No winner
        return null;
    }

    public boolean checkDraw() {
        return this.draw == 9;
    }
    
    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = null;
            }
        }
        turn = true; // X starts again
        run = true;
        draw = 0;
    }

}
