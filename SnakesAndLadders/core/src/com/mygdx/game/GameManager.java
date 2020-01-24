package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Json;

public class GameManager {
    public String userID;
    public Results results;
    public static final GameManager INSTANCE = new GameManager();

    public void saveResults() {
        json=new Json();
        FileHandle file = Gdx.files.local("results.json");
        file.writeString(json.toJson(results), false);
    }
    Json json;

    public void loadResults() {
        json=new Json();
        FileHandle file = Gdx.files.local("results.json");
        if (!file.exists()) {
            results = new Results();
        } else {
            results = json.fromJson(Results.class, file.readString());
        }
    }
    private GameManager() {
        json = new Json();
        userID ="marcel";
        loadResults();
    }

    public void newWin(String name){
        boolean exists = false;
        for(int i=0; i<results.winners.size(); i++){
            if(results.winners.get(i).name==name){
                results.winners.get(i).numOfWins++;
                exists=true;
            }
        }
        if(exists==false){
            results.winners.add(new Winner(name));
        }
        saveResults();
    }

    public Results getResults() {
        return results;
    }
}
