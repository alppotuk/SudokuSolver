package com.example.sudokusolver;

import java.util.HashMap;

// i's are rows and j's are columns
enum GameState{
    game,           //game still goes on
    wrongTable,     //table is not in proper order
    end             //game ended
}
public class SudokuGame {
    private int[][] board;

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    private GameState gameState;

    public SudokuGame(int[][] inBoard){     //Constructor
        board = new int[9][9];
        board = inBoard.clone();
        gameState = refreshGameState();
    }
    public void checkColumns(){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j]!=0){
                    for(int k = j+1; k <9 ;k++ ){
                        if (board[i][j] == board[i][k] && board[i][k] != 0) {
                            gameState = GameState.wrongTable;
                            break;
                        }
                    }
                }
            }
        }
    }
    public void checkRows(){
        for(int j = 0; j < 9; j++){
            for(int i = 0; i < 9; i++){
                if(board[i][j]!=0){
                    for(int k = i+1; k <9 ;k++ ){
                        if (board[i][j] == board[k][j] && board[k][j] != 0) {
                            gameState = GameState.wrongTable;
                            break;
                        }
                    }
                }
            }
        }
    }
    public void checkBoxes(){
        for(int iIndex = 0; iIndex <3 ; iIndex++){
            for(int jIndex = 0; jIndex < 3 ; jIndex++){
                HashMap<Integer, Boolean> availability = new HashMap<Integer, Boolean>();
                for(int i = iIndex * 3 ; i<3 ; i++){
                    for(int j = jIndex *  3 ; j< 3;j++ ){
                        if(board[i][j]!=0){
                            if (!availability.containsKey(board[i][j])) {
                                availability.put(board[i][j], true);
                            } else {
                                gameState = GameState.wrongTable;
                                break;
                            }
                        }
                    }
                }

            }
        }
    }
    public void checkEnd(){             //this checks if the game is ended
        int zeroCounter=0;
        for(int j = 0; j < 9; j++){
            for(int i = 0; i < 9; i++){
                if(board[i][j]==0){
                    zeroCounter++;
                }
            }
        }
        if(zeroCounter==0){
            gameState=GameState.end;
        }else{
            gameState=GameState.game;
        }
    }
    public GameState refreshGameState(){    //checks the game board according the rules
        this.checkEnd();
        this.checkColumns();
        this.checkRows();
        this.checkBoxes();
        return gameState;
    }
    public void printBoard(){       //prints the board to console //this function is for pc console application
        System.out.print("\n\n");
        for(int i = 0; i < 9; i++){
            System.out.print("      ");
            for(int j = 0; j < 9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
