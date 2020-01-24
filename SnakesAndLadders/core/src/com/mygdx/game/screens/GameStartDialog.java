package com.mygdx.game.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.SnakesAndLadders;

import java.util.ArrayList;

public class GameStartDialog implements Screen {
    static SnakesAndLadders game;
    Stage stage;
    Skin skin;
    TextField num;
    TextField nameText1;
    TextField nameText2;
    TextField nameText3;
    TextField nameText4;

    static int enteredNum;
    static String pName1;
    static String pName2;
    static String pName3;
    static String pName4;

    public GameStartDialog (SnakesAndLadders game){
        this.game=game;
        stage=new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        skin = new Skin(Gdx.files.internal("uiskin.json"));
        num = new TextField("0", skin);
        nameText1 = new TextField("", skin);
        nameText2 = new TextField("", skin);
        nameText3 = new TextField("", skin);
        nameText4 = new TextField("", skin);

        nameText1.setTextFieldListener(new TextField.TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char key) {
                pName1 = nameText1.getText();
            }
        });
        nameText2.setTextFieldListener(new TextField.TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char key) {
                pName2 = nameText2.getText();
            }
        });
        nameText3.setTextFieldListener(new TextField.TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char key) {
                pName3 = nameText3.getText();
            }
        });
        nameText4.setTextFieldListener(new TextField.TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char key) {
                pName4 = nameText4.getText();
            }
        });
        num.setTextFieldListener(new TextField.TextFieldListener() {
            @Override
            public void keyTyped(TextField textField, char key) {
                if (num.getText().equals("")) {
                    enteredNum=0;
                }else {
                    enteredNum = Integer.parseInt(num.getText());
                }
            }
        });

        NumOfPlayers dia = new NumOfPlayers("Game Settings", skin);
        dia.getContentTable().add(num);
        dia.getContentTable().row();
        dia.getContentTable().add(nameText1);
        dia.getContentTable().row();
        dia.getContentTable().add(nameText2);
        dia.getContentTable().row();
        dia.getContentTable().add(nameText3);
        dia.getContentTable().row();
        dia.getContentTable().add(nameText4);
        dia.getContentTable().row();
        dia.show(stage);
    }

    public static class NumOfPlayers extends Dialog{
        public NumOfPlayers(String title, Skin skin) {
            super(title, skin);
        }

        {
            text("How many players are playing? (1-5)");
            button("OK");
        }

        @Override
        protected void result(Object object) {
            ArrayList<String> pNames = new ArrayList<>();
            pNames.add(pName1);
            pNames.add(pName2);
            pNames.add(pName3);
            pNames.add(pName4);
            game.setScreen(new GameScreen(game, enteredNum, pNames));
        }
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float v) {
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
    public void dispose() {

    }
}
