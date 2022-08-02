package com.example.sudokusolver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[][] board = new int[9][9];

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText[][] editTextArray = new EditText[9][9] ;

                editTextArray[0][0] = findViewById(R.id.block0_0);
                editTextArray[0][1] = findViewById(R.id.block0_1);
                editTextArray[0][2] = findViewById(R.id.block0_2);
                editTextArray[0][3] = findViewById(R.id.block0_3);
                editTextArray[0][4] = findViewById(R.id.block0_4);
                editTextArray[0][5] = findViewById(R.id.block0_5);
                editTextArray[0][6] = findViewById(R.id.block0_6);
                editTextArray[0][7] = findViewById(R.id.block0_7);
                editTextArray[0][8] = findViewById(R.id.block0_8);
                editTextArray[1][0] = findViewById(R.id.block1_0);
                editTextArray[1][1] = findViewById(R.id.block1_0);
                editTextArray[1][2] = findViewById(R.id.block1_0);
                editTextArray[1][3] = findViewById(R.id.block1_0);
                editTextArray[1][4] = findViewById(R.id.block1_4);
                editTextArray[1][5] = findViewById(R.id.block1_5);
                editTextArray[1][6] = findViewById(R.id.block1_6);
                editTextArray[1][7] = findViewById(R.id.block1_7);
                editTextArray[1][8] = findViewById(R.id.block1_8);
                editTextArray[2][0] = findViewById(R.id.block2_0);
                editTextArray[2][1] = findViewById(R.id.block2_1);
                editTextArray[2][2] = findViewById(R.id.block2_2);
                editTextArray[2][3] = findViewById(R.id.block2_3);
                editTextArray[2][4] = findViewById(R.id.block2_4);
                editTextArray[2][5] = findViewById(R.id.block2_5);
                editTextArray[2][6] = findViewById(R.id.block2_6);
                editTextArray[2][7] = findViewById(R.id.block2_7);
                editTextArray[2][8] = findViewById(R.id.block2_8);
                editTextArray[3][0] = findViewById(R.id.block3_0);
                editTextArray[3][1] = findViewById(R.id.block3_1);
                editTextArray[3][2] = findViewById(R.id.block3_2);
                editTextArray[3][3] = findViewById(R.id.block3_3);
                editTextArray[3][4] = findViewById(R.id.block3_4);
                editTextArray[3][5] = findViewById(R.id.block3_5);
                editTextArray[3][6] = findViewById(R.id.block3_6);
                editTextArray[3][7] = findViewById(R.id.block3_7);
                editTextArray[3][8] = findViewById(R.id.block3_8);
                editTextArray[4][0] = findViewById(R.id.block4_0);
                editTextArray[4][1] = findViewById(R.id.block4_1);
                editTextArray[4][2] = findViewById(R.id.block4_2);
                editTextArray[4][3] = findViewById(R.id.block4_3);
                editTextArray[4][4] = findViewById(R.id.block4_4);
                editTextArray[4][5] = findViewById(R.id.block4_5);
                editTextArray[4][6] = findViewById(R.id.block4_6);
                editTextArray[4][7] = findViewById(R.id.block4_7);
                editTextArray[4][8] = findViewById(R.id.block4_8);
                editTextArray[5][0] = findViewById(R.id.block5_0);
                editTextArray[5][1] = findViewById(R.id.block5_1);
                editTextArray[5][2] = findViewById(R.id.block5_2);
                editTextArray[5][3] = findViewById(R.id.block5_3);
                editTextArray[5][4] = findViewById(R.id.block5_4);
                editTextArray[5][5] = findViewById(R.id.block5_5);
                editTextArray[5][6] = findViewById(R.id.block5_6);
                editTextArray[5][7] = findViewById(R.id.block5_7);
                editTextArray[5][8] = findViewById(R.id.block5_8);
                editTextArray[6][0] = findViewById(R.id.block6_0);
                editTextArray[6][1] = findViewById(R.id.block6_1);
                editTextArray[6][2] = findViewById(R.id.block6_2);
                editTextArray[6][3] = findViewById(R.id.block6_3);
                editTextArray[6][4] = findViewById(R.id.block6_4);
                editTextArray[6][5] = findViewById(R.id.block6_5);
                editTextArray[6][6] = findViewById(R.id.block6_6);
                editTextArray[6][7] = findViewById(R.id.block6_7);
                editTextArray[6][8] = findViewById(R.id.block6_8);
                editTextArray[7][0] = findViewById(R.id.block7_0);
                editTextArray[7][1] = findViewById(R.id.block7_1);
                editTextArray[7][2] = findViewById(R.id.block7_2);
                editTextArray[7][3] = findViewById(R.id.block7_3);
                editTextArray[7][4] = findViewById(R.id.block7_4);
                editTextArray[7][5] = findViewById(R.id.block7_5);
                editTextArray[7][6] = findViewById(R.id.block7_6);
                editTextArray[7][7] = findViewById(R.id.block7_7);
                editTextArray[7][8] = findViewById(R.id.block7_8);
                editTextArray[8][0] = findViewById(R.id.block8_0);
                editTextArray[8][1] = findViewById(R.id.block8_1);
                editTextArray[8][2] = findViewById(R.id.block8_2);
                editTextArray[8][3] = findViewById(R.id.block8_3);
                editTextArray[8][4] = findViewById(R.id.block8_4);
                editTextArray[8][5] = findViewById(R.id.block8_5);
                editTextArray[8][6] = findViewById(R.id.block8_6);
                editTextArray[8][7] = findViewById(R.id.block8_7);
                editTextArray[8][8] = findViewById(R.id.block8_8);

                for(int i = 0; i < 9; i++){
                    for(int j = 0; j < 9; j++){
                        board[i][j] = StringToInteger(editTextArray[i][j].getText().toString());
                    }
                }

                SudokuGame  sudokuGame = new SudokuGame(board);

                intent = new Intent(getApplicationContext(),buttonActivity.class);
                intent.putExtra("gameBoard", sudokuGame.getBoard());
                startActivity(intent);


            }
        });
    }
    public int StringToInteger(String inputString){
        if(inputString.length() != 0){
            return Integer.parseInt(inputString);
        }else{
            return 0;
        }
    }

}
