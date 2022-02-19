package com.substance;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    public static int width = 600;
    public static int height = 800;


    public static Window getInstance() {
        return new Window();
    }

    @Override
    public void paint(Graphics graphics) {
    }

    public void start() {
        setTitle("飞机大战");
        setLocation(500, 0);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setVisible(true);
    }
}
