package ui;

import game.Round;

import javax.swing.*;
import java.awt.*;

public class Menu extends JLabel {

    public Menu(){
        setVisible(true);
        setSize((int)(Gui.height/1.8),Gui.height);
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int width = (int)(Gui.height/1.8);
        setBounds((Gui.width/2)-(width/2), 0, width,Gui.height);
        if(Round.state.equals("paused")){
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, Gui.height/3 - 35, Gui.width, Gui.height/3);
            graphics.setFont(Gui.basicFont.deriveFont(17f));
            graphics.setColor(Color.BLACK);
            graphics.drawString("Press enter to continue", Gui.width/2 - 128, Gui.height/2 - 90);
            graphics.setFont(Gui.basicFont.deriveFont(13f));
            graphics.drawString("Controls:", Gui.width/2 -100, Gui.height/2 - 55);
            graphics.setFont(Gui.basicFont.deriveFont(11f));
            graphics.drawString("[<]", Gui.width/2 -100, Gui.height/2 -30);
            graphics.drawString("to move left", Gui.width/2 -10, Gui.height/2 -30);
            graphics.drawString("[>]", Gui.width/2 -100, Gui.height/2 -10 );
            graphics.drawString("to move right", Gui.width/2 -10, Gui.height/2 -10);
            graphics.drawString("[SPACE]", Gui.width/2 -100, Gui.height/2 +10);
            graphics.drawString("to rotate", Gui.width/2 -10, Gui.height/2 +10);
            graphics.drawString("[down]", Gui.width/2 -100, Gui.height/2 +30);
            graphics.drawString("speed up", Gui.width/2 -10, Gui.height/2 +30);
        }else if(Round.state.equals("end")){
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, Gui.height/3 - 35, Gui.width, Gui.height/3);
            graphics.setFont(Gui.basicFont.deriveFont(17f));
            graphics.setColor(Color.RED);
            graphics.drawString("Failed",  Gui.width/2 -38, Gui.height/2 -60);
            graphics.setColor(Color.BLACK);
            graphics.setFont(Gui.basicFont.deriveFont(15f));
            graphics.drawString("Press enter to restart", Gui.width/2 -112, Gui.height/2);
        }
        repaint();
    }
}
