package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Assets;
import com.mygdx.game.GameBoard;
import com.mygdx.game.GameManager;
import com.mygdx.game.Ladder;
import com.mygdx.game.Map1SnakesAndLadders;
import com.mygdx.game.SnakesAndLadders;
import com.mygdx.game.Player;
import com.mygdx.game.Snake;
import com.mygdx.game.StateClass;

import java.util.ArrayList;
import java.util.Random;

public class GameScreen implements Screen {
    SnakesAndLadders game;

    GameBoard gameBoard;
    ArrayList<Player> players;
    Map1SnakesAndLadders map1Objects;

    public TextureAtlas textureAtlas;
    public Animation animation;
    public float elapsedTime = 0f;
    public float elapsedTimeShowing = 0f;
    public boolean show = false;
    public float timeToRoll = 0f;
    public boolean roll = false;
    public TextureRegion rolledNumberTexture;
    public int lastRolledNumber;

    public ArrayList<Snake> snakes;
    public ArrayList<Ladder> ladders;

    public int currentPlayer = 0;
    public int numOfPlayers;



    public GameScreen(SnakesAndLadders game, int numOfP, ArrayList<String> pNames){
        this.game=game;
        Assets.LoadGame();
        Assets.manager.finishLoading();
		/*while(!Assets.manager.update())
			System.out.println(Assets.manager.getProgress() * 100 + "%");*/

		textureAtlas = new TextureAtlas(Gdx.files.internal("dices.atlas"));
		animation = new Animation(1f/30f, textureAtlas.getRegions());

		numOfPlayers=numOfP;
        map1Objects = new Map1SnakesAndLadders();
        snakes = map1Objects.generateSnakes();
        ladders = map1Objects.generateLadders();
        gameBoard = new GameBoard(10,10, snakes, ladders);
        players = new ArrayList<Player>();
        if(numOfP==1){
            players.add(new Player(pNames.get(0), 0, Assets.manager.get(Assets.kingFigure)));
        }else if(numOfP==2){
            players.add(new Player(pNames.get(0), 0, Assets.manager.get(Assets.kingFigure)));
            players.add(new Player(pNames.get(1), 0, Assets.manager.get(Assets.queenFigure)));
        }else if(numOfP==3){
            players.add(new Player(pNames.get(0), 0, Assets.manager.get(Assets.kingFigure)));
            players.add(new Player(pNames.get(1), 0, Assets.manager.get(Assets.queenFigure)));
            players.add(new Player(pNames.get(2), 0, Assets.manager.get(Assets.horseFigure)));
        }
        else if(numOfP==4){
            players.add(new Player(pNames.get(0), 0, Assets.manager.get(Assets.kingFigure)));
            players.add(new Player(pNames.get(1), 0, Assets.manager.get(Assets.queenFigure)));
            players.add(new Player(pNames.get(2), 0, Assets.manager.get(Assets.horseFigure)));
            players.add(new Player(pNames.get(3), 0, Assets.manager.get(Assets.pawnFigure)));
        }
    }

    @Override
    public void show() {

    }

    public float getFigureX(int position){
        if(position!=0){
            int tmp = position%10;
            return tmp * (game.WORLD_WIDTH/10)+(game.WORLD_WIDTH/20)-0.6f;
        }else
            return 0+(game.WORLD_WIDTH/20)-0.6f;
    }

    public float getFigureY(int position){
        if(position!=0){
            int tmp = position/10;
            return tmp * (game.WORLD_HEIGHT/10)+(game.WORLD_HEIGHT/20)-0.6f;
        }else
            return 0+(game.WORLD_HEIGHT/20)-0.6f;
    }

    @Override
    public void render(float v) {
        game.batch.setProjectionMatrix(game.camera.combined);
        game.batch.begin();
        game.batch.draw(Assets.manager.get(Assets.gameBoard), 0, 0, game.WORLD_WIDTH, game.WORLD_HEIGHT);
        for(int i = 0; i< players.size(); i++){
            game.batch.draw(players.get(i).figure, getFigureX(players.get(i).position), getFigureY(players.get(i).position), 1.2f, 1.2f);
        }
        if(roll) {
            game.batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), game.WORLD_WIDTH / 2 -2f, game.WORLD_HEIGHT / 2 -2f, 4f, 4f);
            elapsedTime+=Gdx.graphics.getDeltaTime();
            Assets.manager.get(Assets.diceRollSound).play();
            Gdx.app.log("ROlled", Float.toString(elapsedTime));
            Gdx.app.log("toROll", Float.toString(timeToRoll));
            if(elapsedTime>=timeToRoll){
                roll=false;
                timeToRoll=0f;
                elapsedTime=0f;
                show=true;
                Random r = new Random();
                lastRolledNumber = r.nextInt((6 - 1) + 1) + 1;
                rolledNumberTexture = (TextureRegion) textureAtlas.getRegions().get(lastRolledNumber-1);
                players.get(currentPlayer).position=players.get(currentPlayer).position+lastRolledNumber;
                int currentP = players.get(currentPlayer).position;
                int currentX = currentP%10;
                int currentY = currentP/10;
                if(gameBoard.gameBoard[currentX][currentY].contains(StateClass.CellState.SNAKE_START)) {
                    for (int i = 0; i < snakes.size(); i++) {
                        if (snakes.get(i).positionStart == currentP)
                            players.get(currentPlayer).position = snakes.get(i).positionEnd;
                    }
                }
                if(gameBoard.gameBoard[currentX][currentY].contains(StateClass.CellState.LADDER_START)) {
                    for (int i = 0; i < ladders.size(); i++) {
                        if (ladders.get(i).positionStart == currentP)
                            players.get(currentPlayer).position = ladders.get(i).positionEnd;
                    }
                }
                if(players.get(currentPlayer).position>=100)
                    gameOver();
                currentPlayer++;
                if(currentPlayer==numOfPlayers)
                    currentPlayer=0;
            }
        }else if(show){
            game.batch.draw(rolledNumberTexture, game.WORLD_WIDTH / 2 -2f, game.WORLD_HEIGHT / 2 -2f, 4f, 4f);
            elapsedTimeShowing+=Gdx.graphics.getDeltaTime();
            if(elapsedTimeShowing>=1.5f){
                show=false;
                elapsedTimeShowing=0f;
            }
        }
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.R)) rollDice();
    }

    public void rollDice(){
        timeToRoll = (float)(Math.random() * ((3 - 1) + 1)) + 1;
        roll = true;
    }

    public void gameOver(){
        GameManager.INSTANCE.newWin(players.get(currentPlayer).name);
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
    public void dispose () {
        textureAtlas.dispose();
        Assets.dispose();
    }
}
