package com.mygdx.game;

import java.util.EnumSet;

public class StateClass {
    public enum GameState {
        GAME_RUNNING, GAME_PAUSED, GAME_OVER,
        ;

        public static EnumSet<GameState> ALL_OPTS = EnumSet.allOf(GameState.class);
    }

    public enum CellState {
        EMPTY, SNAKE_START, SNAKE_END, LADDER_START, LADDER_END
        ;

        public static EnumSet<CellState> ALL_OPTS = EnumSet.allOf(CellState.class);
    }
}
