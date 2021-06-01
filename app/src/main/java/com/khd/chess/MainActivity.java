package com.khd.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.khd.chess.Piece;


public class MainActivity extends AppCompatActivity {


    TableLayout tableLayoutChess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTable();
    }
    
    /**
    * Change view to include timer
    *
    */
    public boolean initTimer(){
        CountDownTimer countDownTimer = new CountDownTimer(5000,100);
        return true;
    }


    /**
     * Change view to include chess grid.
     * @param
     */
    public boolean initTable(){
        tableLayoutChess = (TableLayout)findViewById(R.id.table_chess);
        tableLayoutChess.setPadding(80,200,80,200);
        int count = 0;
        for(int i=0; i<8; i++){
            TableRow row = new TableRow(this);
            tableLayoutChess.addView(row);
            row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT, 1.0f));
            for(int j=0; j<8; j++) {
                TableRow col = new TableRow(this);
                if((count%2)==0){col.setBackgroundColor(Color.WHITE);}
                else{col.setBackgroundColor(Color.BLACK);}
                TextView str2 = new TextView(this);
                str2.setTextColor(Color.BLUE);
                str2.setText(i + ", " + j);
                col.addView(str2);
                row.addView(col);
                col.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1.0f));
                count++;
                System.out.println("Testing.");
            }
        }
        return true;
    }
}

