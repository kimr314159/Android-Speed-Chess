package com.khd.chess;

import android.content.Context;
import android.widget.ImageView;

interface Piece {


    void move();
    void reset();
    boolean setImagepath();
    String getImagePath();
    void getAllowedMoves();
    ImageView getImageView(Context context);
}
