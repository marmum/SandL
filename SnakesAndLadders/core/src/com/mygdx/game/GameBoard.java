package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

import sun.rmi.runtime.Log;

public class GameBoard {
    public EnumSet<StateClass.CellState>[][] gameBoard;

    public GameBoard(int width, int height, ArrayList<Snake> snakes, ArrayList<Ladder> ladders) {
        gameBoard = (EnumSet<StateClass.CellState>[][]) new EnumSet<?>[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                for(Snake s : snakes){
                    Gdx.app.log("MyTag", Integer.toString(s.startX));
                    if(s.startX==x && s.startY==y)
                        gameBoard[x][y] = EnumSet.of(StateClass.CellState.SNAKE_START);
                    if(s.endX==x && s.endY==y)
                        gameBoard[x][y] = EnumSet.of(StateClass.CellState.SNAKE_END);
                }
                for(Ladder l : ladders){
                    if(l.startX==x && l.startY==y)
                        gameBoard[x][y] = EnumSet.of(StateClass.CellState.LADDER_START);
                    if(l.endX==x && l.endY==y)
                        gameBoard[x][y] = EnumSet.of(StateClass.CellState.LADDER_END);
                }
                if(gameBoard[x][y]==null)
                    gameBoard[x][y] = EnumSet.of(StateClass.CellState.EMPTY);
            }
        }
    }
}
