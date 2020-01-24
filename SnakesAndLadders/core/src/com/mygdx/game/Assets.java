package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Assets {
    public static final AssetManager manager = new AssetManager();
    public static final AssetDescriptor<Texture> gameBoard = new AssetDescriptor<Texture>("game_board.png", Texture.class);
    public static final AssetDescriptor<Texture> kingFigure = new AssetDescriptor<Texture>("king_figure.png", Texture.class);
    public static final AssetDescriptor<Texture> queenFigure = new AssetDescriptor<Texture>("queen_figure.png", Texture.class);
    public static final AssetDescriptor<Texture> rookFigure = new AssetDescriptor<Texture>("rook_figure.png", Texture.class);
    public static final AssetDescriptor<Texture> pawnFigure = new AssetDescriptor<Texture>("pawn_figure.png", Texture.class);
    public static final AssetDescriptor<Texture> horseFigure = new AssetDescriptor<Texture>("horse_figure.png", Texture.class);
    public static final AssetDescriptor<Texture> bishopFigure = new AssetDescriptor<Texture>("bishop_figure.png", Texture.class);
    public static final AssetDescriptor<Texture> dice1 = new AssetDescriptor<Texture>("dice1.png", Texture.class);
    public static final AssetDescriptor<Texture> dice2 = new AssetDescriptor<Texture>("dice2.png", Texture.class);
    public static final AssetDescriptor<Texture> dice3 = new AssetDescriptor<Texture>("dice3.png", Texture.class);
    public static final AssetDescriptor<Texture> dice4 = new AssetDescriptor<Texture>("dice4.png", Texture.class);
    public static final AssetDescriptor<Texture> dice5 = new AssetDescriptor<Texture>("dice5.png", Texture.class);
    public static final AssetDescriptor<Texture> dice6 = new AssetDescriptor<Texture>("dice6.png", Texture.class);
    public static final AssetDescriptor<Sound> diceRollSound = new AssetDescriptor<Sound>("dice_roll.wav", Sound.class);

    public static final AssetDescriptor<Texture> playButton = new AssetDescriptor<Texture>("play_button.png", Texture.class);
    public static final AssetDescriptor<Texture> optionsButton = new AssetDescriptor<Texture>("options_button.png", Texture.class);
    public static final AssetDescriptor<Texture> exitButton = new AssetDescriptor<Texture>("exit_button.png", Texture.class);

    public static void LoadGame() {
        manager.load(gameBoard);
        manager.load(kingFigure);
        manager.load(queenFigure);
        manager.load(rookFigure);
        manager.load(pawnFigure);
        manager.load(horseFigure);
        manager.load(bishopFigure);
        manager.load(dice1);
        manager.load(dice2);
        manager.load(dice3);
        manager.load(dice4);
        manager.load(dice5);
        manager.load(dice6);
        manager.load(diceRollSound);
    }

    public static void LoadMainMenu() {
        manager.load(playButton);
        manager.load(optionsButton);
        manager.load(exitButton);
    }

    public static void dispose() {
        manager.dispose();
    }
}
