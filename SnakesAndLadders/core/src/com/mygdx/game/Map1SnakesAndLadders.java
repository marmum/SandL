package com.mygdx.game;

import java.util.ArrayList;

public class Map1SnakesAndLadders {

    public Map1SnakesAndLadders() {
    }

    public ArrayList<Snake> generateSnakes(){
        ArrayList<Snake> snakes = new ArrayList<Snake>();
        snakes.add(new Snake(3, 3, 0, 0));
        snakes.add(new Snake(4, 2, 4, 0));
        snakes.add(new Snake(6, 4, 8, 1));
        snakes.add(new Snake(4, 6, 1, 5));
        snakes.add(new Snake(0, 9, 0, 6));
        snakes.add(new Snake(6, 8, 6, 5));
        snakes.add(new Snake(8, 9, 8, 6));
        return snakes;
    }
    public ArrayList<Ladder> generateLadders(){
        ArrayList<Ladder> ladders = new ArrayList<Ladder>();
        ladders.add(new Ladder(2, 0, 0, 5));
        ladders.add(new Ladder(5, 0, 6, 2));
        ladders.add(new Ladder(9, 1, 9, 6));
        ladders.add(new Ladder(5, 3, 4, 5));
        ladders.add(new Ladder(2, 6, 4, 9));
        ladders.add(new Ladder(7, 6, 7, 9));
        return ladders;
    }
}
