package com.khd.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TableLayout tableLayoutChess;
    TextView textViewTimer;
    CountDownTimer countDownTimer;
    Button buttonTimer;
    boolean isTimerOn;
    MediaPlayer mediaPlayer;
    public static final String START_TIMER = "Start Timer.";
    public static final String PAUSE_TIMER = "Pause Timer.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonTimer = (Button) findViewById(R.id.button_timer);


        buttonTimer.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String text = (buttonTimer.getText() == START_TIMER ? PAUSE_TIMER : START_TIMER);
                        buttonTimer.setText(text);
                    }
                });
        initTable();
        initTimer();
        resetTimer();
    }

    public void resetTimer() {
        System.out.println("ok");
        countDownTimer.start();
    }




    /**
    * Change view to include timer
    *
    */
    public boolean initTimer(){
        try{
            textViewTimer = (TextView) findViewById(R.id.text_view_timer);

            countDownTimer = new CountDownTimer(5000, 100) {
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

            mediaPlayer = MediaPlayer.create(this, R.raw.press);
            tableLayoutChess.setSoundEffectsEnabled(false);
            tableLayoutChess.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mediaPlayer.start();
                    System.out.println("begin sound.");
                }}
             );



            //Define 2d array
            System.out.println(getClass());
            Piece[][] sideA = {
                    { new Rook(), new Knight(),new Bishop(),new Queen(),new King(),new Bishop(),new Knight(),new Rook()},
                    { new Pawn(),new Pawn(),new Pawn(),new Pawn(),new Pawn(),new Pawn(),new Pawn(),new Pawn() }
            };

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


                        System.out.println(sideA[i][j]);
                        System.out.println("not null");
                    }else{
                        col.addView(str2);
                    }

                    col.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1.0f));
                    count++;


                    int currRow = i;
                    int currCol = j;
                    col.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            System.out.println(currRow + ", " + currCol);
                        }}
                    );

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

