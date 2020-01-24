package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Assets;
import com.mygdx.game.SnakesAndLadders;

public class MainMenuScreen implements Screen {

    SnakesAndLadders game;
    public static float playButtonWidth = 3f;
    public static float playButtonHeight = 3f;
    public static float playButtonX = (SnakesAndLadders.WORLD_WIDTH/2-playButtonWidth/2);
    public static float playButtonY = ((SnakesAndLadders.WORLD_HEIGHT/4)*3);
    public static float optionsButtonWidth = 3f;
    public static float optionsButtonHeight = 3f;
    public static float optionsButtonX = (SnakesAndLadders.WORLD_WIDTH/2-playButtonWidth/2);
    public static float optionsButtonY = ((SnakesAndLadders.WORLD_HEIGHT/4)*2);
    public static float exitButtonWidth = 3f;
    public static float exitButtonHeight = 3f;
    public static float exitButtonX = (SnakesAndLadders.WORLD_WIDTH/2-exitButtonWidth/2);
    public static float exitButtonY = (SnakesAndLadders.WORLD_HEIGHT/4);

    public MainMenuScreen (SnakesAndLadders game){
        this.game=game;
        Assets.LoadGame();
        Assets.LoadMainMenu();
        Assets.manager.finishLoading();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float v) {
        game.batch.setProjectionMatrix(game.camera.combined);
        Gdx.gl.glClearColor(0.9f, 0.9f, 0.9f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        Vector3 mousePosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        game.camera.unproject(mousePosition);
        game.batch.draw(Assets.manager.get(Assets.playButton), playButtonX, playButtonY, playButtonWidth, playButtonHeight);
        game.batch.draw(Assets.manager.get(Assets.optionsButton), optionsButtonX, optionsButtonY, optionsButtonWidth, optionsButtonHeight);
        game.batch.draw(Assets.manager.get(Assets.exitButton), exitButtonX, exitButtonY, exitButtonWidth, exitButtonHeight);
        checkClicks();
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
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
    public void dispose() {

    }

    public void checkClicks(){
        Vector3 mousePosition = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        game.camera.unproject(mousePosition);
        if(mousePosition.x < playButtonX+playButtonWidth && mousePosition.x > playButtonX && mousePosition.y < playButtonY+playButtonHeight && mousePosition.y > playButtonY){
            if(Gdx.input.isTouched()){
                this.dispose();
                //game.setScreen(new GameScreen(game));
                game.setScreen(new GameStartDialog(game));
            }
        }
        if(mousePosition.x < optionsButtonX+optionsButtonWidth && mousePosition.x > optionsButtonX && mousePosition.y < optionsButtonY+optionsButtonHeight && mousePosition.y > optionsButtonY){
            if(Gdx.input.isTouched()){
                this.dispose();
                game.setScreen(new LeaderboardScreen(game));
            }
        }
        if(mousePosition.x < exitButtonX+exitButtonWidth && mousePosition.x > exitButtonX && mousePosition.y < exitButtonY+exitButtonHeight && mousePosition.y > exitButtonY){
            if(Gdx.input.isTouched()){
                Gdx.app.exit();
            }
        }
    }
}
