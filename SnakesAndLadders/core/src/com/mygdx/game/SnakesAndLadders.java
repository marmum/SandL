package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.MainMenuScreen;

public class SnakesAndLadders extends Game {
    public OrthographicCamera camera;
    public Viewport viewport;
    public static final float WORLD_WIDTH = 16.f;   //It can be 2600px 1958px
    public static final float WORLD_HEIGHT = 16.f;


	public SpriteBatch batch;

		@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
		this.setScreen(new MainMenuScreen(this));
		GameManager.INSTANCE.loadResults();
	}

	@Override
	public void render () {
			super.render();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
