package io;

import Data.BlockData;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.InputStream;

public class Music implements Runnable{
    static Player player;

    @Override
    public void run() {
        try{
            InputStream is = BlockData.class.getResourceAsStream("/resources/musicAndSounds/tetris.mp3");
            player = new Player(is);
            player.play();
        }catch (Exception ignored){}
    }

    public static void stop(){
        player.close();
    }
}
