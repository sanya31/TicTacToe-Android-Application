package com.sanyagupta.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    /*Player Representation
    0 - O
    1 - X   */
    int activePlayer = 0;
    int state[] = {2,2,2,2,2,2,2,2,2};
    /*
    0 - O
    1 - X
    2 - BLANK
     */
    int[][] winPlace = {{0,1,2}, {3,4,5}, {6,7,8},
                        {0,3,6},{1,4,7}, {2,5,8},
                        {0,4,8}, {2,4,6}};

    public void tap(View view){
        ImageView img = (ImageView) view;
        int tappedImg = Integer.parseInt(img.getTag().toString());
        if(!gameActive){
            resetGame(view);
        }
        if(state[tappedImg]==2) {
            state[tappedImg] = activePlayer;
            img.setTranslationY(-500f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.oo);
                activePlayer = 1;
                TextView status = findViewById(R.id.status);
                status.setText("X's Turn - Tap to Play");
            } else {
                img.setImageResource(R.drawable.xx);
                activePlayer = 0;
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to Play");
            }
            img.animate().translationYBy(500f).setDuration(300);
        }
        for(int[] winState: winPlace){
            if(state[winState[0]]==state[winState[1]] && state[winState[1]]==state[winState[2]] &&
                state[winState[0]]!=2){
                //someone won
                gameActive = false;
                String winner;
                if(state[winState[0]]==0){
                    winner = "O wins!";
                 }
                else{
                    winner = "X wins!";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winner);
            }
        }
    }

    public void resetGame(View view){
        gameActive = true;
        activePlayer = 0;
        for (int i=0; i<state.length; i++){
            state[i] = 2;
            ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}