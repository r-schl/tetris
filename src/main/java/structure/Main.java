package structure;

import Data.Data;
import game.Loop;
import game.Round;
import ui.Gui;

public class Main {

    public static void main(String[] args){
        Round.newBlock();
        Gui gui = new Gui();
        gui.buildWindow();
        gui.buildMenu();
        gui.drawGame();
        Data.createDirectory();
        Thread loop = new Thread(new Loop());
        loop.start();
    }

}
