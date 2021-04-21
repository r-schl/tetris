package io;

import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.InputStream;

public class Sound implements Runnable{
    String path;

    public Sound(String path){
        this.path = path;
    }

    @Override
    public void run() {
        try{
            InputStream is = this.getClass().getResourceAsStream(path);
            Player player = new Player(is);
            player.play();
        }catch (Exception e){

        }
    }

}
