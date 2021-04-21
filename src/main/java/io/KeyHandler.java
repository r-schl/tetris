package io;

import game.Round;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (Round.state.equals("running")){
            switch (key){
                case KeyEvent.VK_SPACE:
                    if(!Checker.rotate()){
                        int[][] ret = Round.getBlock(-1).rotate();
                        Round.getBlock(-1).setStructure(ret);
                    }
                    break;
                case KeyEvent.VK_LEFT:
                    if(!Checker.moveX(-1)){
                        Round.getBlock(-1).left();
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(!Checker.moveX(1)){
                        Round.getBlock(-1).right();
                    }
                    break;
                case KeyEvent.VK_ESCAPE:
                    new Thread(new Sound("/resources/musicAndSounds/openFolder.mp3")).start();
                    Music.stop();
                    Round.pause();
                    break;
                case KeyEvent.VK_DOWN:
                    Round.boost(true);
                    break;
                default:
                    break;
            }
        }else{
            switch (key){
                case KeyEvent.VK_ENTER:
                    if(Round.state.equals("paused")){
                        Round.start();
                    }else if(Round.state.equals("end")){
                        Round.reset();
                    }
                    break;
                default:
                    break;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (Round.state.equals("running")) {
            switch (key) {
                case KeyEvent.VK_DOWN:
                    Round.boost(false);
                    break;
                default:
                    break;
            }
        }
    }
}
