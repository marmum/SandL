package com.mygdx.game;

public class Ladder {
    public int startX;
    public int startY;
    public int endX;
    public int endY;
    public int positionStart;
    public int positionEnd;

    public Ladder() {
    }

    public Ladder(int x1, int y1, int x2, int y2) {
        startX=x1;
        startY=y1;
        endX=x2;
        endY=y2;
        positionStart=(y1*10)+(x1);
        positionEnd=(y2*10)+(x2);
    }
}
