package com.khd.chess;

import android.content.Context;
import android.widget.ImageView;

public class Pawn implements Piece {

    @Override
    public void move() {

    }

    @Override
    public void reset() {

    }

    @Override
    public boolean setImagepath() {
        return false;
    }

    @Override
    public String getImagePath() {
        return null;
    }

    @Override
    public void getAllowedMoves() {

    }

    @Override
    public ImageView getImageView(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.pawn);
        return imageView;
    }
}
