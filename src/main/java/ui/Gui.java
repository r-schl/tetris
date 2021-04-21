package ui;

import Data.BlockData;
import game.Round;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Gui {
    public static int width = 400;
    public static int height = 720;
    public static int tileWidth = width / Round.grid.length;
    public static int tileHeight = height / Round.grid[0].length;
    public static Font basicFont;

    static {
        try {
            InputStream is = Gui.class.getResourceAsStream("/resources/fonts/FFFFORWA.TTF");
            basicFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(12f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    Window window;

    public static void updateData(int setWidth,int setHeight){
        height = setHeight;
        width = setWidth;
        tileWidth = (int) (setHeight/1.8) / Round.grid.length;
        tileHeight = setHeight / Round.grid[0].length;
    }

    public void buildWindow() {
        window = new Window("Tetris");
    }

    public void drawGame(){
        Draw draw = new Draw();
        window.add(draw);
    }

    public void buildMenu(){
        Menu menu = new Menu();
        window.add(menu);
    }


}
