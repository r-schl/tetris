package ui;

import io.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Window extends JFrame {

    public Window(String title){
        setSize(Gui.width +14 +2, Gui.height +37 +2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null);
        addKeyListener(new KeyHandler());
        requestFocus();
        //resize Handler
        getContentPane().addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                Component c = (Component)componentEvent.getSource();
                Gui.updateData(c.getWidth(),c.getHeight());
                System.out.println("resized");
            }

            @Override
            public void componentMoved(ComponentEvent componentEvent) {
                Component c = (Component)componentEvent.getSource();
                Gui.updateData(c.getWidth(),c.getHeight());
                System.out.println("moved");
            }

            @Override
            public void componentShown(ComponentEvent componentEvent) {
                Component c = (Component)componentEvent.getSource();
                Gui.updateData(c.getWidth(),c.getHeight());
                System.out.println("show");
            }

            @Override
            public void componentHidden(ComponentEvent componentEvent) {
                Component c = (Component)componentEvent.getSource();
                Gui.updateData(c.getWidth(),c.getHeight());
                System.out.println("hidden");
            }
        });

    }
}
