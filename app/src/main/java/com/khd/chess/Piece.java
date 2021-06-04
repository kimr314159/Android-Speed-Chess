package com.khd.chess;

interface Piece {


    void move();
    void reset();
    boolean setImagepath();
    String getImagePath();
    void getAllowedMoves();
}
