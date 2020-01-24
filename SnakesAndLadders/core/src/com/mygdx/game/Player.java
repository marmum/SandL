package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Player {
    public String name;
    public int position;
    public Texture figure;

    public Player() {
    }

    public Player(String name, int position, Texture figure) {
        this.name = name;
        this.position = position;
        this.figure = figure;
    }
}
