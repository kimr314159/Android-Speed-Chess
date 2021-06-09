package com.khd.chess;
import android.content.Context;
import android.graphics.Point;
import android.widget.ImageView;


public class Queen implements Piece {

    private Point[] startingPositions = {new Point(3,0) };

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
        imageView.setImageResource(R.drawable.queen);
        return imageView;
    }

    public Point[] getStartingPositions(){
        return startingPositions;
    }

}
