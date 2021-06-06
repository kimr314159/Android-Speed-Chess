package com.khd.chess;

import android.content.Context;
import android.graphics.Point;
import android.widget.ImageView;

import java.nio.file.Path;

public class King implements Piece {

    private Point[] startingPositions = {new Point(4,0),new Point(4,7) };




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
        imageView.setImageResource(R.drawable.king);
        return imageView;
    }

    public Point[] getStartingPositions(){
        return startingPositions;
    }

}
