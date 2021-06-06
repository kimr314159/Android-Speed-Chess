package com.khd.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.khd.chess.Piece;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    TableLayout tableLayoutChess;
    TextView textViewTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTable();
        initTimer();
    }
    
    /**
    * Change view to include timer
    *
    */
    public boolean initTimer(){
        try{
            textViewTimer = (TextView) findViewById(R.id.text_view_timer);
            CountDownTimer countDownTimer = new CountDownTimer(5000, 100) {
                @Override
                public void onTick(long millisUntilFinished) {
                    String secondsLeft = String.valueOf((int)millisUntilFinished/1000);
                    textViewTimer.setText(secondsLeft);
                }

                @Override
                public void onFinish() {
                    textViewTimer.setText("Time Completed.");
                }
            }.start();
        }catch(Exception e){
            System.err.println("Failed to initialize timer. " + e);
            return false;
        }

        return true;
    }


    /**
     * Change view to include chess grid.
     * @param
     */
    public boolean initTable(){
        try {
            tableLayoutChess = (TableLayout) findViewById(R.id.table_chess);
            tableLayoutChess.setPadding(80, 200, 80, 200);

            //Define 2d array
            System.out.println(getClass());
            Piece[][] sideA = new Piece[2][8];
            King king = new King();
            Knight knightA = new Knight();
            Knight knightB = new Knight();
            sideA[0][1] = knightA;
            sideA[0][4] = king;
            sideA[0][6] = knightB;


            //Init entire table
            int count = 0;
            for (int i = 0; i < 8; i++) {
                count++;
                TableRow row = new TableRow(this);
                tableLayoutChess.addView(row);
                row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT, 1.0f));
                for (int j = 0; j < 8; j++) {
                    TableRow col = new TableRow(this);
                    if ((count % 2) == 0) {
                        col.setBackgroundColor(Color.parseColor("#47597F"));
                    } else {
                        col.setBackgroundColor(Color.parseColor("#4C6284"));
                    }
                    TextView str2 = new TextView(this);
                    str2.setTextColor(Color.WHITE);
                    str2.setText(j + ", " + i);
                    row.addView(col);

                    if(i<sideA.length&&sideA[i][j]!=null){
                        ImageView imageView = sideA[i][j].getImageView(this);

                        col.addView(imageView);
                        imageView.getLayoutParams().height = 100;
                        imageView.getLayoutParams().width = 100;
                        imageView.requestLayout();

                        System.out.println(j + ", " + i);
                        System.out.println(sideA[i][j]);
                        System.out.println("not null");
                    }else{
                        col.addView(str2);
                    }

                    col.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1.0f));
                    count++;


                    System.out.println("Testing.");
                }
            }







            //Init black pieces
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 8; j++) {

                }
            }
        }catch(Exception e){
        System.err.println("Failed to initialize table. " + e);
        return false;
    }
        return true;
    }
}

