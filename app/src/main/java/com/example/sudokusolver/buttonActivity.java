package com.example.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Ref;

public class buttonActivity extends AppCompatActivity {
    private int[][] myBoard;
    private SudokuGame sudokuGame;
    private int completeTries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        myBoard = new int[9][9];
        myBoard = (int[][]) bundle.getSerializable("gameBoard");
        RefreshBoard(myBoard,true);
        sudokuGame = new SudokuGame(myBoard);
        SolveSudoku solveMySudoku = new SolveSudoku();
        completeTries = 0;
        solveMySudoku.execute();
    }
    public void RefreshBoard(int[][] board,boolean turnBold){
        TextView[][] txtViewArray = new TextView[9][9];

        txtViewArray[0][0] = findViewById(R.id.text0_0);
        txtViewArray[0][1] = findViewById(R.id.text0_1);
        txtViewArray[0][2] = findViewById(R.id.text0_2);
        txtViewArray[0][3] = findViewById(R.id.text0_3);
        txtViewArray[0][4] = findViewById(R.id.text0_4);
        txtViewArray[0][5] = findViewById(R.id.text0_5);
        txtViewArray[0][6] = findViewById(R.id.text0_6);
        txtViewArray[0][7] = findViewById(R.id.text0_7);
        txtViewArray[0][8] = findViewById(R.id.text0_8);
        txtViewArray[1][0] = findViewById(R.id.text1_0);
        txtViewArray[1][1] = findViewById(R.id.text1_1);
        txtViewArray[1][2] = findViewById(R.id.text1_2);
        txtViewArray[1][3] = findViewById(R.id.text1_3);
        txtViewArray[1][4] = findViewById(R.id.text1_4);
        txtViewArray[1][5] = findViewById(R.id.text1_5);
        txtViewArray[1][6] = findViewById(R.id.text1_6);
        txtViewArray[1][7] = findViewById(R.id.text1_7);
        txtViewArray[1][8] = findViewById(R.id.text1_8);
        txtViewArray[2][0] = findViewById(R.id.text2_0);
        txtViewArray[2][1] = findViewById(R.id.text2_1);
        txtViewArray[2][2] = findViewById(R.id.text2_2);
        txtViewArray[2][3] = findViewById(R.id.text2_3);
        txtViewArray[2][4] = findViewById(R.id.text2_4);
        txtViewArray[2][5] = findViewById(R.id.text2_5);
        txtViewArray[2][6] = findViewById(R.id.text2_6);
        txtViewArray[2][7] = findViewById(R.id.text2_7);
        txtViewArray[2][8] = findViewById(R.id.text2_8);
        txtViewArray[3][0] = findViewById(R.id.text3_0);
        txtViewArray[3][1] = findViewById(R.id.text3_1);
        txtViewArray[3][2] = findViewById(R.id.text3_2);
        txtViewArray[3][3] = findViewById(R.id.text3_3);
        txtViewArray[3][4] = findViewById(R.id.text3_4);
        txtViewArray[3][5] = findViewById(R.id.text3_5);
        txtViewArray[3][6] = findViewById(R.id.text3_6);
        txtViewArray[3][7] = findViewById(R.id.text3_7);
        txtViewArray[3][8] = findViewById(R.id.text3_8);
        txtViewArray[4][0] = findViewById(R.id.text4_0);
        txtViewArray[4][1] = findViewById(R.id.text4_1);
        txtViewArray[4][2] = findViewById(R.id.text4_2);
        txtViewArray[4][3] = findViewById(R.id.text4_3);
        txtViewArray[4][4] = findViewById(R.id.text4_4);
        txtViewArray[4][5] = findViewById(R.id.text4_5);
        txtViewArray[4][6] = findViewById(R.id.text4_6);
        txtViewArray[4][7] = findViewById(R.id.text4_7);
        txtViewArray[4][8] = findViewById(R.id.text4_8);
        txtViewArray[5][0] = findViewById(R.id.text5_0);
        txtViewArray[5][1] = findViewById(R.id.text5_1);
        txtViewArray[5][2] = findViewById(R.id.text5_2);
        txtViewArray[5][3] = findViewById(R.id.text5_3);
        txtViewArray[5][4] = findViewById(R.id.text5_4);
        txtViewArray[5][5] = findViewById(R.id.text5_5);
        txtViewArray[5][6] = findViewById(R.id.text5_6);
        txtViewArray[5][7] = findViewById(R.id.text5_7);
        txtViewArray[5][8] = findViewById(R.id.text5_8);
        txtViewArray[6][0] = findViewById(R.id.text6_0);
        txtViewArray[6][1] = findViewById(R.id.text6_1);
        txtViewArray[6][2] = findViewById(R.id.text6_2);
        txtViewArray[6][3] = findViewById(R.id.text6_3);
        txtViewArray[6][4] = findViewById(R.id.text6_4);
        txtViewArray[6][5] = findViewById(R.id.text6_5);
        txtViewArray[6][6] = findViewById(R.id.text6_6);
        txtViewArray[6][7] = findViewById(R.id.text6_7);
        txtViewArray[6][8] = findViewById(R.id.text6_8);
        txtViewArray[7][0] = findViewById(R.id.text7_0);
        txtViewArray[7][1] = findViewById(R.id.text7_1);
        txtViewArray[7][2] = findViewById(R.id.text7_2);
        txtViewArray[7][3] = findViewById(R.id.text7_3);
        txtViewArray[7][4] = findViewById(R.id.text7_4);
        txtViewArray[7][5] = findViewById(R.id.text7_5);
        txtViewArray[7][6] = findViewById(R.id.text7_6);
        txtViewArray[7][7] = findViewById(R.id.text7_7);
        txtViewArray[7][8] = findViewById(R.id.text7_8);
        txtViewArray[8][0] = findViewById(R.id.text8_0);
        txtViewArray[8][1] = findViewById(R.id.text8_1);
        txtViewArray[8][2] = findViewById(R.id.text8_2);
        txtViewArray[8][3] = findViewById(R.id.text8_3);
        txtViewArray[8][4] = findViewById(R.id.text8_4);
        txtViewArray[8][5] = findViewById(R.id.text8_5);
        txtViewArray[8][6] = findViewById(R.id.text8_6);
        txtViewArray[8][7] = findViewById(R.id.text8_7);
        txtViewArray[8][8] = findViewById(R.id.text8_8);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                txtViewArray[i][j].setText(IntegerToString(board[i][j]));
                if(board[i][j] != 0 && turnBold){
                    txtViewArray[i][j].setTextColor(Color.parseColor("#D50000"));
                }
            }
        }
    }
    public String IntegerToString(int inputInt){
        if(inputInt != 0){
            return String.valueOf(inputInt);
        }else{
            return "";
        }
    }

    public boolean solve(SudokuGame sudokuGame) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudokuGame.getBoard()[i][j] == 0) {
                    for (int number = 1; number < 10; number++) {
                        sudokuGame.getBoard()[i][j] = number;
                        completeTries++;
                        if(sudokuGame.refreshGameState()!=GameState.wrongTable){
                            if (solve(sudokuGame)) {
                                return true;
                            } else {
                                sudokuGame.getBoard()[i][j] = 0;
                            }
                        }else{
                            sudokuGame.getBoard()[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private class SolveSudoku extends AsyncTask<Void,Void,Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            solve(sudokuGame);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            RefreshBoard(sudokuGame.getBoard(),false);
            TextView textView = findViewById(R.id.txtSolved);
            String message_1 = "Completed in " + completeTries + " tries!";
            String message_2 = "Solved Succesfully!";
            textView.setText(message_2);
            Toast.makeText(getApplicationContext(),message_1,Toast.LENGTH_SHORT).show();
        }
    }
    public int[][] doStuff(int[][] board){
        int[][] brandNewBoard = new int[9][9];
        for(int i = 0; i < 9 ; i++){
            for(int j = 0; j <9;j++){
                brandNewBoard[i][j]= board[i][j];
            }
        }
        return brandNewBoard;
    }
}

