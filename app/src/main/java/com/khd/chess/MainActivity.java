package com.khd.chess;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    TableLayout gridViewChess;

    /**
     * Change view to include chess grid.
     * @param
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewChess = (TableLayout)findViewById(R.id.table_chess);
        for(int i=0; i<8; i++){
            TableRow row = new TableRow(this);
            gridViewChess.addView(row);
            row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.MATCH_PARENT, 1.0f));
            for(int j=0; j<8; j++) {
                TableRow col = new TableRow(this);
                col.setBackgroundColor(Color.BLUE);
                TextView str2 = new TextView(this);
                str2.setText(i + ", " + j);
                col.addView(str2);
                row.addView(col);
                col.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT, 1.0f));
                System.out.println("Testing.");
            }
        }
    }
}