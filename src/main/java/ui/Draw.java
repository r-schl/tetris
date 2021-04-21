package ui;

import Data.Data;
import game.Block;
import game.Round;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    public Draw(){
        setVisible(true);
        setSize((int)(Gui.height/1.8),Gui.height);
    }

    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        //int width = (int)(Gui.height/1.8);
        //setBounds((Gui.width/2)-(width/2), 0, width,Gui.height);
        setBounds(1, 1, Gui.width,Gui.height);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,Gui.width, Gui.height);



        //if(Round.state.equals("running")){
                //Iteration through "grid" array
            for (int x = 0; x< Round.grid.length; x++){
                for(int y = 0; y<Round.grid[0].length; y++){
                    if (Round.grid[x][y] > 0){
                        Block block = Round.getBlockById(Round.grid[x][y]);
                        graphics.setColor(block.getColor());
                        graphics.fillRect(x*Gui.tileWidth, y*Gui.tileHeight, Gui.tileWidth, Gui.tileHeight);
                    }else if(Round.grid[x][y]==-1){
                        graphics.setColor(Color.white);
                        graphics.fillRect(x*Gui.tileWidth, y*Gui.tileHeight, Gui.tileWidth, Gui.tileHeight);
                    }
                }
            }

        graphics.setColor(new Color(30,30,30));          //draw grid
        for (int xgrid = 0; xgrid < 10; xgrid++){
            for(int ygrid = 0; ygrid <18; ygrid++){
                graphics.drawRect(xgrid*Gui.tileWidth, ygrid*Gui.tileHeight, Gui.tileWidth, Gui.tileHeight);
            }
        }

            //current block
            Block currentBlock = Round.getBlock(-1);
            int[][] structure = currentBlock.getStructure();
            Color color = currentBlock.getColor();
            int x = currentBlock.getX();
            int y = currentBlock.getY();
            for (int a = 0; a < structure.length; a++){
                for(int b = 0; b < structure.length; b++){
                    if (structure[a][b]==1){
                        graphics.setColor(color);
                        graphics.fillRect((x +a)*Gui.tileWidth, (y+b)*Gui.tileHeight, Gui.tileWidth, Gui.tileHeight);
                        graphics.setColor(new Color(255,255,255));
                        graphics.drawRect((x +a)*Gui.tileWidth, (y+b)*Gui.tileHeight, Gui.tileWidth, Gui.tileHeight);
                    }
                }
            }


            graphics.setColor(Color.white);
            graphics.setFont(Gui.basicFont.deriveFont(13f));
            graphics.drawString("HIGHSCORE: " + Integer.toString(Data.getHighScore()), 10, 28);
            if(Round.score>= Data.getHighScore()){
                graphics.setColor(Color.green);
            }
            graphics.drawString("SCORE: " + Integer.toString(Round.score), 10,53);

        //}

       repaint();
    }
}
