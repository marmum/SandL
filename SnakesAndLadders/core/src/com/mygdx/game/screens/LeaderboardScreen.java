package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SnakesAndLadders;

public class LeaderboardScreen implements Screen {
    final SnakesAndLadders game;

    Stage stage;
    Skin skin;
    Table table;
    Label player1;
    Label player2;
    Label player3;
    Label player4;
    Label player5;
    TextButton button;


    public LeaderboardScreen(final SnakesAndLadders game){
        this.game=game;
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        table = new Table();
        table.setFillParent(true);
        stage.addActor(table);
        player1 = new Label("1. place: " + "player1" + "   " + " wins", skin);
        player2 = new Label("2. place: " + "player2" + "   " + " wins", skin);
        player3 = new Label("3. place: " + "player3" + "   " + " wins", skin);
        player4 = new Label("4. place: " + "player4" + "   " + " wins", skin);
        player5 = new Label("5. place: " + "player5" + "   " + " wins", skin);
        button = new TextButton("Back", skin);
        button.addListener(new ClickListener() {
            @Override public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MainMenuScreen(game));
            };
        });
        player1.setWrap(true);
        player2.setWrap(true);
        player3.setWrap(true);
        player4.setWrap(true);
        player5.setWrap(true);
        table.add(player1);
        table.row();
        table.add(player2);
        table.row();
        table.add(player3);
        table.row();
        table.add(player4);
        table.row();
        table.add(player5);
        table.row();
        table.row();
        table.add(button);
    }

    @Override
    public void show() {
    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() { stage.dispose();} //Need to call dispose!!!

}
